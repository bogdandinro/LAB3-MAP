package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import structures.StructuraSemestru;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StructuraSemestruTest {
    private StructuraSemestru semestru1;
    private StructuraSemestru semestru2;
    @BeforeEach
    void setUp() {
        semestru1 = new StructuraSemestru(1, 1, LocalDate.parse("2019-09-30"), LocalDate.parse("2019-12-21"), LocalDate.parse("2020-01-05"), LocalDate.parse("2020-01-19"));
        semestru2 = new StructuraSemestru(1, 2, LocalDate.parse("2020-02-24"), LocalDate.parse("2020-04-20"), LocalDate.parse("2020-04-26"), LocalDate.parse("2020-06-07"));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void apartineVacantei() {
        assertEquals(semestru1.apartineVacantei(LocalDate.parse("2019-12-23")), true);
        assertEquals(semestru1.apartineVacantei(LocalDate.parse("2019-12-20")), false);

        assertEquals(semestru2.apartineVacantei(LocalDate.parse("2020-04-25")), true);
        assertEquals(semestru2.apartineVacantei(LocalDate.parse("2020-04-29")), false);
    }

    @Test
    void getAnUniversitar() {
        assertEquals(semestru1.getAnUniversitar(), 1);
        assertEquals(semestru2.getAnUniversitar(), 1);
    }

    @Test
    void setAnUniversitar() {
        semestru1.setAnUniversitar(3);
        assertEquals(semestru1.getAnUniversitar(), 3);
    }

    @Test
    void getSemestru() {
        assertEquals(semestru1.getSemestru(), 1);
        assertEquals(semestru2.getSemestru(), 2);
    }

    @Test
    void setSemestru() {
        semestru1.setSemestru(2);
        assertEquals(semestru1.getSemestru(), 2);
    }

    @Test
    void getStartSemester() {
        assertEquals(semestru1.getStartSemester(), LocalDate.parse("2019-09-30"));
        assertEquals(semestru2.getStartSemester(), LocalDate.parse("2020-02-24"));
    }

    @Test
    void setStartSemester() {
        semestru1.setStartSemester(LocalDate.parse("2019-10-01"));
        assertEquals(semestru1.getStartSemester(), LocalDate.parse("2019-10-01"));
    }

    @Test
    void getBeginHoliday() {
        assertEquals(semestru1.getBeginHoliday(), LocalDate.parse("2019-12-21"));
        assertEquals(semestru2.getBeginHoliday(), LocalDate.parse("2020-04-20"));
    }

    @Test
    void setBeginHoliday() {
        semestru1.setBeginHoliday(LocalDate.parse("2019-12-22"));
        assertEquals(semestru1.getBeginHoliday(), LocalDate.parse("2019-12-22"));
    }

    @Test
    void getEndHoliday() {
        assertEquals(semestru1.getEndHoliday(), LocalDate.parse("2020-01-05"));
        assertEquals(semestru2.getEndHoliday(), LocalDate.parse("2020-04-26"));
    }

    @Test
    void setEndHoliday() {
        semestru1.setEndHoliday(LocalDate.parse("2020-01-06"));
        assertEquals(semestru1.getEndHoliday(), LocalDate.parse("2020-01-06"));
    }

    @Test
    void getEndSemester() {
        assertEquals(semestru1.getEndSemester(), LocalDate.parse("2020-01-19"));
        assertEquals(semestru2.getEndSemester(), LocalDate.parse("2020-06-07"));
    }

    @Test
    void setEndSemester() {
        semestru1.setEndSemester(LocalDate.parse("2020-01-20"));
        assertEquals(semestru1.getEndSemester(), LocalDate.parse("2020-01-20"));
    }
}