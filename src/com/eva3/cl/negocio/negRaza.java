/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eva3.cl.negocio;

import com.eva3.cl.datos.DAORaza;
import com.eva3.cl.entidades.Raza;
import java.util.ArrayList;

/**
 *
 * @author Manolo
 */
public class negRaza {
    public ArrayList<Raza> listarTodo()
    {
        DAORaza datRaza = new DAORaza();
        ArrayList<Raza> lraza = datRaza.listarTodo();
        return lraza;
    
    }
}