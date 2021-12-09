package com.example.primaryschool.Service;

import com.example.primaryschool.Entity.Ministry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MinistryService {
    List<Ministry> getAllMinistry();

    Optional<Ministry> findById(String MaGiaoVu);

    Optional<Ministry> findBySDT(String SDT);

    Object save(Ministry newMinistry);

    boolean existsById(String MaGiaoVu);

    void deleteById(String MaGiaoVu);

    List<Ministry> MaxMaMinistry();
}
