package entities;

public class Student extends Entity<Long> implements Comparable<Student> {
    private String name;
    private float media;
    private String prenume;
    private int grupa;
    private String email;
    private String cadruDidacticIndrumatorLab;

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getGrupa() {
        return grupa;
    }

    public void setGrupa(int grupa) {
        this.grupa = grupa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCadruDidacticIndrumatorLab() {
        return cadruDidacticIndrumatorLab;
    }

    public void setCadruDidacticIndrumatorLab(String cadruDidacticIndrumatorLab) {
        this.cadruDidacticIndrumatorLab = cadruDidacticIndrumatorLab;
    }

    @Override
    public boolean equals(Object o){
        if( this == o) return true;
        if(!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Float.compare(student.getMedia(), getMedia()) == 0 &&
                getName().equals(student.getName()) &&   getPrenume().equals(student.getPrenume()) && getEmail().equals(student.getEmail())
                && getCadruDidacticIndrumatorLab().equals(student.getCadruDidacticIndrumatorLab()) && Integer.compare(student.getGrupa(),getGrupa()) == 0;
    }

    @Override
    public String toString(){
        return Long.toString((Long)this.getId()) + ';' + this.name + ';' + this.prenume + ';' + this.grupa + ';' + this.email + ';' + this.cadruDidacticIndrumatorLab;
    }


    @Override
    public int compareTo(Student o){
        return (int)(o.getMedia() - this.getMedia()) ;
    }





    public Student() {
    }

    public Student(String name, float media, String prenume, int grupa, String email, String cadruDidacticIndrumatorLab) {
        this.name = name;
        this.media = media;
        this.prenume = prenume;
        this.grupa = grupa;
        this.email = email;
        this.cadruDidacticIndrumatorLab = cadruDidacticIndrumatorLab;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public String getName() {
        return name;
    }

    public float getMedia() {
        return media;
    }
}
