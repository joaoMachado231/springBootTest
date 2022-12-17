package com.example.demo.dto;

import java.util.Date;

public class TaskRequest {

    private String name;
    private String description;
    private Date initDate;
    private Date endDate;

    public TaskRequest(String name, String description, Date initDate, Date endDate) {
        this.name = name;
        this.description = description;
        this.initDate = initDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getInitDate() {
        return initDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
