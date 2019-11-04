package test;

import entities.Tema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import structures.StructuraAnUniversitar;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TemaTest {
    Tema tema;
    StructuraAnUniversitar structuraAnUniversitar;

    @BeforeEach
    void setUp() {
        tema = new Tema("Tema FP", 8);
        tema.setId(1l);
        /*
        structuraAnUniversitar  = new StructuraAnUniversitar(1, LocalDate.parse("2019-09-30"), LocalDate.parse("2019-12-21"), LocalDate.parse("2020-01-05"), LocalDate.parse("2020-01-19"),
                LocalDate.parse("2020-02-24"), LocalDate.parse("2020-04-20"), LocalDate.parse("2020-04-26"), LocalDate.parse("2020-06-07"));

         */
        //tema.setStartWeek((int)structuraAnUniversitar.getSaptamana(LocalDate.parse("2019-10-31")));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDescriere() {
        setUp();
        assertEquals(tema.getDescriere(), "Tema FP");
    }

    @Test
    void setDescriere() {
        setUp();
        tema.setDescriere("Tema OOP");
        assertEquals(tema.getDescriere(), "Tema OOP");
    }

    /*
    @Test
    void getStartWeek() {
        setUp();
        assertEquals(tema.getStartWeek(), 5);
    }

    @Test
    void setStartWeek() {
        tema.setStartWeek((int)structuraAnUniversitar.getSaptamana(LocalDate.parse("2019-11-05")));
        assertEquals(tema.getStartWeek(), 6);
    }
    */
    @Test
    void getDeadlineWeek() {
        setUp();
        assertEquals(tema.getDeadlineWeek(), 8);
    }

    @Test
    void setDeadlineWeek() {
        setUp();
        tema.setDeadlineWeek(9);
        assertEquals(tema.getDeadlineWeek(), 9);
    }
}