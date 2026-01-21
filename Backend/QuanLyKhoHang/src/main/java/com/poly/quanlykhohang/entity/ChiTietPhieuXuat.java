package com.poly.quanlykhohang.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "CTPhieuXuat")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietPhieuXuat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID") // Hoặc CTPhieuXuatID
    private Long id;

    // Liên kết ngược về bảng Cha (PhieuXuat)
    @ManyToOne
    @JoinColumn(name = "SoPhieu", nullable = false)
    private PhieuXuat phieuXuat;

    // Liên kết với Sản phẩm (Để biết dòng này bán máy loại gì)
    @ManyToOne
    @JoinColumn(name = "MaSP", nullable = false)
    private SanPham sanPham;

    @Column(name = "SoLuong")
    private Integer soLuong; // Tổng số lượng của dòng này (VD: 5 cái Canon)

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Column(name = "GhiChu")
    private String ghiChu;

    // Quan hệ 1-Nhiều: Một dòng chi tiết chứa danh sách các seri cụ thể (Cấp 3)
    @OneToMany(mappedBy = "chiTietPhieuXuat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietXuatSeri> danhSachSeri;
}