package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.*;
import mx.unam.ciencias.edd.proyecto2.svg.*;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;


public class App{
    public static void main(String[] args ){

      Colecciones tipoC=null;
      String tipo = null;
      toSVG estructura = null;
      Lista<String> raw = new Lista<>();
      Lista<Integer> entradas = new Lista<>();

      //leer
      try{
        //leer archivos
        for (String arg: args)
          IOUtils.cargaAColeccion(new FileReader(arg), raw);
        //leer entrada estandar
        IOUtils.cargaAColeccion(new InputStreamReader(System.in), raw);
      }catch (IOException e) {
        IOUtils.error();
      }

      try{
        for (String s: raw)
          if (s.indexOf("#")==-1)
            for (String a : s.trim().split(" "))
              if(tipo!=null)
                entradas.agrega(Integer.parseInt(a));
              else
                tipo = a;
        tipoC = Colecciones.valueOf(tipo);
      }catch (NumberFormatException e) {
        IOUtils.error("Error en el formato");
      }

      switch (tipoC) {
        case ArbolAVL:
          estructura = new ArbolAVLSVG<>();
          break;
        case ArbolBinarioCompleto:
          estructura = new ArbolBinarioCompletoSVG<>();
          break;
        case ArbolBinarioOrdenado:
          estructura = new ArbolBinarioOrdenadoSVG<>();
          break;
        case ArbolRojinegro:
          estructura = new ArbolRojinegroSVG<>();
          break;
        case Cola:
          estructura = new ColaSVG<>();
          break;
        case Grafica:
          break;
        case Lista:
          estructura = new ListaSVG<>();
          break;
        case MonticuloArreglo:
          break;
        case MonticuloMinimo:
          break;
        case Pila:
          estructura = new PilaSVG<>();
          break;
      }

      for (Integer i: entradas)
        estructura.agrega(i);

      System.out.println(estructura.toSVG());
    }
}
