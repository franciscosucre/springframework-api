package com.example.restservice.infraestructure.repositories;

import java.util.ArrayList;

import com.example.restservice.domain.Cat;

public class CatRepository {
    private final ArrayList<Cat> cats = new ArrayList<Cat>();
    
    public ArrayList<Cat> find() {
        return this.cats;
    }

    public Cat findOne(String id) {
        for (Cat cat : this.cats) {
            if (cat.id.equals(id)){
                return cat;
            }
        } 
        return null;
    }

    public Cat insert(Cat cat) {
        this.cats.add(cat);
        return cat;
    }

    public Cat update(String id, String name){
        Cat cat = this.findOne(id);
        if (cat == null){
            throw new Error("Not found");
        }
        this.cats.remove(cat);
        Cat newCat = Cat.cat(cat.id, name);
        this.insert(newCat);
        return newCat;
    }

    public Cat remove(String id) {
        Cat cat = this.findOne(id);
        if (cat == null){
            throw new Error("Not found");
        }
        this.cats.remove(cat);
        return cat;
    }
}
