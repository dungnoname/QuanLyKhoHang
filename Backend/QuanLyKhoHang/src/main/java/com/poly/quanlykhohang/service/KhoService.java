package com.poly.quanlykhohang.service;

import com.poly.quanlykhohang.entity.Kho;
import java.util.List;

public interface KhoService {
    List<Kho> layDanhSachKho();
    Kho luuKho(Kho kho);
    void xoaKho(Integer maKho);
}