package com.poly.quanlykhohang.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Kho")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKho")
    private Integer maKho;

    @Column(name = "TenKho", nullable = false)
    private String tenKho;

    @Column(name = "DiaChi")
    private String diaChi;
}