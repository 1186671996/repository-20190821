package com.kgc.controller;

import java.io.File;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kgc.pojo.Role;
import com.kgc.pojo.User;
import com.kgc.service.UserService;

@Controller
@RequestMapping
public class UserController
{
    private Logger logger = Logger.getLogger(UserController.class);
    
    @Resource
    private UserService userService;
    
    // 当前端页面传过来的的String类型的日期与后台实体类的Date类型不匹配时，需要加上该方法
    /*@InitBinder
    public void init(WebDataBinder binder)
    {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }*/
    
    @RequestMapping(value = "/login.html")
    public String login()
    {
        logger.debug("UserController welcome SMBMS==================");
        return "login";
    }
    
    /**
     * 登录成功后跳转index.jsp <一句话功能简述> <功能详细描述>
     * 
     * @param user
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/dologin.html")
    public String login(Model model, User user, HttpSession session)
        throws Exception
    {
        System.out.println(user);
        user = userService.login(user);
        System.out.println(user);
        if (null == user)
        {
            throw new Exception("用户名或密码不正确");
        }
        model.addAttribute("user", user);
        session.setAttribute("userSession", user);
        return "frame";
    }
    
    /**
     * 分页数据列表
     */
    @RequestMapping({"/user.do", "userlist.html"})
    public String userList(Model model, User user,
        @RequestParam(value = "pageIndex", required = false) Integer pageIndex)
        throws Exception
    {
        System.out.println(user.getUserName());
        List<Role> roleList = userService.selectRole();
        if (pageIndex == null || pageIndex == 0)
        {
            pageIndex = 1;
        }
        PageHelper.startPage(pageIndex, 4);
        List<User> list = userService.selectAll(user);
        
        Page page = (Page)list;
        System.out.println(list);
        model.addAttribute("userList", list);
        model.addAttribute("roleList", roleList);
        model.addAttribute("totalCount", page.getTotal());
        model.addAttribute("currentPageNo", pageIndex);
        model.addAttribute("totalPageCount", page.getPages());
        return "userlist";
    }
    
