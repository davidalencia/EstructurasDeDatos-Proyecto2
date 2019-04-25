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

      //analisis de entrada
      try{
        for (String s: raw)
          if (s.indexOf("#")==-1)
            for (String a : s.trim().split(" "))
              if(tipo!=null)
                entradas.agrega(Integer.parseInt(a));
              else
                tipo = a;
        tipoC = Colecciones.valueOf(tipo);

        //tipo de estructura
        switch (tipoC) {
          case ArbolAVL:
            estructura = new ArbolAVLSVG<Integer>(entradas);
            break;
          case ArbolBinarioCompleto:
            estructura = new ArbolBinarioCompletoSVG<Integer>(entradas);
            break;
          case ArbolBinarioOrdenado:
            estructura = new ArbolBinarioOrdenadoSVG<Integer>(entradas);
            break;
          case ArbolRojinegro:
            estructura = new ArbolRojinegroSVG<Integer>(entradas);
            break;
          case Cola:
            estructura = new ColaSVG<Integer>(entradas);
            break;
          case Grafica:
            estructura = new GraficaSVG<Integer>(entradas);
            break;
          case Lista:
            estructura = new ListaSVG<Integer>(entradas);
            break;
          case MonticuloArreglo:
            Lista<ValorIndexable<Integer>> cambio1 = new Lista<>();
            for (Integer i: entradas)
              cambio1.agrega(new ValorIndexable<Integer>(i, i));
            estructura = new MonticuloArregloSVG<ValorIndexable<Integer>>(cambio1);
            break;
          case MonticuloMinimo:
            Lista<ValorIndexable<Integer>> cambio2 = new Lista<>();
            for (Integer i: entradas)
              cambio2.agrega(new ValorIndexable<Integer>(i, i));
            estructura = new MonticuloMinimoSVG<ValorIndexable<Integer>>(cambio2);
            break;
          case Pila:
            estructura = new PilaSVG<Integer>(entradas);
            break;
        }
      }catch (Exception e) {
        IOUtils.error("Error en el formato");
      }

      //transformación a svg
      System.out.println(estructura.toSVG());
    }
}
