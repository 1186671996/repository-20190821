package com.kgc.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kgc.pojo.Provider;
import com.kgc.service.ProviderService;


@Controller
@RequestMapping
public class ProviderController
{
    private Logger logger = Logger.getLogger(ProviderController.class);
    @Resource
    private ProviderService providerService;
    
    // 当前端页面传过来的的String类型的日期与后台实体类的Date类型不匹配时，需要加上该方法
    @InitBinder
    public void init(WebDataBinder binder)
    {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
    
    /**
     * 跳转并查询全部供应商
     * <一句话功能简述>
     * <功能详细描述>
     * @param model
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("providerlist.html")
    public String providerlist(Model model, Provider provider,
        @RequestParam(value = "pageIndex", required = false) Integer pageIndex)
    {
        if (pageIndex == null || pageIndex == 0)
        {
            pageIndex = 1;
        }
        PageHelper.startPage(pageIndex, 5);
        List<Provider> list = providerService.selectAll();
        Page page = (Page)list;
        model.addAttribute("providerList",list);
        model.addAttribute("totalCount", page.getTotal());
        model.addAttribute("currentPageNo", pageIndex);
        model.addAttribute("totalPageCount", page.getPages());
        return "providerlist";
    }
    
    /**
     * 跳转添加界面
     * <一句话功能简述>
     * <功能详细描述>
     * @param model
     * @param provider
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("provideradd.html")
    public String provideradd(Model model, Provider provider)
    {
        return "provideradd";
        
    }
    
    /**
     * 添加
     * <一句话功能简述>
     * <功能详细描述>
     * @param model
     * @param provider
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping(value="provideraddsave.do",method = RequestMethod.POST)
    public String provideraddsave(Provider provider,HttpSession session, HttpServletRequest request,
        @RequestParam(value = "attachs", required = false) MultipartFile[] attachs)
    {
        String idPicPath = null;
        String workPicPath = null;
        String errorInfo = null;
        boolean flag = true;
        String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
        logger.info("uploadFile path ============== > " + path);
        for (int i = 0; i < attachs.length; i++)
        {
            MultipartFile attach = attachs[i];
            if (!attach.isEmpty())
            {
                if (i == 0)
                {
                    errorInfo = "uploadFileError";
                }
                else if (i == 1)
                {
                    errorInfo = "uploadWpError";
                }
                String oldFileName = attach.getOriginalFilename();// 原文件名
                logger.info("uploadFile oldFileName ============== > " + oldFileName);
                String prefix = FilenameUtils.getExtension(oldFileName);// 原文件后缀
                logger.debug("uploadFile prefix============> " + prefix);
                int filesize = 500000;
                logger.debug("uploadFile size============> " + attach.getSize());
                if (attach.getSize() > filesize)
                {// 上传大小不得超过 500k
                    request.setAttribute(errorInfo, " * 上传大小不得超过 500k");
                    flag = false;
                }
                else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png")
                    || prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg"))
                {// 上传图片格式不正确
                    String fileName = System.currentTimeMillis() + RandomUtils.nextInt() + "_Personal.jpg";
                    logger.debug("new fileName======== " + attach.getName());
                    File targetFile = new File(path, fileName);
                    if (!targetFile.exists())
                    {
                        targetFile.mkdirs();
                    }
                    // 保存
                    try
                    {
                        attach.transferTo(targetFile);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                        request.setAttribute(errorInfo, " * 上传失败！");
                        flag = false;
                    }
                    if (i == 0)
                    {
                        idPicPath = path + File.separator + fileName;
                    }
                    else if (i == 1)
                    {
                        workPicPath = path + File.separator + fileName;
                    }
                    logger.debug("idPicPath: " + idPicPath);
                    logger.debug("workPicPath: " + workPicPath);
                    
                }
                else
                {
                    request.setAttribute(errorInfo, " * 上传图片格式不正确");
                    flag = false;
                }
            }
        }
        if (flag)
        {
            // user.setCreatedBy(((User)session.getAttribute(Constants.USER_SESSION)).getId());
            provider.setCreationDate(new Date());
            provider.setCompanyLicPicPath(idPicPath);
            provider.setOrgCodePicPath(workPicPath);
            try
            {
                providerService.insertProvider(provider);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                // TODO: handle exception
            }
            
            return "redirect:userlist.html";
        }
        return "useradd";
    }
    /**
     * 删除ajax
     * <一句话功能简述>
     * <功能详细描述>
     * @param proid
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("delprovider.do")
    public @ResponseBody Map delProvider(int proid)
    {
        int result = providerService.deleteProvider(proid);
        Map<String, String> map = new HashMap<String, String>();
        if (result > 0)
        {
            map.put("delResult", "true");
        }
        else {
            map.put("delResult", "a");
        }
        return map;
        
    }
    /**
     * 修改
     * <一句话功能简述>
     * <功能详细描述>
     * @param model
     * @param provider
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("provider.do")
    public String provider(Model model,Integer  proid)
    {
        
        Provider provider = providerService.findProviderById(proid);
        model.addAttribute("provider",provider);
        return "providermodify";
        
    }
    
    /**
     * 修改
     * <一句话功能简述>
     * <功能详细描述>
     * @param provider
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("modifysave.html")
    public String modifysave(Provider provider)
    {
        int result = providerService.updateProvider(provider);
        return "redirect:providerlist.html";
        
    }
    
    
    
    @RequestMapping("/providerview.do")
    public String providerview(int proid,Model model)
    {
        Provider provider = providerService.findProviderById(proid);
        model.addAttribute("provider",provider);
        return "providerview";
        
    }
    
    
}
