package test;

import entities.Student;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
//import static junit.framework.TestCase.assertEquals;

public class   StudentTest {
    Student student;

    //DE INTREBAT DE CE NU MERGE BEFORE EACH
    @BeforeEach
    void setUp() {
        student = new Student("Ognean", 7,"Bogdan",225,"bogdan.vacanta@yahoo.com","Gigel");
        student.setId(1l);
    }


    @AfterEach
    void tearDown(){
    }

    @Test
    public void  getName(){
        setUp();
        assertEquals(student.getName(),"Ognean");
    }
    @Test
    public void setNume(){
        setUp();
        student.setName("Pop");
        assertEquals(student.getName(),"Pop");
    }
    @Test
    public void getPrenume(){
        setUp();
        assertEquals(student.getPrenume(),"Bogdan");
    }
    @Test
    public void setPrenume(){
        setUp();
        student.setPrenume("Pop");
        assertEquals(student.getPrenume(),"Pop");
    }
    @Test
    public void getGrupa(){
        setUp();
        assertEquals(student.getGrupa(),225);
    }
    @Test
    public void setGrupa(){
        setUp();
        student.setGrupa(226);
        assertEquals(student.getGrupa(),226);
    }
    @Test
    public void getEmail(){
        setUp();
        assertEquals(student.getEmail(),"bogdan.vacanta@yahoo.com");
    }
    @Test
    public void setEmail(){
        setUp();
        student.setEmail("bobo");
        assertEquals(student.getEmail(),"bobo");
    }
    @Test
    public void getCadruDidacticIndrumatorLab(){
        setUp();
        assertEquals(student.getCadruDidacticIndrumatorLab(),"Gigel");
    }
    @Test
    public void setCadruDidacticIndrumatorLab(){
        setUp();
        student.setCadruDidacticIndrumatorLab("Mircea");
        assertEquals(student.getCadruDidacticIndrumatorLab(),"Mircea");
    }
    @Test
    public void getMedia(){
        setUp();
        assertEquals(student.getMedia(),7);
    }
    @Test
    public void setMedia(){
        setUp();
        student.setMedia(10);
        assertEquals(student.getMedia(),10);
    }

}
