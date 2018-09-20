/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpcientificosdedatos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author adrianguerrero
 */


public class Analisis {
    
    double [][] matrizMarkov;
    double [][] matrizMarkovSinAbandono;
    double [][] matrizAcumulada;
    double [][] matrizAcumuladaSinAbandono;
    ArrayList <Alumno> alumnos;
    String vectorMostrar = "AÑOS\tPRIMERO\tSEGUNDO\tTERCERO\tCUARTO\tQUINTO\tEGRESO\tABANDONO\n";
    private int max = 999;
    double probAbandono = 0;
    double resultadoCaso1;
    int aniosCaso1;
    int aniosCaso2;
    int aniosCaso3;
    int cantidadCaso3;
 
    
    InterfazGraficaAnalisis interfaz;
    
    public Analisis (double [][] matrizMarkov, double [][]matrizMarkovSinAbandono,double probAbandono,ArrayList <Alumno> alumnos){
        this.matrizMarkov = matrizMarkov;
        this.matrizMarkovSinAbandono = matrizMarkovSinAbandono;
        this.matrizAcumulada = generarMatrizAcumulada ();
        this.matrizAcumuladaSinAbandono = generarMatrizAcumuladaSinAbandono ();
        this.alumnos=alumnos;
        this.probAbandono = probAbandono;
    }
    
    
  public void setInterfaz (InterfazGraficaAnalisis interfaz){
      this.interfaz = interfaz;
  }
  
 
    
    
    public double [][] generarMatrizAcumulada (){
		double[][] matrizAcumulada = new double[8][8];
		
                for (int i = 1; i < this.matrizMarkov.length; i++) {
			for (int j = 1; j < this.matrizMarkov[i].length; j++) {
				matrizAcumulada[i][j]=matrizMarkov[i][j];
			}
		}
        
		for (int i = 1; i< matrizAcumulada.length ; i ++){
			double acum = 0;
			for (int j = 1 ; j< matrizAcumulada[i].length ; j++){
				acum=acum+matrizAcumulada[j][i];
				matrizAcumulada [j][i] = acum;
			}
		}
                
		return matrizAcumulada;
	}
	
    public double [][] generarMatrizAcumuladaSinAbandono (){
		double[][] matrizAcumulada = new double[7][7];
		
                for (int i = 1; i < this.matrizMarkovSinAbandono.length; i++) {
			for (int j = 1; j < this.matrizMarkovSinAbandono[i].length; j++) {
				matrizAcumulada[i][j]=matrizMarkovSinAbandono[i][j];
			}
		}
              
        
		for (int i = 1; i< matrizAcumulada.length ; i ++){
			double acum = 0;
			for (int j = 1 ; j< matrizAcumulada[i].length ; j++){
				acum=acum+matrizAcumulada[j][i];
				matrizAcumulada [j][i] = acum;
			}
		}
                
		return matrizAcumulada;
	}
    
  private int proximoAnio (int primerAnio){
     
		double x = Math.random();
		for (int i=1 ; i< matrizAcumulada.length; i++)
			if (x < matrizAcumulada [i][primerAnio] )
				return i;
		return -1;
	}
  
   private int proximoAnioSinAbandono (int primerAnio){
     
		double x = Math.random();
		for (int i=1 ; i< matrizAcumuladaSinAbandono.length; i++)
			if (x < matrizAcumuladaSinAbandono [i][primerAnio] )
				return i;
		return -1;
	}
	  
    
public boolean converge(float [] probActual, float [] probAnterior) 
	{
		for (int i = 0; i < probActual.length ; i ++ )
			if (Math.abs(probActual[i]-probAnterior[i]) > 0.00001)
				return false;
		return true;
	}
  

public float [] vectorEstacionario () {
		
		float vectorAnterior [] = new float[8]; 
		float vectorActual [] = new float[8];
		float exitos[] = new float [8];
		int pasos = 0;
		
                for (int i=0; i< exitos.length; i++){
                    vectorAnterior[i]=-1;
                    vectorActual[i]=0;
                    exitos[i]=0;
                }
		
		int s = 1; // Supongo que un alumno siempre empieza en primer año.
		
		while (pasos<1000 || !converge(vectorActual, vectorAnterior)){
			s = proximoAnio (s);
			exitos[s]++;
			pasos++;
			
			for (int i = 0; i < vectorActual.length ; i++){
                                vectorAnterior[i] = vectorActual[i];
				vectorActual[i] = exitos [i]/pasos;
                        }
                        if (s==6 || s==7)
                            s=1;//vuelvo a empezar ya que sino siempre me quedo en el estado egresado
                        
		}
		return vectorActual;
}
    
