package com.kgc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kgc.pojo.Role;
import com.kgc.pojo.User;

public interface UserService
{
    /**
     * 登录
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @throws Exception 
     * @see [类、类#方法、类#成员]
     */
    public User login(User user) throws Exception;
    /**
     * 查询全部
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<User> selectAll(User user);
    
    /**
     * 添加
     * <一句话功能简述>
     * <功能详细描述>
     * @param user
     * @see [类、类#方法、类#成员]
     */
    public void insertUser(User user);
    
    /**
     * c查询role
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<Role> selectRole();
    /**
     * 删除
     * <一句话功能简述>
     * <功能详细描述>
     * @param uid
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int deleteUserById(Integer uid);
    
    /**
     * 根据id查找user
     * <一句话功能简述>
     * <功能详细描述>
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public User findUserById(int id);
    /**
     * 修改
     * <一句话功能简述>
     * <功能详细描述>
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int updataUser(User user);
}
