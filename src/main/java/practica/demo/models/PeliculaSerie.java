package practica.demo.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
    @Table(name="pelicula_serie")
    public class PeliculaSerie {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int id;

        @Lob
        @Column(name = "imagen", columnDefinition = "BLOB")
        private byte[] imagen;
        private String titulo;
        private Date fecha_creacion;
        private int calificacion;
        // @ManyToMany
       //  @JoinColumn(name = "personajes_asociados_id", referencedColumnName = "id")
        // private List<Personaje> personajeAsociado;


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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaCreacion() {
        return fecha_creacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fecha_creacion = fechaCreacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

   //  public List<Personaje> getPersonajeAsociado() {
      //  return personajeAsociado;
  //  }

  //   public void setPersonajeAsociado(List<Personaje> personajeAsociado) {
    //    this.personajeAsociado = personajeAsociado;
    }
//}
