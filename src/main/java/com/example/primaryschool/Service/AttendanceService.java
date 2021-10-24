package com.example.primaryschool.Service;

import com.example.primaryschool.Entity.Attendance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AttendanceService {

    List<Attendance> getAllAttendance();

    Optional<Attendance> findById(Integer MaDD);

    Object save(Attendance newAttendance);

    boolean existsById(Integer MaDD);

    void deleteById(Integer MaDD);


}
