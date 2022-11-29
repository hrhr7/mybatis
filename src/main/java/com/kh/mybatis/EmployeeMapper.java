package com.kh.mybatis;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Insert("INSERT INTO employee(company_id, employee_name, employee_address) " +
            "VALUES(#{employee.companyId},#{employee.name},#{employee.address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("employee") Employee employee);

    @Select("SELECT * FROM employee")
//    재사용을 위해 id 값을 하나 더 넣음
    @Results(id = "EmployeeMap", value = {
            @Result(property = "companyId", column = "company_id"),
            @Result(property = "name", column = "employee_name"),
            @Result(property = "address", column = "employee_address")
    })
//    결과 list로 받음
    List<Employee> getAll();

//    개별아이디로 조회
    @Select("SELECT * FROM employee WHERE id=#{id}")
    @ResultMap("EmployeeMap")
    Employee getById(@Param("id") int id);

    @Select("SELECT * FROM employee WHERE company_id = #{companyId}")
    @ResultMap("EmployeeMap")
    List<Employee> getByCompanyId(@Param("companyId") int companyId);
}
