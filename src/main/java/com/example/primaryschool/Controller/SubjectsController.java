package com.example.primaryschool.Controller;

import com.example.primaryschool.Entity.ResponseObject;
import com.example.primaryschool.Entity.Subjects;
import com.example.primaryschool.Repository.RepoSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/vi/Subjects")
public class SubjectsController {

    @Autowired
    private RepoSubject SubjectsController;

    // get all Subjects
    @GetMapping("/getallSubjects")
    // this request is: http://localhost:8081/api/vi/Subjects/getallSubjects
    List<Subjects> getallSubjects(){
        return SubjectsController.findAll();
    }

    // get Subjects by ID
    @GetMapping("/{MaMon}")
    // this request is: http://localhost:8081/api/vi/Subjects/{MaMon}
    ResponseEntity<ResponseObject> findById(@PathVariable String MaMon){
        Optional<Subjects> foundProduct = SubjectsController.findById(MaMon);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("999", "Query Product successfully", foundProduct)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("000", "Cannot find product with id = " +MaMon, "")
                );
    }

    // Insert new Product with POST method
    @PostMapping("/insert")
    // this request is: http://localhost:8081/api/vi/Subjects/insert
    ResponseEntity<ResponseObject> InsertSubjects(@RequestBody Subjects newSubject){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Insert Product successfully", SubjectsController.save(newSubject))
        );
    }


    // update, upsert = update if found, otherwise insert
    @PutMapping("/{MaMon}")
    // this request is: http://localhost:8081/api/vi/Subjects/{MaMon}
    ResponseEntity<ResponseObject> UpdateSubjects(@RequestBody Subjects newSubjects, @PathVariable String MaMon){
        Subjects UpdateSubject = SubjectsController.findById(MaMon)
                .map(subject -> {
                    subject.setTenMon(newSubjects.getTenMon());
                    return SubjectsController.save(subject);
                }).orElseGet(() -> {
                    newSubjects.setMaMon(MaMon);
                    return SubjectsController.save(newSubjects);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Update Product successfully", UpdateSubject)
        );
    }

    // Delete a product
    @DeleteMapping("{MaMon}")
    // this request is: http://localhost:8081/api/vi/Subjects/{MaMon}
    ResponseEntity<ResponseObject> DeleteSubjects(@PathVariable String MaMon) {
        boolean exists = SubjectsController.existsById(MaMon);
        if(exists){
            SubjectsController.deleteById(MaMon);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("999", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("000", "Cannot delete a Product successfully", "")
        );
    }
}
