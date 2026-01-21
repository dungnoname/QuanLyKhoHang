package com.poly.quanlykhohang.dao;

import com.poly.quanlykhohang.entity.ChiTietPhieuXuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietPhieuXuatDAO extends JpaRepository<ChiTietPhieuXuat, Long> {
}