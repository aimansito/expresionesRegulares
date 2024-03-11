/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author aiman
 */
public class Main {
    public static void main(String[] args) {
        //todos los archivos que están en la raiz del proyecto
        //son accesibles directamente son su nombre
        List<String> lineasFichero ;
        String ficheros = "ssh_config";
        System.out.println("Leyendo el fichero: "+ficheros);
        lineasFichero = leerFichero(ficheros);
//        
//            //Mostrar numeros  de  palabras por linea
//        lineasFichero.forEach(linea->{;int numerosPalabras = contarPalabrasPorLinea(linea);
//            System.out.println(linea+"-->"+numerosPalabras);
//        });
        
        lineasFichero.forEach(linea->{;int numerosPalabras = contarPalabraConcretaPorLinea("IS",linea);
            System.out.println(linea+"-->"+numerosPalabras);
        });
        
    }
    public static int contarPalabraConcretaPorLinea(String palabra,String linea){
        //expresion regular
        String regex = "\\b"+palabra+"\\b";
        //la clase patern crea un objeto con la representación 
        //compilada o procesada de la expresion regular 
        //permite crear un objeto matcherpattern + regex (String)
        Pattern patron = Pattern.compile(regex);
        //Matcher se cra a part del objeto pattern 
        //permite hacer operaciones usando el regex el string pasado 
        //matches() si cumple el patron
        //find
        //encontrar dl string que cumplan el patron
        Matcher busqueda = patron.matcher(linea);
        int contador = 0;
        while(busqueda.find()){
            contador++;
        }
        return contador;
    }
    
    
    public static int contarPalabrasPorLinea(String linea){
        // En ajva para escapar la barra invertida hay que añadir otra
        // barra adicional 
        linea = linea.trim();
        String[] array = linea.split("\\s+");
        
        return array.length;
    }
    //Mostrar numeros  de  palabras por linea
    
    
    //metodo para leer un fichero de texto plano
    //usa la clase files 
    public static List<String> leerFichero(String nombreFichero){
        List<String> lista = new ArrayList<>();
        try{
            Files.readAllLines(Paths.get(nombreFichero));
        }catch(IOException ex){
            System.out.println("Error");
        }
        
        return lista;
    }
}
