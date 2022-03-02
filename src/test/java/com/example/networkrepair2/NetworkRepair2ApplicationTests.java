package com.example.networkrepair2;

import com.example.networkrepair2.mapper.AdministratorListMapper;
import com.example.networkrepair2.service.AdministratorListService;
import com.example.networkrepair2.service.impl.AdministratorListServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NetworkRepair2ApplicationTests {
    @Autowired
    AdministratorListServiceImpl administratorListService;
    @Autowired
    AdministratorListMapper administratorListMapper;

    @Test
    void contextLoads() {
        System.out.println(administratorListService.list(null));
    }

    @Test
    void test(){
        System.out.println(administratorListMapper.selectAllByAdministratorNumber(9999L));
    }

}
