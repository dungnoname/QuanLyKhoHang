package com.poly.quanlykhohang.dao;

import com.poly.quanlykhohang.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SanPhamDAO extends JpaRepository<SanPham, String> {

    // Tìm kiếm theo tên sản phẩm
    List<SanPham> findByTenSPContainingIgnoreCase(String tenSP);

    // Cảnh báo hàng sắp hết (Tồn thực tế < MinStock)
    @Query("SELECT sp FROM SanPham sp " +
            "WHERE (SELECT COUNT(m) FROM MayIn m WHERE m.sanPham = sp AND m.trangThai = 1) < sp.tonToiThieu")
    List<SanPham> findLowStockProducts();
}