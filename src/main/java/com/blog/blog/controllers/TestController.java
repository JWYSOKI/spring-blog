package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    @ResponseBody
    private String sayHi(@RequestParam(value = "isLoud, required = false") boolean isLoud) {
        if (isLoud) {
            return "<h1>WELL HELLO";
        } else {
            return "<h1>Well Hi</h1>";
        }
    }

    @RequestMapping(path = "/howdy", method = RequestMethod.GET)
    @ResponseBody
    private String sayHowdy() {
        return "Well Howdy";
    }

    @GetMapping("/greetings")
    @ResponseBody
    private String greet() {
        return "Greetings";
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(
            @PathVariable int number
    ) {
        return number + " plus one is " + (number + 1) + "!";
    }


    @GetMapping("/favnum/{favnum}/leastfavnum/{leastnum}")
    @ResponseBody
    private String numMessage(
            @PathVariable int leastnum,
            @PathVariable int favnum
    ) {
        String message = "";
        message += "Fav num is: " + favnum;
        message += "<br>";
        message += "Least fav num is: " + leastnum;
        return message;
    }




    @GetMapping("/list")
    private String listOfNames(Model viewModel) {

        List<String> names = new ArrayList<>();

        names.add("Graham");
        names.add("Tori");
        names.add("Cash");
        names.add("Jojo");

        viewModel.addAttribute("listOfNames", names);
        viewModel.addAttribute("role", "user");
//        viewModel.addAttribute("role", "admin");

        return "lists";
    }

}