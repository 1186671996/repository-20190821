package com.kgc.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kgc.mapper.UserMapper;
import com.kgc.pojo.Role;
import com.kgc.pojo.User;

@Repository
public class UserServiceImpl implements UserService
{
    private Logger logger = Logger.getLogger(UserServiceImpl.class);
    
    @Autowired
    UserMapper userMapper;
    
    @Override
    public List<User> selectAll(User user)
    {
        return userMapper.selectAll(user);
    }

    @Override
    public void insertUser(User user)
    {
        userMapper.insertUser(user);
    }

    @Override
    public User login(User user) throws Exception
    {
        // TODO Auto-generated method stub
        User  u = userMapper.login(user);
        if(u == null)
        {
            throw new Exception("用户不存在，请检查此用户");
        }
        return u;
    }

    @Override
    public List<Role> selectRole()
    {
        // TODO Auto-generated method stub
        return userMapper.selectRole();
    }

    @Override
    public int deleteUserById(Integer uid)
    {
        // TODO Auto-generated method stub
        
        return userMapper.deleteUserById(uid);
    }

    @Override
    public User findUserById(int id)
    {
        // TODO Auto-generated method stub
        
        return userMapper.selectRoleById(id);
    }

    @Override
    public int updataUser(User user)
    {
        // TODO Auto-generated method stub
        
        return userMapper.updateUser(user);
    }
    
}
