package com.example.primaryschool.ServiceIMPL;

import com.example.primaryschool.Entity.Attendance;
import com.example.primaryschool.Repository.RepoAttendance;
import com.example.primaryschool.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceIMPL implements AttendanceService {

    @Autowired
    private RepoAttendance RepoAttendance;

    @Override
    public List<Attendance> getAllAttendance() {
        return RepoAttendance.findAll();
    }

    @Override
    public Optional<Attendance> findById(Integer MaDD) {
        return RepoAttendance.findById(MaDD);
    }

    @Override
    public Object save(Attendance newAttendance) {
        return RepoAttendance.save(newAttendance);
    }

    @Override
    public boolean existsById(Integer MaDD) {
        return RepoAttendance.existsById(MaDD);
    }

    @Override
    public void deleteById(Integer MaDD) {
        RepoAttendance.deleteById(MaDD);
    }
}
