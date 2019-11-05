package ui;

import entities.Student;
import entities.Tema;
import entities.validator.ValidationException;
import repository.StudentFileRepository;
import repository.TemaFileRepository;
import services.Service;
import structures.StructuraAnUniversitar;

import java.util.Scanner;

public class Ui {
    private Service service;

    public Ui(StructuraAnUniversitar structuraAnUniversitar, TemaFileRepository temaFileRepository, StudentFileRepository studentFileRepository) {
        this.service = Service.getInstance(structuraAnUniversitar, temaFileRepository, studentFileRepository);
    }

    public void run() {
        String cmd="";
        boolean finish = false;
        Scanner read = new Scanner(System.in);
        while(!finish){
            try {
                printMenu();
                cmd = read.nextLine();
                switch (cmd) {
                    case "adaugareStudent":
                        adaugareStudent(read);
                        break;
                    case "modificareStudent":
                        modificareStudent(read);
                        break;
                    case "cautareStudent":
                        cautareStudent(read);
                        break;
                    case "stergereStudent":
                        stergereStudent(read);
                        break;
                    case "afisareStudenti":
                        afisareStudenti();
                        break;
                    case "adaugareTema":
                        adaugareTema(read);
                        break;
                    case "modificareTema":
                        modificareTema(read);
                        break;
                    case "cautareTema":
                        cautareTema(read);
                        break;
                    case "stergereTema":
                        stergereTema(read);
                        break;
                    case "afisareTeme":
                        afisareTeme();
                        break;
                    case "exit":
                        finish = true;
                        read.close();
                        break;
                    default:
                        System.out.println("comanda invalida.");
                }
            } catch (IllegalArgumentException | ValidationException e) {
                System.out.println(e);
            }
        }
    }

    private void printMenu()
    {
        System.out.println();
        System.out.println("adaugare(Student/Tema) - adaugare student/tema");
        System.out.println("modificare(Student/Tema) - modificare student/tema");
        System.out.println("cautare(Student/Tema) - cautare student/tema");
        System.out.println("stergere(Student/Tema) - stergere student/tema");
        System.out.println("afisare(Studenti/Teme) - afiseaza studentii/temele");
    }

    private void adaugareStudent(Scanner read) throws IllegalArgumentException,ValidationException
    {
        System.out.println("Id-ul studentului:");
        Long id = Long.parseLong(read.nextLine());
        System.out.println("Numele studentului:");
        String nume = read.nextLine();
        System.out.println("Media studentului");
        Float media= Float.parseFloat(read.nextLine());
        System.out.println("Prenumele studentului:");
        String prenume = read.nextLine();
        System.out.println("Grupa studentului:");
        int grupa = Integer.parseInt(read.nextLine());
        System.out.println("Email-ul studentului:");
        String email = read.nextLine();
        System.out.println("Cadrul didactic indrumator de la laborator:");
        String cadruDidacticIndrumatorLab = read.nextLine();

        Student student = new Student(nume,media, prenume, grupa, email, cadruDidacticIndrumatorLab);
        student.setId(id);
        service.adaugareStudent(student);
        System.out.println(student);
    }

    private void modificareStudent(Scanner read) throws IllegalArgumentException, ValidationException
    {
        System.out.println("Id-ul studentului:");
        Long id = Long.parseLong(read.nextLine());
        System.out.println("Numele studentului:");
        String nume = read.nextLine();
        System.out.println("Media studentului");
        Float media= Float.parseFloat(read.nextLine());
        System.out.println("Prenumele studentului:");
        String prenume = read.nextLine();
        System.out.println("Grupa studentului:");
        int grupa = Integer.parseInt(read.nextLine());
        System.out.println("Email-ul studentului:");
        String email = read.nextLine();
        System.out.println("Cadrul didactic indrumator de la laborator:");
        String cadruDidacticIndrumatorLab = read.nextLine();

        Student student = new Student(nume,media, prenume, grupa, email, cadruDidacticIndrumatorLab);
        student.setId(id);
        Student studentModificat = service.modificareStudent(student);
        System.out.println(studentModificat);
    }

    private void cautareStudent(Scanner read) throws IllegalArgumentException, ValidationException
    {
        System.out.println("Id-ul studentului:");
        Long id = Long.parseLong(read.nextLine());
        Student student = service.cautareStudent(id);
        System.out.println(student);
    }

    private void stergereStudent(Scanner read) throws IllegalArgumentException, ValidationException
    {
        System.out.println("Id-ul studentului:");
        Long id = Long.parseLong(read.nextLine());

        Student student = service.stergereStudent(id);
        System.out.println(student);
    }

    private void afisareStudenti()
    {
        service.afisareStudent().forEach(System.out::println);
        System.out.println();
    }

    private void adaugareTema(Scanner read) throws IllegalArgumentException, ValidationException
    {
        System.out.println("Id-ul temei:");
        Long id = Long.parseLong(read.nextLine());
        System.out.println("Descrierea temei:");
        String descriere = read.nextLine();
        System.out.println("Deadline-ul temei:");
        int deadline = Integer.parseInt(read.nextLine());

        Tema tema = new Tema(descriere, deadline);
        tema.setId(id);
        service.adaugareTema(tema);
        System.out.println(tema);
    }

    private void modificareTema(Scanner read) throws IllegalArgumentException, ValidationException
    {
        System.out.println("Id-ul temei:");
        Long id = Long.parseLong(read.nextLine());
        System.out.println("Descrierea temei:");
        String descriere = read.nextLine();
        System.out.println("Deadline-ul temei:");
        int deadline = Integer.parseInt(read.nextLine());

        Tema tema = new Tema(descriere, deadline);
        tema.setId(id);
        Tema temaModificata = service.modificareTema(tema);
        System.out.println(temaModificata);
    }

    private void cautareTema(Scanner read) throws IllegalArgumentException, ValidationException
    {
        System.out.println("Id-ul temei:");
        Long id = Long.parseLong(read.nextLine());

        Tema tema = service.cautareTema(id);
        System.out.println(tema);
    }

    private void stergereTema(Scanner read) throws IllegalArgumentException, ValidationException
    {
        System.out.println("Id-ul temei:");
        Long id = Long.parseLong(read.nextLine());

        Tema tema = service.stergereTema(id);
        System.out.println(tema);
    }

    private void afisareTeme()
    {
        service.afiseazaTeme().forEach(System.out::println);
        System.out.println();
    }
}
