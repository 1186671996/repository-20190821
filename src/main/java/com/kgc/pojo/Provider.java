package com.kgc.pojo;

import java.util.Date;
import java.util.List;

/**
 * 供应商
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年11月28日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Provider
{
    
    private int id; // id
    
    private String proCode; // 供应商编码
    
    private String proName; // 供应商名称
    
    private String proDesc; // 供应商描述
    
    private String proContact; // 供应商联系人
    
    private String proPhone; // 供应商电话
    
    private String proAddress; // 供应商地址
    
    private String proFax; // 供应商传真
    
    private int createdBy; // 创建者
    
    private Date creationDate; // 创建时间
    
    private int modifyBy; // 更新者
    
    private Date modifyDate;// 更新时间
    
    private String companyLicPicPath;
    
    private String orgCodePicPath;
    
    private List<Bill> listBill;
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getProCode()
    {
        return proCode;
    }
    
    public void setProCode(String proCode)
    {
        this.proCode = proCode;
    }
    
    public String getProName()
    {
        return proName;
    }
    
    public void setProName(String proName)
    {
        this.proName = proName;
    }
    
    public String getProDesc()
    {
        return proDesc;
    }
    
    public void setProDesc(String proDesc)
    {
        this.proDesc = proDesc;
    }
    
    public String getProContact()
    {
        return proContact;
    }
    
    public void setProContact(String proContact)
    {
        this.proContact = proContact;
    }
    
    public String getProPhone()
    {
        return proPhone;
    }
    
    public void setProPhone(String proPhone)
    {
        this.proPhone = proPhone;
    }
    
    public String getProAddress()
    {
        return proAddress;
    }
    
    public void setProAddress(String proAddress)
    {
        this.proAddress = proAddress;
    }
    
    public String getProFax()
    {
        return proFax;
    }
    
    public void setProFax(String proFax)
    {
        this.proFax = proFax;
    }
    
    public int getCreatedBy()
    {
        return createdBy;
    }
    
    public void setCreatedBy(int createdBy)
    {
        this.createdBy = createdBy;
    }
    
    public Date getCreationDate()
    {
        return creationDate;
    }
    
    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }
    
    public int getModifyBy()
    {
        return modifyBy;
    }
    
    public void setModifyBy(int modifyBy)
    {
        this.modifyBy = modifyBy;
    }
    
    public Date getModifyDate()
    {
        return modifyDate;
    }
    
    public void setModifyDate(Date modifyDate)
    {
        this.modifyDate = modifyDate;
    }

    public List<Bill> getListBill()
    {
        return listBill;
    }

    public void setListBill(List<Bill> listBill)
    {
        this.listBill = listBill;
    }

    
    public String getCompanyLicPicPath()
    {
        return companyLicPicPath;
    }

    public void setCompanyLicPicPath(String companyLicPicPath)
    {
        this.companyLicPicPath = companyLicPicPath;
    }

    public String getOrgCodePicPath()
    {
        return orgCodePicPath;
    }

    public void setOrgCodePicPath(String orgCodePicPath)
    {
        this.orgCodePicPath = orgCodePicPath;
    }

    @Override
    public String toString()
    {
        return "Provider [id=" + id + ", proCode=" + proCode + ", proName=" + proName + ", proDesc=" + proDesc
            + ", proContact=" + proContact + ", proPhone=" + proPhone + ", proAddress=" + proAddress + ", proFax="
            + proFax + ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", modifyBy=" + modifyBy
            + ", modifyDate=" + modifyDate + "]";
    }
    
}
