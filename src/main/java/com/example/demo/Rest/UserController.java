package com.example.demo.Rest;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@Data
@RequestMapping("/users")
public class UserController {
    private final UserService us;
    @GetMapping("/user_form")
    public String getUserForm(Model model, String message){
        model.addAttribute("new_user", new User());
        if(message != null){
            model.addAttribute("message", message);
        }
        return "user-form";
    }
    @PostMapping("/user_form")
    public String save(@ModelAttribute User user, Model model){
        String message = "Пользователь сохранен";
        us.saveUser(user);
        return getUserForm(model, message);
    }
    @GetMapping("/{id}")
    public String getById(@PathVariable String id, Model model){
        User user = us.findById(id);
        model.addAttribute("sdfsf", user);
        return "user";
    }

    @PostMapping("/delete")
    public void deleteUser(@RequestBody String id){
        us.deleteUserById(id);
    }
    @GetMapping("/list")
    public List<User> getAllUsers(){
        return us.getAllUsers();
    }
}

