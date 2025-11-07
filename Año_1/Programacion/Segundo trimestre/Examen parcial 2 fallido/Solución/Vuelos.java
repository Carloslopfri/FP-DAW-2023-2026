public class Vuelos {

    private String nombre;

    private String ciudadOrigen;

    private String ciudadDestino;

    private String fechaHoraOrigen;

    private String fechaHoraDestino;

    public Vuelos(String nombre, String ciudadOrigen, String ciudadDestino, String fechaHoraOrigen, String fechaHoraDestino) {

        this.nombre=nombre;

        this.ciudadOrigen=ciudadOrigen;

        this.ciudadDestino=ciudadDestino;

        this.fechaHoraOrigen=fechaHoraOrigen;

        this.fechaHoraDestino=fechaHoraDestino;

    }

    public String getNombre() {

        return nombre;
        
    }

    public String getCiudadOrigen() {

        return ciudadOrigen;

    }

    public String getCiudadDestino() {

        return ciudadDestino;

    }

    public String getFechaHoraOrigen() {

        return fechaHoraOrigen;

    }

    public String getFechaHoraDestino() {

        return fechaHoraDestino;

    }

    public void setNombre(String nombre) {

        this.nombre=nombre;

    }

    public void setCiudadOrigen(String ciudadOrigen) {

        this.ciudadOrigen=ciudadOrigen;

    }

    public void setCiudadDestino(String ciudadDestino) {

        this.ciudadDestino=ciudadDestino;

    }

    public void setFechaHoraOrigen(String fechaHoraOrigen) {

        this.fechaHoraOrigen=fechaHoraOrigen;

    }

    public void setFechaHoraDestino(String fechaHoraDestino) {

        this.fechaHoraDestino=fechaHoraDestino;

    }

}
