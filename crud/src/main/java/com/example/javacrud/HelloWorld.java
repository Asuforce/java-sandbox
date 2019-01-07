package com.example.javacrud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorld {
  @GetMapping("/")
  public String hello() {
    return "hello";
  }
}
