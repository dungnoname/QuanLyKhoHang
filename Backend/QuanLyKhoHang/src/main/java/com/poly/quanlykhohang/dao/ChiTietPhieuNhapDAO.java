package com.poly.quanlykhohang.dao;

import com.poly.quanlykhohang.entity.ChiTietPhieuNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChiTietPhieuNhapDAO extends JpaRepository<ChiTietPhieuNhap, Long> {

    // Lấy danh sách chi tiết của 1 phiếu nhập
    List<ChiTietPhieuNhap> findByPhieuNhap_SoPhieu(Long soPhieu);
}