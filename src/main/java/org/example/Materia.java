package org.example;

import java.util.List;

public class Materia {
    String nombre;
    List<Materia> correlativas;

    public Materia(){

    }

    public Materia(String nombre, List<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    public boolean puedeCursar(Alumno alumno){
        return alumno.getMateriasAprobadas().containsAll(correlativas);
    }

    @Override
    public String toString() {
        return "Materia{" +
                "nombre='" + nombre + '\'' +
                ", correlativas=" + correlativas +
                '}';
    }
}
