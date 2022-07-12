package com.xy.springboot04.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xy.springboot04.Mapper.UserMapper;
import com.xy.springboot04.pojo.User;
import com.xy.springboot04.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @GetMapping("/basicTable")
    public String basic_table() {

        return "table/basic_table";
    }


    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             RedirectAttributes ra){

        userService.removeById(id);

        ra.addAttribute("pn",pn);
        return "redirect:/dynamicTable";
    }


    @Autowired
    private UserService userService;

    @GetMapping("/dynamicTable")
    public String dynamic_table(@RequestParam(value = "pn" ,defaultValue = "1") int pn,Model model) {

        /*List<User> list = userService.list();*/
        Page<User> page = new Page<>(pn, 2);
        Page<User> userPage = userService.page(page, null);
       /* model.addAttribute("users",list);*/

       /* model.addAttribute("page",page);
        long current = page.getCurrent();
        long pages = page.getPages();
        long total = page.getTotal();
        List<User> records = page.getRecords();*/

        model.addAttribute("users",userPage);
        return "table/dynamic_table";
    }



    @GetMapping("/responsiveTable")
    public String responsive_table() {

        return "table/responsive_table";
    }

    @GetMapping("/editableTable")
    public String editable_table() {

        return "table/editable_table";
    }

}
