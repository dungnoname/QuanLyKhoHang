package com.poly.quanlykhohang.dao;

import com.poly.quanlykhohang.entity.MayIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface MayInDAO extends JpaRepository<MayIn, String> {

    // Tìm máy theo số Seri (quét mã vạch)
    Optional<MayIn> findBySoSeri(String soSeri);

    // Lấy danh sách máy khả dụng của 1 dòng sản phẩm (Trạng thái = 1: Tồn kho)
    @Query("SELECT m FROM MayIn m WHERE m.sanPham.maSP = :maSP AND m.trangThai = 1")
    List<MayIn> findAvailableMachinesByProduct(String maSP);

    // Đếm tồn kho của 1 mã sản phẩm
    @Query("SELECT COUNT(m) FROM MayIn m WHERE m.sanPham.maSP = :maSP AND m.trangThai = 1")
    Long countStockByProduct(String maSP);

    // Tìm máy theo kho (Dùng cho kiểm kê)
    List<MayIn> findByKho_MaKho(Integer maKho);
}