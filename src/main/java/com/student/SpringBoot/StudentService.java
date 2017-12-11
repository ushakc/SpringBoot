package com.student.SpringBoot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

 import java.util.HashMap;

@RestController
@RequestMapping(value="/rest/student")
class StudentService{

    @RequestMapping(value="/",method = RequestMethod.GET)
    public HashMap<Long,Student> getAllStudents(){
        return Application.hmStudent;
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Student addStudent(@RequestParam(value="name") String name
            ,@RequestParam(value="subject",defaultValue = "unknown") String subject){

        Student student=new Student(name,subject);
        Application.hmStudent.put(new Long(student.getId()),student);
        return student;

    }


}
