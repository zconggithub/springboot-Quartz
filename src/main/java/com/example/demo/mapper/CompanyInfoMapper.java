package com.example.demo.mapper;

import com.example.demo.bean.CompanyInfo;

public interface CompanyInfoMapper {
   

    int deleteByPrimaryKey(Integer id);

    int insert(CompanyInfo record);

    int insertSelective(CompanyInfo record);

   

    CompanyInfo selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(CompanyInfo record);

    int updateByPrimaryKey(CompanyInfo record);
}