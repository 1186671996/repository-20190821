package com.kgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.kgc.pojo.Role;
import com.kgc.pojo.User;

@Repository
public interface UserMapper
{
    /**
     * 查询全部
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
//    @Select("select * from smbms_user")
    public List<User> selectAll(User user);
    
    public User findUserById(@Param("id") int id);
    
    public List<User> findUserLikeName(String name);
    
    public User findUserByName(String name);
    
    /**
     * 添加
     * <一句话功能简述>
     * <功能详细描述>
     * @param user
     * @see [类、类#方法、类#成员]
     */
    public void insertUser(User user);
    
    public int updateUser(User user);
    
    public void delete(User user);
    
    public User selectRoleById(@Param("id") int id);
    
    public User selectAdressById(@Param("id") int id);
    
    /**
     * 登录
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("select * from smbms_user where userCode = #{userCode} and userPassword=#{userPassword}")
    public User login(User user);
    
    /**
     * 查询全部角色
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("select * from smbms_role")
    public List<Role> selectRole();
    
    /**
     * 删除
     * <一句话功能简述>
     * <功能详细描述>
     * @param id
     * @see [类、类#方法、类#成员]
     */
    @Delete("delete from smbms_user where id=#{uid}")
    public int deleteUserById(Integer uid);
}
