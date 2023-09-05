package com.bootcamp.project.model;


import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@Data
@Entity
@RequiredArgsConstructor
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoListID;
    private Date creationDate = new Date();
    private String todoListName;
    protected Boolean active; // If False it can be deleted ob DB
    @ManyToOne
    private User user;
    public ToDoList(String todoListName, User user) {
        this.todoListName = todoListName;
        this.user = user;
        this.active = true;
    }
    /** Function that deactivate a List */
    public void deactivateList(){ this.active = false; }
}