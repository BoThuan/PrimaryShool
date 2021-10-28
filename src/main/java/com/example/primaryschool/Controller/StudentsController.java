package com.example.primaryschool.Controller;

import com.example.primaryschool.Entity.Students;
import com.example.primaryschool.Entity.ResponseObject;
import com.example.primaryschool.Service.StudentsService;

import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/vi/Students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    // get all Students
    @GetMapping("/getAllStudents")
    // this request is: http://localhost:8081/api/vi/Students/getAllStudents
    List<Students> getallStudents(){
        return studentsService.getAllStudents();
    }

    // get Students by MaHS
    @GetMapping("/Id/{MaHS}")
    // this request is: http://localhost:8081/api/vi/Students/Id/{MaHS}
    ResponseEntity<ResponseObject> findById(@PathVariable String MaHS) {
        Optional<Students> foundProduct = studentsService.findById(MaHS);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("999", "Query Product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("000", "Cannot find product with id = " + MaHS, "")
                );
    }


    @GetMapping("/Name/{TenHS}")
        // this request is: http://localhost:8081/api/vi/Students/Name/{TenHS}
    ResponseEntity<ResponseObject> findByName(@PathVariable String TenHS) {
        Optional<Students> foundProduct = studentsService.findByName(TenHS);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("999", "Query Product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("000", "Cannot find product with Name = " + TenHS, "")
                );
    }

    //TODO Write find student by Male
    @GetMapping("/Gioitinh/{GioiTinh}")
        // this request is: http://localhost:8081/api/vi/Students/{MaHS}
    ResponseEntity<ResponseObject> findByMale(@PathVariable Boolean GioiTinh) {
        Optional<Students> foundProduct = studentsService.findByMale(GioiTinh);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("999", "Query Product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("000", "Cannot find product with Name = " + GioiTinh, "")
                );
    }


    // get all Students
    @GetMapping("/getCountStudents")
    // this request is: http://localhost:8081/api/vi/Students/getCountStudents
    Integer getCountStudents(){
        return studentsService.countStudent();
    }


    // Insert new Students
    @PostMapping("/insert")
    // this request is: http://localhost:8081/api/vi/Students/insert
    ResponseEntity<ResponseObject> InsertStudents(@RequestBody Students newStudents){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Insert Product successfully", studentsService.save(newStudents))
        );
    }

    // update, upsert = update if found, otherwise insert
    @PutMapping("/{MaHS}")
    // this request is: http://localhost:8081/api/vi/Students/{MaHS}
    ResponseEntity<ResponseObject> UpdateStudents(@RequestBody Students newStudents, @PathVariable String MaHS){
        Students UpdateStudents = (Students) studentsService.findById(MaHS)
                .map(Students -> {
                    Students.setTenHS(newStudents.getTenHS());
                    Students.setNgaySinh(newStudents.getNgaySinh());
                    Students.setGioiTinh(newStudents.getGioiTinh());
                    Students.setDiaChi(newStudents.getDiaChi());
                    Students.setGhiChu(newStudents.getGhiChu());
                    Students.setParents(newStudents.getParents());
                    return studentsService.save(Students);
                }).orElseGet(() -> {
                    newStudents.setMaHS(MaHS);
                    return studentsService.save(newStudents);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Update Product successfully", UpdateStudents)
        );
    }

    // delete
    @DeleteMapping("{MaHS}")
        // this request is: http://localhost:8081/api/vi/Students/{MaHS}
    ResponseEntity<ResponseObject> DeleteStudents(@PathVariable String MaHS) {
        boolean exists = studentsService.existsById(MaHS);
        if(exists){
            studentsService.deleteById(MaHS);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("999", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("000", "Cannot delete a Product successfully", "")
        );
    }
}
