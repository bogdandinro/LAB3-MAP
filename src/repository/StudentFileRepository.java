package repository;

import entities.Student;
import entities.validator.Validator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;


public class StudentFileRepository extends AbstractRepository<Long, Student> {


    public StudentFileRepository(Validator validator, String filename) {
        super(validator, filename);
    }

    protected void loadData() {
        Path path = Paths.get(super.filename);
        try {
            List<String> lines = Files.readAllLines(path);
            lines.forEach(linie -> {
                //E entity = creatiEntity(linie);
                String[] params = linie.split(";");
                Student s = new Student(params[1],Float.parseFloat(params[2]),params[3],Integer.parseInt(params[4]),params[5],params[6]);
                s.setId(Long.parseLong(params[0]));
                super.save(s);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveData(Iterable<Student> students) {
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("/data/studenti.txt"));

            try {
                Iterator var3 = students.iterator();

                while(var3.hasNext()) {
                    Student student = (Student)var3.next();
                    bf.write(student.toString());
                    bf.write(10);
                }
            } catch (Throwable var6) {
                try {
                    bf.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            bf.close();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }
}

