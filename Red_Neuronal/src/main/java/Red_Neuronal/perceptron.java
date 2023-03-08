
package Red_Neuronal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class perceptron {
     double temp_amb;
    double temp_corp;
    double coor;
    double resp_por_min;
    double lts_por_dia;
    double kgs_por_dia;
    double edad;
    double peso;
    ArrayList <Double> entradas =  new ArrayList(); 
    ArrayList <Double> entradas_nor = new ArrayList(); 
    double [][][] pesos;//Los pesos serán arreglos multidimensionales. Así: W[capa, neurona inicial, neurona final],
    double [][] umbral; //Los umbrales de cada neurona serán arreglos bidimensionales. Así: U[capa, neurona que produce la salida]
    double [][] salida; //Las salidas de cada neurona serán arreglos bidimensionales. Así: A[capa, neurona que produce la salida] 
    //double[][][] nuevos_pesos;//Los nuevos pesos serán arreglos multidimensionales. Así: W[capa, neurona inicial, neurona final]
    //double[][] nuevos_umbrales; //Los nuevos umbrales de cada neurona serán arreglos bidimensionales. Así: U[capa, neurona que produce la salida]
    int TotalCapas; //El total de capas que tendrá el perceptrón incluyendo la capa de entrada
    int[] neuronasporcapa; //Cuantas neuronas habrá en cada capa
    int TotalEntradas; //Total de entradas externas del perceptrón
    int TotalSalidas; //Total salidas externas del perceptrón
    double minimoX;
    double maximoX;

        
    public String ingresar_entradas(){
        entradas.add(temp_amb);
        entradas.add(resp_por_min);
        entradas.add(temp_corp);        
        entradas.add(coor);
        entradas.add(edad); 
        entradas.add(peso);         
        entradas.add(kgs_por_dia);                
        entradas.add(lts_por_dia);
        
        Perceptron();
        leer_pesos(); 
        leer_umbrales(); 
        normalizar();        
        procesa();        
        return calcular_resultado();
        
       
    }
    
    private void leer_pesos(){

        BufferedReader acu2;
        try{
            File archivo=new File("C:\\Users\\lucas\\OneDrive\\Documentos\\NetBeansProjects\\JavaSQL\\src\\main\\java\\sql\\javasql\\pesos.txt");
            FileReader pesos_leidos= new FileReader(archivo);
            acu2=new BufferedReader(pesos_leidos);                        
            for (int capa = 2; capa <= TotalCapas; capa++){
                for (int neurona = 1; neurona <= neuronasporcapa[capa]; neurona++) {
                    for (int entra = 1; entra <= neuronasporcapa[capa - 1]; entra++){                                                             
                        String lectura_pesos= acu2.readLine();                
                        double y;
                        y=Double.parseDouble(lectura_pesos);  
                        pesos[capa-1][entra][neurona]= y;                        
                    }                         
                } 
            }
        }
        catch(IOException ex){
            System.err.println("error "+ex.getMessage());                   
        }      
    }
    
    
    private void leer_umbrales(){
        
        BufferedReader acu2;
        try{
            File archivo=new File("C:\\Users\\lucas\\OneDrive\\Documentos\\NetBeansProjects\\JavaSQL\\src\\main\\java\\sql\\javasql\\umbrales.txt");
            FileReader umbrales_leidos= new FileReader(archivo);
            acu2=new BufferedReader(umbrales_leidos);            
            
            for (int capa = 2; capa <= TotalCapas; capa++){
                for (int i = 1; i <= neuronasporcapa[capa]; i++){
                    String lectura_pesos= acu2.readLine();                
                    double y;
                    y=Double.parseDouble(lectura_pesos);
                    umbral[capa][i] = y;
                }
            }
        }
        catch(IOException ex){
            System.err.println("error "+ex.getMessage());                   
        }      
    }
    
    
    private void Perceptron() {
            this.TotalEntradas = 8;
            this.TotalSalidas = 1;
            this.TotalCapas = 4;
            int maxNeuronas = 0; //Detecta el máximo número de neuronas por capa para dimensionar los arreglos
            this.neuronasporcapa = new int[TotalCapas + 1];
            for (int capa = 1; capa <= TotalCapas; capa++) {
                this.neuronasporcapa[capa] = neuronasporcapa[capa];
                if (neuronasporcapa[capa] > maxNeuronas){ 
                    maxNeuronas = neuronasporcapa[capa];
                }   
            }
            maxNeuronas = 8;
            neuronasporcapa[1] = TotalEntradas; //Entradas externas del perceptrón
            neuronasporcapa[2] = 6; //Capa oculta con 4 neuronas
            neuronasporcapa[3] = 6; //Capa oculta con 4 neuronas
            neuronasporcapa[4] = TotalSalidas; //Capa de salida con 1 neurona
            
        //Dimensiona con el máximo valor
            pesos = new double[TotalCapas + 1][maxNeuronas + 1][maxNeuronas + 1];            
            umbral = new double[TotalCapas + 1][maxNeuronas + 1];                        
            salida = new double[TotalCapas + 1][maxNeuronas + 1];
    }
    
    
    private void normalizar(){
        //Normaliza los valores entre 0 y 1 que es lo que requiere el perceptrón
        minimoX = entradas.get(0);
        maximoX = entradas.get(0);
        for (int j = 0; j < TotalEntradas; j++) {
            if (entradas.get(j) > maximoX) 
                maximoX = entradas.get(j);
            if (entradas.get(j) < minimoX) 
            minimoX = entradas.get(j);
        }  
        
        for (int j = 0; j < TotalEntradas; j++) {
            double x=entradas.get(j);
            x =(entradas.get(j) - minimoX) / (maximoX - minimoX);
            entradas_nor.add(x);
         }       
    }
    
    
    private void procesa(){        
        //Entradas externas del perceptrón pasan a la salida de la primera capa
        for (int copia = 1; copia < TotalEntradas; copia++){            
            salida[1][copia] = entradas_nor.get(copia);                
        }
        for (int copia = 1; copia < neuronasporcapa[2]; copia++){

        }
        //Proceso del perceptrón
        for (int capa = 2; capa <= TotalCapas; capa++){
            for (int neurona = 1; neurona <= neuronasporcapa[capa]; neurona++) {
                salida[capa][neurona] = 0;
                for (int entra = 1; entra <= neuronasporcapa[capa - 1]; entra++){
                    //System.out.println("CAPA "+capa+" - "+"NEURONA "+neurona+" - "+"SALIDA ANTERIOR "+salida[capa - 1][entra]+" - "+"PESO "+pesos[capa - 1][entra][neurona]+" - "+"SALIDA "+salida[capa][neurona]);
                    salida[capa][neurona] += salida[capa - 1][entra] * pesos[capa - 1][entra][neurona];                                         
                }                
                salida[capa][neurona] += umbral[capa][neurona];
                salida[capa][neurona] = 1 / (1 + Math.exp(-salida[capa][neurona]));                
            }
        }
    }
    
    
    
    private String calcular_resultado(){      
        System.out.println("SALIDA FINAL: "+salida[TotalCapas][1]);
        System.out.println(( 4.0 - 1.0)+1.0);
        double y=salida[TotalCapas][1]*( 4.0 - 1.0)+1.0; 
        System.out.println("SALIDA NORMALIZADA: "+y);
        long x=Math.round(y);
        System.out.println("SALIDA FINAL: "+x);
        if (x!=1) 
            if (x==2)
                return "espongiforme bivona";
            else if(x==3)
                return "agitacion";
            else
                return "no hay enfermedad"; 
        else return "fiebre aftosa";
    }                    
}