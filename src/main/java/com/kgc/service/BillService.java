package com.kgc.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kgc.pojo.Bill;

public interface BillService
{
    public List<Bill> selectLikeName(String productName);
    public List<Bill> selectByLike(String productName,int providerId,int isPayment);
    
    /**
     * 查询全部
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<Bill> selectAll();
    
    /**
     * 根据id查询订单
     * <一句话功能简述>
     * <功能详细描述>
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public Bill selectBill(int id);
    
    /**
     * 删除
     * <一句话功能简述>
     * <功能详细描述>
     * @param billId
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int delBill(int billId);
}
