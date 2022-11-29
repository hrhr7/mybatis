package com.kh.mybatis;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyMapper {
//    mybatis 문법
//    컬럼명 대소문자 꼭 구별하기
    @Insert("INSERT INTO company(company_name, company_address) VALUES(#{company.name}, #{company.address})")
//    id 값은 자동생성해야해서
    @Options(useGeneratedKeys = true, keyProperty = "id")
//  insert 쿼리문 호출해야하는 메서드, 테이블이랑 매핑해야하는 객체 만듦
    int insert(@Param("company") Company company);

    @Select("SELECT * FROM company") //company list 나옴
    @Results({
            @Result(property = "name", column = "company_name"),
            @Result(property = "address", column = "company_address")
    })
//    결과 list 타입으로 넘겨받음=>select문 완성~!
    List<Company> getAll();
}
