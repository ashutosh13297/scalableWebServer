package com.iitmandi.scalableWebServer.model;

public class College {

    private String id;
    private String name;

    public College(Integer id, String name) {
        this.id = "C" + id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
