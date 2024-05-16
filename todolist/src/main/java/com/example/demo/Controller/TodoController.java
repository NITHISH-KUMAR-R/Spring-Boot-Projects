package com.example.demo.Controller;

import com.example.demo.Model.Todo;
import com.example.demo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/viewTodoList")
    public String viewAllTodoItems(Model model, @ModelAttribute("message") String message) {
        model.addAttribute("list", service.getAllModelItems());
        model.addAttribute("message", message);
        return "ViewTodoList"; // Assuming "ViewTodoList.jsp" exists in "/WEB-INF/views/" directory
    }

    @GetMapping("/updateToDoStatus/{id}")
    public String updateToDoStatus(@PathVariable Long id, RedirectAttributes redirectAttributes,Model model) {
        if (service.updateStatus(id)) {
            redirectAttributes.addFlashAttribute("message", "Update Success");
            model.addAttribute("list", service.getAllModelItems()); // Add model attributes as needed
            return "ViewToDoList"; // Return the view directly
        }

        redirectAttributes.addFlashAttribute("message", "Update Failure");
        return "redirect:/ViewToDoList";
    }

    @GetMapping("/addToDoItem")
    public String addToDoItem(Model model) {
        model.addAttribute("todo", new Todo());

        return "AddToDoItem";
    }
    @PostMapping("/saveToDoItem")
    public String saveToDoItem(Todo todo, RedirectAttributes redirectAttributes,Model model) {
        if(service.saveUpdateItem(todo)) {
            redirectAttributes.addFlashAttribute("message", "Save Success");
            model.addAttribute("list", service.getAllModelItems()); // Add model attributes as needed
            return "ViewToDoList"; // Return the view directly
        }

        redirectAttributes.addFlashAttribute("message", "Save Failure");
        return "redirect:/addToDoItem";
    }

    @GetMapping("/editToDoItem/{id}")
    public String editToDoItem(@PathVariable Long id, Model model){
        model.addAttribute("todo",service.getItemById(id));
        return "EditToDoItem";
    }

    @PostMapping("/editSaveToDoItem")
    public String editSaveToDoItem(Todo todo, RedirectAttributes redirectAttributes,Model model){
        if(service.saveUpdateItem(todo)){
            redirectAttributes.addFlashAttribute("message","Edit Success");
            model.addAttribute("list", service.getAllModelItems()); // Add model attributes as needed
            return "ViewToDoList"; // Return the view directly
        }
        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/editToDoItem/" + todo.getId();
    }
    @GetMapping("/deleteToDoItem/{id}")
    public String deleteToDoItem(@PathVariable Long id, RedirectAttributes redirectAttributes,Model model) {
        if (service.deleteItem(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
            model.addAttribute("list", service.getAllModelItems()); // Add model attributes as needed
            return "ViewToDoList"; // Return the view directly
        }

        redirectAttributes.addFlashAttribute("message", "Delete Failure");
        return "redirect:/ViewToDoList";
    }


}