  public float prob_caso1 (int anios){
      // Probabilidad de que un alumno se reciba en al menos X años.
    this.aniosCaso1=anios;
      float prob_actual =  0;
     float prob_anterior = -1;
     float exitos = 0;
     float intentos = 0;
     
     while (intentos<500 || !Converge (prob_actual,prob_anterior))
     {
         int s = 1;
         int cont = 0;
         while (cont < anios) // no hace falta reiniciar el contador porque una vez que cae en egreso no sale 
         {
           //  System.out.println(s);
             s=proximoAnioSinAbandono (s);
             cont ++;
         }
         
         if (s==6)//6 es egreso
             exitos++;
         intentos++;
         
         prob_anterior=prob_actual;
         prob_actual = exitos/intentos;
     }
     return prob_actual;   
  } 
  
  
  public String mostrarVectorEstacionario (){
      DecimalFormat df = new DecimalFormat("0.0000");
      String result = " ";
           
          
            result += this.vectorMostrar;
            float [] vectorEstacionario = this.vectorEstacionario();
            for (int i= 1; i< vectorEstacionario.length; i++){
               result += "\t";
               result += df.format(vectorEstacionario [i]);}

            
            return result;
  }
  
  
  public boolean Converge(float probActual, float probAnterior) 
	{
		return (Math.abs(probActual-probAnterior) < 0.0001);
	}


  

    public float [] caso2 (int anioIngreso){
     
      ArrayList <Alumno> alumnosIngresantes = new ArrayList <Alumno> ();
      for (Alumno alumno : alumnos)
          if (alumno.getAnioIngreso()==anioIngreso)
              alumnosIngresantes.add(alumno);
     
      int cantidadAlumnos = alumnosIngresantes.size();
      double probAbandono = this.probAbandono;
      int cantidadFinal = (int) (cantidadAlumnos - (cantidadAlumnos*probAbandono));
      
      float [] vectorActual = new float [max] ;
      float [] vectorAnterior = new float [max] ;
      float [] vectorExitos = new float [max];
  
     
     for(int i= 0 ; i< max ; i ++){
        vectorActual[i] = 0; 
        vectorAnterior[i] = -1;
        vectorExitos[i]=0;
      }
     
     int intentos = 0;
 while (!converge (vectorActual,vectorAnterior)){
      
      for (int i = 0; i< cantidadFinal ; i++)
      {
          int pasos = 0;
          int s = 1;
          while (s != 6){
              s = proximoAnioSinAbandono (s);
              pasos ++;  
         } 
         vectorExitos [pasos] ++;
         intentos++;
         
         for(int j= 0 ; j< max ; j ++){
             vectorAnterior[j] = vectorActual[j]; 
             vectorActual[j] = vectorExitos[j]/intentos;
            }
         
       }}                 
            for(int j= 0 ; j< max ; j ++){
            
            vectorActual[j] = vectorActual[j]*cantidadFinal;
            }
            
            int cont =0;
            int pos=0;
            while (cont<cantidadFinal){
                vectorActual[pos]=(float) Math.ceil(vectorActual[pos]);
                cont+= vectorActual[pos];
                pos++;
            }
            
             for(int j= pos ; j< max ; j ++){
 
            vectorActual[j] = 0;
            }
            
    vectorActual [0] = cantidadAlumnos-cantidadFinal;
   return vectorActual;
    }

    public float [] caso22 (int anioIngreso){
      float [] vectorActual = new float [max] ;
      float [] vectorAnterior = new float [max] ;
      float [] vectorExitos = new float [max];
      int intentos = 0;
      ArrayList <Alumno> alumnosIngresantes = new ArrayList <Alumno> ();
      for (Alumno alumno : alumnos)
          if (alumno.getAnioIngreso()==anioIngreso)
              alumnosIngresantes.add(alumno);
      int cantidadAlumnos = alumnosIngresantes.size();
      
      for(int i= 0 ; i< max ; i ++){
        vectorActual[i] = 0; 
        vectorAnterior[i] = -1;
      }
      
      while (!converge (vectorActual,vectorAnterior)){
      
      for (int i = 0; i< cantidadAlumnos ; i++)
      {
          
          int pasos = 0;
          int s = 1;
          while (s != 6){
              s = proximoAnio (s);
              pasos ++;  
         } 
         vectorExitos [pasos] ++;
         intentos++;
         
         for(int j= 0 ; j< max ; j ++){
             vectorAnterior[j] = vectorActual[j]; 
             vectorActual[j] = vectorExitos[j]/intentos;
            }
         
       }  
            
      }
      return  vectorActual; 
    }  
    
    
  public String mostrarCaso2 (int anio){
      String result = " ";
      this.aniosCaso2 = anio;
      ArrayList <Alumno> alumnosIngresantes = new ArrayList <Alumno> ();
      for (Alumno alumno : alumnos)
          if (alumno.getAnioIngreso()==anio)
              alumnosIngresantes.add(alumno);
      
      
      int cantidadAlumnos = alumnosIngresantes.size();
            float [] vectorResultado = this.caso2(anio);

      result += "Total de ingresantes : ";
      result += cantidadAlumnos;
      result += "  Total de abandonos : ";
      result += vectorResultado[0];
 
      result += "\n";
      int anioRecibido = 0;  
            
      for (int i= 1; i< vectorResultado.length; i++){
          if (vectorResultado[i] != 0){
                    
                    anioRecibido = anio + i;
                    result += anioRecibido; 
                    result += "\t";
                }
            }
       result += "\n"; 
       result += " "; 
      for (int i= 1; i< vectorResultado.length; i++){
          if (vectorResultado[i] != 0){
                    
                    result += vectorResultado[i]; 
                    result += "\t";
                }
            }
            
      return result;
  }
      
