package com.xiaobin.example.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaobin.example.springboot.domain.User;
import com.xiaobin.example.springboot.domain.UserExample;
import com.xiaobin.example.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/5/7
 * Time: 20:53
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/all")
    public String getUser(Model model) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(2L);
        List<User> all = userMapper.selectByExample(userExample);
        model.addAttribute("all", all);
        System.out.println(all);
        return "user";
    }

    @RequestMapping("/allPage")
    public String getUser(Model model,
                          @RequestParam(value = "start", defaultValue = "0") int start,
                          @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size, "id desc");
        UserExample userExample = new UserExample();
//        userExample.createCriteria().andIdEqualTo(2L);
        userExample.setOrderByClause("id asc");
        List<User> all = userMapper.selectByExample(userExample);
        PageInfo<User> page = new PageInfo<>(all);
        model.addAttribute("page", page);
        System.out.println(all.toString());
        return "userList";
    }

    @RequestMapping("/addUser")
    public String addUser(User user) {
        userMapper.insert(user);
        return "redirect:all";
    }

    @RequestMapping("/deleteUser")
    public String delUser(User user) {
        userMapper.deleteByPrimaryKey(user.getId());
        return "redirect:all";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user) {
        user.setCreateTime(1515310345751L);
        userMapper.updateByPrimaryKey(user);
        System.out.println(user);
        return "redirect:all";
    }

    @RequestMapping("/editUser")
    public String editUser(Long id, Model model) {
        User user = userMapper.selectByPrimaryKey(id);
        model.addAttribute("user", user);
        return "editUser";
    }

}
