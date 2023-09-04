package com.iitmandi.scalableWebServer.dao;

import com.iitmandi.scalableWebServer.model.Application;
import com.iitmandi.scalableWebServer.model.College;
import com.iitmandi.scalableWebServer.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentDao {

    List<String> testInExpensiveQuery();
    List<String> testModeratelyExpensiveQuery();
    List<String> testHighlyExpensiveQuery();
    String addStudentData(List<Student> studentList);
    String addCollegeData(List<College> studentList);
    String addClgApplication(List<Application> studentList);

}
