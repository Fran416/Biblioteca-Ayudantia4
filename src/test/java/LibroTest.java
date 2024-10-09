import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LibroTest {

    Libro libro01 = new Libro("10001","Don quijote de la mancha", "Miguel de cervantes", "Fantasia", 100);

    Libro libro02 = new Libro("10002","Spiderman", "Stan lee", "Accion", 200);

    @BeforeEach
    void setUp() {
        Libro libro01 = new Libro("10001","Don quijote de la mancha", "Miguel de cervantes", "Fantasia", 100);

        Libro libro02 = new Libro("10002","Spiderman", "Stan lee", "Accion", 200);
    }

    @Test
    void mostrarINFO() {
        String infoLibro =libro01.mostrarINFO();
        assertEquals(infoLibro,  "ISBN: "+"10001"+
                "\nTitulo: "+"Don quijote de la mancha"+
                "\nAutor: "+"Miguel de cervantes"+
                "\nGenero: "+"Fantasia"+
                "\nCantidad Disponible: "+100+
                "\nDisponible: "+"Si");
    }

    @Test
    void prestar() {
        for (int i = 1; i <= 100; i++ ){
            libro02.prestar();
        }
        for (int i = 1; i <= 99; i++ ){
            libro01.prestar();
        }
        assertEquals(1, libro01.getCantidadDisponible());
        assertEquals(100, libro02.getCantidadDisponible());
    }

    @Test
    void devolver() {
        for (int i = 1; i <= 99; i++ ){
            libro01.prestar();
        }
        for (int i = 1; i <= 99; i++ ){
            libro01.devolver();
        }
        assertEquals(100, libro01.getCantidadDisponible());
    }

    @Test
    void getTitulo() {
        assertEquals("Spiderman", libro02.getTitulo());
    }

    @Test
    void getAutor() {
        assertEquals("Stan lee", libro02.getAutor());
        assertEquals("Miguel de cervantes", libro01.getAutor());
    }

    @Test
    void getGenero() {
        assertEquals("Accion", libro02.getGenero());
        assertEquals("Fantasia", libro01.getGenero());
    }

    @Test
    void getIsbn() {
        assertEquals("10001", libro01.getIsbn());
        assertEquals("10002", libro02.getIsbn());
    }

    @Test
    void getCantidadDisponible() {
        assertEquals(100, libro01.getCantidadDisponible());
        assertEquals(200, libro02.getCantidadDisponible());
    }

    @Test
    void isDisponible() {
        assertEquals(true, libro01.isDisponible());
        for (int i = 1; i <= 100; i++ ){
            libro01.prestar();
        }
        assertEquals(false, libro01.isDisponible());
    }

    @Test
    void setTitulo() {
        libro01.setTitulo("Don quijote del manchado");
        assertEquals("Don quijote del manchado", libro01.getTitulo());
    }

    @Test
    void setAutor() {
        libro01.setAutor("Juanin");
        assertEquals("Juanin", libro01.getAutor());
    }

    @Test
    void setGenero() {
        libro01.setGenero("Masculino");
        assertEquals("Masculino", libro01.getGenero());
    }

    @Test
    void setIsbn() {
        libro01.setIsbn("200");
        assertEquals("200", libro01.getIsbn());
    }

    @Test
    void setCantidadDisponible() {
        libro01.setCantidadDisponible(10);
        assertEquals(10, libro01.getCantidadDisponible());
    }

    @Test
    void setDisponible() {
        libro01.setDisponible(false);
        assertEquals(false, libro01.isDisponible());
        libro01.setDisponible(true);
        assertEquals(true, libro01.isDisponible());
        libro02.setDisponible(false);
        assertEquals(false, libro02.isDisponible());
    }
}