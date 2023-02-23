/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eva3.cl.datos;

import com.eva3.cl.entidades.Mascota;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manolo
 */
public class DAOMascota {
    private final String selectAll = "SELECT M.ID_MASCOTA,M.NOMBRE,M.ESPECIE,M.RUT_PROPIETARIO,M.NOMBRE_PROPIETARIO,M.EDAD,M.FECHA_INSCRIPCION,M.ID_RAZA,RZ.RAZA FROM MASCOTA M LEFT JOIN RAZA RZ ON (M.ID_RAZA = RZ.ID_RAZA)ORDER BY M.ID_MASCOTA";
    private final String insert = "INSERT INTO MASCOTA (NOMBRE,ESPECIE,RUT_PROPIETARIO,NOMBRE_PROPIETARIO,EDAD,FECHA_INSCRIPCION,ID_RAZA)VALUES(?,?,?,?,?,?,?)";
    private final String update = "UPDATE MASCOTA SET NOMBRE=?,ESPECIE=?,RUT_PROPIETARIO=?,NOMBRE_PROPIETARIO=?,EDAD=?,FECHA_INSCRIPCION=?,ID_RAZA=? WHERE ID_MASCOTA=?";
    private final String delete = "DELETE FROM MASCOTA WHERE ID_MASCOTA =?";
    private Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;  
    
    public ArrayList<Mascota> listarTodo()
    {
        try {
            ArrayList<Mascota> listaMascota = new ArrayList<>();
            PreparedStatement ps = objConn.getConn().prepareStatement(selectAll);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Mascota mas = new Mascota();
                mas.setId_mascota(rs.getInt("id_mascota"));
                mas.setNombre_mascota(rs.getString("nombre"));
                mas.setEspecie(rs.getString("especie"));
                mas.setRut_propietario(rs.getString("rut_propietario"));
                mas.setNombre_propietario(rs.getString("nombre_propietario"));
                mas.setEdad(rs.getInt("edad"));
                mas.setFecha_inscripcion(rs.getDate("fecha_inscripcion"));
                mas.setId_raza(rs.getInt("id_raza"));
                mas.setNombre_raza(rs.getString("raza"));
                listaMascota.add(mas);
                
            }
            return listaMascota;
        } catch (SQLException ex) {
            Logger.getLogger(DAOMascota.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public boolean agregarMascota(Mascota mascota)
    {
        try {
            java.sql.Date fecha_inscripcion = new java.sql.Date(mascota.getFecha_inscripcion().getTime());
            PreparedStatement ps = objConn.getConn().prepareStatement(insert);
            ps.setString(1, mascota.getNombre_mascota());
            ps.setString(2, mascota.getEspecie());
            ps.setString(3, mascota.getRut_propietario());
            ps.setString(4, mascota.getNombre_propietario());
            ps.setInt(5, mascota.getEdad());
            ps.setDate(6, fecha_inscripcion);
            ps.setInt(7,mascota.getId_raza());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOMascota.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
    public boolean modificarMascota(Mascota mascota)
    {
        try {
            java.sql.Date fecha_inscripcion = new java.sql.Date(mascota.getFecha_inscripcion().getTime());
            PreparedStatement ps = objConn.getConn().prepareStatement(update);
            ps.setString(1, mascota.getNombre_mascota());
            ps.setString(2, mascota.getEspecie());
            ps.setString(3, mascota.getRut_propietario());
            ps.setString(4, mascota.getNombre_propietario());
            ps.setInt(5, mascota.getEdad());
            ps.setDate(6, fecha_inscripcion);
            ps.setInt(7,mascota.getId_raza());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOMascota.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
    public boolean eliminarMascota(Mascota mascota)
    {
        try {
            
            PreparedStatement ps = objConn.getConn().prepareStatement(delete);
            ps.setInt(1, mascota.getId_mascota());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOMascota.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
}
