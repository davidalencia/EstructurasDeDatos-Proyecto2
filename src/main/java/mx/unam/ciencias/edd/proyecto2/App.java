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
            estructura = new ArbolAVLSVG<>(entradas);
            break;
          case ArbolBinarioCompleto:
            estructura = new ArbolBinarioCompletoSVG<>(entradas);
            break;
          case ArbolBinarioOrdenado:
            estructura = new ArbolBinarioOrdenadoSVG<>(entradas);
            break;
          case ArbolRojinegro:
            estructura = new ArbolRojinegroSVG<>(entradas);
            break;
          case Cola:
            estructura = new ColaSVG<>(entradas);
            break;
          case Grafica:
            estructura = new GraficaSVG<>(entradas);
            break;
          case Lista:
            estructura = new ListaSVG<>(entradas);
            break;
          case MonticuloArreglo:
            break;
          case MonticuloMinimo:
            Lista<ValorIndexable<Integer>> cambio = new Lista<>();
            for (Integer i: entradas)
              cambio.agrega(new ValorIndexable<Integer>(i, i));
            estructura = new MonticuloMinimoSVG<ValorIndexable<Integer>>(cambio);
            break;
          case Pila:
            estructura = new PilaSVG<>(entradas);
            break;
        }
      }catch (Exception e) {
        IOUtils.error("Error en el formato");
      }

      //transformación a svg
      System.out.println(estructura.toSVG());
    }
}
