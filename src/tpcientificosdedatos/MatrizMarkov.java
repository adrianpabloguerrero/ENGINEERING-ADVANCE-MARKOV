/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tpcientificosdedatos;


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
 * @author User
 */
public class MatrizMarkov {
    static final int AniosCarrera = 8; //(0-6) 6 es egreso;
    private double[][] matrizMarkov; 
    private double [][] matrizConjunta;
    private double [][] matrizConjuntaSinAbandono;
    private double [][] matrizMarkovSinAbandono;
    String matrizMostrar = "AÑOS\tPRIMERO\tSEGUNDO\tTERCERO\tCUARTO\tQUINTO\tEGRESO\tABANDONO\n";
    ArrayList <Alumno> alumnos = new ArrayList <Alumno> ();
    int parametroAnio;
    int parametroAbandono;
    Analisis analisis;
    double probAbandono;
    private ArrayList <Alumno> abandonos = new ArrayList <Alumno> ();
    
    
    
    //                   1 2 3 4 5 E A
    //años desde ingreso
    
    public MatrizMarkov(ArrayList <Alumno> alumnos, int parametroAnio, int parametroAbandono) throws ParseException{
        this.matrizMarkov = new double [AniosCarrera][AniosCarrera];
        this.matrizConjunta = new double [AniosCarrera][AniosCarrera];
        this.matrizConjuntaSinAbandono = new double [7][7];
        this.matrizMarkovSinAbandono = new double [7][7];
        for (int x=0; x < this.matrizMarkov.length; x++) {
            for (int y=0; y < this.matrizMarkov[x].length; y++) {
                this.matrizMarkov[x][y] = 0;
                this.matrizConjunta [x][y] = 0;
               
            }
        }
        for (int x=0; x < this.matrizMarkovSinAbandono.length; x++) {
            for (int y=0; y < this.matrizMarkovSinAbandono[x].length; y++) {
                this.matrizConjuntaSinAbandono [x][y]=0;
                this.matrizMarkovSinAbandono[x][y]=0;
            }}
        this.parametroAnio = parametroAnio;
        this.parametroAbandono = parametroAbandono;
        this.alumnos=alumnos;
        calcularConjunta();
        calcularYdadoX ();
        calcularConjuntaSinAbandono();
        calcularYdadoXSinAbandono();
        
        this.analisis = new Analisis (this.matrizMarkov,this.matrizMarkovSinAbandono,this.probAbandono,this.alumnos);
    }
    
    public Analisis getAnalisis (){
        return this.analisis;
    }
    
    
    
     public void copiarMatriz (double [][] matrizOrigen , double [][] matrizDestino){
         for (int i = 0; i < matrizDestino.length; i++) {
			for (int j = 0; j < matrizDestino[i].length; j++) {
				matrizDestino[i][j]=matrizOrigen[i][j];
			}
		}
        
    }
    
     
     public double [][] getMatrizMarkov (){
         return this.matrizMarkov;
     }
     
     
     
    public void calcularYdadoX() {
		
                copiarMatriz (matrizConjunta,matrizMarkov);
		double [] marginalX = new double [matrizMarkov.length];
                
                for (int i = 0; i<marginalX.length; i++ )
                    marginalX[i]=0;
                
                for (int i = 0; i < matrizMarkov.length; i++) {
			for (int j = 0; j < matrizMarkov[i].length; j++) {
				marginalX[j]+=matrizMarkov[i][j];
			}
		}
                
		for (int i = 0; i < matrizMarkov.length; i++) {
			for (int j = 0; j < matrizMarkov[i].length; j++) {
				if (matrizMarkov[i][j]!=0)
					matrizMarkov[i][j]= (matrizMarkov[i][j]/marginalX[j]);
			}
		}
                
	}
    
    
    

    
    
     private void calcularConjunta () throws ParseException {
       System.out.println("alumnos matriz:" + alumnos.size());
        Date hoy = new Date();
        int anioX = this.parametroAnio;//2010
        int anioY = anioX+1;//2011
        double iteraciones = 0;
        int alumnosPrimero = 0;
        int alumnosSegundo = 0;
        int abandonos = 0;
        
        while (anioX < hoy.getYear()+1900){//2018
            
            for (Alumno alumno : alumnos){
                if (anioX > alumno.getAnioIngreso() ){
                //    System.out.println ("Ingreso" + alumno.getAnioIngreso()+ "parametro" + this.parametroAnio);
                if (!alumno.abandono(anioX,this.parametroAbandono))
                    {
                    matrizConjunta [alumno.calcularAnio(anioY)][alumno.calcularAnio(anioX)]++;
                   // System.out.println("alumno: "+ alumno.getLegajo() + " En el año " + anioX + "estoy en " + alumno.calcularAnio(anioX) + " En el anio " + anioY + " estoy en " + alumno.calcularAnio(anioY) );
                   
                    iteraciones++;
                     } else if (!alumno.seRecibio(anioX)) {
                         boolean x = false;
                         sumarAbandono (alumno,anioX,x);
                         if (!x){
                             matrizConjunta[7][7]++;}
                         iteraciones++;
                        
                     }
            }  }  
            anioX++;
            anioY++;
        }
        
      
        for (int x=0; x < matrizConjunta.length; x++) {
            for (int y=0; y < matrizConjunta[x].length; y++) {
                matrizConjunta[x][y] = matrizConjunta [x][y] / iteraciones;
            }
        }
        System.out.println("Total abandonados: " + this.abandonos.size());

      this.probAbandono=(double) this.abandonos.size()/ (double) alumnos.size();
        
    }
    
     
     public double getProbAbandono (){
         return this.probAbandono;
     }
     
