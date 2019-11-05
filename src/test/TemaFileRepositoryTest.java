package test;

import entities.Tema;
import entities.validator.ValidationTema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TemaFileRepository;

import static org.junit.jupiter.api.Assertions.*;

class TemaFileRepositoryTest {
    ValidationTema validationTema;
    TemaFileRepository temaFileRepository;
    Tema tema1;
    Tema tema2;

    @BeforeEach
    void setUp() {
        validationTema = new ValidationTema();
        temaFileRepository = new TemaFileRepository(validationTema, "src/test/temeTest");
        tema1 = new Tema("Tema OOP", 1, 8);
        tema1.setId(1l);
        tema2 = new Tema("Tema FP", 4, 5);
        tema2.setId(3l);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void loadData() {
        assertEquals(temaFileRepository.findOne(1l).equals(tema1), true);
    }

    @Test
    void saveData() {
        temaFileRepository.save(tema2);
        TemaFileRepository temaFileRepository1 = new TemaFileRepository(validationTema, "src/test/temeTest");
        assertEquals(temaFileRepository1.findOne(2l).equals(tema2), false);

    }
}