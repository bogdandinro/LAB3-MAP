package repository;

import entities.Tema;
import entities.validator.Validator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class TemaFileRepository  extends AbstractRepository<Long,Tema>{
    public TemaFileRepository(Validator validator, String filename) {
        super(validator, filename);
    }

    protected void loadData() {
        Path path = Paths.get(super.filename);

        try {
            List<String> lines = Files.readAllLines(path);
            lines.forEach((linie) -> {
                String[] params = linie.split(";");
                Tema tema = new Tema(params[1], Integer.parseInt(params[2]), Integer.parseInt(params[3]));
                tema.setId(Long.parseLong(params[0]));
                super.save(tema);
            });
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    public void saveData(Iterable<Tema> teme) {
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("data/teme.txt"));

            try {
                Iterator var3 = teme.iterator();

                while(var3.hasNext()) {
                    Tema tema = (Tema)var3.next();
                    bf.write(tema.toString());
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
