package com.poly.quanlykhohang.service.impl;

import com.poly.quanlykhohang.dao.KhoDAO;
import com.poly.quanlykhohang.dao.MayInDAO;
import com.poly.quanlykhohang.entity.Kho;
import com.poly.quanlykhohang.service.KhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KhoServiceImpl implements KhoService {

    private final KhoDAO khoDAO;
    private final MayInDAO mayInDAO; // Dùng để check ràng buộc

    @Override
    public List<Kho> layDanhSachKho() {
        return khoDAO.findAll();
    }

    @Override
    public Kho luuKho(Kho kho) {
        return khoDAO.save(kho);
    }

    @Override
    public void xoaKho(Integer maKho) {
        // Logic nghiệp vụ: Không cho xóa kho nếu còn máy bên trong
        var dsMay = mayInDAO.findByKho_MaKho(maKho);
        if (!dsMay.isEmpty()) {
            throw new RuntimeException("Không thể xóa kho này vì vẫn còn " + dsMay.size() + " máy đang tồn kho!");
        }
        khoDAO.deleteById(maKho);
    }
}