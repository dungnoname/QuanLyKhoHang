package com.poly.quanlykhohang.dao;

import com.poly.quanlykhohang.entity.ChiTietXuatSeri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ChiTietXuatSeriDAO extends JpaRepository<ChiTietXuatSeri, Long> {

    // Tìm thông tin xuất kho (Ngày bán, Phiếu bán) dựa trên Số Seri
    // Dùng để check hạn bảo hành
    @Query("SELECT ctx FROM ChiTietXuatSeri ctx " +
            "JOIN FETCH ctx.chiTietPhieuXuat ct " +
            "JOIN FETCH ct.phieuXuat p " +
            "WHERE ctx.mayIn.maSeri = :maSeri")
    Optional<ChiTietXuatSeri> findExportInfoBySerial(String maSeri);
}