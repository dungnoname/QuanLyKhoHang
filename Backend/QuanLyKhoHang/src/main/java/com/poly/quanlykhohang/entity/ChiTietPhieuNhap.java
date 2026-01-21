package com.poly.quanlykhohang.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "CTPhieuNhap")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietPhieuNhap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID") // Hoặc CTPhieuNhapID tùy bạn đặt trong SQL
    private Long id;

    // Liên kết ngược về bảng Cha (PhieuNhap)
    @ManyToOne
    @JoinColumn(name = "SoPhieu", nullable = false)
    private PhieuNhap phieuNhap;

    // Nhập dòng máy nào (Canon 2900, HP 1020...)
    @ManyToOne
    @JoinColumn(name = "MaSP", nullable = false)
    private SanPham sanPham;

    @Column(name = "SoLuong")
    private Integer soLuong; // Ví dụ: Nhập 10 cái

    @Column(name = "DonGia")
    private BigDecimal donGia; // Giá vốn nhập vào

    @Column(name = "GhiChu")
    private String ghiChu;

    // Quan hệ 1-Nhiều: Danh sách các seri cụ thể của dòng này (Cấp 3)
    @OneToMany(mappedBy = "chiTietPhieuNhap", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietNhapSeri> danhSachSeri;
}