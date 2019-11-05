package test;

import entities.Tema;
import entities.validator.ValidationTema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.InMemoRepo;

import static org.junit.jupiter.api.Assertions.*;

class InMemoRepoTest {

    InMemoRepo<Long, Tema> inMemoryRepository;
    ValidationTema validationTema;
    Tema tema1;
    Tema tema2;

    @BeforeEach
    void setUp() {
        validationTema = new ValidationTema();
        inMemoryRepository = new InMemoRepo<>(validationTema);
        tema1 = new Tema("Tema FP",5, 9);
        tema1.setId(1l);
        tema2 = new Tema("Tema OOP",3, 10);
        tema2.setId(2l);
        inMemoryRepository.save(tema1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findOne() {
        assertEquals(inMemoryRepository.findOne(1l).equals(tema1), true);
    }

    @Test
    void findAll() {
        Iterable<Tema> t = inMemoryRepository.findAll();
        for (Tema tema : t)
        {
            assertEquals(tema.equals(tema1), true);
        }
    }

    @Test
    void save() {
        inMemoryRepository.save(tema2);
        assertEquals(inMemoryRepository.findOne(2l).equals(tema2), true);
    }

    @Test
    void delete() {
        inMemoryRepository.delete(1l);
        assertEquals(inMemoryRepository.findOne(1l), null);
    }

    @Test
    void update() {
        tema2.setId(1l);
        inMemoryRepository.update(tema2);
        assertEquals(inMemoryRepository.findOne(1l).equals(tema2), true);
    }
}