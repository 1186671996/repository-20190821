package com.kgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.kgc.pojo.Provider;

@Repository
public interface ProviderMapper
{
    /**
     * 查询全部
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("select * from smbms_provider")
    public List<Provider> selectAll();
    /**
     * 添加
     * <一句话功能简述>
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    @Insert("insert into smbms_provider (proCode,proName,proDesc,proContact,proPhone,proAddress,proFax,createdBy,creationDate,modifyDate,modifyBy,companyLicPicPath,orgCodePicPath)"
        + " values (#{proCode},#{proName},#{proDesc},#{proContact},#{proPhone},#{proAddress},#{proFax},#{createdBy},#{creationDate},#{modifyDate},#{modifyBy},#{companyLicPicPath},#{orgCodePicPath})")
    public int insertProvider(Provider provider);
    /**
     * 修改
     * <一句话功能简述>
     * <功能详细描述>
     * @param provider
     * @see [类、类#方法、类#成员]
     */
    @Update("update smbms_provider set proCode=#{proCode},proName=#{proName},proDesc=#{proDesc},proContact=#{proContact},proCode=#{proCode},"
        + "proPhone=#{proPhone},proAddress=#{proAddress},proFax=#{proFax}"
        + ",createdBy=#{createdBy},creationDate=#{creationDate} where id = #{id}")
    public int updateProvider(Provider provider);
    /**
     * 删除
     * <一句话功能简述>
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    @Delete("delete from smbms_provider where id = #{id}")
    public int deleteProvider(int id);
    /**
     * 获取根据条件查询的总记录数
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("SELECT COUNT(*)  FROM smbms_provider WHERE proAddress  like '%${value}%'")
    public int countOfSelectByLike(String proAddress);
    
    /**
     * 获取供应商以及订单列表 注解
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    
    @Select("select * from smbms_provider")
    @Results({
        @Result(column="id",property="id"),
        @Result(column="proCode",property="proCode"),
        @Result(column="proName",property="proName"),
        @Result(column="proDesc",property="proName"),
        @Result(column="proCintact",property="proCintact"),
        @Result(column="proAddress",property="proAddress"),
        @Result(property="listBill",column="id",many=@Many(select="com.mybatis.dao.BillMapper.selectByProviderId"))
        })
    public List<Provider> selectAllAndBill();
    /**
     * 条件可以按照供应商名称的模糊查询
     * <一句话功能简述>
     * <功能详细描述> 
     * @param proAddress
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("SELECT * FROM smbms_provider WHERE proName  like '%${value}%'")
    public List<Provider> SelectByLikeName(String proAddress);
    
    /**
     * 查找供应商按照id
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("select * from smbms_provider where id = #{id}")
    public Provider findProviderById(int id);
}
