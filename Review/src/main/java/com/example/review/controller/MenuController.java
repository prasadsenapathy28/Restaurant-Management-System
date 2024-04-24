package com.example.review.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.review.model.Menu;
import com.example.review.service.MenuService;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/getmenu")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @PostMapping("/addMenu")
    public Menu addMenu(@RequestBody Menu menu) {
        return menuService.addMenu(menu);
    }

    @PutMapping("/update/{id}")
    public String updateMenu(@PathVariable int id, @RequestBody Menu menu) {
        if(menuService.updateMenu(id, menu)!=null)
            return "Updated";
        return "Id not found";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMenu(@PathVariable int id) {
        return menuService.deleteMenu(id);
    }
}