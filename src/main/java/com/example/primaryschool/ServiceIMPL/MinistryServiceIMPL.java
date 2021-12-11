package com.example.primaryschool.ServiceIMPL;

import com.example.primaryschool.Entity.Ministry;
import com.example.primaryschool.Repository.RepoMinistry;
import com.example.primaryschool.Service.MinistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MinistryServiceIMPL implements MinistryService {

    @Autowired
    private RepoMinistry RepoMinistry;

    @Override
    public List<Ministry> getAllMinistry() {
        return RepoMinistry.findAll();
    }

    @Override
    public Optional<Ministry> findById(String MaGiaoVu) {
        return RepoMinistry.findById(MaGiaoVu);
    }

    @Override
    public Optional<Ministry> findBySDT(String SDT) {
        return RepoMinistry.findBySDT(SDT);
    }

    @Override
    public Object save(Ministry newMinistry) {
        return RepoMinistry.save(newMinistry);
    }

    @Override
    public boolean existsById(String MaGiaoVu) {
        return RepoMinistry.existsById(MaGiaoVu);
    }

    @Override
    public void deleteById(String MaGiaoVu) {
        RepoMinistry.deleteById(MaGiaoVu);
    }

    @Override
    public List<Ministry> MaxMaMinistry() {
        return RepoMinistry.maxMaMinistry();
    }
}
