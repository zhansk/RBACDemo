package bspringsecuritydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class LoginController {

    @GetMapping("hello")
    public String hello(){
        return "hello security";
    }
    @GetMapping("index")
    public String index(){
        return "hello index";
    }
    @GetMapping("update")
    @PreAuthorize("hasAnyAuthority('update')")
    public String update(){
        return "hello update";
    }

    @GetMapping("create")
    @PreAuthorize("hasAnyAuthority('admin')")
    public String create(){
        return "hello create";
    }

    @GetMapping("deleteAll")
    @PreAuthorize("hasAnyAuthority('deleteAll')")
    public String deleteAll(){
        return "deleteAll";
    }

//    @RequestMapping("/login")
//    public String login(){
//        return "redirect:main.html";
//    }

//    @RequestMapping(value = "/toMain",method = RequestMethod.POST)
//    public String toMain(){
//        return "redirect:main.html";
//    }
//    @RequestMapping(value = "/toError")
//    public String toError(){
//        return "redirect:error.html";
//    }
}
