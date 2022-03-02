package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.entity.User;
import spring.service.UserServise;

import java.util.List;

@Controller
@RequestMapping("/user")
public class MyController {
    private User[] listUser = new User[]{new User("dima","andreev",10)};
    @Autowired
    private UserServise uSerServise;
    @GetMapping()
    public String showAllUsers(Model model){
        List<User> list = uSerServise.getAllUser();
        model.addAttribute("listUser",list);
        return "showAllUsers";
    }
    @GetMapping("/new")
    public String addNewUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "addUser";
    }
    @PostMapping()
    public String saveUser(@ModelAttribute("user")User user){
        uSerServise.saveUser(user);
        return "redirect:/user";
    }
    @GetMapping("/{id}")
    public String getUserFromId(@PathVariable("id")int id,Model model){
        User user = uSerServise.getUserFromId(id);
        model.addAttribute("user",user);
        return "showInfo";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id")int id){
        uSerServise.deleteUserFromId(id);
        return "redirect:/user";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id")int id,Model model){
        User user = uSerServise.getUserFromId(id);
        model.addAttribute("user",user);
        return "edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user")User user,@PathVariable("id")int id){
       if(uSerServise.getUserFromId(id)==null){
           uSerServise.saveUser(user);
       }else {
           User user2 = uSerServise.getUserFromId(id);
           user2.setName(user.getName());
           user2.setLastName(user.getLastName());
           user2.setAge(user.getAge());
           uSerServise.saveUser(user2);
       }
       return "redirect:/user";
    }
}
