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
    private StructuraAnUniversitar structuraAnUniversitar;
    private TemaFileRepository temaFileRepository;
    private StudentFileRepository studentFileRepository;

    private static Service service = null;

    public static Service getInstance(StructuraAnUniversitar structuraAnUniversitar, TemaFileRepository temaFileRepository, StudentFileRepository studentFileRepository)
    {
        if (service == null)
            service = new Service(structuraAnUniversitar, temaFileRepository, studentFileRepository);
        return service;
    }

    public Service(StructuraAnUniversitar structuraAnUniversitar, TemaFileRepository temaFileRepository, StudentFileRepository studentFileRepository) {
        this.structuraAnUniversitar = structuraAnUniversitar;
        this.temaFileRepository = temaFileRepository;
        this.studentFileRepository = studentFileRepository;
    }

    public void adaugareTema(Tema T)
    {
        T.setStartWeek(structuraAnUniversitar.getSaptamana(LocalDate.now()));
        Tema tema = temaFileRepository.save(T);
        if (tema != null)
            throw new ValidationException("Exista o tema cu acest id!\n");
    }

    public Tema cautareTema(Long Id)
    {
        Tema tema = temaFileRepository.findOne(Id);
        if (tema == null)
            throw new ValidationException("Nu exista nicio tema cu acest id!\n");
        return tema;
    }

    public Tema modificareTema(Tema T)
    {
        Tema t = cautareTema(T.getId());
        if (t.getDeadlineWeek() != T.getDeadlineWeek() && structuraAnUniversitar.getSaptamana(LocalDate.now()) > T.getDeadlineWeek())
        {
            throw new ValidationException("Saptamana curenta trebuie sa fie mai mica decat nr saptamanii cu termen de predare!\n");
        }
        T.setStartWeek(structuraAnUniversitar.getSaptamana(LocalDate.now()));
        Tema tema = temaFileRepository.update(T);
        if (tema == null)
            throw new ValidationException("Nu exista nicio tema cu acest id!\n");
        return tema;
    }

    public Tema stergereTema(Long Id)
    {
        Tema tema = temaFileRepository.delete(Id);
        if (tema == null)
            throw new ValidationException("Nu exista nicio tema cu acest id!\n");
        return tema;
    }

    public Iterable<Tema> afiseazaTeme()
    {
        return temaFileRepository.findAll();
    }

    public void adaugareStudent(Student S)
    {
        Student student = studentFileRepository.save(S);
        if (student != null)
            throw new ValidationException("Exista un student cu acest id!\n");
    }

    public Student cautareStudent(Long Id)
    {
        Student student = studentFileRepository.findOne(Id);
        if (student == null)
            throw new ValidationException("Nu exista niciun student cu acest id!\n");
        return student;
    }

    public Student modificareStudent(Student S)
    {
        Student student = studentFileRepository.update(S);
        if (student == null)
            throw new ValidationException("Nu exista niciun student cu acest id!\n");
        return student;
    }

    public Student stergereStudent(Long Id)
    {
        Student student = studentFileRepository.delete(Id);
        if (student == null)
            throw new ValidationException("Nu exista niciun student cu acest id!\n");
        return student;
    }

    public Iterable<Student> afisareStudent()
    {
        return studentFileRepository.findAll();
    }
}
