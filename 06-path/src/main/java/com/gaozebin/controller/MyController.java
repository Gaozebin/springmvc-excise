package com.gaozebin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @RequestMapping
 *      value：所有请求的公共部分,叫做模块名称
 *      位置：放在类的上面
 */
@Controller
public class MyController {
    /**
     * @RequestMapping:请求映射
     *              属性：method，表示请求的方式。它的值RequestMethod类枚举值。
     *              例如表示get请求方式，RequestMethod.GET
     *              post方式，RequestMethod.POST
     *
     *  你不用get方式，错误是：
     *  HTTP status 405- Request method 'GET' not supported.
     * @return
     */
    //指定some.do使用get请求方式
    @RequestMapping(value = "/user/some.do")
    public ModelAndView doSome(){
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","欢迎使用springmvc做web开发");
        mv.addObject("fun","执行的是doSome方法");
        mv.setViewName("/index.jsp");

        return mv;
    }
}
