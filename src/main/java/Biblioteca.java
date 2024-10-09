import java.util.ArrayList;
import java.util.Objects;

public class Biblioteca {
    public String nombre;
    public ArrayList<Libro> libros;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = (ArrayList<Libro>) new ArrayList();
    }

    public void agregarLibro(String isbn, String titulo, String autor, String genero, int cantidadDisponible) {
        for (Libro libro: libros) {
            if (libro.getIsbn().equals(isbn)) {
                libro.setCantidadDisponible(libro.getCantidadDisponible() + cantidadDisponible);
            }
        }

        Libro libro = new Libro(isbn, titulo, autor, genero, cantidadDisponible);
        libros.add(libro);
    }

    public String mostrarLibrosDisponibles() {
        String listaLibrosDisponibles = "ISBN |      Titulo      |     Autor     |  Genero  | Cantidad Disponibles";
        for (Libro libro : libros) {
            if (libro.isDisponible()){
                listaLibrosDisponibles += "\n"+libro.getIsbn() + " | " + libro.getTitulo() + " | " + libro.getAutor() + " | " +libro.getGenero() +  " | "  + libro.getCantidadDisponible();
            }
        }
        return listaLibrosDisponibles;
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public ArrayList<Libro> buscarLibrosPorAutor(String autor) {
        ArrayList<Libro> librosPorAutor = new ArrayList<Libro>();
        for (Libro libro : libros) {
            if (Objects.equals(libro.getAutor(), autor)) {
                librosPorAutor.add(libro);
            }
        }
        return librosPorAutor;
    }

    public void eliminarLibro(String titulo) {
        libros.removeIf(libro -> libro.getTitulo().equals(titulo) && !libro.isDisponible() && libro.getCantidadDisponible() == 0);
    }

    public void prestarLibro(String titulo){
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                libro.prestar();
            }
        }
    }

    public void devolverLibro(String titulo){
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                libro.devolver();
            }
        }
    }
}
