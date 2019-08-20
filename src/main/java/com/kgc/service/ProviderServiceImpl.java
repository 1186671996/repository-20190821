package com.kgc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kgc.mapper.ProviderMapper;
import com.kgc.mapper.UserMapper;
import com.kgc.pojo.Provider;

@Service
public class ProviderServiceImpl implements ProviderService
{
    @Autowired
    ProviderMapper providerMapper;

    @Override
    public List<Provider> selectAll()
    {
        
        return providerMapper.selectAll();
    }

    @Override
    public List<Provider> selectByLikeName(String proAddress)
    {
        return providerMapper.SelectByLikeName(proAddress);
    }

    @Override
    public int insertProvider(Provider provider)
    {
        // TODO Auto-generated method stub
        
        return providerMapper.insertProvider(provider);
    }

    @Override
    public int deleteProvider(int id)
    {
        return providerMapper.deleteProvider(id);
    }

    @Override
    public Provider findProviderById(int id)
    {
        // TODO Auto-generated method stub
        
        return providerMapper.findProviderById(id);
    }

    @Override
    public int updateProvider(Provider provider)
    {
        // TODO Auto-generated method stub
        
        return providerMapper.updateProvider(provider);
    }
    
}
