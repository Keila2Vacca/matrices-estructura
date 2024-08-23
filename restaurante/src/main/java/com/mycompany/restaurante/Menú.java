
package com.mycompany.restaurante;

import javax.swing.JOptionPane;


public class Menú {
    String platos[];
    int datos[][];
    String dias[] = new String []{"Lunes", "Martes","Miércoles","Jueves","Viernes","Sábado"};
    
    /*que aparesca un listado de analítica con: cantidad de tipo de platos vendidos a la semana, dia de la semana que más y menos se vendió de ese plato,
    dia de la semana que más y menos se vende y 5 estadísticas adicionales.
    */
    
    public void createMenu (int cantidad){
        platos = new String[cantidad];
        int i = 0;
        while(i < cantidad){
            platos[i] = JOptionPane.showInputDialog("Diga el nombre del plato: " + (i+1));
            i++;
        }
    }
    
    public void searchMenu(){
        
        for (int i = 0; i < platos.length; i++) {
           JOptionPane.showMessageDialog(null, "Platos: " + platos[i]); 
        }    
    }
    
   public void intoDatos(){
      datos = new int[6][platos.length]; 
       for (int f = 0; f < 6; f++) {
           for (int c = 0; c < platos.length; c++) {
               datos[f][c] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ventas para el día: " + f + "Plato: " + platos[c]));
           }
       }
   }
}
