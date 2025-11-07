package paquete;

import java.util.Random;

public class Dado {

    private static int cara;

    public static int getCara() {

        Random random=new Random();

        cara=random.nextInt(1, 7);

        return cara;

    }
    
}
