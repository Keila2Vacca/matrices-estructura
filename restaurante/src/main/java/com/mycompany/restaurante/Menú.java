package com.mycompany.restaurante;

import javax.swing.JOptionPane;

public class Menú {

    int datos[][];
    String dias[];
    Platos arrayObjetos[];

    public void createMenu(int cantidad) {
        arrayObjetos = new Platos[cantidad];

        Platos obj = new Platos();

        int i = 0;
        while (i < cantidad) {
            obj.setName(JOptionPane.showInputDialog("Diga el nombre del plato: "));
            obj.setPrice(validateIntInput(JOptionPane.showInputDialog("Diga el precio del plato: ")));
            obj.setBasePrice(validateIntInput(JOptionPane.showInputDialog("Diga el precio base del plato: ")));
           
            arrayObjetos[i] = obj;
        }
    }

    public String searchMenu() {
        String menuString = "Menú: \n";

        for (Platos arrayObjeto : arrayObjetos) {
            JOptionPane.showMessageDialog(null, "Platos: " + arrayObjeto.getName());
        }
        menuString += "Este menú cuenta con " + arrayObjetos.length + " plato(s)";
        return menuString;
    }

    public void intoDatos() {
        datos = new int[6][arrayObjetos.length];
        dias = new String[]{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
        for (int dia = 0; dia < 6; dia++) {
            for (int plato = 0; plato < arrayObjetos.length; plato++) {
                datos[dia][plato] = validateIntInput(JOptionPane.showInputDialog(null, "Ventas para el día: " + dias[dia] + "Plato: " + arrayObjetos[plato].getName()));
            }
        }
    }

    public void analyzeInfo() {
        int gananciaTotal = 0;
        int gananciaReal = 0;
        String returnString = "";
        int[] ventasDia = new int[6];
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado"};
        for (int plato = 0; plato < arrayObjetos.length; plato++) {
            for (int dia = 0; dia < 6; dia++) {
                ventasDia[dia] += datos[dia][plato];
                gananciaTotal += (datos[dia][plato] * arrayObjetos[plato].getPrice());
                gananciaReal += (datos[dia][plato] * arrayObjetos[plato].getBasePrice());
            }
        }

        int[] ventasPlato = new int[arrayObjetos.length];
        for (int plato = 0; plato < arrayObjetos.length; plato++) {
            for (int dia = 0; dia < 6; dia++) {
                ventasPlato[plato] += datos[dia][plato];
            }
        }

        int platosVendidos = sumValues(ventasDia);
        returnString += "-- Información General --\n";
        returnString += "· Platos vendidos en la semana: " + platosVendidos + "\n";
        returnString += "· Ganancia total: $" + gananciaTotal + "\n";
        returnString += "· Ganancia real: $" + gananciaReal + "\n";

        
        String promedioPlatos = String.format("%.1f", (double) platosVendidos / dias.length);
        returnString += "· Promedio de platos vendidos cada día: " + promedioPlatos + "\n";

     
        returnString += "· Día más vendido: " + dias[findMaxIndex(ventasDia)] + " con " + ventasDia[findMaxIndex(ventasDia)] + " ventas\n";

        returnString += "· Día menos vendido: " + dias[findMinIndex(ventasDia)] + " con " + ventasDia[findMinIndex(ventasDia)] + " ventas\n";

       
        returnString += "· El plato más vendido fue: " + arrayObjetos[findMaxIndex(ventasPlato)].getName() + " con " + ventasPlato[findMaxIndex(ventasPlato)] + " ventas esta semana" + "\n";

     
        returnString += "· El plato menos vendido fue: " + arrayObjetos[findMinIndex(ventasPlato)].getName() + " con " + ventasPlato[findMinIndex(ventasPlato)] + " ventas esta semana" + "\n\n";
        
       
    }
    

    private int findMaxIndex(int[] array) {
        int maxIndex = 0;
        int maxNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if (maxNumber == 0) {
                maxNumber = array[i];
                maxIndex = i;
            }
            if (maxNumber < array[i]) {
                maxNumber = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private int findMinIndex(int[] array) {
        int minIndex = 0;
        int minNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if (minNumber == 0) {
                minNumber = array[i];
                minIndex = i;
            }
            if (minNumber > array[i]) {
                minNumber = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private int sumValues(int[] array) {
        int total = 0;
        for (int value : array) {
            total += value;
        }
        return total;
    }

    private int validateIntInput(String str) {
        while (isNumber(str) == false) {
            str = JOptionPane.showInputDialog("Ingrese un número ENTERO válido (sin espacios):");
        }
        return Integer.parseInt(str);
    }

    private static boolean isNumber(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
