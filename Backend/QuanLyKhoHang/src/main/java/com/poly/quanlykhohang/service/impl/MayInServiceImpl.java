package com.poly.quanlykhohang.service.impl;

import com.poly.quanlykhohang.dao.*;
import com.poly.quanlykhohang.entity.*;
import com.poly.quanlykhohang.service.MayInService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MayInServiceImpl implements MayInService {

    private final MayInDAO mayInDAO;
    private final ChiTietNhapSeriDAO chiTietNhapSeriDAO;
    private final ChiTietXuatSeriDAO chiTietXuatSeriDAO;
    private final KhoDAO khoDAO;

    @Override
    public MayIn timTheoSeri(String soSeri) {
        return mayInDAO.findBySoSeri(soSeri)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy máy có seri: " + soSeri));
    }

    @Override
    public List<MayIn> timMayTonKhoTheoSanPham(String maSP) {
        return mayInDAO.findAvailableMachinesByProduct(maSP);
    }

    @Override
    public Map<String, Object> traCuuLichSuMay(String soSeri) {
        Map<String, Object> history = new HashMap<>();

        // 1. Lấy thông tin hiện tại
        MayIn mayIn = timTheoSeri(soSeri);
        history.put("thongTinMay", mayIn);

        // 2. Tìm nguồn gốc Nhập (Trace Backward)
        Optional<ChiTietNhapSeri> nhapEntry = chiTietNhapSeriDAO.findByMayIn_MaSeri(soSeri);
        if (nhapEntry.isPresent()) {
            PhieuNhap pn = nhapEntry.get().getChiTietPhieuNhap().getPhieuNhap();
            history.put("ngayNhap", pn.getNgayNhap());
            history.put("nhaCungCap", pn.getNhaCungCap().getTenDonVi());
            history.put("phieuNhap", pn.getSoPhieu());
        }

        // 3. Tìm lịch sử Xuất (Trace Forward)
        Optional<ChiTietXuatSeri> xuatEntry = chiTietXuatSeriDAO.findExportInfoBySerial(soSeri);
        if (xuatEntry.isPresent()) {
            PhieuXuat px = xuatEntry.get().getChiTietPhieuXuat().getPhieuXuat();
            history.put("ngayXuat", px.getNgayXuat());
            history.put("khachHang", px.getKhachHang().getTenDonVi());
            history.put("phieuXuat", px.getSoPhieu());

            // Logic tính bảo hành (Ví dụ mặc định bảo hành 12 tháng từ ngày xuất)
            LocalDateTime hanBaoHanh = px.getNgayXuat().plusMonths(12);
            history.put("hanBaoHanh", hanBaoHanh);

            if (LocalDateTime.now().isBefore(hanBaoHanh)) {
                history.put("trangThaiBaoHanh", "CÒN BẢO HÀNH");
            } else {
                history.put("trangThaiBaoHanh", "HẾT BẢO HÀNH");
            }
        } else {
            history.put("trangThaiBaoHanh", "CHƯA BÁN");
        }

        return history;
    }

    @Override
    public void capNhatTrangThai(String soSeri, Integer trangThaiMoi) {
        MayIn mayIn = timTheoSeri(soSeri);
        mayIn.setTrangThai(trangThaiMoi);
        mayInDAO.save(mayIn);
    }

    @Override
    public void chuyenKho(String soSeri, Integer maKhoMoi) {
        MayIn mayIn = timTheoSeri(soSeri);
        Kho khoMoi = khoDAO.findById(maKhoMoi)
                .orElseThrow(() -> new RuntimeException("Kho đích không tồn tại"));

        mayIn.setKho(khoMoi);
        // Có thể thêm logic ghi log vào bảng Lịch sử chuyển kho ở đây (nếu có)
        mayInDAO.save(mayIn);
    }
}