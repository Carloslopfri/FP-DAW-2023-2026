/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete;

/**
 *
 * @author ramonfr
 */
public class IdentificadorMascotas {
    
    public static void identificarMascotas (Mascota[] animales) {

        for(int i=0; i<animales.length; i++) {

            System.out.println(animales[i]);

            if(animales[i] instanceof Perro) {

                Perro p=(Perro) animales[i];

                p.andar();

            }

            else if(animales[i] instanceof Pajaro) {

                Pajaro p=(Pajaro) animales[i];

                p.volar();

            }

        }

    }

}
