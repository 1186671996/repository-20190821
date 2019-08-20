package com.kgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.junit.runners.Parameterized.Parameter;

import com.kgc.pojo.Bill;

public interface BillMapper
{
    @Select("select * from smbms_bill")
    public List<Bill> selectByPrividerId(int productName);
    
    @Select("SELECT * FROM smbms_bill WHERE productName  like '%${value}%'")
    public List<Bill> selectLikeName(String productName);
    
    @Select("select*from  smbms_bill  where  productName=#{productName}  and  providerId=#{providerId}  and isPayment=#{isPayment}")
    public List<Bill> selectByLike(@Param("productName")String productName,@Param("providerId")int providerId,@Param("isPayment")int isPayment);
}
