package test;

import entities.Tema;
import entities.validator.ValidationTema;
import entities.validator.ValidatorStudent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.StudentFileRepository;
import repository.TemaFileRepository;
import services.Service;
import structures.StructuraAnUniversitar;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    private StructuraAnUniversitar structuraAnUniversitar;
    private TemaFileRepository temaFileRepository;
    private StudentFileRepository studentFileRepository;
    private ValidatorStudent validationStudent;
    private ValidationTema validationTema;
    Tema tema1;
    private Service service;
    @BeforeEach
    void setUp() {
        validationTema = new ValidationTema();
        validationStudent = new ValidatorStudent();
        temaFileRepository = new TemaFileRepository(validationTema, "src/test/temeTest");
        studentFileRepository = new StudentFileRepository(validationStudent, "src/test/studentiTest");
        structuraAnUniversitar = new StructuraAnUniversitar(1, LocalDate.parse("2019-09-30"), LocalDate.parse("2019-12-21"), LocalDate.parse("2020-01-05"), LocalDate.parse("2020-01-19"),
                LocalDate.parse("2020-02-24"), LocalDate.parse("2020-04-20"), LocalDate.parse("2020-04-26"), LocalDate.parse("2020-06-07"));
        service = new Service(structuraAnUniversitar, temaFileRepository, studentFileRepository);
        tema1 = new Tema("Tema FP", structuraAnUniversitar.getSaptamana(LocalDate.now()) + 1);
        tema1.setId(2l);
    }

    @AfterEach
    void tearDown() {
    }
/*
    @Test

    void modificareTema() {
        setUp();
        service.modificareTema(tema1);
        Tema tema2 = temaFileRepository.findOne(2l);
        assertEquals(temaFileRepository.findOne(2l).equals(tema1), true);
        service.stergereTema(tema2.getId());
    }

 */
}