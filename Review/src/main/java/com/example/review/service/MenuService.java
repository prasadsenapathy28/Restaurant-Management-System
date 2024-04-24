package com.example.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.review.model.Menu;
import com.example.review.repository.MenuRepository;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }
    public Menu getMenuByid(int id){
        Menu men = menuRepository.findById(id).orElse(null);
        return men;
    }
    public Menu updateMenu(int id, Menu menu) {
        Menu men = getMenuByid(id);
        if (men!=null) {
            men.setName(menu.getName());
            men.setPrice(menu.getPrice());;
            return menuRepository.save(men);
        }
        return null;
    }
    public String deleteMenu(int id) {
        if(getMenuByid(id)!=null){
            menuRepository.deleteById(id);
            return "Deleted";
        }
        return "Id not found";
    }
}