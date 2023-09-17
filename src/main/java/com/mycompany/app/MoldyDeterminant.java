package com.mycompany.app;

import javax.swing.plaf.ColorUIResource;
import java.util.ArrayList;
import java.util.Collections;

public class MoldyDeterminant {
    public static Boolean moldyDeterminant(ArrayList<ArrayList<Float>> colour_values) {

        int size = colour_values.size();
        ArrayList<Float> hsv = new ArrayList<Float>();

        for (ArrayList<Float> row : colour_values) {
            if (row.get(3) > 0.001){
                float[] buffer = new float[3];
                ColorUIResource.RGBtoHSB(Math.round(row.get(0)), Math.round(row.get(1)), Math.round(row.get(2)), buffer);

                hsv.add(buffer[0] * 360);
            }
        }

        size = hsv.size();

        Collections.sort(hsv);

        System.out.println(hsv);

        int index_of_division = -1;

        for (int k = size-1; k>0; k--){
            if (hsv.get(k) - hsv.get(k-1) >= 10){
                index_of_division = k;
            }

        }

        if(index_of_division == -1 && Math.abs(hsv.get(0) - hsv.get(hsv.size() - 1)) < 15.5){
            System.out.println("All colours are in same hue group");
            return Boolean.FALSE; // false, cos there is no 'mold'
        }
        else {
            System.out.println("There are two different colour groups. Division starts at index " + index_of_division +
                    "of sorted hues.");
            return Boolean.TRUE;
        }

    }

    public static void main(String[] args) {


    }

}
