package com.example.keymanage.dao;

import com.example.keymanage.model.Apply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplyRepository extends JpaRepository<Apply,Integer> {
    public List<Apply> findByCompany(String company);
    public List<Apply> findByCompanyAndIsApply(String company,String isApply);
}