      private void calcularConjuntaSinAbandono () throws ParseException {
       //System.out.println("alumnos matriz:" + alumnos.size());
        Date hoy = new Date();
        int anioX = this.parametroAnio;//2010
        int anioY = anioX+1;//2011
        double iteraciones = 0;
        int alumnosPrimero = 0;
        int alumnosSegundo = 0;
        int abandonos = 0;
        
        while (anioX < hoy.getYear()+1900){//2018
            
            for (Alumno alumno : alumnos){
                if (anioX > alumno.getAnioIngreso() ){
                //    System.out.println ("Ingreso" + alumno.getAnioIngreso()+ "parametro" + this.parametroAnio);
                if (!alumno.abandono(anioX,this.parametroAbandono))
                    {
                    matrizConjuntaSinAbandono [alumno.calcularAnio(anioY)][alumno.calcularAnio(anioX)]++;
                   // System.out.println("alumno: "+ alumno.getLegajo() + " En el año " + anioX + "estoy en " + alumno.calcularAnio(anioX) + " En el anio " + anioY + " estoy en " + alumno.calcularAnio(anioY) );
                   
                    iteraciones++;
                     } 
            }  }  
            anioX++;
            anioY++;
        }
        
      
        for (int x=0; x < matrizConjuntaSinAbandono.length; x++) {
            for (int y=0; y < matrizConjuntaSinAbandono[x].length; y++) {
                matrizConjuntaSinAbandono[x][y] = matrizConjuntaSinAbandono [x][y] / iteraciones;
            }
        }
        System.out.println("Total abandonados: " + this.abandonos.size());
        
    }
      
      public void calcularYdadoXSinAbandono() {
		
                copiarMatriz (matrizConjuntaSinAbandono,matrizMarkovSinAbandono);
		double [] marginalX = new double [matrizMarkovSinAbandono.length];
                
                for (int i = 0; i<marginalX.length; i++ )
                    marginalX[i]=0;
                
                for (int i = 0; i < matrizMarkovSinAbandono.length; i++) {
			for (int j = 0; j < matrizMarkovSinAbandono[i].length; j++) {
				marginalX[j]+=matrizMarkovSinAbandono[i][j];
			}
		}
                
		for (int i = 0; i < matrizMarkovSinAbandono.length; i++) {
			for (int j = 0; j < matrizMarkovSinAbandono[i].length; j++) {
				if (matrizMarkovSinAbandono[i][j]!=0)
					matrizMarkovSinAbandono[i][j]= (matrizMarkovSinAbandono[i][j]/marginalX[j]);
			}
		}
                
	}
    
    
    
    
    public int getCantFilas(){
        return this.matrizMarkov.length;
    }
    public int getCantColumnas(){
        return this.matrizMarkov[0].length;
    }
    
    public void sumar(int fila, int columna){
        this.matrizMarkov[fila-1][columna-1]++;
    }
    public void sumarEgreso(int fila){
        int col = 5;
        this.matrizMarkov[fila-1][col]++;
    }
    
    public void sumarAbandono(int fila){
        int col = 6;
        this.matrizMarkov[fila-1][col]++;
    }
    
    
    private String getAnioFila (int anioI){
       String anioS = " ";
       
       switch (anioI){
           case 1:
               anioS = "PRIMERO";
               break;
           case 2:
                anioS = "SEGUNDO";
                break;
           case 3: 
                anioS = "TERCERO";
                break;
           case 4:
               anioS = "CUARTO";
               break;
           case 5: 
               anioS = "QUINTO";
               break;
           case 6:
               anioS = "EGRESO";
               break;
           case 7:
               anioS = "ABANDONO";
       }
        return anioS;
    }
    
    
    public String imprimirMatriz(){
         DecimalFormat df = new DecimalFormat("0.0000");
            
         String matrizResult = "";
         matrizResult += "MATRIZ DE MARKOV";
         matrizResult += "\n";
         matrizResult += this.matrizMostrar;
             
            for (int x=1; x < this.matrizMarkov.length; x++) {
                matrizResult += getAnioFila(x); 
                matrizResult += "\t";
                for (int y=1; y < this.matrizMarkov[1].length; y++) {
                    matrizResult += (df.format(this.matrizMarkov[x][y]));
                   
                   if(y<this.matrizMarkov[1].length-1){
                        matrizResult += "\t";
                   }
                }
                  matrizResult += "\n";
         
            }
            
          matrizResult += "\n";
          
            return matrizResult;
    }
   
    
    
    public String getMatrizMostrar() throws IOException{
        String aux = this.imprimirMatriz();
        return aux;
    }
    
   
    
    public void GuardarArchivo() throws IOException {
        String f = this.imprimirMatriz();
       JFileChooser chooser = new JFileChooser();
       chooser.setCurrentDirectory(new File(""));
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

    private void sumarAbandono(Alumno alumno,int anioX,boolean x) throws ParseException {
    
        boolean existe = false;
        
        
            for (Alumno aux : this.abandonos)
            {
                if (aux.getLegajo()==alumno.getLegajo())
                    existe=true;
            }
            
       if (!existe){
           abandonos.add(alumno);
           this.matrizConjunta [7][alumno.calcularAnio(anioX)]++;
           x=true;
                   }
                    
                               
        }
      
        
    
    
    
    
    
}
