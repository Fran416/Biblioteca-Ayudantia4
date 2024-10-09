import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {
    Biblioteca biblioteca = new Biblioteca("UFRO Library");

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        Biblioteca biblioteca = new Biblioteca("UFRO Library");

        biblioteca.agregarLibro("10001","Don quijote de la mancha", "Miguel de cervantes", "Fantasia", 100);
        biblioteca.agregarLibro("10002","Spiderman", "Stan lee", "Accion", 200);
    }

    @BeforeEach
    void setUp() {
        for (int i = 1; i<=100; i++){
            biblioteca.prestarLibro("Don quijote de la mancha");
        }
        biblioteca.eliminarLibro("Don quijote de la mancha");

        for (int i = 1; i<=200; i++){
            biblioteca.prestarLibro("Spiderman");
        }
        biblioteca.eliminarLibro("Spiderman");

        biblioteca.agregarLibro("10001","Don quijote de la mancha", "Miguel de cervantes", "Fantasia", 100);
        biblioteca.agregarLibro("10002","Spiderman", "Stan lee", "Accion", 200);
    }

    @Test
    void agregarLibro() {
        biblioteca.agregarLibro("10001","Don quijote de la mancha", "Miguel de cervantes", "Fantasia", 100);
        biblioteca.agregarLibro("10002","Spiderman", "Stan lee", "Accion", 200);

        assertFalse(biblioteca.libros.isEmpty());
    }

    @Test
    void mostrarLibrosDisponibles() {
        for (int i = 1; i<=200; i++){
            biblioteca.prestarLibro("Spiderman");
        }
        biblioteca.eliminarLibro("Spiderman");

        assertEquals("ISBN |      Titulo      |     Autor     |  Genero  | Cantidad Disponibles"+"\n"+"10001"+ " | " + "Don quijote de la mancha" + " | " + "Miguel de cervantes" + " | " +"Fantasia" +  " | "  + 100, biblioteca.mostrarLibrosDisponibles());
    }

    @Test
    void buscarLibroPorTitulo() {
        assertEquals("10001", biblioteca.buscarLibroPorTitulo("Don quijote de la mancha").getIsbn());
    }

    @Test
    void buscarLibrosPorAutor() {
        assertFalse(biblioteca.buscarLibrosPorAutor("Miguel de cervantes").isEmpty());
        assertTrue(biblioteca.buscarLibrosPorAutor("juanin").isEmpty());
    }

    @Test
    void eliminarLibro() {

        for (int i = 1; i<=200; i++){
            biblioteca.prestarLibro("Spiderman");
        }
        biblioteca.eliminarLibro("Spiderman");

        for (int i = 1; i<=100; i++){
            biblioteca.prestarLibro("Don quijote de la mancha");
        }
        biblioteca.eliminarLibro("Don quijote de la mancha");

        assertTrue(biblioteca.libros.isEmpty());
    }

    @Test
    void prestarLibro() {
        for (int i = 1; i<=55; i++){
            biblioteca.prestarLibro("Don quijote de la mancha");
        }
        assertEquals(45, biblioteca.buscarLibroPorTitulo("Don quijote de la mancha").getCantidadDisponible());
    }

    @Test
    void devolverLibro() {

        for (int i = 1; i<=55; i++){
            biblioteca.prestarLibro("Don quijote de la mancha");
        }

        for (int i = 1; i<=55; i++){
            biblioteca.devolverLibro("Don quijote de la mancha");
        }

        assertEquals(100, biblioteca.buscarLibroPorTitulo("Don quijote de la mancha").getCantidadDisponible());
    }
}