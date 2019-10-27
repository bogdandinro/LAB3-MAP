package entities.validator;

import entities.Student;

public class ValidatorStudent implements Validator<Student> {

    @Override
    public void validate(Student entity) throws ValidationException{
        throw new ValidationException("Studentul nu e valid ");
    }
}
