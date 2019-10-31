package entities.validator;

import entities.Student;

public class ValidatorStudent implements Validator<Student> {

    @Override
    public void validate(Student entity) throws ValidationException{
        if (entity.getMedia() < 1 || entity.getMedia() > 10)
            throw new ValidationException("Media trebuie sa apartina intervalului [1,10]\n");
    }
}
