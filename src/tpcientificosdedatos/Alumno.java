/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpcientificosdedatos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author User
 */
public class Alumno {
    private int legajo;
    private PlanAbs plan;//2011-S95-1995
    private Date fechaIngreso;
    private ArrayList<Materia> finales;
    private ArrayList<Materia> cursadas;
    private int codigoCarrera;
    
    public Alumno(int leg, String p, Date anioIng, int codC){
        this.legajo = leg;
        this.fechaIngreso = anioIng;
        this.codigoCarrera = codC;
        this.finales = new ArrayList<>();
        this.cursadas = new ArrayList<>();
       
        //CHECKEAR COMPARACION DE STRING
        if(p.equals("1995")){
            this.plan = new Plan1995();
        }
            else if(p.equals("S95")){
                    this.plan = new PlanS95();
                    }else{
                        this.plan = new Plan2011();
                    }
    }
    
    public PlanAbs getPlan(){
        return this.plan;
    }
         
    public int getAnioIngreso(){
        return (this.fechaIngreso.getYear()+1900);
    }
        
    public Date getFechaIngreso(){
        return this.fechaIngreso;
    }
    
    public void agregarFinal(Materia mat){
        this.finales.add(mat);
    }
    
    public void agregarCursada(Materia mat){
        this.cursadas.add(mat);
    }
    
    public int getLegajo(){
        return this.legajo;
    }
    public int calcularMateriasAprobadasHastaAnio(int anio) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaSt = "01/01/"+Integer.toString(anio);
        Date fechaAux =  sdf.parse(fechaSt);
        int result = 0;
        for(Materia m : this.finales){
            if(m.aprobada() && (m.getFecha().before(fechaAux))) {
                result++;
            } else {
            }
        }
        return result;
    }
    
    public int calcularAnio(int anioReferencia) throws ParseException{
        return (this.plan.calcularAnio(this.calcularMateriasAprobadasHastaAnio(anioReferencia)));
    }
    
    public boolean abandono(int anio, int parametroAbandono) throws ParseException{
        //Devuelve verdadero en caso de que no haya registrado ningun final ni cursada en los ultimos n años
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaSt = "01/01/"+Integer.toString(anio);
        Date fechaAux =  sdf.parse(fechaSt);
        String fechaStMenor = "01/01/"+Integer.toString(anio-parametroAbandono);
        Date fechaAuxMenor =  sdf.parse(fechaStMenor);
        
        boolean pasaronAniosDesdeIngreso = false;
        boolean registroAlgo = false;
        
        if(this.getFechaIngreso().before(fechaAux)) {
                int dias=(int) ((fechaAux.getTime()- this.getFechaIngreso().getTime())/86400000);
                if(dias > (parametroAbandono*365))
                    pasaronAniosDesdeIngreso = true;
            }
        
        if(pasaronAniosDesdeIngreso){
  
            for(Materia m : this.finales){
                if(m.getFecha().after(fechaAuxMenor) && m.getFecha().before(fechaAux)) {
                    registroAlgo = true;
                }
            }

            for(Materia m : this.cursadas){
                if(m.getFecha().after(fechaAuxMenor) && m.getFecha().before(fechaAux)) {
                    registroAlgo = true;
                }
            }
        }
     
        return (pasaronAniosDesdeIngreso && !registroAlgo);
    }
    
    public boolean seRecibio(int anio) throws ParseException{
       // System.out.println(this.plan.getCantidadMateriasTotales() + " " +this.calcularMateriasAprobadasHastaAnio(anio));
        return (this.plan.getCantidadMateriasTotales() <= this.calcularMateriasAprobadasHastaAnio(anio));
    }

}