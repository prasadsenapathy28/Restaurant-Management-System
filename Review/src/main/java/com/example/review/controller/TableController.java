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

import com.example.review.model.ResTable;
import com.example.review.service.TableService;

@RestController
@RequestMapping("/api/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping("getalltab")    
    public List<ResTable> getAllTables() {
        return tableService.getAllTables();
    }

    @GetMapping("get/{id}")
    public ResTable getTableById(@PathVariable int id) {
        ResTable table = tableService.getTableById(id);
        return table != null ? table : null;
    }

    @PostMapping("/addTable")
    public ResTable addTable(@RequestBody ResTable table) {
        ResTable addedTable = tableService.addTable(table);
        return addedTable;
    }

    @PutMapping("/update/{id}")
    public String updateTable(@PathVariable int id, @RequestBody ResTable table) {
        ResTable updatedTable = tableService.updateTable(id, table);
        if(updatedTable!=null)
            return "Updated";
        return "Id not found";
    }

    @DeleteMapping("delete/{id}")
    public String deleteTable(@PathVariable int id) {
        return tableService.deleteTable(id);
    }
}

