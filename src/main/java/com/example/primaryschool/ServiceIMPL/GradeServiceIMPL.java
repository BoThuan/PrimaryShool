package com.example.primaryschool.ServiceIMPL;

import com.example.primaryschool.Entity.Grade;
import com.example.primaryschool.Repository.RepoGrade;
import com.example.primaryschool.Service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceIMPL implements GradeService {

    @Autowired
    private RepoGrade RepoGrade;

    @Override
    public List<Grade> getAllParents() {
        return RepoGrade.findAll();
    }

    @Override
    public Optional<Grade> findById(String MaKhoi) {
        return RepoGrade.findById(MaKhoi);
    }

    @Override
    public Object save(Grade newGrade) {
        return RepoGrade.save(newGrade);
    }

    @Override
    public boolean existsById(String MaKhoi) {
        return RepoGrade.existsById(MaKhoi);
    }

    @Override
    public void deleteById(String MaKhoi) {
        RepoGrade.deleteById(MaKhoi);
    }
}
