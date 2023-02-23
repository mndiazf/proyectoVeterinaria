/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eva3.cl.datos;
// importé lo necesario y terminé el DAO usuario
import com.eva3.cl.entidades.Usuario;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manolo
 */
public class DAOUsuario {
    private final String selectUsuario = "select * from usuario where login = ?";
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    public Usuario buscaUsuario(String login)
    {
        try {
            Usuario usu = new Usuario();
            PreparedStatement ps;
            ps = objConn.getConn().prepareStatement(selectUsuario);
            ps.setString(1, login);
            rs = ps.executeQuery();
            if(rs.next())
            {
                usu.setId_usuario(rs.getInt("id_usuario"));
                usu.setLogin(rs.getString("login"));
                usu.setPass(rs.getString("pass"));
            }
            return usu;
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
