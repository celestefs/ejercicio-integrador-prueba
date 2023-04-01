package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Materia materia1 = new Materia("Programación I", Collections.emptyList());
        Materia materia2 = new Materia("Programación II", Collections.singletonList(materia1));
        Materia materia3 = new Materia("Programación III", Collections.singletonList(materia2));
        Materia materia4 = new Materia("Bases de datos I", Collections.emptyList());
        Materia materia5 = new Materia("Bases de datos II", Collections.singletonList(materia4));

        Collection<Materia> correlativas = new ArrayList<>();
        correlativas.add(materia1);
        correlativas.add(materia2);
        correlativas.add(materia3);
        correlativas.add(materia4);
        correlativas.add(materia5);

        Alumno alumno1 = new Alumno("Pedro", "233", Collections.singletonList(materia1));
        Alumno alumno2 = new Alumno("Sofia", "154", Collections.emptyList());
        Alumno alumno3 = new Alumno("Lucas", "456", Arrays.asList(materia1, materia2));
        Alumno alumno4 = new Alumno("Maria", "56", Collections.singletonList(materia4));

        System.out.println(alumno3.getNombre() + " tiene las siguientes materias aprobadas " + alumno3.getMateriasAprobadas());
        // inscripcion a materia III
        Inscripcion in = new Inscripcion(alumno3, materia3, LocalDateTime.now());
        // valido la inscripcion
        System.out.println(in.validarInscripcion());
        // chequeo si la inscripcion fue aprobada/rechazada con otro metodo
        System.out.println("la inscripcion fue aprobada? " + in.aprobada());
        // chequeo si el alumno puede cursar cierta materia
        System.out.println(materia3.puedeCursar(alumno2));

        try {
            FileReader archivoEntrada = new FileReader("C:\\Users\\Celes\\Desktop\\inscripciones.txt");
            Scanner sc = new Scanner(archivoEntrada);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
            }
            sc.close();
            /*FileWriter archivoSalida = new FileWriter("C:\\Users\\Celes\\Desktop\\archivoDeSalida.txt");
            archivoSalida.write();
            archivoSalida.close();
            System.out.println("El archivo de salida ha sido creado.");*/
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }
    }
}