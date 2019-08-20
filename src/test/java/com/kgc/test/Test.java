package com.kgc.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kgc.mapper.UserMapper;
import com.kgc.pojo.User;
import com.kgc.service.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class Test
{
    private Logger logger = Logger.getLogger(Test.class);
    
    @Autowired
    UserMapper userMapper;
    
    @org.junit.Test
    public void selectAll()
    {
        User user = new User();
        System.out.println(userMapper.selectAll(user));
        
    }
}
