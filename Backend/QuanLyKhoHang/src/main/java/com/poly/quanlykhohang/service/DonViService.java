package com.poly.quanlykhohang.service;

import com.poly.quanlykhohang.entity.DonVi;
import java.util.List;

public interface DonViService {
    List<DonVi> layTatCa();
    List<DonVi> layDanhSachNhaCungCap();
    List<DonVi> layDanhSachKhachHang();
    DonVi luuDonVi(DonVi donVi);
    void xoaDonVi(String maDonVi);
}