package com.example.primaryschool.Controller;

import com.example.primaryschool.Entity.Ministry;
import com.example.primaryschool.Entity.ResponseObject;
import com.example.primaryschool.Service.MinistryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/vi/Ministry")
public class MinistryController {

    @Autowired
    private MinistryService ministryService;

    // get all Ministry
    @GetMapping("/getAllMinistry")
    // this request is: http://localhost:8081/api/vi/Ministry/getAllMinistry
    List<Ministry> getallMinistry(){
        return ministryService.getAllMinistry();
    }

    // get all Ministry
    @GetMapping("/MaxMaGV")
    // this request is: http://localhost:8081/api/vi/Ministry/MaxMaGV
    String getMaxMaGV(){ return ministryService.MaxMaMinistry(); }

    // get Ministry by MaGiaoVu
    @GetMapping("/magiaovu={MaGiaoVu}")
    // this request is: http://localhost:8081/api/vi/Ministry/magiaovu={MaGiaoVu}
    ResponseEntity<ResponseObject> findById(@PathVariable String MaGiaoVu) {
        Optional<Ministry> foundProduct = ministryService.findById(MaGiaoVu);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("999", "Query Product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("000", "Cannot find product with id = " + MaGiaoVu, "")
                );
    }


    // Insert new Ministry
    @PostMapping("/insert")
    // this request is: http://localhost:8081/api/vi/Ministry/insert
    ResponseEntity<ResponseObject> InsertMinistry(@RequestBody Ministry newMinistry){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Insert Product successfully", ministryService.save(newMinistry))
        );
    }

    // update, upsert = update if found, otherwise insert
    @PutMapping("/{MaGiaoVu}")
    // this request is: http://localhost:8081/api/vi/Ministry/{MaGiaoVu}
    ResponseEntity<ResponseObject> UpdateMinistry(@RequestBody Ministry newMinistry, @PathVariable String MaGiaoVu){
        Ministry UpdateMinistry = (Ministry) ministryService.findById(MaGiaoVu)
                .map(ministry -> {
                    ministry.setTenGiaoVu(newMinistry.getTenGiaoVu());
                    ministry.setChucVu(newMinistry.getChucVu());
                    ministry.setSDT(newMinistry.getSDT());
                    ministry.setEmail(newMinistry.getEmail());
                    ministry.setDiaChi(newMinistry.getDiaChi());
                    ministry.setGhiChu(newMinistry.getGhiChu());
                    return ministryService.save(ministry);
                }).orElseGet(() -> {
                    newMinistry.setMaGiaoVu(MaGiaoVu);
                    return ministryService.save(newMinistry);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Update Product successfully", UpdateMinistry)
        );
    }

    // delete
    @DeleteMapping("{MaGiaoVu}")
    // this request is: http://localhost:8081/api/vi/Ministry/{MaGiaoVu}
    ResponseEntity<ResponseObject> DeleteMinistry(@PathVariable String MaGiaoVu) {
        boolean exists = ministryService.existsById(MaGiaoVu);
        if(exists){
            ministryService.deleteById(MaGiaoVu);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("999", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("000", "Cannot delete a Product successfully", "")
        );
    }
}
