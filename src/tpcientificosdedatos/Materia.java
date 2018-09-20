/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpcientificosdedatos;

import java.util.Date;

/**
 *
 * @author User
 */
public class Materia {
    private int codigoMateria;
    private Date fecha;
    private boolean aprobada;
    
    public Materia(int codM, Date fec, boolean ap){
        this.codigoMateria = codM;
        this.fecha = fec;
        this.aprobada = ap;
    }
    
    public int getCodigoMateria(){
        return this.codigoMateria;
    }
    
    public boolean aprobada(){
        return this.aprobada;
    }
    
    public Date getFecha(){
        return this.fecha;
    }
}
