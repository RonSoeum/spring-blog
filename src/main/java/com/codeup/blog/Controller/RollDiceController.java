package com.codeup.blog.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @PostMapping("/roll-dice")
    public String rollDice(@RequestParam(name = "guess") int guess, Model model) {

        Random rand = new Random();
        int diceRoll = rand.nextInt(6);
        diceRoll += 1;

        String result;
        if (diceRoll == guess) {
            result = "You guessed the right number!";
        } else {
            result = "You are wrong.";
        }

        model.addAttribute("guess", guess);
        model.addAttribute("diceRoll", diceRoll);
        model.addAttribute("result", result);
        return "roll-dice";
    }

}// class