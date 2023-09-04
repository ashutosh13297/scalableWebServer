package com.iitmandi.scalableWebServer.model;

public class Application {

    private Integer studentId;
    private String clgId;

    public Application(Integer studentId, Integer clgId) {
        this.studentId = studentId;
        this.clgId = "C" + clgId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getClgId() {
        return clgId;
    }

    public void setClgId(String clgId) {
        this.clgId = clgId;
    }
}
