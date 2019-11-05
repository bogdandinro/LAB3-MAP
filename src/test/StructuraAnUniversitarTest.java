package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import structures.StructuraAnUniversitar;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StructuraAnUniversitarTest {

    StructuraAnUniversitar structuraAnUniversitar;

    @BeforeEach
    void setUp() {
        structuraAnUniversitar  = new StructuraAnUniversitar(1, LocalDate.parse("2019-09-30"), LocalDate.parse("2019-12-21"), LocalDate.parse("2020-01-05"), LocalDate.parse("2020-01-19"),
                LocalDate.parse("2020-02-24"), LocalDate.parse("2020-04-20"), LocalDate.parse("2020-04-26"), LocalDate.parse("2020-06-07"));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSaptamana() {
        assertEquals(structuraAnUniversitar.getSaptamana(LocalDate.parse("2019-10-01")), 1);
        assertEquals(structuraAnUniversitar.getSaptamana(LocalDate.parse("2019-12-22")), -1);
        assertEquals(structuraAnUniversitar.getSaptamana(LocalDate.parse("2020-08-23")), 0);
    }
}