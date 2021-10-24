package com.example.primaryschool.ServiceIMPL;

import com.example.primaryschool.Entity.Classroom;
import com.example.primaryschool.Repository.RepoClassroom;
import com.example.primaryschool.Service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceIMPL implements ClassroomService {

    @Autowired
    private RepoClassroom RepoClassroom;

    @Override
    public List<Classroom> getAllClassroom() {
        return RepoClassroom.findAll();
    }

    @Override
    public Optional<Classroom> findById(String MaLop) {
        return RepoClassroom.findById(MaLop);
    }

    @Override
    public Object save(Classroom newClassroom) {
        return RepoClassroom.save(newClassroom);
    }

    @Override
    public boolean existsById(String MaLop) {
        return RepoClassroom.existsById(MaLop);
    }

    @Override
    public void deleteById(String MaLop) {
        RepoClassroom.deleteById(MaLop);
    }
}
