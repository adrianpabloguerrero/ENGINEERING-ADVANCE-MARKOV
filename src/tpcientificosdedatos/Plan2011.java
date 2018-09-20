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
public class Plan2011 extends PlanAbs{
    public Plan2011(){
        this.cantMaterias = 36;
    }
    @Override
    public int calcularAnio(int cantMateriasAprobadas) {
        if(cantMateriasAprobadas < 9){
            return 1;   
        }else if (cantMateriasAprobadas >= 9 && cantMateriasAprobadas < 19){
            return 2;
        }else if (cantMateriasAprobadas >= 19 && cantMateriasAprobadas < 28){
            return 3;
        }else if (cantMateriasAprobadas >= 28 && cantMateriasAprobadas < 34){
            return 4;
        }else if (cantMateriasAprobadas >= 34 && cantMateriasAprobadas < 36){
            return 5;
        }else{
            return 6; //USAR PARA RECIBIDO?
        }
    }
    
}
