package practica.demo.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="genero")
public class Genero {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @Lob
    @Column(name = "imagen", columnDefinition = "BLOB")
    private byte[] imagen;

    @ManyToMany
    @JoinColumn(name = "pelicula_serie_id", referencedColumnName = "id")
    private List<PeliculaSerie> peliculaSerie;

    public Genero(List<PeliculaSerie> peliculaSerie) {
        this.peliculaSerie = peliculaSerie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }


}
