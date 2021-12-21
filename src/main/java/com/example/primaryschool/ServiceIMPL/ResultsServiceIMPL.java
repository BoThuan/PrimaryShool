package com.example.primaryschool.ServiceIMPL;

import com.example.primaryschool.Entity.Results;
import com.example.primaryschool.Repository.RepoResults;
import com.example.primaryschool.Service.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultsServiceIMPL implements ResultsService {

    @Autowired
    private RepoResults RepoResults;

    @Override
    public List<Results> getAllResults() {
        return RepoResults.findAll();
    }

    @Override
    public Optional<Results> findById(String MaKQ) {
        return RepoResults.findById(MaKQ);
    }

    @Override
    public Object save(Results newResults) {
        return RepoResults.save(newResults);
    }

    @Override
    public boolean existsById(String MaKQ) {
        return RepoResults.existsById(MaKQ);
    }

    @Override
    public void deleteById(String MaKQ) {
        RepoResults.deleteById(MaKQ);
    }

    @Override
    public List<Results> findBystudent(String mahs) {
        return RepoResults.findBystudent(mahs);
    }
}
