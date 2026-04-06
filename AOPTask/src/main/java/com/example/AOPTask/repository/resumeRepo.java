package com.example.AOPTask.repository;

import com.example.AOPTask.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface resumeRepo  extends JpaRepository<Resume,Long>
{

}
