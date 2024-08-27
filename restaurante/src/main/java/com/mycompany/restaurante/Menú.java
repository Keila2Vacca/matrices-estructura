
package com.mycompany.restaurante;

import javax.swing.JOptionPane;


public class Menú {
    
    int datos[][];
    String dias[];
    Platos arrayObjetos[];
    
   
    public void createMenu (int cantidad){
        arrayObjetos = new Platos[cantidad];
        
        Platos obj = new Platos();
        
        int i = 0;
        while(i < cantidad){
            obj.setName(JOptionPane.showInputDialog("Diga el nombre del plato: " ));
            obj.setPrice(Integer.parseInt(JOptionPane.showInputDialog("Diga el precio del plato: " )));
            
            arrayObjetos[i] = obj;
        }
    }
    
    public void searchMenu(){
        
        for (int i = 0; i < arrayObjetos.length; i++) {
           JOptionPane.showMessageDialog(null, "Platos: " + arrayObjetos[i].getName()); 
        }    
    }
    
   public void intoDatos(){
      datos = new int[6][platos.length]; 
      dias = new String []{"Lunes", "Martes","Miércoles","Jueves","Viernes","Sábado"};
       for (int dia = 0; dia < 6; dia++) {
           for (int plato = 0; plato < platos.length; plato++) {
               datos[dia][plato] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ventas para el día: " + dias[dia] + "Plato: " + platos[platos]));
           }
       }
   }
}
