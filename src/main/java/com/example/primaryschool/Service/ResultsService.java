package com.example.primaryschool.Service;

import com.example.primaryschool.Entity.Assignment;
import com.example.primaryschool.Entity.Results;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ResultsService {

    List<Results> getAllResults();

    Optional<Results> findById(String MaKQ);

    Object save(Results newResults);

    boolean existsById(String MaKQ);

    void deleteById(String MaKQ);

    List<Results> findBystudent(String mahs);
}
