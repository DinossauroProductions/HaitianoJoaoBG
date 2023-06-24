package com.dinossauroProductions.Utility;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Utils {

    public static void testarRandomCall(int min, int max){

        int[] estatistica = new int[max - min + 1];

        for(int i = 0; i < 10000000; i++){
            //System.out.println();
            estatistica[Utils.randomCall(min, max)-min]++;
        }

        for(int i = 0; i < estatistica.length; i++){
            System.out.println("Numero de "+(i+min)+"s: "+estatistica[i]);
        }

    }



    public static int randomCall (int min, int max){
        // a função deve retornar um número inteiro entre os valores passados, inclusive.

        //por exemplo: randomCall(1, 6);
        //deve retornar algo dentre: {1, 2, 3, 4, 5, 6}.

        Random rand = new Random(System.nanoTime());

        return min + Math.abs(rand.nextInt()) % (max - min + 1);
    }

    public static int d6 (){
        return randomCall(1, 6);
    }

    public static int d3 (){
        return randomCall(1, 3);
    }
}
