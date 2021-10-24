package com.example.primaryschool.ServiceIMPL;

import com.example.primaryschool.Entity.Teachers;
import com.example.primaryschool.Repository.RepoTeachers;
import com.example.primaryschool.Service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TeachersServiceIMPL implements TeachersService {

    @Autowired
    private RepoTeachers RepoTeachers;

    @Override
    public List<Teachers> getAllTeachers() {
        return RepoTeachers.findAll();
    }

    @Override
    public Optional<Teachers> findById(String MaGV) {
        return RepoTeachers.findById(MaGV);
    }

    @Override
    public Object save(Teachers newTeachers) {
        return RepoTeachers.save(newTeachers);
    }

    @Override
    public boolean existsById(String MaGV) {
        return RepoTeachers.existsById(MaGV);
    }

    @Override
    public void deleteById(String MaGV) {
        RepoTeachers.deleteById(MaGV);
    }
}
