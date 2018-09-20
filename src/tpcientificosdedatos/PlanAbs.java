/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpcientificosdedatos;

/**
 *
 * @author User
 */
public abstract class PlanAbs {
    int cantMaterias;
    
    public abstract int calcularAnio(int cantMateriasAprobadas);
    
    public int getCantidadMateriasTotales(){
        return this.cantMaterias;
    }
}
