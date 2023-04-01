package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

public class InscripcionTest {

    @Test
    public void testMateriaSinCorrelativas(){

        Materia materia = new Materia("Programación I", Collections.emptyList());
        Alumno alumno = new Alumno("Juan Pérez", "123", Collections.emptyList());
        Inscripcion inscripcion = new Inscripcion(alumno, materia, LocalDateTime.now());

        Assert.assertTrue(inscripcion.aprobada());

    }

    @Test
    public void testMateriaConCorrelativasYAlumnoLasTiene(){

        Materia materia1 = new Materia("Programación I", Collections.emptyList());
        Materia materia2 = new Materia("Programación II", Collections.singletonList(materia1));
        Materia materia3 = new Materia("Programación III", Collections.singletonList(materia2));
        Alumno alumno = new Alumno("Juan Pérez", "123", Arrays.asList(materia1, materia2));
        Inscripcion inscripcion = new Inscripcion(alumno, materia3, LocalDateTime.now());

        Assert.assertTrue(inscripcion.aprobada());

    }

    @Test
    public void testMateriaConCorrelativasPeroAlumnoNoLasTiene(){

        Materia materia1 = new Materia("Programación I", Collections.emptyList());
        Materia materia2 = new Materia("Programación II", Collections.singletonList(materia1));
        Materia materia3 = new Materia("Programación III", Collections.singletonList(materia2));
        Alumno alumno = new Alumno("Juan Pérez", "123", Collections.singletonList(materia1));
        Inscripcion inscripcion = new Inscripcion(alumno, materia3, LocalDateTime.now());

        Assert.assertFalse(inscripcion.aprobada());

    }
}

