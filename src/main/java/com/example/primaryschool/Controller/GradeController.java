package com.example.primaryschool.Controller;

import com.example.primaryschool.Entity.Grade;
import com.example.primaryschool.Entity.ResponseObject;
import com.example.primaryschool.Service.GradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/vi/Grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    // get all Grade
    @GetMapping("/getallGrade")
    // this request is: http://localhost:8081/api/vi/Grade/getallGrade
    List<Grade> getallGrade(){
        return gradeService.getAllParents();
    }

    // Insert new Grade
    @PostMapping("/insert")
    // this request is: http://localhost:8081/api/vi/Grade/insert
    ResponseEntity<ResponseObject> InsertGrade(@RequestBody Grade newGrade){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Insert Product successfully", gradeService.save(newGrade))
        );
    }

    // update, upsert = update if found, otherwise insert
    @PutMapping("/{MaKhoi}")
    // this request is: http://localhost:8081/api/vi/Grade/{MaKhoi}
    ResponseEntity<ResponseObject> UpdateGrade(@RequestBody Grade newGrade, @PathVariable String MaKhoi){
        Grade UpdateGrade = (Grade) gradeService.findById(MaKhoi)
                .map(grade -> {
                    grade.setTenKhoi(newGrade.getTenKhoi());
                    return gradeService.save(grade);
                }).orElseGet(() -> {
                    newGrade.setMaKhoi(MaKhoi);
                    return gradeService.save(newGrade);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Update Product successfully", UpdateGrade)
        );
    }

    // delete
    @DeleteMapping("{MaKhoi}")
    // this request is: http://localhost:8081/api/vi/Grade/{MaKhoi}
    ResponseEntity<ResponseObject> DeleteGrade(@PathVariable String MaKhoi) {
        boolean exists = gradeService.existsById(MaKhoi);
        if(exists){
            gradeService.deleteById(MaKhoi);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("999", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("000", "Cannot delete a Product successfully", "")
        );
    }
}
