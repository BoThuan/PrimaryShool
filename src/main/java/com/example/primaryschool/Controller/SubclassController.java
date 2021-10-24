package com.example.primaryschool.Controller;

import com.example.primaryschool.Entity.Subclass;
import com.example.primaryschool.Entity.ResponseObject;
import com.example.primaryschool.Service.SubclassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/vi/Subclass")
public class SubclassController {

    @Autowired
    private SubclassService subclassService;

    // get all Subclass
    @GetMapping("/getAllSubclass")
    // this request is: http://localhost:8080/api/vi/Subclass/getAllSubclass
    List<Subclass> getallSubclass(){
        return subclassService.getAllSubclass();
    }

    // get Subclass by MaPL
    @GetMapping("/{MaPL}")
    // this request is: http://localhost:8081/api/vi/Subclass/{MaPL}
    ResponseEntity<ResponseObject> findById(@PathVariable String MaPL) {
        Optional<Subclass> foundProduct = subclassService.findById(MaPL);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("999", "Query Product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("000", "Cannot find product with id = " + MaPL, "")
                );
    }


    // Insert new Subclass
    @PostMapping("/insert")
    // this request is: http://localhost:8080/api/vi/Subclass/insert
    ResponseEntity<ResponseObject> InsertSubclass(@RequestBody Subclass newSubclass){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Insert Product successfully", subclassService.save(newSubclass))
        );
    }

    // update, upsert = update if found, otherwise insert
    @PutMapping("/{MaPL}")
    // this request is: http://localhost:8080/api/vi/Subclass/{MaPL}
    ResponseEntity<ResponseObject> UpdateSubclass(@RequestBody Subclass newSubclass, @PathVariable String MaPL){
        Subclass UpdateSubclass = (Subclass) subclassService.findById(MaPL)
                .map(Subclass -> {
                    Subclass.setMaLop(newSubclass.getMaLop());
                    Subclass.setMaHS(newSubclass.getMaHS());
                    Subclass.setHanhKiem(newSubclass.getHanhKiem());
                    Subclass.setXepLoai(newSubclass.getXepLoai());
                    Subclass.setDiemTBNam(newSubclass.getDiemTBNam());
                    Subclass.setDiemKy1(newSubclass.getDiemKy1());
                    Subclass.setDiemKy2(newSubclass.getDiemKy2());
                    return subclassService.save(Subclass);
                }).orElseGet(() -> {
                    newSubclass.setMaPL(MaPL);
                    return subclassService.save(newSubclass);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Update Product successfully", UpdateSubclass)
        );
    }

    // delete
    @DeleteMapping("{MaPL}")
    // this request is: http://localhost:8080/api/vi/Subclass/{MaPL}
    ResponseEntity<ResponseObject> DeleteSubclass(@PathVariable String MaPL) {
        boolean exists = subclassService.existsById(MaPL);
        if(exists){
            subclassService.deleteById(MaPL);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("999", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("000", "Cannot delete a Product successfully", "")
        );
    }
}
