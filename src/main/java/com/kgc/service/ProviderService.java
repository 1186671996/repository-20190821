package com.kgc.service;

import java.util.List;

import com.kgc.pojo.Provider;

public interface ProviderService
{
    /**
     * 查询全部
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<Provider> selectAll();
    /**
     * 按名字查询
     * <一句话功能简述>
     * <功能详细描述>
     * @param proAddress
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<Provider> selectByLikeName(String proAddress);
    /**
     * 添加
     * <一句话功能简述>
     * <功能详细描述>
     * @param provider
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int insertProvider(Provider provider);
    
    /**
     * 删除
     * <一句话功能简述>
     * <功能详细描述>
     * @param id
     * @see [类、类#方法、类#成员]
     */
    public int deleteProvider(int id);
    
    /**
     * 查找供应商按照id
     * <一句话功能简述>
     * <功能详细描述>
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public Provider findProviderById(int id);
    
    /**
     * 修改
     * <一句话功能简述>
     * <功能详细描述>
     * @param provider
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int updateProvider(Provider provider);
}
