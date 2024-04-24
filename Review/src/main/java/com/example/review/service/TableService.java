package com.example.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.review.model.ResTable;
import com.example.review.repository.TableRepository;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public List<ResTable> getAllTables() {
        return tableRepository.findAll();
    }

    public ResTable getTableById(int id) {
        return tableRepository.findById(id).orElse(null);
    }

    public ResTable addTable(ResTable table) {
        return tableRepository.save(table);
    }
    public ResTable updateTable(int id, ResTable table) {
        ResTable tab = getTableById(id);
        if(tab!=null) {
            tab.setCapacity(table.getCapacity());
            tab.setNumber(table.getNumber());
            tab.setStatus(table.getStatus());
            return tableRepository.save(tab);
        }
        return null;
    }
    public String deleteTable(int id) {
        if(getTableById(id)!=null){
            tableRepository.deleteById(id);
            return "Deleted";
        }
        return "Id not found";
    }
}