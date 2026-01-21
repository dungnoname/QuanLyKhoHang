package com.poly.quanlykhohang.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "PhieuXuat")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhieuXuat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SoPhieu")
    private Long soPhieu;

    @ManyToOne
    @JoinColumn(name = "MaDonVi") // Khách hàng
    private DonVi khachHang;

    @ManyToOne
    @JoinColumn(name = "MaKho") // Xuất từ kho nào
    private Kho khoXuat;

    @Column(name = "NgayXuat")
    private LocalDateTime ngayXuat;

    @Column(name = "TongTien")
    private BigDecimal tongTien;

    @Column(name = "VAT")
    private BigDecimal thueVAT;

    @Column(name = "GhiChu")
    private String ghiChu;

    // Quan hệ 1-Nhiều: Một phiếu có nhiều dòng chi tiết sản phẩm
    @OneToMany(mappedBy = "phieuXuat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietPhieuXuat> danhSachChiTiet;
}