  public String mostrarCaso3 (int cantidad, int anio){
      String result = " ";
     
     
      float [] vectorResultado = this.caso3(cantidad,anio);
            
      int [] vectorEntero = new int [vectorResultado.length];
      
      for (int i=0;i<vectorResultado.length;i++){
          vectorEntero [i] = (int) (vectorResultado [i]*cantidad);
      }
       
     result += this.vectorMostrar;
     //result += "\n"; 
       result += " "; 
       
       
      for (int i= 1; i< vectorResultado.length; i++){
           result += "\t";
                    
                    result += vectorEntero[i]; 
                   
                
            }
            
      return result;
  }
      
  
  
  
  
  public float [] caso3 (int cantidad, int anios){
      
      //manejarme con probabilidaddes y multipicar por cantidad
      this.aniosCaso3=anios;
      this.cantidadCaso3=cantidad;
      float [] vectorActual = new float [8];
      float [] vectorAnterior = new float [8];
      float [] vectorExitos = new float [8];
      
      for (int i=0;i<8;i++){
          vectorActual[i]=0;
          vectorAnterior[i]=-1;
          vectorExitos[i]=0;
      }
      
      vectorActual[0]=-1;
      
      int intentos = 0;
      int s;
      int pasos;
      
      while (intentos < 100 || !converge (vectorActual,vectorAnterior)){
          for (int i=0; i<cantidad; i++){
              s=1;
              pasos=0;
              while (pasos<anios){
                  s=proximoAnio(s);
                  pasos++;
              }
             vectorExitos[s]++;     
          
          intentos++;
         for (int j=0;j<8;j++){
                    vectorAnterior[j]=vectorActual[j];
                    vectorActual[j]=vectorExitos[j]/intentos;
                    
                }
          
          }
      }
      
     return vectorActual; 
        
  }
  


 
       
    public void GuardarArchivo() throws IOException {
       String f = " ";
       JFileChooser chooser = new JFileChooser();
       chooser.setCurrentDirectory(new File(""));
       
       f+="VECTOR ESTACIONARIO ";
       f+="\n";
       f+=this.mostrarVectorEstacionario();
       f+="\n";
       f+="\n";
       
       f+="PROBABILIDAD DE QUE UN ALUMNO SE RECIBA EN AL MENOS  ";
       f+= this.aniosCaso1;
       f+= " ES DE : ";
       f+= this.resultadoCaso1;
       f+="\n";
       f+="\n";
       f+="LOS ALUMNOS INGRESANTES DEL AÑO ";
       f+= this.aniosCaso2;
       f+=" SE RECIBIRAN CON LA SIGUIENTE DISTRIBUCION :";
       f+="\n";
       f+= this.mostrarCaso2(aniosCaso2);
       f+="\n";
       f+="\n";
       f+="EN LOS PROXIMOS ";
       f+=this.aniosCaso3;
       f+=" AÑOS ";
       f+=this.cantidadCaso3;
       f+=" ESTARAN DISTRUBUIDOS DE LA SIGUIENTE FORMA: ";
       f+="\n";
       f+= this.mostrarCaso3(this.cantidadCaso3, this.aniosCaso3);
       
       
       
             
        int retrival = chooser.showSaveDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {
        try {
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(chooser.getSelectedFile()+".csv");
            fileWriter.append(f);
            fileWriter.flush();
            fileWriter.close();
            JOptionPane.showMessageDialog(null, "GUARDADO CON EXITO!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }          
            

    }
      
        
    }  

