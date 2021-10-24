package com.example.primaryschool.ServiceIMPL;

import com.example.primaryschool.Entity.Assignment;
import com.example.primaryschool.Repository.RepoAssignment;
import com.example.primaryschool.Service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentServiceIMPL implements AssignmentService {

    @Autowired
    private RepoAssignment RepoAssignment;

    @Override
    public List<Assignment> getAllAssignment() {
        return RepoAssignment.findAll();
    }

    @Override
    public Optional<Assignment> findById(String MaPC) {
        return RepoAssignment.findById(MaPC);
    }

    @Override
    public Object save(Assignment newAssignment) {
        return RepoAssignment.save(newAssignment);
    }

    @Override
    public boolean existsById(String MaPC) {
        return RepoAssignment.existsById(MaPC);
    }

    @Override
    public void deleteById(String MaPC) {
        RepoAssignment.deleteById(MaPC);
    }
}
