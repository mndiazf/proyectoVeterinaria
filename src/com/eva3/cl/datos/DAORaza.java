/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eva3.cl.datos;

import com.eva3.cl.entidades.Raza;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manolo
 */
public class DAORaza {
    private final String selectAll = "SELECT * FROM RAZA";
    private Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    public ArrayList<Raza> listarTodo()
    {
        try {
            ArrayList<Raza> listaRaza = new ArrayList<>();
            PreparedStatement ps = objConn.getConn().prepareStatement(selectAll);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Raza raz = new Raza();
                raz.setId_raza(rs.getInt("id_raza"));
                raz.setNombre_raza(rs.getString("raza"));
                listaRaza.add(raz);
            }
            return listaRaza;
        } catch (SQLException ex) {
            Logger.getLogger(DAORaza.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
