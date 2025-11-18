package com.tecsup.studentcourse.controller;

import com.tecsup.studentcourse.model.Student;
import com.tecsup.studentcourse.model.Course;
import com.tecsup.studentcourse.repository.StudentRepository;
import com.tecsup.studentcourse.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(studentDetails.getName());
                    student.setEmail(studentDetails.getEmail());
                    student.setPhone(studentDetails.getPhone());
                    return ResponseEntity.ok(studentRepository.save(student));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    studentRepository.delete(student);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<Student> enrollStudentInCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentRepository.findById(studentId)
                .flatMap(student -> courseRepository.findById(courseId)
                        .map(course -> {
                            student.getCourses().add(course);
                            return ResponseEntity.ok(studentRepository.save(student));
                        }))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<Student> unenrollStudentFromCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentRepository.findById(studentId)
                .flatMap(student -> courseRepository.findById(courseId)
                        .map(course -> {
                            student.getCourses().remove(course);
                            return ResponseEntity.ok(studentRepository.save(student));
                        }))
                .orElse(ResponseEntity.notFound().build());
    }
}