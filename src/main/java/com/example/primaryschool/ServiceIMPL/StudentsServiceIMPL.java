package com.example.primaryschool.ServiceIMPL;

import com.example.primaryschool.Entity.Students;
import com.example.primaryschool.Repository.RepoStudents;
import com.example.primaryschool.Service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsServiceIMPL implements StudentsService {

    @Autowired
    private RepoStudents RepoStudents;

    @Override
    public List<Students> getAllStudents() {
        return RepoStudents.findAll();
    }

    @Override
    public Optional<Students> findById(String MaHS) {
        return RepoStudents.findById(MaHS);
    }

    @Override
    public Optional<Students> findByName(String Name) {
        return RepoStudents.findByName(Name);
    }

    @Override
    public Optional<Students> findByMale(Boolean GioiTinh) {
        return RepoStudents.findByMale(GioiTinh);
    }

    @Override
    public Integer countStudent() {
        return RepoStudents.countStudent();
    }

    @Override
    public Object save(Students newStudents) {
        return RepoStudents.save(newStudents);
    }

    @Override
    public boolean existsById(String MaHS) {
        return RepoStudents.existsById(MaHS);
    }

    @Override
    public void deleteById(String MaHS) {
        RepoStudents.deleteById(MaHS);
    }
}
