package com.poly.quanlykhohang.service.impl;

import com.poly.quanlykhohang.dao.DonViDAO;
import com.poly.quanlykhohang.entity.DonVi;
import com.poly.quanlykhohang.service.DonViService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DonViServiceImpl implements DonViService {

    private final DonViDAO donViDAO;

    @Override
    public List<DonVi> layTatCa() {
        return donViDAO.findAll();
    }

    @Override
    public List<DonVi> layDanhSachNhaCungCap() {
        return donViDAO.findByLoaiDonVi(1); // 1 = Nhà cung cấp
    }

    @Override
    public List<DonVi> layDanhSachKhachHang() {
        return donViDAO.findByLoaiDonVi(2); // 2 = Khách hàng
    }

    @Override
    public DonVi luuDonVi(DonVi donVi) {
        // Có thể thêm logic check trùng SĐT ở đây
        return donViDAO.save(donVi);
    }

    @Override
    public void xoaDonVi(String maDonVi) {
        donViDAO.deleteById(maDonVi);
    }
}