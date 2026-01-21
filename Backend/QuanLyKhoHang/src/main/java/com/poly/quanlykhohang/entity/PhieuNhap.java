package com.poly.quanlykhohang.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "PhieuNhap")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhieuNhap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SoPhieu")
    private Long soPhieu;

    // Nhà cung cấp (Lấy từ bảng DonVi với LoaiDonVi = 1)
    @ManyToOne
    @JoinColumn(name = "MaDonVi")
    private DonVi nhaCungCap;

    // Nhập vào kho nào
    @ManyToOne
    @JoinColumn(name = "MaKho")
    private Kho khoNhap;

    @Column(name = "NgayNhap")
    private LocalDateTime ngayNhap;

    @Column(name = "TongTien")
    private BigDecimal tongTien;

    @Column(name = "VAT")
    private BigDecimal thueVAT;

    @Column(name = "GhiChu")
    private String ghiChu;

    // Quan hệ 1-Nhiều: Một phiếu nhập chứa nhiều dòng chi tiết sản phẩm
    @OneToMany(mappedBy = "phieuNhap", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietPhieuNhap> danhSachChiTiet;
}