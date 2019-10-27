package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyMap {
    private Map<Integer, List<Student>> map;

    public MyMap(){
        this.map = new TreeMap<>();
    }

    public void add(Student student){
        float medie = student.getMedia();
        int rotunjita = Math.round(medie);
        if(map.containsKey(rotunjita)){
            //se adauga in lista
        }
        else {
            List<Student> lista =new ArrayList<>();
            lista.add(student);
            map.put(rotunjita,lista);
        }
    }
}
