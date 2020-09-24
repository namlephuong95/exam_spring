package aptech.fpt.spring.controller;

import aptech.fpt.spring.entity.User;
import aptech.fpt.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/user/index")
    public String index(Model model){
        List<User> users = (List<User>) userRepository.findAll();
        model.addAttribute("users",users);
        return "index";
    }

    @RequestMapping(path = "/user/add", method = RequestMethod.GET)
    public String addUser(@ModelAttribute User u){
//        model.addAttribute("user",new User());
        return "addUser";
    }

    @RequestMapping(path = "/user/save",method = RequestMethod.POST)
    public String save(User user){
        userRepository.save(user);
        return "redirect:/";
    }

    @RequestMapping(path = "/user/edit",method = RequestMethod.GET)
    public String editUser(@RequestParam("id") Long userId, Model model){
        Optional<User> userEdit = userRepository.findById(userId);
        userEdit.ifPresent(user -> model.addAttribute("user",user));
        return "editUser";
    }

    @RequestMapping(path = "/user/delete",method = RequestMethod.DELETE)
    public String deleteUser(@RequestParam("id") Long userId, Model model){
        userRepository.deleteById(userId);
        return "redirect:/";
    }
}
