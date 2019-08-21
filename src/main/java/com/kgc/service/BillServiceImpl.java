package com.kgc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kgc.mapper.BillMapper;
import com.kgc.pojo.Bill;

@Repository
public class BillServiceImpl implements BillService
{
    @Autowired
    BillMapper billMapper;

    @Override
    public List<Bill> selectLikeName(String productName)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Bill> selectByLike(String productName, int providerId, int isPayment)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Bill> selectAll()
    {
        // TODO Auto-generated method stub
        return billMapper.selectAll();
    }

    @Override
    public Bill selectBill(int id)
    {
        // TODO Auto-generated method stub
        return billMapper.selectBill(id);
    }

    @Override
    public int delBill(int billId)
    {
        // TODO Auto-generated method stub
        
        return billMapper.delBill(billId);
    }
    
    
}
