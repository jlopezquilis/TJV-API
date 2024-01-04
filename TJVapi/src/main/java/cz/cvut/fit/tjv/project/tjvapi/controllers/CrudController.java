package cz.cvut.fit.tjv.project.tjvapi.controllers;

import cz.cvut.fit.tjv.project.tjvapi.entities.EntityWithId;
import cz.cvut.fit.tjv.project.tjvapi.services.CrudService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

public abstract class CrudController<E extends EntityWithId<ID>, ID, S extends CrudService<E, ID, R>, R extends CrudRepository<E, ID>> {
    protected S service;

    public CrudController(S service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    public E create (@RequestBody E data) {
        return service.create(data);
    }

    public Iterable<E> readAll() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public E readById(@PathVariable ID id) {
        var optE = service.readById(id);
        if (optE.isPresent())
            return optE.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)      //204 No content, correct
    public void update(@PathVariable ID id,@RequestBody E data) {
        service.update(id,data);
    }
}
