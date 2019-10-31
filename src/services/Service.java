package services;

import entities.Student;
import entities.Tema;
import entities.validator.ValidationException;
import entities.validator.ValidationTema;
import entities.validator.ValidatorStudent;
import repository.StudentFileRepository;
import repository.TemaFileRepository;
import structures.StructuraAnUniversitar;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Objects;

public class Service {
    private StructuraAnUniversitar structuraAnUniversitar = new StructuraAnUniversitar(1, 14, 12, 13, LocalDate.of(LocalDate.now().getYear(), 9, 30), 14, 9, 9, LocalDate.of(LocalDate.now().getYear() + 1, 2, 25));
    private TemaFileRepository temaFileRepository;
    private StudentFileRepository studentFileRepository;
    private ValidationTema validationTema = new ValidationTema();
    private ValidatorStudent validationStudent = new ValidatorStudent();
    private static Service service = null;

    public static Service getInstance() {
        if (service == null) {
            service = new Service();
        }

        return service;
    }

    private Service() {
        //aici trebuie schimbata destinatia
        this.temaFileRepository = new TemaFileRepository(this.validationTema, "./data/teme.txt");
        this.validationStudent = new ValidatorStudent();
        this.studentFileRepository = new StudentFileRepository(this.validationStudent, "./data/studenti.txt");
    }

    public void adaugareTema(Tema T) {
        T.setStartWeek(this.structuraAnUniversitar.getSaptamana(LocalDate.now()));
        Tema tema = (Tema)this.temaFileRepository.save(T);
        if (tema != null) {
            throw new ValidationException("Exista o tema cu acest id!\n");
        } else {
            this.temaFileRepository.saveData(this.temaFileRepository.findAll());
        }
    }

    public Tema cautareTema(Long Id) {
        Tema tema = (Tema)this.temaFileRepository.findOne(Id);
        if (tema == null) {
            throw new ValidationException("Nu exista nicio tema cu acest id!\n");
        } else {
            this.temaFileRepository.saveData(this.temaFileRepository.findAll());
            return tema;
        }
    }

    public void modificareTema(Tema T) {
        Tema t = this.cautareTema((Long)T.getId());
        if (t.getDeadlineWeek() != T.getDeadlineWeek() && this.structuraAnUniversitar.getSaptamana(LocalDate.now()) > T.getDeadlineWeek()) {
            throw new ValidationException("Saptamana curenta trebuie sa fie mai mica decat nr saptamanii cu termen de predare!\n");
        } else {
            Tema tema = (Tema)this.temaFileRepository.update(T);
            if (tema == null) {
                throw new ValidationException("Nu exista nicio tema cu acest id!\n");
            } else {
                this.temaFileRepository.saveData(this.temaFileRepository.findAll());
            }
        }
    }

    public Tema stergereTema(Long Id) {
        Tema tema = (Tema)this.temaFileRepository.delete(Id);
        if (tema == null) {
            throw new ValidationException("Nu exista nicio tema cu acest id!\n");
        } else {
            this.temaFileRepository.saveData(this.temaFileRepository.findAll());
            return tema;
        }
    }

    public void afiseazaTeme() {
        Iterable var10000 = this.temaFileRepository.findAll();
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
        System.out.println();
    }
    public void adaugareStudent(Student S){
        Student student =(Student)this.studentFileRepository.save(S);
        if(student != null){
            throw new ValidationException("Exista deja un student cu acest id \n");
        }
        else{
            this.studentFileRepository.saveData(this.studentFileRepository.findAll());
        }
    }

    public Student cautareStudent(Long Id){
        Student student = (Student)this.studentFileRepository.findOne(Id);
        if(student == null){
            throw new ValidationException("Nu exista niciun student cu acest id \n");
        }
        else{
            this.studentFileRepository.saveData(this.studentFileRepository.findAll());
            return student;
        }
    }

    public void modificareStudent(Student S){
        Student student = (Student)this.studentFileRepository.update(S);
        if(student == null){
            throw new ValidationException("Nu exista niciun student cu acest id \n");
        }
        else{
            this.studentFileRepository.saveData(this.studentFileRepository.findAll());
        }
    }

    public Student stergereStudent(Long Id){
        Student student =(Student)this.studentFileRepository.delete(Id);
        if(student == null){
            throw new ValidationException("Nu exista niciun student cu acest id \n");
        }
        else{
            this.studentFileRepository.saveData(this.studentFileRepository.findAll());
            return student;
        }
    }

    public void afisareStudent(){
        Iterable var=this.studentFileRepository.findAll();
        PrintStream var2=System.out;
        Objects.requireNonNull(var2);
        var.forEach(var2::println);
        System.out.println();
    }
}
