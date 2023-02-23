/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eva3.cl.entidades;

import java.util.Date;

/**
 *
 * @author Manolo
 */
public class Mascota {
    private int id_mascota;
    private String nombre_mascota;
    private String especie;
    private String rut_propietario;
    private String nombre_propietario;
    private int edad;
    private Date fecha_inscripcion;
    private int id_raza;
    private String nombre_raza;
    
    public Mascota (){}

    public Mascota(int id_mascota, String nombre_mascota, String especie, String rut_propietario, String nombre_propietario, int edad, Date fecha_inscripcion, int id_raza, String nombre_raza) {
        this.id_mascota = id_mascota;
        this.nombre_mascota = nombre_mascota;
        this.especie = especie;
        this.rut_propietario = rut_propietario;
        this.nombre_propietario = nombre_propietario;
        this.edad = edad;
        this.fecha_inscripcion = fecha_inscripcion;
        this.id_raza = id_raza;
        this.nombre_raza = nombre_raza;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRut_propietario() {
        return rut_propietario;
    }

    public void setRut_propietario(String rut_propietario) {
        this.rut_propietario = rut_propietario;
    }

    public String getNombre_propietario() {
        return nombre_propietario;
    }

    public void setNombre_propietario(String nombre_propietario) {
        this.nombre_propietario = nombre_propietario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(Date fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public int getId_raza() {
        return id_raza;
    }

    public void setId_raza(int id_raza) {
        this.id_raza = id_raza;
    }

    public String getNombre_raza() {
        return nombre_raza;
    }

    public void setNombre_raza(String nombre_raza) {
        this.nombre_raza = nombre_raza;
    }
    
    
    
    
}
