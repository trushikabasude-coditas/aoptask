package com.example.AOPTask.controller;

import com.example.AOPTask.entity.Resume;
import com.example.AOPTask.repository.resumeRepo;
import com.example.AOPTask.service.resumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resume")
public class resumeController {
    @Autowired
    private resumeService resumeservice;
    @PostMapping("/uploadResume")
    public Resume uploadResume(@RequestParam Resume resume){
        return resumeservice.uploadResume(resume);
    }
}
