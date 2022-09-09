package com.vttp2022.MiniProject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vttp2022.MiniProject.repository.ToDoRepo;
import com.vttp2022.MiniProject.service.ToDoService;

@Controller
@RequestMapping ("/ToDoList")
public class ToDoController {
    private static final Logger logger = LoggerFactory.getLogger(ToDoController.class);

    @Autowired
    private ToDoService todoService;

    @Autowired
    private ToDoRepo ToDoRepo;

    //@GetMapping
    //public String

    @GetMapping 
    public String getMessage (@RequestParam (required = true) String message, Model model){
        model.addAttribute("message", message);
        return ToDoList;
        
    }

    public List toDoList{

    }

    
}
 