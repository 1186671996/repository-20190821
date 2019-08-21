package com.kgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.stereotype.Repository;

import com.kgc.pojo.Bill;

@Repository
public interface BillMapper
{
    /**
     * 查询全部
     * <一句话功能简述>
     * <功能详细描述>
     * @param productName
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("select * from smbms_bill")
    public List<Bill> selectAll();
    
    /**
     * 根据id查询订单
     * <一句话功能简述>
     * <功能详细描述>
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Select("select * from smbms_bill where id = #{id}")
    public Bill selectBill(int id);
    
    /**
     * 删除
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Delete("delete from smbms_bill where id = #{billId}")
    public int delBill(int billId);
    
    /**
     * 添加
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Insert("insert into smbms_bill (billCode,productName,productDesc,"
        + "productUnit,productCount,totalPrice,isPayment) values(#{billCode},"
        + "#{productName},#{productDesc},#{productUnit},#{productCount},"
        + "#{totalPrice},#{isPayment},)")
    public int insertBill();
}
