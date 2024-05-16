package com.example.demo.Service;

import com.example.demo.Model.Todo;
import com.example.demo.Repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public  class TodoService{

    @Autowired
    TodoRepo repo;


    public List<Todo> getAllModelItems(){
        ArrayList<Todo> todoList = new ArrayList<>();
        repo.findAll().forEach(todo -> todoList.add(todo));
        return todoList;

    }


    public Optional<Todo> findById(Long aLong) {
        return Optional.empty();
    }



    public Todo getItemById(Long id){
        return repo.findById(id).get();
    }

    public boolean updateStatus(Long id){
        Todo todo = getItemById(id);
        todo.setStatus("Completed");
        return saveUpdateItem(todo);
    }

    public boolean saveUpdateItem(Todo todo){
        Todo updateObj = repo.save(todo);
        if(getItemById(updateObj.getId())!=null){
            return true;
        }
        return false;
    }

    public boolean deleteItem(Long id){
        repo.deleteById(id);
        if(repo.findById(id).isEmpty()){
            return true;
        }
        return false;
    }




}
