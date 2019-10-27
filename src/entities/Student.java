package entities;

public class Student extends Entity<Long> implements Comparable<Student> {
    private String name;
    private float media;

    @Override
    public boolean equals(Object o){
        if( this == o) return true;
        if(!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Float.compare(student.getMedia(), getMedia()) == 0 &&
                getName().equals(student.getName());
    }

    @Override
    public String toString(){
        return "Student{" +
                "name=" +name + '\'' + ", media=" +media + ", id=" + getId() + "}";
    }
    @Override
    public int compareTo(Student o){
        return (int)(o.getMedia() - this.getMedia());
    }

    /*
    @Override
    public int hashCode(){
        return Object.hash(name,media);
    }
    */

    public Student() {
    }

    public Student(String name, float media) {
        this.name = name;
        this.media = media;
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
