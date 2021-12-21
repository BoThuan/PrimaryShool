package com.example.primaryschool.ServiceIMPL;

import com.example.primaryschool.Entity.Parents;
import com.example.primaryschool.Repository.RepoParents;
import com.example.primaryschool.Service.ParentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentsServiceIMPL implements ParentsService {

    @Autowired
    private RepoParents RepoParents;

    @Override
    public List<Parents> getAllParents() {
        return RepoParents.findAll();
    }

    @Override
    public Optional<Parents> findById(String MaPH) {
        return RepoParents.findById(MaPH);
    }

    @Override
    public Optional<Parents> findByName(String TenPH) {
        return RepoParents.findByName(TenPH);
    }

    @Override
    public Object save(Parents newParents) {
        return RepoParents.save(newParents);
    }

    @Override
    public boolean existsById(String MaPH) {
        return RepoParents.existsById(MaPH);
    }

    @Override
    public void deleteById(String MaPH) {
        RepoParents.deleteById(MaPH);
    }
}
