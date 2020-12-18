package com.example.boardgamenightinventoryservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class UserGameController {
    @GetMapping("/")
    public String getIndex() {
        return "GET to index route";
    }
}
