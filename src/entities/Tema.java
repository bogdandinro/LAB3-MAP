package entities;

import java.util.Objects;

public class Tema extends Entity<Long> implements Comparable<Tema> {
    private String descriere;
    private int startWeek;
    private int deadlineWeek;

    public Tema(String descriere, int deadlineWeek) {
        this.descriere = descriere;
        this.deadlineWeek = deadlineWeek;
        this.startWeek = 1;
    }

    public Tema(String descriere, int startWeek, int deadlineWeek) {
        this.descriere = descriere;
        this.deadlineWeek = deadlineWeek;
        this.startWeek = startWeek;
    }

    public String getDescriere() {
        return this.descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public int getStartWeek() {
        return this.startWeek;
    }

    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }

    public int getDeadlineWeek() {
        return this.deadlineWeek;
    }

    public void setDeadlineWeek(int deadlineWeek) {
        this.deadlineWeek = deadlineWeek;
    }

    public String toString() {
        return Long.toString((Long)super.getId()) + ';' + this.descriere + ';' + this.startWeek + ";" + this.deadlineWeek;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Tema)) {
            return false;
        } else {
            Tema tema = (Tema)o;
            return this.startWeek == tema.startWeek && this.deadlineWeek == tema.deadlineWeek && Objects.equals(this.descriere, tema.descriere);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.descriere, this.startWeek, this.deadlineWeek});
    }

    public int compareTo(Tema o) {
        return 0;
    }
}
