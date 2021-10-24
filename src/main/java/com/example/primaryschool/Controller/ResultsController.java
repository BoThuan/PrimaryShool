package com.example.primaryschool.Controller;

import com.example.primaryschool.Entity.Results;
import com.example.primaryschool.Entity.ResponseObject;
import com.example.primaryschool.Service.ResultsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/vi/Results")
public class ResultsController {

    @Autowired
    private ResultsService resultsService;

    // get all Results
    @GetMapping("/getAllResults")
    // this request is: http://localhost:8081/api/vi/Results/getAllResults
    List<Results> getallResults(){
        return resultsService.getAllResults();
    }

    // get Results by MaKQ
    @GetMapping("/{MaKQ}")
    // this request is: http://localhost:8081/api/vi/Results/{MaKQ}
    ResponseEntity<ResponseObject> findById(@PathVariable String MaKQ) {
        Optional<Results> foundProduct = resultsService.findById(MaKQ);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("999", "Query Product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("000", "Cannot find product with id = " + MaKQ, "")
                );
    }


    // Insert new Results
    @PostMapping("/insert")
    // this request is: http://localhost:8081/api/vi/Results/insert
    ResponseEntity<ResponseObject> InsertResults(@RequestBody Results newResults){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Insert Product successfully", resultsService.save(newResults))
        );
    }

    // update, upsert = update if found, otherwise insert
    @PutMapping("/{MaKQ}")
    // this request is: http://localhost:8081/api/vi/Results/{MaKQ}
    ResponseEntity<ResponseObject> UpdateResults(@RequestBody Results newResults, @PathVariable String MaKQ){
        Results UpdateResults = (Results) resultsService.findById(MaKQ)
                .map(results -> {
                    results.setMaPL(newResults.getMaPL());
                    results.setMaPC(newResults.getMaPC());
                    results.setDiemMieng(newResults.getDiemMieng());
                    results.setDiem15p(newResults.getDiem15p());
                    results.setDiem1t(newResults.getDiem1t());
                    return resultsService.save(results);
                }).orElseGet(() -> {
                    newResults.setMaKQ(MaKQ);
                    return resultsService.save(newResults);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Update Product successfully", UpdateResults)
        );
    }

    // delete
    @DeleteMapping("{MaKQ}")
    // this request is: http://localhost:8081/api/vi/Results/{MaKQ}
    ResponseEntity<ResponseObject> DeleteResults(@PathVariable String MaKQ) {
        boolean exists = resultsService.existsById(MaKQ);
        if(exists){
            resultsService.deleteById(MaKQ);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("999", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("000", "Cannot delete a Product successfully", "")
        );
    }
}
