package com.example.primaryschool.ServiceIMPL;

import com.example.primaryschool.Entity.Approve;
import com.example.primaryschool.Repository.RepoApprove;
import com.example.primaryschool.Service.ApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApproveServiceIMPL implements ApproveService {

    @Autowired
    private RepoApprove RepoApprove;

    @Override
    public List<Approve> getAllApprove() {
        return RepoApprove.findAll();
    }

    @Override
    public Optional<Approve> findById(Integer maPD) {
        return RepoApprove.findById(maPD);
    }

    @Override
    public Object save(Approve newApprove) {
        return RepoApprove.save(newApprove);
    }

    @Override
    public boolean existsById(Integer maPD) {
        return RepoApprove.existsById(maPD);
    }

    @Override
    public void deleteById(Integer maPD) {
        RepoApprove.deleteById(maPD);
    }
}
