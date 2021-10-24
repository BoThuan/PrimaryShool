package com.example.primaryschool.Controller;

import com.example.primaryschool.Entity.Classroom;
import com.example.primaryschool.Entity.ResponseObject;
import com.example.primaryschool.Service.ClassroomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/vi/Classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    // get all Classroom
    @GetMapping("/getAllClassroom")
    // this request is: http://localhost:8081/api/vi/Classroom/getAllClassroom
    List<Classroom> getallClassroom(){
        return classroomService.getAllClassroom();
    }

    // get Classroom by MaLop
    @GetMapping("/{MaLop}")
    // this request is: http://localhost:8081/api/vi/Classroom/{MaLop}
    ResponseEntity<ResponseObject> findById(@PathVariable String MaLop) {
        Optional<Classroom> foundProduct = classroomService.findById(MaLop);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("999", "Query Product successfully", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("000", "Cannot find product with id = " + MaLop, "")
                );
    }


    // Insert new Classroom
    @PostMapping("/insert")
    // this request is: http://localhost:8081/api/vi/Classroom/insert
    ResponseEntity<ResponseObject> InsertClassroom(@RequestBody Classroom newClassroom){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Insert Product successfully", classroomService.save(newClassroom))
        );
    }

    // update, upsert = update if found, otherwise insert
    @PutMapping("/{MaLop}")
    // this request is: http://localhost:8081/api/vi/Classroom/{MaLop}
    ResponseEntity<ResponseObject> UpdateClassroom(@RequestBody Classroom newClassroom, @PathVariable String MaLop){
        Classroom UpdateClassroom = (Classroom) classroomService.findById(MaLop)
                .map(classroom -> {
                    classroom.setKhoi(newClassroom.getKhoi());
                    classroom.setMaGV(newClassroom.getMaGV());
                    classroom.setTenLop(newClassroom.getTenLop());
                    classroom.setYear(newClassroom.getYear());
                    return classroomService.save(classroom);
                }).orElseGet(() -> {
                    newClassroom.setMaLop(MaLop);
                    return classroomService.save(newClassroom);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("999", "Update Product successfully", UpdateClassroom)
        );
    }

    // delete
    @DeleteMapping("{MaLop}")
    // this request is: http://localhost:8081/api/vi/Classroom/{MaLop}
    ResponseEntity<ResponseObject> DeleteClassroom(@PathVariable String MaLop) {
        boolean exists = classroomService.existsById(MaLop);
        if(exists){
            classroomService.deleteById(MaLop);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("999", "Delete Product successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("000", "Cannot delete a Product successfully", "")
        );
    }
}
