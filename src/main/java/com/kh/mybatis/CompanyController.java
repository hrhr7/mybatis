package com.kh.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/company") // 전체 경로
public class CompanyController {
//    의존성주입 필요
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private CompanyService companyService;

    @PostMapping("") // 하위경로 지정안함
    public int post(@RequestBody Company company){
        return companyMapper.insert(company);
    }
    @GetMapping("")
    public List<Company> getAll(){
        return companyService.getAll();
    }
}
// 값 읽을 때 get으로