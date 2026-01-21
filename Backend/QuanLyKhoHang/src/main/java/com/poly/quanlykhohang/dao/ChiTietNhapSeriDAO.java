package com.poly.quanlykhohang.dao;

import com.poly.quanlykhohang.entity.ChiTietNhapSeri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ChiTietNhapSeriDAO extends JpaRepository<ChiTietNhapSeri, Long> {

    // Truy xuất nguồn gốc: Máy này nhập ở phiếu nào?
    Optional<ChiTietNhapSeri> findByMayIn_MaSeri(String maSeri);
}