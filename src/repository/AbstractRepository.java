package repository;

import entities.Entity;
import entities.validator.Validator;

public abstract class AbstractRepository<ID, E extends Entity <ID>> extends InMemoRepo<ID,E>{
    protected String filename;

    public AbstractRepository(Validator validator,String filename){
        super(validator);
        this.filename = filename;
        this.loadData();
    }

    protected abstract void loadData();

    public abstract void saveData(Iterable <E> var1);

}
