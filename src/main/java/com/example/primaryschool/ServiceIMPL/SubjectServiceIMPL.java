package com.example.primaryschool.ServiceIMPL;

import com.example.primaryschool.Entity.Subjects;
import com.example.primaryschool.Repository.RepoSubject;
import com.example.primaryschool.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@RequiredArgsConstructor
//@Transactional
//@Slf4j
@Service
public class SubjectServiceIMPL implements SubjectService {
    @Autowired
    private RepoSubject RepoSubject;

    @Override
    public List<Subjects> getALlSubjects() {
        return RepoSubject.findAll();
    }

    @Override
    public Optional<Subjects> findById(String maMon) {
        return RepoSubject.findById(maMon);
    }

//    @Override
//    public Subjects findById(Integer id) {
//        return null;
//    }

    @Override
    public Object save(Subjects newSubject) {
        return RepoSubject.save(newSubject);
    }

    @Override
    public boolean existsById(String maMon) {
        return RepoSubject.existsById(maMon);
    }

    @Override
    public void deleteById(String maMon) {
        RepoSubject.deleteById(maMon);
    }
}
