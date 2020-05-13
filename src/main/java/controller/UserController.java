package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.impl.UserService;

import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("user")
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    //测试方法
    @RequestMapping("test/login")
    public String testCheckUser(User user) {
        int result = userService.checkUser(user);
        if(result == 1) {
            return "success";
        }
        return "error";
    }




    //后端接口
    @RequestMapping("login")
    @ResponseBody
    public Map checkUser(@RequestParam("uID") String uID, @RequestParam("uPwd") String uPwd){
        User user = new User();
        user.setuID(uID);
        user.setuPwd(uPwd);
        Map resultMap = new HashMap();
        int count = userService.checkUser(user);
        if(count == 1){
            resultMap.put("result",1);
        }else{
            resultMap.put("result",0);
        }
        return resultMap;
    }
}
