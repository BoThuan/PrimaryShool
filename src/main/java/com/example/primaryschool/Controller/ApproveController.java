package com.example.primaryschool.Controller;

import com.example.primaryschool.Entity.Approve;
import com.example.primaryschool.Entity.ResponseObject;
import com.example.primaryschool.Service.ApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/vi/Approve")
public class ApproveController {

    @Qualifier("approveService")
    @Autowired
    private ApproveService ApproveService;

    // get all Approve
    @GetMapping("/getAllApprove")
    // this request is: http://localhost:8081/api/vi/Approve/getAllApprove
    List<Approve> getallApprove(){
        return ApproveService.getAllApprove();
    }

    // get Approve by maPD
    @GetMapping("/maPD={maPD}")
    // this request is: http://localhost:8081/api/vi/Approve/maPD={maPD}
    ResponseEntity<ResponseObject> findById(@PathVariable Integer maPD) {
        Optional<Approve> foundProduct = ApproveService.findById(maPD);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("999", "Query Product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("000", "Cannot find product with id = " + maPD, "")
                );
    }


    // Insert new Approve
    @PostMapping("/insert")
    // this request is: http://localhost:8081/api/vi/Approve/insert
    ResponseEntity<ResponseObject> InsertApprove(@RequestBody Approve newApprove){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Insert Product successfully", ApproveService.save(newApprove))
        );
    }

    // update, upsert = update if found, otherwise insert
    @PutMapping("/{maPD}")
    // this request is: http://localhost:8081/api/vi/Approve/{maPD}
    ResponseEntity<ResponseObject> UpdateApprove(@RequestBody Approve newApprove, @PathVariable Integer maPD){
        Approve UpdateApprove = (Approve) ApproveService.findById(maPD)
                .map(Approve -> {
                    Approve.setNguoiGui(newApprove.getNguoiGui());
                    Approve.setThoiGian(newApprove.getThoiGian());
                    Approve.setNoiDung(newApprove.getNoiDung());
                    Approve.setPheDuyet(newApprove.getPheDuyet());
                    return ApproveService.save(Approve);
                }).orElseGet(() -> {
                    newApprove.setMaPD(maPD);
                    return ApproveService.save(newApprove);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Update Product successfully", UpdateApprove)
        );
    }

    // delete
    @DeleteMapping("{maPD}")
    // this request is: http://localhost:8081/api/vi/Approve/{maPD}
    ResponseEntity<ResponseObject> DeleteApprove(@PathVariable Integer maPD) {
        boolean exists = ApproveService.existsById(maPD);
        if(exists){
            ApproveService.deleteById(maPD);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("999", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("000", "Cannot delete a Product successfully", "")
        );
    }
}
