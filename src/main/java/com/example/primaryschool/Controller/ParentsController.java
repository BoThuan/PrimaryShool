package com.example.primaryschool.Controller;

import com.example.primaryschool.Entity.Parents;
import com.example.primaryschool.Entity.ResponseObject;
import com.example.primaryschool.Service.ParentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/vi/Parents")
public class ParentsController {
    @Autowired
    private ParentsService parentsService;

    // get all Parents
    @GetMapping("/getallParents")
    // this request is: http://localhost:8081/api/vi/Parents/getallParents
    List<Parents> getallParents() {
        return parentsService.getAllParents();
    }

    // get Parents by MaPH
    @GetMapping("/maph={MaPH}")
    // this request is: http://localhost:8081/api/vi/Parents/{MaPH}
    Optional<Parents> findById(@PathVariable String MaPH) {
        return parentsService.findById(MaPH);
    }

    // Insert new Parents with POST method
    @PostMapping("/insert")
    // this request is: http://localhost:8081/api/vi/Parents/insert
    ResponseEntity<ResponseObject> InsertParents(@RequestBody Parents newParent) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Insert Product successfully", parentsService.save(newParent))
        );
    }

    // update, upsert = update if found, otherwise insert
    @PutMapping("/{MaPH}")
    // this request is: http://localhost:8081/api/vi/Parents/{MaPH}
    ResponseEntity<ResponseObject> UpdateParents(@RequestBody Parents newParent, @PathVariable String MaPH) {
        Parents UpdateParent = (Parents) parentsService.findById(MaPH)
                .map(parent -> {
                    parent.setTenPH(newParent.getTenPH());
                    parent.setSdt(newParent.getSdt());
                    parent.setQuanHe(newParent.getQuanHe());
                    parent.setGhiChu(newParent.getGhiChu());
                    return parentsService.save(parent);
                }).orElseGet(() -> {
                    newParent.setMaPH(MaPH);
                    return parentsService.save(newParent);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Update Product successfully", UpdateParent)
        );
    }

    // Delete a Parents
    @DeleteMapping("{MaPH}")
    // this request is: http://localhost:8081/api/vi/Parents/{MaPH}
    ResponseEntity<ResponseObject> DeleteParents(@PathVariable String MaPH) {
        boolean exists = parentsService.existsById(MaPH);
        if (exists) {
            parentsService.deleteById(MaPH);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("999", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("000", "Cannot delete a Product successfully", "")
        );

    }
}