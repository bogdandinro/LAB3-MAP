package repository;

import entities.Entity;
import entities.validator.Validator;

import java.util.HashMap;
import java.util.Map;

public class InMemoRepo<ID, E extends Entity<ID>> implements CrudRepository<ID,E>{
    private Map<ID,E> entities;

    public InMemoRepo(Validator<E> validator) {
        this.validator = validator;
        entities = new HashMap<ID, E>();
    }
    private Validator<E> validator;

    @Override
    public E save(E entity)
    {
        if (entity == null)
        {
            throw new IllegalArgumentException("Entity must not be null");
        }
        if (entities.containsKey(entity.getId())) {
            return entity;
        }
        validator.validate(entity);
        entities.put(entity.getId(), entity);
        return null;
    }

    @Override
    public E findOne(ID id) {
        return null;
    }

    @Override
    public Iterable<E> findAll() {
        return entities.values();
    }

    @Override
    public E delete(ID id) {
        return null;
    }

    @Override
    public E update(E entity) {
        return null;
    }



}
