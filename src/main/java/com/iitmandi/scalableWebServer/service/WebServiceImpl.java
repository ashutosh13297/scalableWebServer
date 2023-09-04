package com.iitmandi.scalableWebServer.service;

import com.iitmandi.scalableWebServer.constant.Constants;
import com.iitmandi.scalableWebServer.dao.StudentDao;
import com.iitmandi.scalableWebServer.model.Application;
import com.iitmandi.scalableWebServer.model.College;
import com.iitmandi.scalableWebServer.model.Student;
import com.iitmandi.scalableWebServer.util.WebServerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WebServiceImpl implements WebService {

    private static final Logger LOG = LoggerFactory.getLogger(WebServiceImpl.class);

    @Autowired
    StudentDao studentDao;
    @Override
    public List<String> testInExpensiveQuery() {
        try {
            return studentDao.testInExpensiveQuery();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<String> testModeratelyExpensiveQuery() {
        try {
            return studentDao.testModeratelyExpensiveQuery();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<String> testHighlyExpensiveQuery() {
        try {
            return studentDao.testHighlyExpensiveQuery();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String addStudentData(Integer noOfStudent) {
        if(noOfStudent == null)
            noOfStudent = Constants.MAX_RECORD_LIMIT;
        try {
            List<Student> studentList = new ArrayList<>();
            for(int i = 1 ; i <= noOfStudent ; i++) {
                Student student = new Student(i, "student_" + i);
                studentList.add(student);
                if(i % Constants.BATCH_SIZE == 0) {
                    studentDao.addStudentData(new ArrayList<>(studentList));
                    studentList.clear();
                }
            }
            if(!studentList.isEmpty()) {
                studentDao.addStudentData(studentList);
            }
            return "Success";
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String addCollegeData(Integer noOfCollege) {
        if(noOfCollege == null)
            noOfCollege = Constants.MAX_RECORD_LIMIT;
        try {
            List<College> clgList = new ArrayList<>();
            for(int i = 1 ; i <= noOfCollege ; i++) {
                College college = new College(i, "college_" + i);
                clgList.add(college);
                if(i % Constants.BATCH_SIZE == 0) {
                    studentDao.addCollegeData(new ArrayList<>(clgList));
                    clgList.clear();
                }
            }
            if(!clgList.isEmpty()) {
                studentDao.addCollegeData(clgList);
            }
            return "Success";
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String addClgApplication(Integer noOfApplications) {
        if(noOfApplications == null)
            noOfApplications = Constants.MAX_RECORD_LIMIT;
        try {
            List<Application> applicationList = new ArrayList<>();
            for(int i = 1 ; i <= noOfApplications ; i++) {
//                int sId = WebServerUtil.getRandomNumber();
//                int cId = WebServerUtil.getRandomNumber();
                Application application = new Application(i, i);
                applicationList.add(application);
                if(i % Constants.BATCH_SIZE == 0) {
                    studentDao.addClgApplication(new ArrayList<>(applicationList));
                    applicationList.clear();
                }
            }
            if(!applicationList.isEmpty()) {
                studentDao.addClgApplication(applicationList);
            }
            return "Success";
        } catch (Exception e) {
            throw e;
        }
    }
}
