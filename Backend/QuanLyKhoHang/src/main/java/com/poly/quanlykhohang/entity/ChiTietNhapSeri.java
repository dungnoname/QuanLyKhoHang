package com.poly.quanlykhohang.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CTNhap_Seri")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietNhapSeri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    // Liên kết ngược về bảng Cấp 2 (ChiTietPhieuNhap)
    // Cột này trong DB tên là CTPhieuNhapID
    @ManyToOne
    @JoinColumn(name = "CTPhieuNhapID", nullable = false)
    private ChiTietPhieuNhap chiTietPhieuNhap;

    // Liên kết tới cái máy cụ thể vừa được tạo ra trong kho
    @ManyToOne
    @JoinColumn(name = "MaMay", nullable = false)
    private MayIn mayIn;
}