package ru.galyautdinov.webcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){
        model.addAttribute("message","Hello, "+surname+" "+name);
        //System.out.println("Hello, "+surname+" "+name);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a") int a,
                                 @RequestParam(value = "b") int b,
                                 @RequestParam(value = "action") String action,
                                 Model model){
        String result;
        switch (action){
            case ("multiplication"):
                result = Integer.toString(a*b);
                break;
            case ("addition"):
                result = Integer.toString(a+b);
                break;
            case ("subtraction"):
                result = Integer.toString(a-b);
                break;
            case ("division"):
                result = Double.toString(a/(double)b);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
        model.addAttribute("message", result);

        return "first/calculator";
    }
}
