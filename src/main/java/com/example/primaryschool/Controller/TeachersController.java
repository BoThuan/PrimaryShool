package com.example.primaryschool.Controller;

import com.example.primaryschool.Entity.ResponseObject;
import com.example.primaryschool.Entity.Teachers;
import com.example.primaryschool.Service.TeachersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/vi/Teachers")
public class TeachersController {

    @Autowired
    private TeachersService teachersService;

    // get all Teachers
    @GetMapping("/getAllTeachers")
    // this request is: http://localhost:8081/api/vi/Teachers/getAllTeachers
    List<Teachers> getallTeachers(){
        return teachersService.getAllTeachers();
    }

    // get all Ministry
    @GetMapping("/MaxMaGV")
    // this request is: http://localhost:8081/api/vi/Teachers/MaxMaGV
    Optional<Teachers> getMaxMaGV(){ return teachersService.MaxMaTeachers(); }

    // get Teachers by MaGV
    @GetMapping("/ID/{MaGV}")
    // this request is: http://localhost:8081/api/vi/Teachers/ID/{MaGV}
    ResponseEntity<ResponseObject> findById(@PathVariable String MaGV) {
        Optional<Teachers> foundProduct = teachersService.findById(MaGV);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("999", "Query Product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("000", "Cannot find product with id = " + MaGV, "")
                );
    }

    @GetMapping("/Name/{TenGV}")
        // this request is: http://localhost:8081/api/vi/Teachers/Name/{TenGV}
    ResponseEntity<ResponseObject> findByName(@PathVariable String TenGV) {
        Optional<Teachers> foundProduct = teachersService.findByName(TenGV);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("999", "Query Product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("000", "Cannot find product with Name = " + TenGV, "")
                );
    }

    @GetMapping("/SDT/{SDT}")
        // this request is: http://localhost:8081/api/vi/Teachers/SDT/{SDT}
    ResponseEntity<ResponseObject> findBySDT(@PathVariable String SDT) {
        Optional<Teachers> foundProduct = teachersService.findBySDT(SDT);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("999", "Query Product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("404", "Cannot find product with SDT = " + SDT, foundProduct)
                );
    }

    @GetMapping("/Email/{Email}")
        // this request is: http://localhost:8081/api/vi/Teachers/Email/{Email}
    ResponseEntity<ResponseObject> findByEmail(@PathVariable String Email) {
        Optional<Teachers> foundProduct = teachersService.findByEmail(Email);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("999", "Query Product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("000", "Cannot find product with Email = " + Email, "")
                );
    }

    // get all Students
    @GetMapping("/getCountTeachers")
    // this request is: http://localhost:8081/api/vi/Students/getCountStudents
    Integer getCountTeachers(){
        return teachersService.countTeachers();
    }


    // Insert new Teachers
    @PostMapping("/insert")
    // this request is: http://localhost:8081/api/vi/Teachers/insert
    ResponseEntity<ResponseObject> InsertTeachers(@RequestBody Teachers newTeachers){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Insert Product successfully", teachersService.save(newTeachers))
        );
    }

    // update, upsert = update if found, otherwise insert
    @PutMapping("/{MaGV}")
    // this request is: http://localhost:8081/api/vi/Teachers/{MaGV}
    ResponseEntity<ResponseObject> UpdateTeachers(@RequestBody Teachers newTeachers, @PathVariable String MaGV){
        Teachers UpdateTeachers = (Teachers) teachersService.findById(MaGV)
                .map(Teachers -> {
                    Teachers.setTenGV(newTeachers.getTenGV());
                    Teachers.setNgaySinh(newTeachers.getNgaySinh());
                    Teachers.setGioiTinh(newTeachers.getGioiTinh());
                    Teachers.setDiaChi(newTeachers.getDiaChi());
                    Teachers.setSDT(newTeachers.getSDT());
                    Teachers.setEmail(newTeachers.getEmail());
                    Teachers.setGhiChu(newTeachers.getGhiChu());
                    return teachersService.save(Teachers);
                }).orElseGet(() -> {
                    newTeachers.setMaGV(MaGV);
                    return teachersService.save(newTeachers);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Update Product successfully", UpdateTeachers)
        );
    }

    // delete
    @DeleteMapping("{MaGV}")
    // this request is: http://localhost:8081/api/vi/Teachers/{MaGV}
    ResponseEntity<ResponseObject> DeleteTeachers(@PathVariable String MaGV) {
        boolean exists = teachersService.existsById(MaGV);
        if(exists){
            teachersService.deleteById(MaGV);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("999", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("000", "Cannot delete a Product successfully", "")
        );
    }
}
