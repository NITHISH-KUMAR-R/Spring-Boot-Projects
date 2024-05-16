package com.example.demo.Model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import java.util.Date;

@Entity
@Table(name="demo_todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private long id;
//    @Column
//    @NonNull
//    private String name;

    @Column
    private String status;
    @Column
    @NonNull
    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date date;
//    @Column(nullable = false)
//    @Temporal(TemporalType.DATE)
//    private Date date;

    public Todo() {
    }






}
