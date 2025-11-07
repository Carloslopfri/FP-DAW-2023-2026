package paquete;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author ramonfr
 */
public class ExamenEjer2 {

    public static void main(String[] args) {
        Mascota unaMascota = new Mascota("Jerry");
        Perro unPerro = new Perro("Toby","caniche");
        Pajaro unPajaro = new Pajaro();
        unPajaro.setNombre("Piolin");
        unPajaro.setEspecie("canario");
        Mascota[] animales = new Mascota[3];
        animales[0]=unaMascota;
        animales[1]=unPerro;
        animales[2]=unPajaro;
        IdentificadorMascotas.identificarMascotas(animales);
    }
}
