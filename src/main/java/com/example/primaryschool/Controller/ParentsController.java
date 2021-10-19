package com.example.primaryschool.Controller;

import com.example.primaryschool.Entity.Parents;
import com.example.primaryschool.Entity.ResponseObject;
import com.example.primaryschool.Repository.RepoParents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/vi/Parents")
public class ParentsController {
    @Autowired
    private RepoParents ParentsRepository;

    // get all Parents
    @GetMapping("/getallParents")
    // this request is: http://localhost:8080/api/vi/Parents/getallParents
    List<Parents> getallParents() {
        return ParentsRepository.findAll();
    }

    // get Parents by MaPH
    @GetMapping("/{MaPH}")
    // this request is: http://localhost:8080/api/vi/Parents/{MaPH}
    ResponseEntity<ResponseObject> findById(@PathVariable String MaPH) {
        Optional<Parents> foundProduct = ParentsRepository.findById(MaPH);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("999", "Query Product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("000", "Cannot find product with id = " + MaPH, "")
                );
    }

    // Insert new Parents with POST method
    @PostMapping("/insert")
    // this request is: http://localhost:8080/api/vi/Parents/insert
    ResponseEntity<ResponseObject> InsertParents(@RequestBody Parents newParent) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Insert Product successfully", ParentsRepository.save(newParent))
        );
    }

    // update, upsert = update if found, otherwise insert
    @PutMapping("/{MaPH}")
    // this request is: http://localhost:8080/api/vi/Parents/{id}
    ResponseEntity<ResponseObject> UpdateParents(@RequestBody Parents newParent, @PathVariable String MaPH) {
        Parents UpdateParent = ParentsRepository.findById(MaPH)
                .map(parent -> {
                    parent.setTenPH(newParent.getTenPH());
                    parent.setSdt(newParent.getSdt());
                    parent.setQuanHe(newParent.getQuanHe());
                    parent.setGhiChu(newParent.getGhiChu());
                    return ParentsRepository.save(parent);
                }).orElseGet(() -> {
                    newParent.setMaPH(MaPH);
                    return ParentsRepository.save(newParent);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Update Product successfully", UpdateParent)
        );
    }

    // Delete a Parents
    @DeleteMapping("{MaPH}")
    // this request is: http://localhost:8080/api/vi/Parents/{MaPH}
    ResponseEntity<ResponseObject> DeleteParents(@PathVariable String MaPH) {
        boolean exists = ParentsRepository.existsById(MaPH);
        if (exists) {
            ParentsRepository.deleteById(MaPH);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("999", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("000", "Cannot delete a Product successfully", "")
        );

    }
}