/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eva3.cl.entidades;

/**
 *
 * @author Manolo
 */
public class Usuario {
    private int id_usuario;
    private String login;
    private String pass;

    public Usuario() {
    }

    public Usuario(int id_usuario, String login, String pass) {
        this.id_usuario = id_usuario;
        this.login = login;
        this.pass = pass;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
