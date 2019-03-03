package com.codeup.blog.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {

        Random rand = new Random();
        int diceRoll = rand.nextInt(6);
        diceRoll += 1;

        String result;
        if (diceRoll == guess) {
            result = "Lucky Guess!";
        } else {
            result = "You are wrong.";
        }

        model.addAttribute("guess", guess);
        model.addAttribute("diceRoll", diceRoll);
        model.addAttribute("result", result);
        return "roll-dice";
    }

}// class