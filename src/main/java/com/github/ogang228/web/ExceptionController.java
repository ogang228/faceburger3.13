package com.github.ogang228.web;

import com.github.ogang228.exception.NoItemFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NoItemFoundException.class)
    public String handleNoItemFoundException(Model model, NoItemFoundException exception) {
        model.addAttribute("error", exception.getMessage());
        return "error";
    }
}
