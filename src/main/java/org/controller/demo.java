package org.controller;

import org.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


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
}
