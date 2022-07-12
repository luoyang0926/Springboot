package com.xy.springboot04.controller;

import com.xy.springboot04.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;


@Controller
public class IndexController {
    @GetMapping({
            "/","/index"
    })
    public String toIndex() {
        return "login";
    }

    //登录
    @RequestMapping("/login")
    public String toLogin(User user, HttpSession session, Model model) {


        if(StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())){
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser",user);
            //登录成功重定向到main.html;  重定向防止表单重复提交
            return "redirect:/index.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            //回到登录页面
            return "login";
        }

    }
    /**
     * 去index页面
     * @return
     */
    @GetMapping("/index.html")
    //@ResponseBody
    public String mainPage(HttpSession session,Model model){

      //  log.info("当前方法是：{}","mainPage");
      /*  //是否登录。  拦截器，过滤器
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null){
            return "index";
        }else {
            //回到登录页面
            model.addAttribute("msg","请重新登录");
            return "login";
        }*/
//        ValueOperations<String, String> opsForValue =
//                redisTemplate.opsForValue();
//
//        String s = opsForValue.get("/index.html");
//        String s1 = opsForValue.get("/sql");
//
//
//        model.addAttribute("mainCount",s);
//        model.addAttribute("sqlCount",s1);

        return "index";

    }

}
