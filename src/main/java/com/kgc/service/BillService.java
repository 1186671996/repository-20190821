package com.kgc.service;

import java.util.List;

import com.kgc.pojo.Bill;

public interface BillService
{
    public List<Bill> selectLikeName(String productName);
    public List<Bill> selectByLike(String productName,int providerId,int isPayment);

}
