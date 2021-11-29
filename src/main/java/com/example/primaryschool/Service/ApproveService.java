package com.example.primaryschool.Service;

import com.example.primaryschool.Entity.Approve;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ApproveService {

    List<Approve> getAllApprove();

    Optional<Approve> findById(Integer maPD);

    Object save(Approve newApprove);

    void deleteById(Integer maPD);

    boolean existsById(Integer maPD);

}
