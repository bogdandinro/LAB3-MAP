package repository;

import entities.Student;
import entities.validator.Validator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// ne facem AbstractFileRepository extends InMemoRepo<ID, E>

public class StudentFileRepository extends InMemoRepo<Long, Student> {
    private String filename;

    public StudentFileRepository(Validator validator, String filename) {
        super(validator);
        filename = this.filename;
        loadData();
    }

    private void loadData() {
        Path path = Paths.get(filename);
        try {
            List<String> lines = Files.readAllLines(path);
            lines.forEach(linie -> {
                //E entity = creatiEntity(linie);
                String[] params = linie.split(";");
                Student s = new Student(params[1], Float.parseFloat(params[2]));
                ///aici ceva nu e ok
                //s.setID(Long.parseLong(params[0]));
                super.save(s);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
