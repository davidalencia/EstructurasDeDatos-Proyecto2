package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.*;
import mx.unam.ciencias.edd.proyecto2.svg.*;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;


public class App{
    public static void main(String[] args ){

      Lista<String> raw = new Lista<>();
      Lista<String> entradas = new Lista<>();

      //leer
      try{
        //leer archivos
        for (String arg: args)
          IOUtils.cargaAColeccion(new FileReader(arg), raw);
        //leer entrada estandar
        IOUtils.cargaAColeccion(new InputStreamReader(System.in), raw);
      }catch (IOException e) {
        System.out.println("Algo ha fallado."+
        "\nPor favor asegurese de que todos los archivos existan.");
        return;
      }

      for (String s: raw)
        if (s.indexOf("#")==-1)
          for (String a : s.trim().split(" "))
              entradas.agrega(a);

      String tipo = entradas.getPrimero();
      entradas.eliminaPrimero();
      Colecciones tipoC = Colecciones.valueOf(tipo);

      toSVG estructura;
      estructura = new ArbolAVLSVG<>();
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
        //Arreglos,
        case Cola:
          break;
        case Grafica:
          break;
        case Lista:
          break;
        case Pila:
          break;
        //case MonticuloMinimo
        //  break;
      }

      for (String s: entradas)
        estructura.agrega(Integer.parseInt(s));
      System.out.println(estructura.toSVG());
    }
}
