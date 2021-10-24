package com.example.primaryschool.Service;

import com.example.primaryschool.Entity.Subjects;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SubjectService {

   List<Subjects> getALlSubjects();

    Optional<Subjects> findById(String maMon);

//    Subjects findById(Integer id);

    Object save(Subjects newSubject);

    boolean existsById(String maMon);

    void deleteById(String maMon);
}
