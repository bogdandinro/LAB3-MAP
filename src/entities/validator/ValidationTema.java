package entities.validator;

import entities.Tema;

public class ValidationTema implements Validator<Tema> {
    public ValidationTema() {
    }

    public void validate(Tema entity) throws ValidationException {
        if (entity.getStartWeek() >= entity.getDeadlineWeek()) {
            throw new ValidationException("startWeek trebuie sa fie < deadlineWeek\n");
        } else if (entity.getStartWeek() < 1 && entity.getStartWeek() > 14) {
            throw new ValidationException("startWeek trebuie sa apartine [1, 14]\n");
        } else if (entity.getDeadlineWeek() < 1 && entity.getDeadlineWeek() > 14) {
            throw new ValidationException("deadLineWeek trebuie sa apartine [1, 14]\n");
        }
    }
}
