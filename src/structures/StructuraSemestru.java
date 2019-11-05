package structures;

import utils.Perioada;

import java.time.LocalDate;
import java.util.ArrayList;

public class StructuraSemestru {
    int anUniversitar;
    int semestru;
    private LocalDate startSemester;
    private LocalDate beginHoliday;
    private LocalDate endHoliday;
    private LocalDate endSemester;

    public StructuraSemestru(int anUniversitar, int semestru, LocalDate startSemester, LocalDate beginHoliday, LocalDate endHoliday, LocalDate endSemester) {
        this.anUniversitar = anUniversitar;
        this.semestru = semestru;
        this.startSemester = startSemester;
        this.beginHoliday = beginHoliday;
        this.endHoliday = endHoliday;
        this.endSemester = endSemester;
    }

    /**
     * @param data - LocalDate
     * @return true - daca data trimisa este in perioada vacantei
     * false - altfel
     */
    public boolean apartineVacantei(LocalDate data)
    {
        if (data.isAfter(beginHoliday) && data.isBefore(endHoliday))
            return true;
        return false;
    }

    /**
     * @return anul universitar
     */
    public int getAnUniversitar() {
        return anUniversitar;
    }

    /**
     * seteaza anul universitar
     * @param anUniversitar - intreg
     */
    public void setAnUniversitar(int anUniversitar) {
        this.anUniversitar = anUniversitar;
    }

    /**
     * @return semestru
     */
    public int getSemestru() {
        return semestru;
    }

    /**
     * seteaza semestrul
     * @param semestru - intreg
     */
    public void setSemestru(int semestru) {
        this.semestru = semestru;
    }

    /**
     * @return inceputul semestrului
     */
    public LocalDate getStartSemester() {
        return startSemester;
    }

    /**
     * seteaza inceputulul semestrului
     * @param startSemester - LocalDate
     */
    public void setStartSemester(LocalDate startSemester) {
        this.startSemester = startSemester;
    }

    /**
     * @return inceputul vacantei
     */
    public LocalDate getBeginHoliday() {
        return beginHoliday;
    }

    /**
     * seteaza inceputul vacantei
     * @param beginHoliday - LocalDate
     */
    public void setBeginHoliday(LocalDate beginHoliday) {
        this.beginHoliday = beginHoliday;
    }

    /**
     * @return sfarsitul vacantei
     */
    public LocalDate getEndHoliday() {
        return endHoliday;
    }

    /**
     * seteaza sfarsitul vacantei
     * @param endHoliday - LocalDate
     */
    public void setEndHoliday(LocalDate endHoliday) {
        this.endHoliday = endHoliday;
    }

    /**
     * @return sfarsitul semestrului
     */
    public LocalDate getEndSemester() {
        return endSemester;
    }

    /**
     * seteaza sfarsitul semestrului
     * @param endSemester - LocalDate
     */
    public void setEndSemester(LocalDate endSemester) {
        this.endSemester = endSemester;
    }
}