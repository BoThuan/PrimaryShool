package com.example.primaryschool.Controller;

import com.example.primaryschool.Entity.Grade;
import com.example.primaryschool.Entity.ResponseObject;
import com.example.primaryschool.Repository.RepoGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/vi/Grade")
public class GradeController {
    @Autowired
    private RepoGrade GradeRepository;

    // get all Grade
    @GetMapping("/getallGrade")
    // this request is: http://localhost:8080/api/vi/Grade/getallGrade
    List<Grade> getallGrade(){
        return GradeRepository.findAll();
    }

    // Insert new Grade
    @PostMapping("/insert")
    // this request is: http://localhost:8080/api/vi/Grade/insert
    ResponseEntity<ResponseObject> InsertGrade(@RequestBody Grade newGrade){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Insert Product successfully", GradeRepository.save(newGrade))
        );
    }

    // update, upsert = update if found, otherwise insert
    @PutMapping("/{MaKhoi}")
    // this request is: http://localhost:8080/api/vi/Grade/{id}
    ResponseEntity<ResponseObject> UpdateGrade(@RequestBody Grade newGrade, @PathVariable String MaKhoi){
        Grade UpdateGrade = GradeRepository.findById(MaKhoi)
                .map(grade -> {
                    grade.setTenKhoi(newGrade.getTenKhoi());
                    return GradeRepository.save(grade);
                }).orElseGet(() -> {
                    newGrade.setMaKhoi(MaKhoi);
                    return GradeRepository.save(newGrade);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Update Product successfully", UpdateGrade)
        );
    }

    // delete
    @DeleteMapping("{id}")
    // this request is: http://localhost:8080/api/vi/Grade/{id}
    ResponseEntity<ResponseObject> DeleteGrade(@PathVariable String MaKhoi) {
        boolean exists = GradeRepository.existsById(MaKhoi);
        if(exists){
            GradeRepository.deleteById(MaKhoi);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("999", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("000", "Cannot delete a Product successfully", "")
        );
    }
}
