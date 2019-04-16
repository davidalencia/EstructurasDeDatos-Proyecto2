package mx.unam.ciencias.edd.proyecto2;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import  mx.unam.ciencias.edd.proyecto2.svg.SVG;
import  mx.unam.ciencias.edd.proyecto2.svg.Atributo;


public class SVGTest{
    @Test
    public void toStringTest(){
        String s;
        SVG svg = new SVG("svg");
        s ="<svg>\n</svg>";
        assertTrue(svg.toString().equals(s));

        svg.setAtributo("width", "200");
        svg.setAtributo(new Atributo("height","201"));
        assertTrue(svg.getAtributo("width").getValor().equals("200"));
        assertTrue(svg.getAtributo("height").getValor().equals("201"));
        s="<svg width='200' height='201'>\n</svg>";
        assertTrue(svg.toString().equals(s));

        svg.setContenido("contenido");
        assertTrue(svg.getContenido().equals("contenido"));
        svg.setContenido("otro contenido");
        assertFalse(svg.getContenido().equals("contenido"));
        assertTrue(svg.getContenido().equals("otro contenido"));
        s="<svg width='200' height='201'>\notro contenido\n</svg>";
        assertTrue(svg.toString().equals(s));
    }
}
