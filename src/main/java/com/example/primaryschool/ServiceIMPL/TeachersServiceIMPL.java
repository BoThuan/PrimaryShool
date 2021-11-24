package com.example.primaryschool.ServiceIMPL;

import com.example.primaryschool.Entity.Teachers;
import com.example.primaryschool.Repository.RepoTeachers;
import com.example.primaryschool.Service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public Optional<Teachers> findByName(String TenGV)  {
        return RepoTeachers.findByName(TenGV);
    }

    @Override
    public Optional<Teachers> findByEmail(String Email) {
        return RepoTeachers.findByEmail(Email);
    }

    @Override
    public Optional<Teachers> findBySDT(String SDT) {
        return RepoTeachers.findBySDT(SDT);
    }

    @Override
    public Integer countTeachers() {
        return RepoTeachers.countTeachers();
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
