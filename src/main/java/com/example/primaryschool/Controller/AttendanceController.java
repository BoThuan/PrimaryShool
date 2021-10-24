package com.example.primaryschool.Controller;

import com.example.primaryschool.Entity.Attendance;
import com.example.primaryschool.Entity.ResponseObject;
import com.example.primaryschool.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/vi/Attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    // get all attendance
    @GetMapping("/getAllAttendance")
    // this request is: http://localhost:8080/api/vi/attendance/getAllattendance
    List<Attendance> getallattendance(){
        return attendanceService.getAllAttendance();
    }

    // get attendance by MaPC
    @GetMapping("/{MaDD}")
    // this request is: http://localhost:8081/api/vi/attendance/{MaDD}
    ResponseEntity<ResponseObject> findById(@PathVariable Integer MaDD) {
        Optional<Attendance> foundProduct = attendanceService.findById(MaDD);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("999", "Query Product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("000", "Cannot find product with id = " + MaDD, "")
                );
    }


    // Insert new attendance
    @PostMapping("/insert")
    // this request is: http://localhost:8080/api/vi/attendance/insert
    ResponseEntity<ResponseObject> Insertattendance(@RequestBody Attendance newAttendance){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Insert Product successfully", attendanceService.save(newAttendance))
        );
    }

    // update, upsert = update if found, otherwise insert
    @PutMapping("/{MaDD}")
    // this request is: http://localhost:8080/api/vi/attendance/{MaDD}
    ResponseEntity<ResponseObject> Updateattendance(@RequestBody Attendance newAttendance, @PathVariable Integer MaDD){
        Attendance UpdateAttendance = (Attendance) attendanceService.findById(MaDD)
                .map(attendance -> {
                    attendance.setMaLop(newAttendance.getMaLop());
                    attendance.setMaPL(newAttendance.getMaPL());
                    attendance.setNgay(newAttendance.getNgay());
                    attendance.setCo(newAttendance.getCo());
                    return attendanceService.save(attendance);
                }).orElseGet(() -> {
                    newAttendance.setMaDD(MaDD);
                    return attendanceService.save(newAttendance);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Update Product successfully", UpdateAttendance)
        );
    }

    // delete
    @DeleteMapping("{MaDD}")
    // this request is: http://localhost:8080/api/vi/attendance/{MaDD}
    ResponseEntity<ResponseObject> Deleteattendance(@PathVariable Integer MaDD) {
        boolean exists = attendanceService.existsById(MaDD);
        if(exists){
            attendanceService.deleteById(MaDD);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("999", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("000", "Cannot delete a Product successfully", "")
        );
    }
}
