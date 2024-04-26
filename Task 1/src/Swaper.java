import java.util.ArrayList;
import java.util.List;

public class Swaper {

    public static void main(String[] args) {
        System.out.println("\n###########################################################\n");

        System.out.print("WEJSCIE:\nWYJSCIE:");
        pairSwap("");
        System.out.println("\n###########################################################\n");

        System.out.print("WEJSCIE:NULL\nWYJSCIE:");
        pairSwap(null);
        System.out.println("\n###########################################################\n");

        System.out.print("WEJSCIE:Litw0=0jczyzno\nWYJSCIE:");
        pairSwap("Litw0=0jczyzno");
        System.out.println("\n###########################################################\n");

        System.out.print("WEJSCIE:_Litw0=Ojczyzno\nWYJSCIE:");
        pairSwap("_Litw0=Ojczyzno");
        System.out.println("\n###########################################################\n");

        System.out.print("WEJSCIE:Litw0=0jczyzno, C13=c3n1c c0s.\nWYJSCIE:");
        pairSwap("Litw0=0jczyzno, C13=c3n1c c0s.");
        System.out.println("\n###########################################################\n");

        System.out.print("WEJSCIE:Litw0=0jczyzno, C13=c3n1c, c0s.\nWYJSCIE:");
        pairSwap("Litw0=0jczyzno, C13=c3n1c, c0s.");
        System.out.println("\n###########################################################\n");

        System.out.print("WEJSCIE:Litw0=0jczyzno, C*3=c3n1c c0s.\nWYJSCIE:");
        pairSwap("Litw0=0jczyzno, C*3=c3n1c c0s.");
        System.out.println("\n###########################################################\n");

        System.out.print("WEJSCIE:Litw0=0jczyzno, C13=c3n1c=c0s\nWYJSCIE:");
        pairSwap("Litw0=0jczyzno, C13=c3n1c=c0s");
        System.out.println("\n###########################################################\n");

        System.out.print("WEJSCIE:Litw0=0jczyzno, C13 =c3n1c\nWYJSCIE:");
        pairSwap("Litw0=0jczyzno, C13 =c3n1c");
        System.out.println("\n###########################################################\n");
    }

    public static void pairSwap(String text) {

        //obsluga nulla
        if (text == null){
            text = "";
        }

        //rozdzielenie tekstu wedlug znakow interpunkcyjnych
        String[] tokens = text.split("\\s+");

        for (String token : tokens){

            //szukanie ewentulanych par identyfikatorow i ich rozdzial
            if (token.contains("=")) {
                String id1 = token.substring(0, token.indexOf('='));
                String id2 = token.substring(token.indexOf('=') + 1);

                //sprawdzenie znakow w identyfikatorach i czy nie sa puste
                if (!id1.matches(".*[^A-Za-z0-9_].*") && !id2.matches(".*[^A-Za-z0-9_].*") && !id1.isEmpty() && !id2.isEmpty()) {

                    //sprawdzenie pierwszego znaku w identyfikatorach
                    if (id1.substring(0, 1).matches(".*[A-Za-z_].*") && id2.substring(0, 1).matches(".*[A-Za-z_].*")) {

                        //zamiana miejscami identyfikatorow
                        String pair = id2 + "=" + id1;
                        text = text.replace(token, pair);
                    }
                }
            }
        }
        System.out.println(text);
    }

}
