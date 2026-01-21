package com.poly.quanlykhohang.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "DMSanPham")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SanPham {

    @Id
    @Column(name = "MaSP", length = 50)
    private String maSP; // Khóa chính (String)

    @Column(name = "TenSP", nullable = false, length = 200)
    private String tenSP;

    @Column(name = "DonViTinh", length = 50)
    private String donViTinh;

    @Column(name = "MoTa", columnDefinition = "NVARCHAR(MAX)")
    private String moTa;

    @Column(name = "Hieu", length = 100) // Thương hiệu
    private String thuongHieu;

    @Column(name = "Gia")
    private BigDecimal giaNiemYet; // Giá cơ bản

    // Bổ sung cho chức năng cảnh báo tồn kho (2.2)
    @Column(name = "MinStock")
    private Integer tonToiThieu;

    @Column(name = "MaxStock")
    private Integer tonToiDa;

    // Quan hệ với Loại sản phẩm (nếu có bảng LoaiSP)
    @Column(name = "MaLoai")
    private Integer maLoai;
}