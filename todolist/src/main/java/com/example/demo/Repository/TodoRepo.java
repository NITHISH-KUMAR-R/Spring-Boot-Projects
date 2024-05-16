package com.example.demo.Repository;

import com.example.demo.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo  extends JpaRepository<Todo,Long> {
}
