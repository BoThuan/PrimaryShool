package com.example.primaryschool.ServiceIMPL;

import com.example.primaryschool.Entity.Subclass;
import com.example.primaryschool.Repository.RepoSubclass;
import com.example.primaryschool.Service.SubclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubclassServiceIMPL implements SubclassService {

    @Autowired
    private RepoSubclass RepoSubclass;

    @Override
    public List<Subclass> getAllSubclass() {
        return RepoSubclass.findAll();
    }

    @Override
    public Optional<Subclass> findById(String MaPL) {
        return RepoSubclass.findById(MaPL);
    }

    @Override
    public Object save(Subclass newMaPL) {
        return RepoSubclass.save(newMaPL);
    }

    @Override
    public boolean existsById(String MaPL) {
        return RepoSubclass.existsById(MaPL);
    }

    @Override
    public void deleteById(String MaPL) {
        RepoSubclass.deleteById(MaPL);
    }
}
