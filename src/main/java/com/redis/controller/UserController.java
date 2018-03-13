package com.redis.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.redis.domain.User;
import com.redis.service.IUserService;

/**
 * user������
 * 
 * @author YaoQi
 */

@Controller
@RequestMapping("UserCRUD")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * ��ѯ����User
     * 
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/showUser.do", method = RequestMethod.GET)
    @ResponseBody
    public List<User> showUsers(Model model) {
        System.out.println("**********showUsers********");
        List<User> userList = new ArrayList<User>();
        userList = userService.getAllUser();
        model.addAttribute("userList", userList); // ������ݵ�model
        return userList;
    }

    /**
     * ����һ���û�
     * 
     * @param userName
     * @param sex
     * @param age
     * @return
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap addUser(String name, String password, String username) {
        System.out.println("******addUser********");
        System.out.println(name+password+username);
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setUsername(username);
        userService.insertUser(user);
        ModelMap model = new ModelMap();
        model.addAttribute("result", "��ӳɹ�");
        return model;
    }

    /**
     * ͨ��userIDɾ���û�
     * 
     * @param userID
     */
    @RequestMapping(value = "/delUser/{userID}", method = RequestMethod.GET)
    public ModelAndView delUser(@PathVariable int userID) {
        System.out.println(userID);
        userService.deleteUser(userID);
        ModelAndView mv = new ModelAndView();
        List<User> userList = new ArrayList<User>();
        userList = userService.getAllUser();
        mv.addObject("userList", userList); // ������ݵ�model
        mv.setViewName("showUser");
        return mv;
    }

    /**
     * ��ѯ�û�
     * 
     * @param model
     * @param keyWords
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String findUsers(Model model, String keyWords) {
        System.out.println(keyWords);
        List<User> userList = new ArrayList<User>();
        userList = userService.findUsers(keyWords);
        model.addAttribute("userList", userList); // ������ݵ�model
        return "showUser";
    }
    
    /**
     * �����û���Ϣ
     * @param userName
     * @param sex
     * @param age
     * @param id
     * @return
     */
    @RequestMapping(value="/editUser",method=RequestMethod.POST)
    public ModelAndView editUser(String name, String password, String username, String id) {
        System.out.println(name + password + username+id);
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setUsername(username);
        user.setId(id);
        userService.editUser(user);
        ModelAndView mv = new ModelAndView();
        List<User> userList = new ArrayList<User>();
        userList = userService.getAllUser();
        mv.addObject("userList", userList); // ������ݵ�model
        mv.setViewName("redirect:/UserCRUD/showUser");
        return mv;
    }
}
