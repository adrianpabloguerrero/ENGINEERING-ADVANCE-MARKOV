/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpcientificosdedatos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 *
 * @author User
 */
public class TPCientificosDeDatos {
        private InterfazGraficaSeleccionArchivos interfazSeleccionArchivos;
        private InterfazGraficaPrincipal interfazPrincipal;
        private InterfazGraficaMatrizMarkov interfazMatrizMarkov;
        private InterfazGraficaAnalisis interfazAnalisis;
        private int parametroAnio;
        private int parametroAbandono;
        private MatrizMarkov matrizMarkov;
        private HashMap<Integer,Alumno> alumnosHM;
        public static final String SEPARATOR=";";
        public static final String QUOTE="\"";
        public static final String INGENIERIASISTEMAS="206";
       
        //public int totalMatAdd = 0;
   
    public TPCientificosDeDatos() throws ParseException{
        this.interfazSeleccionArchivos = new InterfazGraficaSeleccionArchivos(this);
        this.interfazPrincipal = new InterfazGraficaPrincipal(this);
        this.interfazMatrizMarkov = new InterfazGraficaMatrizMarkov(this);
        this.interfazAnalisis = new InterfazGraficaAnalisis(this);
        this.alumnosHM = new HashMap <>();
        //this.matrizMarkov = new MatrizMarkov(this.calcularMaximoAnios());
        //this.parametroAbandono=2; //DEFAULT VALUE
    }
    
   
    public void agregarAlumno(Alumno agregar){
        this.alumnosHM.put(agregar.getLegajo(), agregar);
    }
    public int getParametroAnio(){
    return this.parametroAnio;
    }
    
   
    
    public void setParametroAnio(int var){
        this.parametroAnio = var;
    }
    
    public int getParametroAbandono(){
        return this.parametroAbandono;
    }
    public void setParametroAbandono(int var){
        this.parametroAbandono = var;
    }
    public void mostrarInterfazSeleccionArchivos(){
        this.interfazSeleccionArchivos.setVisible(true);
    }
    public void mostrarInterfazPrincipal(){
        this.interfazPrincipal.setVisible(true);
    }
      
    public void mostrarInterfazMatrizMarkov() throws IOException{
        //this.interfazMatrizMarkov.setVisible(true);
        this.interfazMatrizMarkov.mostrate();

    }
    
    public void mostrarInterfazAnalisis () throws IOException {
        this.interfazAnalisis.mostrate();
    }
    public MatrizMarkov getMatrizMarkov(){
        return this.matrizMarkov;
    }
   
     
    public void cargarAlumnos(String pathAlumnos) throws IOException{
        
      BufferedReader br = null;
      
      try {
         
         br =new BufferedReader(new FileReader(pathAlumnos));
         String line = br.readLine();
         while (null!=line) {
            String [] fields = line.split(SEPARATOR);
            //System.out.println(Arrays.toString(fields));
            //Formato del array [carrera, legajo, plan, fecha_ingreso, calidad, localidad_nacimiento, colegio_secundario, titulo_secundario]
           
  
            String carreraAux = fields[0];
            
           
            if (carreraAux.equals(INGENIERIASISTEMAS)){
                int legajoAux = Integer.parseInt(fields[1]);
                String planAux = fields[2];
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaIngresoAux =  sdf.parse(fields[3]);
                this.agregarAlumno(new Alumno(legajoAux, planAux, fechaIngresoAux , Integer.parseInt(carreraAux)));
            
            }
            line = br.readLine();
         }
         System.out.println("Termino Carga Alumnos \nTotal Cargadados: "+ this.alumnosHM.size());
         
      } catch (IOException | NumberFormatException | ParseException e) {
      } finally {
         if (null!=br) {
            br.close();
         }
      }
    }
    
    public Alumno getAlumno(int legajo){
        return this.alumnosHM.get(legajo);
    }
    
    public void agregarFinal(int codAlumno, Materia finalAgregar){
        this.getAlumno(codAlumno).agregarFinal(finalAgregar);
    }
      
