package structures;

import utils.Perioada;

import java.time.LocalDate;
import java.util.ArrayList;

public class StructuraSemestru {
    private int nrSaptamani;
    private int inceputVacanta;
    private int sfarsitVacanta;
    private ArrayList<Perioada> saptamani;
    private LocalDate inceputSemestru;

    private void genereazaSemestru() {
        this.saptamani.clear();

        int i;
        for(i = 0; i < this.inceputVacanta; ++i) {
            this.saptamani.add(i, new Perioada(this.inceputSemestru.plusDays((long)(7 * i)), this.inceputSemestru.plusDays((long)(7 * i + 6))));
        }

        for(int j = this.sfarsitVacanta; i < this.nrSaptamani; ++j) {
            this.saptamani.add(i, new Perioada(this.inceputSemestru.plusDays((long)(7 * j)), this.inceputSemestru.plusDays((long)(7 * j + 6))));
            ++i;
        }

    }

    public StructuraSemestru(int nrSaptamani, int inceputVacanta, int sfarsitVacanta, LocalDate inceputSemestru) {
        this.saptamani = new ArrayList(this.nrSaptamani);
        this.nrSaptamani = nrSaptamani;
        this.inceputVacanta = inceputVacanta;
        this.sfarsitVacanta = sfarsitVacanta;
        this.inceputSemestru = inceputSemestru;
        this.genereazaSemestru();
    }

    public ArrayList<Perioada> getSaptamani() {
        return this.saptamani;
    }

    public void setSaptamani(ArrayList<Perioada> saptamani) {
        this.saptamani = saptamani;
    }

    public int getNrSaptamani() {
        return this.nrSaptamani;
    }

    public void setNrSaptamani(int nrSaptamani) {
        this.nrSaptamani = nrSaptamani;
        this.genereazaSemestru();
    }

    public int getInceputVacanta() {
        return this.inceputVacanta;
    }

    public void setInceputVacanta(int inceputVacanta) {
        this.inceputVacanta = inceputVacanta;
        this.genereazaSemestru();
    }

    public int getSfarsitVacanta() {
        return this.sfarsitVacanta;
    }

    public void setSfarsitVacanta(int sfarsitVacanta) {
        this.sfarsitVacanta = sfarsitVacanta;
        this.genereazaSemestru();
    }

}
