package practica.demo.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="personaje")
public class Personaje {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Lob
    @Column(name = "imagen", columnDefinition = "BLOB")
    private byte[] imagen;
    private String nombre;
    private int edad;
   private float peso;
    private String historia;
    @ManyToMany
    @JoinColumn(name = "pelicula_serie_id", referencedColumnName = "id")
    private List<PeliculaSerie> peliculaSerie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public PeliculaSerie getPeliculaSerie() {
        return (PeliculaSerie) peliculaSerie;
    }

    public void setPeliculaSerie(List<PeliculaSerie >peliculaSerie) {
        this.peliculaSerie = peliculaSerie;
    }
}

