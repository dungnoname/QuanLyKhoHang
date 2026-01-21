package com.poly.quanlykhohang.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CTXuat_Seri")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietXuatSeri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    // Liên kết ngược về bảng Cấp 2 (ChiTietPhieuXuat)
    // Cột này trong DB tên là CTPhieuXuatID (hoặc Ref_DetailID)
    @ManyToOne
    @JoinColumn(name = "CTPhieuXuatID", nullable = false)
    private ChiTietPhieuXuat chiTietPhieuXuat;

    // Liên kết tới cái máy cụ thể trong kho
    @ManyToOne
    @JoinColumn(name = "MaMay", nullable = false)
    private MayIn mayIn;
}