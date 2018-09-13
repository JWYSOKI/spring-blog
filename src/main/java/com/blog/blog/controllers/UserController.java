package com.blog.blog.controllers;

//
//import com.blog.blog.models.User;
//import com.blog.blog.repositories.UserRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.validation.Valid;
//
//@Controller
//public class UserController {
//
//    private UserRepository users;
//    private PasswordEncoder passwordEncoder;
//
//    public UserController(UserRepository users, PasswordEncoder passwordEncoder) {
//        this.users = users;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @GetMapping("/sign-up")
//    public String showSignupForm(Model model){
//        model.addAttribute("user", new User());
//        return "users/sign-up";
//    }
//
//    @PostMapping("/sign-up")
//    public String saveUser(@Valid User user, Errors errors, Model model){
//        if(errors.hasErrors()){
//            model.addAttribute(user);
//            return"users/sign-up";
//        }
//
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        users.save(user);
//        return "redirect:/login";
//    }
//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "users/login";
//    }
//}

import com.blog.blog.models.Post;
import com.blog.blog.models.User;
import com.blog.blog.repositories.PostsRepo;
import com.blog.blog.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/your-posts")
    @ResponseBody
    public String findUser(){

        User user = userRepository.findOne(2L);
        List<Post> posts = user.getPosts();

        for (Post post :posts) {
            System.out.println("post.getId() = " + post.getId());
        }

        return "your-posts";

    }

}