    /**
     * 跳转添加界面 <一句话功能简述> <功能详细描述>
     * 
     * @param model
     * @param user
     * @param pageIndex
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/jsp/useradd.html")
    public String userAdd()
    {
        return "useradd";
        
    }
    
    /**
     * 添加 <一句话功能简述> <功能详细描述>
     * 
     * @param user
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    /*
     * @RequestMapping(value="/useraddsave.html",method=RequestMethod.POST) public String useraddsave(Model model, User
     * user, HttpSession session,HttpServletRequest request,
     * 
     * @RequestParam(value ="a_idPicPath", required = false) MultipartFile attach) throws Exception {
     * System.out.println(user); String idPicPath = null; if (!attach.isEmpty()) { String path = request.getSession().
     * getServletContext().getRealPath("statics"+File.separator+"uploadfiles"); String oldFileName =
     * attach.getOriginalFilename(); String prefix = FilenameUtils.getExtension(oldFileName); int filesize = 500000; if
     * (attach.getSize() > filesize) { request .setAttribute("uploadFilError", "上传文件大小不超过500kb"); return "useradd"; }
     * else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") || prefix.equalsIgnoreCase("jpeg") ||
     * prefix.equalsIgnoreCase("pneg")) { String fileName =
     * System.currentTimeMillis()+RandomUtils.nextInt()+"_Personal.jpg"; File targetFile = new File(path, fileName); if
     * (!targetFile.exists()) { targetFile.mkdirs(); } try { attach.transferTo(targetFile); } catch (Exception e) {
     * e.printStackTrace(); request.setAttribute("uploadFileError", "上传失败"); return "useradd"; // TODO: handle exception
     * } idPicPath = path + File.separator + fileName; }else { request.setAttribute("uploadFileError", "上传图片失败"); return
     * "useradd"; } } user.setIdPicPath(idPicPath); //
     * user.setCreatedBy(((User)session.getAttribute(Constants.USER_SESSION)).getId()); user.setCreationDate(new
     * Date());
     * 
     * userService.insertUser(user); return "redirect:userlist.html";
     * 
     * }
     */
    @RequestMapping(value="/useraddsave.html", method = RequestMethod.POST)
    public String addUserSave(User user, HttpSession session, HttpServletRequest request,
        @RequestParam(value = "attachs", required = false) MultipartFile[] attachs)
    {
        System.out.println(user.getBirthday());
        System.out.println(request.getParameter("birthday"));
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
            user.setCreationDate(new Date());
            user.setIdPicPath(idPicPath);
            user.setWorkPicPath(workPicPath);
            userService.insertUser(user);
            return "redirect:userlist.html";
        }
        return "useradd";
    }
    
    /**
     * user.do <一句话功能简述> <功能详细描述>
     * 
     * @param user
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/jsp/user.do")
    public @ResponseBody Map userDo(User user)
        throws Exception
    {
        Map map = new HashMap();
        map.put("1", "1");
        return map;
        
    }
    
    /**
     * ajax查询role <一句话功能简述> <功能详细描述>
     * 
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/rolelist.do")
    public @ResponseBody List<Role> rolelist()
        throws Exception
    {
        return userService.selectRole();
    }
    
    @RequestMapping("/deleteUser.do")
    public @ResponseBody Map<String, String> deleteUser(Integer uid)
        throws Exception
    {
        Map<String, String> map = new HashMap<String, String>();
        int num = userService.deleteUserById(uid);
        if (num == 0)
        {
            map.put("delResult", "false");
        }
        else
        {
            map.put("delResult", "true");
        }
        return map;
    }
    
    @RequestMapping("/updataUser.do")
    public String updataUser(Model model, Integer uid)
        throws Exception
    {
        User user = userService.findUserById(uid);
        model.addAttribute("user", user);
        System.out.println(user);
        System.out.println(uid);
        return "usermodify";
    }
    
    @RequestMapping("/usermodifysave.html")
    public String usermodifysave(Model model, User user)
        throws Exception
    {
        userService.updataUser(user);
        
        return "redirect:userlist.html";
        
    }
    
    /**
     * c跳转查看用户界面 * <一句话功能简述> <功能详细描述>
     * 
     * @param model
     * @param user
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/viewUser")
    public String viewUser(Model model, int uid)
        throws Exception
    {
        User user = userService.findUserById(uid);
        model.addAttribute("user", user);
        return "userview";
        
    }
    /**
     * 退出
     * <一句话功能简述>
     * <功能详细描述>
     * @param model
     * @param session
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/logout.do")
    public String logout(Model model, HttpSession session)
        throws Exception
    {
        session.removeAttribute("userSession");
        return "login";
        
    }
    
    /**
     * 修改密码页面
     * <一句话功能简述>
     * <功能详细描述>
     * @param model
     * @param session
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/pwdmodify.html")
    public String pwdmodify()
        throws Exception
    {
        return "pwdmodify";
        
    }
    
    /**
     * 原密码验证
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    @RequestMapping("/pwdmodify.dodo")
    public @ResponseBody Map<String, String> pwdmodifys(String oldpassword,HttpSession session)
        throws Exception
    {
        Map<String, String> map = new HashMap<String, String>();
        User user = (User)session.getAttribute("userSession");
        if (null == user)
        {
            map.put("result", "sessionerror");
            return map;
        }
        else if (null == oldpassword || "".equals(user.getUserPassword())) 
        {
            map.put("result", "error");
            return map;
        }
        else if (oldpassword.equals(user.getUserPassword()))
        {
            map.put("result", "true");
            return map;
        }
        else {
            map.put("result", "false");
            return map;
        }
        
    }
    
    @RequestMapping("/pwdmodify.do")
    public String dopwdmodify( HttpServletRequest req)
        throws Exception
    {
        String oldpassword = req.getParameter("oldpassword");
        String newpassword = req.getParameter("newpassword");
        String rnewpassword = req.getParameter("rnewpassword");
        return null;
        
    }
    
    
    @ExceptionHandler(value={Exception.class})
    public String handlerException(Exception e,HttpServletRequest req)
    {
        req.setAttribute("e", e);
        
        return "error";
        
    }
    
    
}
