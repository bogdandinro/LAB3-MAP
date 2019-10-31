package repository;

import entities.Entity;
import entities.validator.ValidationException;
import entities.validator.Validator;

import java.util.HashMap;
import java.util.Map;

public class InMemoRepo<ID, E extends Entity<ID>> implements CrudRepository<ID, E>{
    private Map<ID, E> entities;
    private Validator<E> validator;

    public InMemoRepo(Validator<E> validator) {
        this.validator = validator;
        this.entities = new HashMap();
    }

    public E findOne(ID id) {
        return entities.get(id);
    }

    public Iterable<E> findAll() {
        return this.entities.values();
    }

    public E save(E entity) throws ValidationException {
        if (entity == null)
        {
            throw new IllegalArgumentException("Entitatea nu poate sa fie null!\n");
        }
        if (entity.getId() == null)
        {
            throw new IllegalArgumentException("Id-ul nu poate sa fie null!\n");
        }
        if (entities.containsKey(entity.getId())) {
            return entity;
        }
        validator.validate(entity);
        entities.put(entity.getId(), entity);
        return null;
    }

    public E delete(ID id) {
        E elem = this.findOne(id);
        this.entities.remove(id);
        return elem;
    }

    public E update(E entity) {
        E elem = this.findOne(entity.getId());
        if (elem != null) {
            this.delete(entity.getId());
            this.save(entity);
            return elem;
        } else {
            return null;
        }
    }
}
