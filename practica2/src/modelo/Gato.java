/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SONY VAIO
 */

@XmlRootElement

public class Gato {
    private Integer id;
    private String raza;
    private String nombre;
    private Double edad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getEdad() {
        return edad;
    }

    public void setEdad(Double edad) {
        this.edad = edad;
    }


    @Override
    public String toString() {
        return " " + nombre + " " + raza + " " + edad;
    }    
}
