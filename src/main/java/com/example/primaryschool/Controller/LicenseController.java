package com.example.primaryschool.Controller;

import com.example.primaryschool.Entity.License;
import com.example.primaryschool.Entity.ResponseObject;
import com.example.primaryschool.Service.LicenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/vi/License")
public class LicenseController {
    @Autowired
    private LicenseService licenseService;

    // get all License
    @GetMapping("/getAllLicense")
    // this request is: http://localhost:8081/api/vi/License/getAllLicense
    List<License> getallLicense(){
        return licenseService.getAllLicense();
    }

    // get License by MaGP
    @GetMapping("/{MaGP}")
    // this request is: http://localhost:8081/api/vi/License/{MaGP}
    ResponseEntity<ResponseObject> findById(@PathVariable String MaGP) {
        Optional<License> foundProduct = licenseService.findById(MaGP);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("999", "Query Product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("000", "Cannot find product with id = " + MaGP, "")
                );
    }


    // Insert new License
    @PostMapping("/insert")
    // this request is: http://localhost:8081/api/vi/License/insert
    ResponseEntity<ResponseObject> InsertLicense(@RequestBody License newLicense){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Insert Product successfully", licenseService.save(newLicense))
        );
    }

    // update, upsert = update if found, otherwise insert
    @PutMapping("/{MaGP}")
    // this request is: http://localhost:8081/api/vi/License/{MaGP}
    ResponseEntity<ResponseObject> UpdateLicense(@RequestBody License newLicense, @PathVariable String MaGP){
        License UpdateLicense = (License) licenseService.findById(MaGP)
                .map(license -> {
                    license.setMaPH(newLicense.getMaPH());
                    license.setNgay(newLicense.getNgay());
                    license.setBatDau(newLicense.getKetThuc());
                    license.setLyDo(newLicense.getLyDo());
                    license.setDuyet(newLicense.getDuyet());
                    return licenseService.save(license);
                }).orElseGet(() -> {
                    newLicense.setMaGP(MaGP);
                    return licenseService.save(newLicense);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Update Product successfully", UpdateLicense)
        );
    }

    // delete
    @DeleteMapping("{MaGP}")
    // this request is: http://localhost:8081/api/vi/License/{MaGP}
    ResponseEntity<ResponseObject> DeleteLicense(@PathVariable String MaGP) {
        boolean exists = licenseService.existsById(MaGP);
        if(exists){
            licenseService.deleteById(MaGP);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("999", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("000", "Cannot delete a Product successfully", "")
        );
    }
}
