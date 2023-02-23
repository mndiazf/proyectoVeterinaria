/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eva3.cl.negocio;

import com.eva3.cl.datos.DAOMascota;
import com.eva3.cl.entidades.Mascota;
import java.util.ArrayList;

/**
 *
 * @author Manolo
 */
public class negMascota {
    private DAOMascota datMascota = new DAOMascota();
    public ArrayList<Mascota> listarTodo()
    {
        
        ArrayList<Mascota> lMascota = datMascota.listarTodo();
        return lMascota;
    }
    
    public boolean agregaMascota(Mascota mas)
    {
        return datMascota.agregarMascota(mas);
    }
    
    public boolean modificarMascota(Mascota mas)
    {
        return datMascota.modificarMascota(mas);
    }
    
    public boolean eliminarMascota(Mascota mas)
    {
        return datMascota.eliminarMascota(mas);
    }
    
}
