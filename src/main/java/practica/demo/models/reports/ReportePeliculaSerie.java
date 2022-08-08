package practica.demo.models.reports;

import java.util.Date;

public interface ReportePeliculaSerie {
    int getId();
    Byte[] getImagen();
    String getTitulo();
    Date getFecha_creacion();
    int getcalificacion();
    String getPersonaje();

}
