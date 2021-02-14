package crut.controller;
import crut.model.User;
import crut.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/users")
public class UserController {


    private final UserService service ;

    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping()
    public String usersPage(Model model){
        model.addAttribute("user", service.getAllUser());
        return "users";
    }

    @GetMapping("/userAdd")
    public String  usersAdd(Model model, @ModelAttribute("user") User user){
        model.addAttribute("newUser", new User());
        return "/userAdd";
    }

    @PostMapping("/add")
    public String  usersAdd(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/users";
    }


    @GetMapping("/userupdate/{id}")
    public String updateUser(Model model, @PathVariable("id") long id){
        model.addAttribute("user", service.getUserById(id));
        return "/userUpdate";
    }
    @PostMapping("/update")
    public String  update (@ModelAttribute("user") User user) {
        service.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/remove/{id}")
    public String removeUser(@PathVariable("id")long id){
        service.removeUser(id);
        return "redirect:/users";
    }
}

