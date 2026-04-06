package com.example.AOPTask.service;

import com.example.AOPTask.entity.Resume;
import com.example.AOPTask.repository.resumeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class resumeService {
    @Autowired
    private resumeRepo resumerepo;
    //checking the conditions
    public Resume uploadResume(Resume resume) {

        if(resume.getEmail()==null||resume.getPhone()==null){
            throw new RuntimeException("Inavlid Credentials!!");
        }
        if(!resume.getEmail().contains("@")){
            throw new RuntimeException("Inavlid Credentials!!");
        }
        if(resume.getExperience()<0) {
            throw new RuntimeException("Experience must be positive");
        }
        return resumerepo.save(resume);
    }
}
