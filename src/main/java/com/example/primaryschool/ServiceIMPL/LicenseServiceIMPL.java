package com.example.primaryschool.ServiceIMPL;

import com.example.primaryschool.Entity.License;
import com.example.primaryschool.Repository.RepoLicense;
import com.example.primaryschool.Service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenseServiceIMPL implements LicenseService {

    @Autowired
    private RepoLicense RepoLicense;

    @Override
    public List<License> getAllLicense() {
        return RepoLicense.findAll();
    }

    @Override
    public Optional<License> findById(String MaGP) {
        return RepoLicense.findById(MaGP);
    }

    @Override
    public Object save(License newLicense) {
        return RepoLicense.save(newLicense);
    }

    @Override
    public boolean existsById(String MaGP) {
        return RepoLicense.existsById(MaGP);
    }

    @Override
    public void deleteById(String MaGP) {
        RepoLicense.deleteById(MaGP);
    }
}
