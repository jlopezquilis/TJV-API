package cz.cvut.fit.tjv.project.tjvapi.services;

import cz.cvut.fit.tjv.project.tjvapi.entities.EntityWithId;
import cz.cvut.fit.tjv.project.tjvapi.services.exceptions.EntityCannotBeCreatedException;
import cz.cvut.fit.tjv.project.tjvapi.services.exceptions.EntityDoesNotExistException;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class CrudService<E extends EntityWithId<ID>, ID, R extends CrudRepository<E, ID>> {
    protected R repository;

    public CrudService(R repository) {
        this.repository = repository;
    }

    //Implement operations for every entity
    public E create(E data) {
        /*
        Adding logic for differentiate between create and update.
        Here we had to create the interface EntityWithId (implemented by every entity) for ensuring we have a getId method in every entity
        */
        if (repository.existsById(data.getId()))
            throw new EntityCannotBeCreatedException();

        return repository.save(data);
    }

    public Iterable<E> readAll() {
        return repository.findAll();
    }

    public Optional<E> readById(ID id) {   //Optional as may not exist
        return repository.findById(id);
    }

    public void update(ID id, E data) {
        if (!repository.existsById(id))
            throw new EntityDoesNotExistException();

        data.setId(id);

        repository.save(data);
    }

    public void deleteById(ID id) {
        if (!repository.existsById(id))
            throw new EntityDoesNotExistException();

        repository.deleteById(id);
    }
}
