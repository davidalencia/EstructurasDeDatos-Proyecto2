package mx.unam.ciencias.edd.proyecto2;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import  mx.unam.ciencias.edd.proyecto2.svg.Atributo;

public class AtributoTest{
    @Test
    public void equals(){
        Atributo a = new Atributo("attr");
        assertFalse(a.equals("hola"));
        assertFalse(a.equals("attr"));
        assertTrue(a.equals(new Atributo("attr")));
        assertTrue(a.equals(new Atributo("attr", "hola")));
        assertFalse(a.equals(new Atributo("attrr", "hola")));

        Atributo b = new Atributo("attr");
        assertTrue(a.equals(b));
        b.setValor("hola");
        assertTrue(a.equals(b));
    }
}
