package com.example.primaryschool.Controller;

import com.example.primaryschool.Entity.Approve;
import com.example.primaryschool.Entity.ResponseObject;
import com.example.primaryschool.Service.ApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/vi/Approve")
public class ApproveController {

    @Autowired
    private ApproveService approveService;

    // get all Approve
    @GetMapping("/getAllApprove")
    // this request is: http://localhost:8081/api/vi/Approve/getAllApprove
    List<Approve> getallApprove(){
        return approveService.getAllApprove();
    }

    // get Approve by maPD
    @GetMapping("/maPD={maPD}")
    // this request is: http://localhost:8081/api/vi/Approve/maPD={maPD}
    ResponseEntity<ResponseObject> findById(@PathVariable Integer maPD) {
        Optional<Approve> foundProduct = approveService.findById(maPD);
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
                new ResponseObject("999", "Insert Product successfully", approveService.save(newApprove))
        );
    }

    // update, upsert = update if found, otherwise insert
    @PutMapping("/{maPD}")
    // this request is: http://localhost:8081/api/vi/Approve/{maPD}
    ResponseEntity<ResponseObject> UpdateApprove(@RequestBody Approve newApprove, @PathVariable Integer maPD){
        Approve UpdateApprove = (Approve) approveService.findById(maPD)
                .map(Approve -> {
                    Approve.setPheDuyet(newApprove.getPheDuyet());
                    return approveService.save(Approve);
                }).orElseGet(() -> {
                    newApprove.setMaPD(maPD);
                    return approveService.save(newApprove);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Update Product successfully", UpdateApprove)
        );
    }

    // delete
    @DeleteMapping("{maPD}")
    // this request is: http://localhost:8081/api/vi/Approve/{maPD}
    ResponseEntity<ResponseObject> DeleteApprove(@PathVariable Integer maPD) {
        boolean exists = approveService.existsById(maPD);
        if(exists){
            approveService.deleteById(maPD);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("999", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("000", "Cannot delete a Product successfully", "")
        );
    }
}
