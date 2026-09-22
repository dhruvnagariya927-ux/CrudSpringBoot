package dhruvnagariya927.crudProject.Controller;


import dhruvnagariya927.crudProject.entity.Student;
import dhruvnagariya927.crudProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

        private StudentService studentService;

     @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //create Student
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

       Student createdStudent= studentService.createStudent(student);

       return ResponseEntity.status(HttpStatus.CREATED)
               .body(createdStudent);

    }




    //read  one Student

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudentDetail(@PathVariable Long id){
         Student getStudentRes= studentService.getStudent(id);



         if (getStudentRes==null){
             return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
         }

        return ResponseEntity.ok(getStudentRes);
     }


    //read All Student

    @GetMapping("/getAll")
    public ResponseEntity <List<Student>>getAllStudent(){
          List  <Student >studentList=studentService.getAllStudentDetails();


        if (studentList==null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(studentList);

    }


    //update Student


    //delete Student
}