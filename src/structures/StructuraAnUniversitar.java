package structures;

import entities.Entity;
import utils.Perioada;

import java.time.LocalDate;
import java.util.Iterator;

public class StructuraAnUniversitar extends Entity<Long> {
    private int anulUniversitar;
    StructuraSemestru sem1;
    StructuraSemestru sem2;

    public StructuraAnUniversitar(int anulUniversitar, int nrSaptamaniSem1, int inceputVacantaSem1, int sfarsitVacantaSem1, LocalDate inceputSem1, int nrSaptamaniSem2, int inceputVacantaSem2, int sfarsitVacantaSem2, LocalDate inceputSem2) {
        this.anulUniversitar = anulUniversitar;
        this.sem1 = new StructuraSemestru(nrSaptamaniSem1, inceputVacantaSem1, sfarsitVacantaSem1, inceputSem1);
        this.sem2 = new StructuraSemestru(nrSaptamaniSem2, inceputVacantaSem2, sfarsitVacantaSem2, inceputSem2);
    }

    public int getSaptamana(LocalDate date) {
        int i = 0;

        Iterator var3;
        Perioada week;
        for(var3 = this.sem1.getSaptamani().iterator(); var3.hasNext(); ++i) {
            week = (Perioada)var3.next();
            if (week.apartinePerioadei(date)) {
                return i + 1;
            }
        }

        i = 0;

        for(var3 = this.sem2.getSaptamani().iterator(); var3.hasNext(); ++i) {
            week = (Perioada)var3.next();
            if (week.apartinePerioadei(date)) {
                return i + 1;
            }
        }

        return -1;
    }

    public int getAnulUniversitar() {
        return this.anulUniversitar;
    }

    public void setAnulUniversitar(int anulUniversitar) {
        this.anulUniversitar = anulUniversitar;
    }

    public StructuraSemestru getSem1() {
        return this.sem1;
    }

    public void setSem1(StructuraSemestru sem1) {
        this.sem1 = sem1;
    }

    public StructuraSemestru getSem2() {
        return this.sem2;
    }

    public void setSem2(StructuraSemestru sem2) {
        this.sem2 = sem2;
    }

    public String toString() {
        return "StructuraAnUniversitar{id=" + super.getId() + ", anulUniversitar=" + this.anulUniversitar + ", sem1=" + this.sem1 + ", sem2=" + this.sem2 + '}';
    }
}
