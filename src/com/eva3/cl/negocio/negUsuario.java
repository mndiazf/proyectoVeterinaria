/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eva3.cl.negocio;

import com.eva3.cl.datos.DAOUsuario;
import com.eva3.cl.entidades.Usuario;

/**
 *
 * @author Manolo
 */
public class negUsuario {

    public boolean inicioSesion(String login, String pass) {
        try {
            DAOUsuario datUsuario = new DAOUsuario();
            Usuario usu = new Usuario();
            usu = datUsuario.buscaUsuario(login);
            if (usu != null) {
                if (usu.getPass().equals(pass)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }
}

