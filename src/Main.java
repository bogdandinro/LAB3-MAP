import entities.validator.ValidationTema;
import entities.validator.ValidatorStudent;
import repository.StudentFileRepository;
import repository.TemaFileRepository;
import structures.StructuraAnUniversitar;
import ui.Ui;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        StructuraAnUniversitar structuraAnUniversitar = new StructuraAnUniversitar(1, LocalDate.parse("2019-09-30"), LocalDate.parse("2019-12-21"), LocalDate.parse("2020-01-05"), LocalDate.parse("2020-01-19"),
                LocalDate.parse("2020-02-24"), LocalDate.parse("2020-04-20"), LocalDate.parse("2020-04-26"), LocalDate.parse("2020-06-07"));
        ValidationTema validationTema = new ValidationTema();
        ValidatorStudent validationStudent = new ValidatorStudent();
        TemaFileRepository temaFileRepository = new TemaFileRepository(validationTema, "data/teme.txt");
        StudentFileRepository studentFileRepository = new StudentFileRepository(validationStudent, "data/studenti.txt");
        Ui ui = new Ui(structuraAnUniversitar, temaFileRepository, studentFileRepository);
        ui.run();
    }
}
