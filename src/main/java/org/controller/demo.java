package org.controller;

import org.domain.ComplexUser;
import org.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;


@Controller

@RequestMapping("/a")
public class demo {
    @RequestMapping("/aa")
    public String aa(){
        return "success";
    }
    @RequestMapping("modelandview")
    public ModelAndView aaa(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","这是数据");
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping(value = "json" ,params = "id")
    @ResponseBody   //以response返回数据
    public User json(int id){
        User user=new User();
        user.setId(id);
        if (id == 1) {
            user.setName("张三");
        }else {
            user.setName("李四");
        }
        return user;
    }
//------------------------------------------------------------------------------------------------------------------------------------------
    /* 传统数据绑定--手动解析*/
    @RequestMapping("tra1")
    public String gettraditional1(HttpServletRequest  request){
        String id =request.getParameter("id");
        request.setAttribute("msg","id的值是"+id);
        return "success";
    }
    @RequestMapping("tra2")
    public String gettraditional1(HttpServletRequest request,HttpSession session){
        String id =request.getParameter("id");
        session.setAttribute("msg","id的值是"+id);
        return "success";
    }
    @RequestMapping("tra3")
    public String gettraditional1(HttpServletRequest request, ModelMap map){
        String id =request.getParameter("id");
        map.addAttribute("msg","id的值是"+id);
        return "success";
    }
//--------------------------------------------------------------------------------------------

    /****
     * 数据绑定
     * 传参（流程中  先转在绑定） 不传int型的数据会报错   因为null无法转换为int型   不传String可以  String可以为null
     * 别名  @RequestParam
     */
    @RequestMapping("sim1")
    public String getSimple1(int id ,String name,HttpServletRequest request){
     request.setAttribute("msg","我的id是"+id+"我的name是"+name);
     return "success";
    }
    @RequestMapping("sim2")
    //@RequestParam("name")注解实现别名 以使得前后端传入数据一致
    public ModelAndView getSimple2(int id ,@RequestParam("name") String names){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg","我的id是"+id+"我的name是"+names);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    //rest风格-------注解加上 参数路径就要有
    @RequestMapping("/user1/{id}/{name}")
    public String getSimple2(@PathVariable("id") int id ,@PathVariable(value = "name")String name,HttpServletRequest request){
        request.setAttribute("msg","我的id是"+id+"我的name是"+name);
        return "success";
    }
    @RequestMapping("/user2/{id}/{name}")
    //在 rest风格中   @PathVariable(value = "name")实现一一对应 也可实现别名
    public ModelAndView getSimple3(@PathVariable("id") int id ,@PathVariable(value = "name") String names){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg","我的id是"+id+"我的name是"+names);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    //pojo类型进行数据绑定   pojo类要与属性名称保持一致
    //pojo使用User类
    @RequestMapping("insert")
    public  ModelAndView insert(User user){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg",user);
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping("register")
    public  ModelAndView register(){
        ModelAndView modelAndView=new ModelAndView();

        modelAndView.setViewName("register");
        return modelAndView;
    }

/****
 * 自定义类型转换器
 */

    //日期转换器  在方法中使用
    @RequestMapping("date")
    public ModelAndView getdate(@DateTimeFormat(pattern = "yyyy-MM-dd")Date birthday){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg",birthday);
        modelAndView.setViewName("success");
        return modelAndView;
    }


    /***
     * 复杂数据绑定
     *
     */
    @RequestMapping("comparr")
    public  ModelAndView dataArr(String[] ids){
        ModelAndView modelAndView=new ModelAndView();
        String ste="要删除的数据id为：";
        for (String id:ids) {
ste+=id+";";
        }
        modelAndView.addObject("msg",ste);
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping("complist")
    public  ModelAndView dataArr(@RequestParam List<String> ids){
        ModelAndView modelAndView=new ModelAndView();
        String ste="要删除的数据id为：";
        for (String id:ids) {
            ste+=id+";";
        }
        modelAndView.addObject("msg",ste);
        modelAndView.setViewName("success");
        return modelAndView;
    }
    //复杂pojo对象
    @RequestMapping("comppojo")
    public  ModelAndView datapojo(ComplexUser complexUser){
        ModelAndView modelAndView=new ModelAndView();
        String ste="用户："+complexUser.getInfo()+"编号："+complexUser.getId()+"的账户信息是："+complexUser.getUser();
        modelAndView.addObject("msg",ste);
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping("comppojolist" )
    public  ModelAndView datapojos(ComplexUser complexUser){
        ModelAndView modelAndView=new ModelAndView();
        String ste="用户："+complexUser.getInfo()+"编号："+complexUser.getId()+"的账户信息是："+complexUser.getUser();
/***
 * 加入list pojo对象
 */
      List<User> userList =complexUser.getUserList();
        for (User user : userList) {
            ste+=complexUser.getUser();
        }

        modelAndView.addObject("msg",ste);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    //使用map来管理pojo
    @RequestMapping("comppojomap" )
    public ModelAndView daramap(ComplexUser complexUser){
        ModelAndView modelAndView=new ModelAndView();
        String ste="用户："+complexUser.getInfo()+"编号："+complexUser.getId()+"的账户信息是：";
        HashMap<String, User> usermap = complexUser.getUsermap();
        Set<String> keys = usermap.keySet();//获得所有key
        for (String key : keys) {
            User user = usermap.get(key);
            ste+="name: "+user.getName();
            ste+="birthday: "+user.getBirthday();
            ste+="password: "+user.getPassword();
            ste+="id: "+user.getId();
        }
        modelAndView.addObject("msg",ste);
        modelAndView.setViewName("success");
        return modelAndView;
    }
}

