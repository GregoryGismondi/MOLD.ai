package com.mycompany.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws IOException {
        String filepath = "mold-ai/";
        Scanner sc = new Scanner(System.in);
        System.out.print("[0] Good Apple\n[1] Good Banana\n[2] Good Bread\n[3] Good Orange");
        System.out.print("\n[4] Bad Apple\n[5] Bad Banana\n[6] Bad Bread\n[7] Bad Orange\nMake a selection: ");
        int userChoice = sc.nextInt();
        switch(userChoice){
            case 0:
                filepath += "good_apple.png";
                break;
            case 1:
                filepath += "good_banana.png";
                break;
            case 2:
                filepath += "good_bread.png";
                break;
            case 3:
                filepath += "good_orange.png";
                break;
            case 4:
                filepath += "moldy_apple.png";
                break;
            case 5:
                filepath += "moldy_banana.png";
                break;
            case 6:
                filepath += "moldy_bread.png";
                break;
            case 7:
                filepath += "moldy_orange.png";
                break;
        }
        //String filepath = sc.nextLine();

        ArrayList<ArrayList<Float>> colour_values = DetectProperties.detectProperties(filepath);

        Boolean isMoldy = MoldyDeterminant.moldyDeterminant(colour_values);

        visuals.visual(isMoldy, filepath, colour_values);
    }
}
