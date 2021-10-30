package com.example.primaryschool.Service;

import com.example.primaryschool.Entity.Parents;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ParentsService {

    List<Parents> getAllParents();

    Optional<Parents> findById(String MaPH);

    Optional<Parents> findByName(String TenPH);

    Optional<Parents> findByPhone(String Sdt);

    Object save(Parents newParents);

    boolean existsById(String maMon);

    void deleteById(String maMon);
}
