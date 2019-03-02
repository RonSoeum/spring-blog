package com.codeup.blog.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public long add(@PathVariable long num1, @PathVariable long num2) {
        long result = num1 + num2;
        return result;
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public long subtract(@PathVariable long num2, @PathVariable long num1) {
        long result = num2 - num1;
        return result;
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public long multiply(@PathVariable long num1, @PathVariable long num2) {
        long result = num1 * num2;
        return result;
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public double divide(@PathVariable double num1, @PathVariable double num2) {
        double result = num1 / num2;
        return result;
    }

}// class