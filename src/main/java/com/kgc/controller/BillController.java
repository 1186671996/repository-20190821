package com.kgc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.MapBindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kgc.pojo.Bill;
import com.kgc.pojo.Role;
import com.kgc.pojo.User;
import com.kgc.service.BillService;
import com.kgc.service.UserService;

@Controller
@RequestMapping
public class BillController
{
    @Resource
    BillService billService;
    
    @RequestMapping("bill.do")
    public String billList(Model model, User user,
        @RequestParam(value = "pageIndex", required = false) Integer pageIndex)
        throws Exception
    {
        System.out.println(user.getUserName());
        if (pageIndex == null || pageIndex == 0)
        {
            pageIndex = 1;
        }
        PageHelper.startPage(pageIndex, 4);
        List<Bill> billList = billService.selectAll();
        Page page = (Page)billList;
        System.out.println(billList);
        model.addAttribute("billList", billList);
        model.addAttribute("totalCount", page.getTotal());
        model.addAttribute("currentPageNo", pageIndex);
        model.addAttribute("totalPageCount", page.getPages());
        return "billlist";
    }
    
    /**
     * 跳转查看 <一句话功能简述> <功能详细描述>
     * 
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("billview.html")
    public String billview(int billid, Model model)
    {
        model.addAttribute("bill", billService.selectBill(billid));
        return "billview";
    }
    
    /**
     * 删除
     * <一句话功能简述>
     * <功能详细描述>
     * @param billid
     * @param model
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/delbill.do")
    public @ResponseBody Map<String, String> delBill(int billid, Model model)
    {
        int result = billService.delBill(billid);
        Map<String, String> map = new HashMap<String, String>(); 
        if (result == 0)
        {
            map.put("delResult", "false");
        }
        else {
            map.put("delResult", "true");
        }
        return map;
    }
    
    /**
     * 跳转添加页面
     * <一句话功能简述>
     * <功能详细描述>
     * @param billid
     * @param model
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/billadd.html")
    public String billadd(Integer billid)
    {
        return "billadd";
    }
    
    @RequestMapping("/billadd.do")
    public String doBillAdd(Bill bill, Model model)
    {
        
        
        return "billadd";
    }
}
