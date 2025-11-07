package examen.daw;

import java.io.Serializable;

public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idProveedor;

    private String codigo;

    private byte[] imagen;

    private String nombre;

    private String marca;

    private String tipo;

    private String grupo;

    private double peso;

    private double precioUnidad;

    private int stock;

    public Proveedor(int idProveedor, String codigo, byte[] imagen, String nombre, String marca, String tipo, String grupo, double peso, double precioUnidad, int stock) {

        this.idProveedor = idProveedor;

        this.codigo = codigo;

        this.imagen = imagen;

        this.nombre = nombre;

        this.marca = marca;

        this.tipo = tipo;

        this.grupo = grupo;

        this.peso = peso;

        this.precioUnidad = precioUnidad;

        this.stock = stock;

    }

    public int getIdProveedor() {

        return idProveedor;

    }

    public void setIdProveedor(int idProveedor) {

        this.idProveedor = idProveedor;

    }

    public String getCodigo() {

        return codigo;

    }

    public void setCodigo(String codigo) {

        this.codigo = codigo;

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

    public String getMarca() {

        return marca;

    }

    public void setMarca(String marca) {

        this.marca = marca;

    }

    public String getTipo() {

        return tipo;

    }

    public void setTipo(String tipo) {

        this.tipo = tipo;

    }

    public String getGrupo() {

        return grupo;

    }

    public void setGrupo(String grupo) {

        this.grupo = grupo;

    }

    public double getPeso() {

        return peso;

    }

    public void setPeso(double peso) {

        this.peso = peso;

    }

    public double getPrecioUnidad() {

        return precioUnidad;

    }

    public void setPrecioUnidad(double precioUnidad) {

        this.precioUnidad = precioUnidad;

    }

    public int getStock() {

        return stock;

    }

    public void setStock(int stock) {

        this.stock = stock;

    }

    @Override
    public String toString() {

        return "Proveedor{" +

                "idProveedor=" + idProveedor +

                ", codigo='" + codigo + '\'' +

                ", nombre='" + nombre + '\'' +

                ", marca='" + marca + '\'' +

                ", tipo='" + tipo + '\'' +

                ", grupo='" + grupo + '\'' +

                ", peso=" + peso +

                ", precioUnidad=" + precioUnidad +

                ", stock=" + stock +

                '}';

    }

}
