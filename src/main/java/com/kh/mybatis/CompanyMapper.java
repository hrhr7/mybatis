package com.kh.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CompanyMapper {
//    mybatis 문법
    @Insert("INSERT INTO company(company_name, company_address) VALUES(#{company.name}, #{company.address})")
//    id 값은 자동생성해야해서
    @Options(useGeneratedKeys = true, keyProperty = "id")
//        호출해야하는 메서드, 테이블이랑 매핑해야하는 객체 만듦
    int insert(@Param("company") Company company);
    

}
