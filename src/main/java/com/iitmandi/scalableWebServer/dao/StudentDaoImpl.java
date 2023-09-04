package com.iitmandi.scalableWebServer.dao;

import com.iitmandi.scalableWebServer.model.Application;
import com.iitmandi.scalableWebServer.model.College;
import com.iitmandi.scalableWebServer.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.iitmandi.scalableWebServer.constant.Constants.COMMA_DELIMITER;

@Repository
public class StudentDaoImpl implements StudentDao{

    private static final Logger LOG = LoggerFactory.getLogger(StudentDaoImpl.class);

    @Resource(name = "studentJdbcTemplateRead")
    private JdbcTemplate studentJdbcTemplateRead;

    @Override
    public List<String> testInExpensiveQuery() {
        List<String> studentList = new ArrayList<>();
        try {
            List<Map<String, Object>> rows = studentJdbcTemplateRead.queryForList("select S_ID from student_info");
            if (!rows.isEmpty()) {
                for (Map<String, Object> row : rows) {
                    studentList.add(row.get("S_ID").toString());
                }
            }
        } catch (DataAccessException e) {
            throw e;
        }
        return studentList;
    }

    @Override
    public List<String> testModeratelyExpensiveQuery() {
        List<String> studentList = new ArrayList<>();
        try {
            List<Map<String, Object>> rows = studentJdbcTemplateRead.queryForList("select s.S_ID from student_info s inner join application a on a.S_ID = s.S_ID");
            if (!rows.isEmpty()) {
                for (Map<String, Object> row : rows) {
                    studentList.add(row.get("S_ID").toString());
                }
            }
        } catch (DataAccessException e) {
            throw e;
        }
        return studentList;
    }

    @Override
    public List<String> testHighlyExpensiveQuery() {
        List<String> studentList = new ArrayList<>();
        try {
            List<Map<String, Object>> rows = studentJdbcTemplateRead.queryForList("select s.S_ID from student_info s inner join application a on a.S_ID = s.S_ID inner join college c on c.C_ID = a.C_ID");
            if (!rows.isEmpty()) {
                for (Map<String, Object> row : rows) {
                    studentList.add(row.get("S_ID").toString());
                }
            }
        } catch (DataAccessException e) {
            throw e;
        }
        return studentList;
    }

    @Override
    public String addStudentData(List<Student> studentList) {
        int i[] = {};
        try {
            try (Connection con = studentJdbcTemplateRead.getDataSource().getConnection();
                 Statement stmt = con.createStatement()) {
                for (Student student : studentList) {
                    StringBuilder sqlBuilder = new StringBuilder("INSERT INTO student_info (`S_ID`,`S_NAME`)");
                    sqlBuilder.append("VALUES(").append(student.getId()).append(COMMA_DELIMITER)
                            .append("'").append(student.getName()).append("')")
                            .append(" ON DUPLICATE KEY UPDATE ")
                            .append("S_ID = ").append(student.getId())
                            .append(", S_NAME = '").append(student.getName() + "'");
                    stmt.addBatch(sqlBuilder.toString());
                }
                i = stmt.executeBatch();
                stmt.clearBatch();
                LOG.info("batch update done.");
            }
        } catch (SQLException ex) {
            LOG.info("exception in addStudentData, "+ex.getMessage());
        }
        return null;
    }

    @Override
    public String addCollegeData(List<College> clgList) {
        int i[] = {};
        try {
            try (Connection con = studentJdbcTemplateRead.getDataSource().getConnection();
                 Statement stmt = con.createStatement()) {
                for (College college : clgList) {
                    StringBuilder sqlBuilder = new StringBuilder("INSERT INTO college (`C_ID`,`C_NAME`)");
                    sqlBuilder.append("VALUES('").append(college.getId()).append("'").append(COMMA_DELIMITER)
                            .append("'").append(college.getName()).append("')")
                            .append(" ON DUPLICATE KEY UPDATE ")
                            .append("C_ID = '").append(college.getId())
                            .append("', C_NAME = '").append(college.getName() + "'");
                    stmt.addBatch(sqlBuilder.toString());
                }
                i = stmt.executeBatch();
                stmt.clearBatch();
                LOG.info("batch update done.");
            }
        } catch (SQLException ex) {
            LOG.info("exception in addStudentData, "+ex.getMessage());
        }
        return null;
    }

    @Override
    public String addClgApplication(List<Application> applicationList) {
        int i[] = {};
        try {
            try (Connection con = studentJdbcTemplateRead.getDataSource().getConnection();
                 Statement stmt = con.createStatement()) {
                for (Application application : applicationList) {
                    StringBuilder sqlBuilder = new StringBuilder("INSERT INTO application (`C_ID`,`S_ID`)");
                    sqlBuilder.append("VALUES('").append(application.getClgId()).append("'").append(COMMA_DELIMITER)
                            .append(application.getStudentId()).append(")")
                            .append(" ON DUPLICATE KEY UPDATE ")
                            .append("C_ID = '").append(application.getClgId())
                            .append("', S_ID = ").append(application.getStudentId());
                    stmt.addBatch(sqlBuilder.toString());
                }
                i = stmt.executeBatch();
                stmt.clearBatch();
                LOG.info("batch update done.");
            }
        } catch (SQLException ex) {
            LOG.info("exception in addStudentData, "+ex.getMessage());
        }
        return null;
    }
}
