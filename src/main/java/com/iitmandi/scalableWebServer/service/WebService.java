package com.iitmandi.scalableWebServer.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface WebService {

    List<String> testInExpensiveQuery();
    List<String> testModeratelyExpensiveQuery();
    List<String> testHighlyExpensiveQuery();
    String addStudentData(Integer noOfStudent);
    String addCollegeData(Integer noOfCollege);
    String addClgApplication(Integer noOfApplication);
}
