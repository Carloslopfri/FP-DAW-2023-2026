package Ejercicio1;

public class Main {

    public static void main(String[] args) {

        Lactante l1 = new Lactante("2020-01-01", "Juan", TipoLactancia.directa);

        System.out.println(l1.comer("papilla"));

    }
    
}
