package com.example.primaryschool.Controller;

import com.example.primaryschool.Entity.Assignment;
import com.example.primaryschool.Entity.ResponseObject;
import com.example.primaryschool.Service.AssignmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/vi/Assignment")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    // get all Assignment
    @GetMapping("/getAllAssignment")
    // this request is: http://localhost:8081/api/vi/Assignment/getAllAssignment
    List<Assignment> getallAssignment(){
        return assignmentService.getAllAssignment();
    }

    // get Assignment by MaPC
    @GetMapping("/{MaPC}")
    // this request is: http://localhost:8081/api/vi/Assignment/{MaPC}
    ResponseEntity<ResponseObject> findById(@PathVariable String MaPC) {
        Optional<Assignment> foundProduct = assignmentService.findById(MaPC);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("999", "Query Product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("000", "Cannot find product with id = " + MaPC, "")
                );
    }


    // Insert new Assignment
    @PostMapping("/insert")
    // this request is: http://localhost:8081/api/vi/Assignment/insert
    ResponseEntity<ResponseObject> InsertAssignment(@RequestBody Assignment newAssignment){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Insert Product successfully", assignmentService.save(newAssignment))
        );
    }

    // update, upsert = update if found, otherwise insert
    @PutMapping("/{MaPC}")
    // this request is: http://localhost:8081/api/vi/Assignment/{MaPC}
    ResponseEntity<ResponseObject> UpdateAssignment(@RequestBody Assignment newAssignment, @PathVariable String MaPC){
        Assignment UpdateAssignment = (Assignment) assignmentService.findById(MaPC)
                .map(assignment -> {
                    assignment.setMaMon(newAssignment.getMaMon());
                    assignment.setMaLop(newAssignment.getMaLop());
                    assignment.setMaGV(newAssignment.getMaGV());
                    assignment.setCa(newAssignment.getCa());
                    return assignmentService.save(assignment);
                }).orElseGet(() -> {
                    newAssignment.setMaPC(MaPC);
                    return assignmentService.save(newAssignment);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Update Product successfully", UpdateAssignment)
        );
    }

    // delete
    @DeleteMapping("{MaPC}")
    // this request is: http://localhost:8081/api/vi/Assignment/{MaPC}
    ResponseEntity<ResponseObject> DeleteAssignment(@PathVariable String MaPC) {
        boolean exists = assignmentService.existsById(MaPC);
        if(exists){
            assignmentService.deleteById(MaPC);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("999", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("000", "Cannot delete a Product successfully", "")
        );
    }
}
