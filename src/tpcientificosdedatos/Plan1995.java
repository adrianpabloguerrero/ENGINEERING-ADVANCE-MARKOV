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
public class Plan1995  extends PlanAbs{
    public Plan1995(){
        this.cantMaterias = 35;
    }
    @Override
    public int calcularAnio(int cantMateriasAprobadas) {
        if(cantMateriasAprobadas < 8){
            return 1;   
        }else if (cantMateriasAprobadas >= 8 && cantMateriasAprobadas < 18){
            return 2;
        }else if (cantMateriasAprobadas >= 18 && cantMateriasAprobadas < 27){
            return 3;
        }else if (cantMateriasAprobadas >= 27 && cantMateriasAprobadas < 33){
            return 4;
        }else if (cantMateriasAprobadas >= 33 && cantMateriasAprobadas < 35){
            return 5;
        }else{
            return 6; //USAR PARA RECIBIDO
        }
    
    }
    
}
