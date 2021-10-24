package com.example.primaryschool.Service;

import com.example.primaryschool.Entity.License;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LicenseService {
    List<License> getAllLicense();

    Optional<License> findById(String MaGP);

    Object save(License newLicense);

    boolean existsById(String MaGP);

    void deleteById(String MaGP);
}
