public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private String isbn;
    private int cantidadDisponible;
    private boolean disponible;

    public Libro(String isbn, String titulo, String autor, String genero, int cantidadDisponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.cantidadDisponible = cantidadDisponible;
        this.disponible = true;
    }

    public String mostrarINFO(){
        String isbnMostrar = this.isbn;
        String tituloMostrar = this.titulo;
        String autorMostrar = this.autor;
        String generoMostrar = this.genero;
        int cantidadDisponibleMostrar = this.cantidadDisponible;
        String disponibleMostrar;
        if (this.disponible) {
            disponibleMostrar = "Si";
        } else {
            disponibleMostrar = "No";
        }
        String info = "ISBN: "+isbnMostrar+
                      "\nTitulo: "+tituloMostrar+
                      "\nAutor: "+autorMostrar+
                      "\nGenero: "+generoMostrar+
                      "\nCantidad Disponible: "+cantidadDisponibleMostrar+
                      "\nDisponible: "+disponibleMostrar;

        return info;
    }

    public Libro prestar() {
        setCantidadDisponible(this.cantidadDisponible-1);
        if (this.cantidadDisponible == 0){
            setDisponible(false);
        }
        return this;
    }

    public Libro devolver() {
        if (!this.disponible){
            this.setDisponible(true);
            setCantidadDisponible(this.cantidadDisponible+1);
        } else {
            setCantidadDisponible(this.cantidadDisponible+1);
        }
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
