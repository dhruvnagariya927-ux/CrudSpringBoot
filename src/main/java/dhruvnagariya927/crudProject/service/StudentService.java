package dhruvnagariya927.crudProject.service;

import dhruvnagariya927.crudProject.entity.Student;
import dhruvnagariya927.crudProject.repository.StudentRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for student-related business logic.
 */



@Service
public  class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public  Student createStudent(Student studentReq){

        Student studentResponse=studentRepository.save(studentReq);
            return studentResponse;

        }

        //get student
    public Student getStudent(Long id){
        Optional<Student> studentRes=studentRepository.findById(id);
        if (studentRes.isPresent()){

            return studentRes.get();
        }

        return  null;

    }


    //get All Student

    public List<Student> getAllStudentDetails(){
        List<Student> studentRes=studentRepository.findAll();


        return  studentRes;
    }


    //update student detail

    public  Student updateStudent(Long id,Student studentReq){
     Optional   <Student> existingStudent= studentRepository.findById(id);

     if (existingStudent.isEmpty()){
         return null;
     }

     Student studentToSave= existingStudent.get();

    studentToSave.setAge(studentReq.getAge());
    studentToSave.setName(studentReq.getName());
    studentToSave.setRollno(studentReq.getRollno());
    studentToSave.setSubject(studentReq.getSubject());

    return studentRepository.save(studentToSave);

    }

    public Student deleteStudent(Long id) {
        Optional<Student> existingStudent = studentRepository.findById(id);

        if (existingStudent.isEmpty()) {
            return null;
        }

        Student studentToDelete = existingStudent.get();
        studentRepository.delete(studentToDelete);
        return studentToDelete;
    }

}