    public void cargarFinales(String pathFinales) throws IOException, ParseException{
          BufferedReader br = null;
      
      try {
         
         br =new BufferedReader(new FileReader(pathFinales));
         String line = br.readLine();
         while (null!=line) {
            String [] fields = line.split(SEPARATOR);
            //System.out.println(Arrays.toString(fields));
            //Formato del array [carrera, legajo, materia, fecha, resultado, nota, forma_aprobacion, plan, nombre]
            
            String carreraAux = fields[0];
            //this.totalMatAdd++;
            if (carreraAux.equals(INGENIERIASISTEMAS)){
                int legajoAux = Integer.parseInt(fields[1]);
                int codMateriaAux = Integer.parseInt(fields[2]);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaAux =  sdf.parse(fields[3]);
                String resultadoAux = fields[4];
                Boolean aprobo = false;
                
                if(resultadoAux.equals("A")){
                    aprobo = true;
                }
                
                this.agregarFinal(legajoAux, new Materia(codMateriaAux, fechaAux, aprobo));
            }
            line = br.readLine();
         }
         
      } catch (IOException | NumberFormatException | ParseException e) {
      } finally {
         if (null!=br) {
            br.close();
         }
      }
          
    }
    
    public void agregarCursada(int codAlumno, Materia cursadaAgregar){
         this.getAlumno(codAlumno).agregarCursada(cursadaAgregar);
    }
    
    public void cargarCursadas(String pathCursadas) throws IOException, ParseException{
              BufferedReader br = null;
      
      try {
          
         
         
         br =new BufferedReader(new FileReader(pathCursadas));
         String line = br.readLine();
         while (null!=line) {
            String [] fields = line.split(SEPARATOR);
            //System.out.println(Arrays.toString(fields));
            //Formato del array [carrera, plan, legajo, materia, fecha_regularidad, resultado, nota, origen, nombre]
            String carreraAux = fields[0];
            
            if (carreraAux.equals(INGENIERIASISTEMAS)){
                int legajoAux = Integer.parseInt(fields[2]);
                int codMateriaAux = Integer.parseInt(fields[3]);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaAux =  sdf.parse(fields[4]);
                String resultadoAux = fields[5];
                Boolean aprobo = false;
                if(resultadoAux.equals("A")){
                    aprobo = true;
                }
                this.agregarCursada(legajoAux, new Materia(codMateriaAux, fechaAux, aprobo));
            }
            line = br.readLine();
         }
         
         
      } catch (IOException | NumberFormatException | ParseException e) {
      } finally {
         if (null!=br) {
            br.close();
         }
      }
      
      this.pruebas();
     
}
    
    public void pruebas() throws ParseException{
        //System.out.println(this.getAlumno(2483).seRecibio(2011));
     int countRecibidos = 0;
     int countNo = 0;
     for (int key : alumnosHM.keySet()) {
         
        if(this.getAlumno(key).seRecibio(2222)){
            countRecibidos++;
        }else{
            countNo++;
        }
     }
     
     System.out.println("si: " + countRecibidos + " no: " + countNo);
     //System.out.println(this.calcularMaximoAnios());
     
     
    }
    
    public int calcularMaximoAnios() throws ParseException{
        int maximo=0;
        Date hoy = new Date();
        
        for (int key : alumnosHM.keySet()) {
            int maximoParcial=0;
            Date fechaIngreso = this.getAlumno(key).getFechaIngreso();
            int anioIngreso = fechaIngreso.getYear()+1900;
            
            if(anioIngreso >= this.parametroAnio){
                while(anioIngreso <= (hoy.getYear()+1900) && !this.getAlumno(key).seRecibio(anioIngreso) && !this.getAlumno(key).abandono(anioIngreso, this.parametroAbandono)){
                    maximoParcial++;
                    anioIngreso++;
                }
            }
            
            
            if(maximoParcial > maximo){
                maximo = maximoParcial;
                
            }
        }
        return (maximo + this.parametroAbandono);
    }
    
    
    
    
    
    public void calcularMatrizMarkov() throws ParseException{
        
        ArrayList <Alumno> alumnosEnFecha = new ArrayList <Alumno> ();
   
        for (int key : alumnosHM.keySet()) {
            
            Date fechaIngreso = this.getAlumno(key).getFechaIngreso();
            
            int anioIngreso = fechaIngreso.getYear()+1900;
            //System.out.println(anioIngreso);
            if(anioIngreso >= this.parametroAnio)
                alumnosEnFecha.add(this.getAlumno(key));
        }
       // System.out.println(alumnosEnFecha.size());
        this.matrizMarkov = new MatrizMarkov(alumnosEnFecha,this.parametroAnio,this.parametroAbandono);
        }
            

    
    public static void main(String[] args) throws ParseException {
        TPCientificosDeDatos tpCientificosDeDatos = new TPCientificosDeDatos();
        tpCientificosDeDatos.mostrarInterfazSeleccionArchivos(); 
    }
    
}
