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
public class PlanS95  extends PlanAbs{

    public PlanS95(){
        this.cantMaterias = 34;
    }
    @Override
    public int calcularAnio(int cantMateriasAprobadas) {
        if(cantMateriasAprobadas < 7){
            return 1;   
        }else if (cantMateriasAprobadas >= 7 && cantMateriasAprobadas < 17){
            return 2;
        }else if (cantMateriasAprobadas >= 17 && cantMateriasAprobadas < 26){
            return 3;
        }else if (cantMateriasAprobadas >= 26 && cantMateriasAprobadas < 32){
            return 4;
        }else if (cantMateriasAprobadas >= 32 && cantMateriasAprobadas < 34){
            return 5;
        }else{
            return 6; //USAR PARA RECIBIDO?
        }
    }
    
}
