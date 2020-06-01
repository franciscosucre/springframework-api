package com.example.restservice.infraestructure.routes;

import java.util.ArrayList;

import com.example.restservice.domain.Cat;
import com.example.restservice.infraestructure.repository.CatRepository;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cats")
class CatController {

    private final CatRepository repository;

    CatController(CatRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/")
    ArrayList<Cat> all() {
        return repository.find();
    }

    @PostMapping("/")
    Cat insert(@RequestBody Cat catData) {
        return repository.insert(Cat.cat(null, catData.name));
    }

    // Single item

    @GetMapping("/{id}")
    Cat findOne(@PathVariable String id) throws NotFound {
        Cat cat = repository.findOne(id);
        if (cat == null){
            throw new NotFound();
        }
        return cat;
    }

    @PutMapping("/{id}")
    Cat updateCat(@RequestBody Cat data, @PathVariable String id) throws NotFound {
        Cat cat = repository.update(id, data.name);
        if (cat == null){
            throw new NotFound();
        }
        return cat;
    }

    @DeleteMapping("/{id}")
    Cat deleteCat(@PathVariable String id) throws NotFound {
        Cat cat = repository.remove(id);
        if (cat == null){
            throw new NotFound();
        }
        return cat;
    }
}
