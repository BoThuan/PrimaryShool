package com.example.primaryschool.Service;

import com.example.primaryschool.Entity.Subclass;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SubclassService {
    List<Subclass> getAllSubclass();

    Optional<Subclass> findById(String MaPL);

    Object save(Subclass newMaPL);

    boolean existsById(String MaPL);

    void deleteById(String MaPL);
}
