package com.poly.quanlykhohang.dao;

import com.poly.quanlykhohang.entity.Kho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoDAO extends JpaRepository<Kho, Integer> {
}