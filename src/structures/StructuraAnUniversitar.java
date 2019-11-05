package structures;

import entities.Entity;
import utils.Perioada;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;

public class StructuraAnUniversitar extends Entity<Long> {
    private StructuraSemestru sem1;
    private StructuraSemestru sem2;

    public StructuraAnUniversitar(int anUniversitar, LocalDate startSemester1, LocalDate beginHoliday1, LocalDate endHoliday1,
                                  LocalDate endSemester1, LocalDate startSemester2, LocalDate beginHoliday2, LocalDate endHoliday2, LocalDate endSemester2)
    {
        this.sem1 = new StructuraSemestru(anUniversitar, 1, startSemester1, beginHoliday1, endHoliday1, endSemester1);
        this.sem2 = new StructuraSemestru(anUniversitar, 2, startSemester2, beginHoliday2, endHoliday2, endSemester2);
    }

    /**
     * Gaseste pentru o data trimisa ca parametru, saptmana echivalenta din anul universitar.
     * @param data - LocalDate
     * @return -1 - daca data trimisa este in perioada vacantei
     * 0 - daca data trimisa nu face parte din anul universitar
     * nr intreg > 0 - altfel
     */
    public int getSaptamana(LocalDate data)
    {
        if (sem1.apartineVacantei(data) || sem2.apartineVacantei(data))
            return -1;
        if (data.isAfter(sem1.getStartSemester()) && data.isBefore(sem1.getEndSemester()))
        {
            return (int)ChronoUnit.WEEKS.between(sem1.getStartSemester(),data) + 1;
        }
        if (data.isAfter(sem2.getStartSemester()) && data.isBefore(sem2.getEndSemester()))
        {
            return (int)ChronoUnit.WEEKS.between(sem2.getStartSemester(),data) + 1;
        }
        return 0;
    }
}