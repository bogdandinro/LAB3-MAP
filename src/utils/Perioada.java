package utils;

import java.time.LocalDate;
import java.time.Period;

public class Perioada {
    private LocalDate inceput;
    private LocalDate sfarsit;

    public Perioada(LocalDate inceput, LocalDate sfarsit) {
        this.inceput = inceput;
        this.sfarsit = sfarsit;
    }

    public boolean apartinePerioadei(LocalDate data) {
        Period incep = Period.between(this.inceput, data);
        if (incep.isNegative()) {
            return false;
        } else {
            Period sfar = Period.between(data, this.sfarsit);
            return !sfar.isNegative();
        }
    }

    public LocalDate getInceput() {
        return this.inceput;
    }

    public void setInceput(LocalDate inceput) {
        this.inceput = inceput;
    }

    public LocalDate getSfarsit() {
        return this.sfarsit;
    }

    public void setSfarsit(LocalDate sfarsit) {
        this.sfarsit = sfarsit;
    }

    public String toString() {
        return "Perioada{inceput=" + this.inceput + ", sfarsit=" + this.sfarsit + '}';
    }
}
