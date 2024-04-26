public class Drawer {

    public static void main(String[] args) {
        System.out.println("\n###########################################################\n");
        System.out.println("\nTEST drawVerse()\n");

        System.out.println("WEJSCIE:gap = 0, x = 0\nWYJSCIE:");
        drawVerse(0,0);
        System.out.println("\n###########################################################\n");

        System.out.println("WEJSCIE:gap = -1, x = 0\nWYJSCIE:");
        drawVerse(-1,0);
        System.out.println("\n###########################################################\n");

        System.out.println("WEJSCIE:gap = 0, x = -1\nWYJSCIE:");
        drawVerse(0,-1);
        System.out.println("\n###########################################################\n");

        System.out.println("WEJSCIE:gap = 3, x = 5\nWYJSCIE:");
        drawVerse(3,5);
        System.out.println("\n###########################################################\n");

        System.out.println("\n***********************************************************\n");
        System.out.println("\nTEST drawPyramid()\n");

        System.out.println("WEJSCIE:n = -1, h = -1\nWYJSCIE:");
        drawPyramid(-1,-1);
        System.out.println("\n###########################################################\n");

        System.out.println("WEJSCIE:n = 0, h = 3\nWYJSCIE:");
        drawPyramid(0,3);
        System.out.println("\n###########################################################\n");

        System.out.println("WEJSCIE:n = 3, h = 0\nWYJSCIE:");
        drawPyramid(3,0);
        System.out.println("\n###########################################################\n");

        System.out.println("WEJSCIE:n = 1, h = 5\nWYJSCIE:");
        drawPyramid(1,5);
        System.out.println("\n###########################################################\n");

        System.out.println("\n***********************************************************\n");
        System.out.println("\nTEST drawAFigure()\n");

        System.out.println("WEJSCIE:n = -1\nWYJSCIE:");
        drawAFigure(-1);
        System.out.println("\n###########################################################\n");

        System.out.println("WEJSCIE:n = 0\nWYJSCIE:");
        drawAFigure(0);
        System.out.println("\n###########################################################\n");

        System.out.println("WEJSCIE:n = 5\nWYJSCIE:");
        drawAFigure(5);
        System.out.println("\n###########################################################\n");


    }

    public static void drawPyramid(int n, int h) {
        if (n >= 0 && h >= 0) {
            for (int level = 1; level <= h; level++) {
                drawVerse(h - level, 2 * n + 1);
                n++;
            }
        } else {
            System.out.println("Nieprawidlowe dane wejsciowe!");
        }
    }

    public static void drawAFigure(int n) {
        if (n >= 0) {
            int h = n;

            for (int i = 0; i < n; i++) {
                drawPyramid(i, h);
                h--;
            }
        }
        else
        {
            System.out.println("Nieprawidlowe dane wejsciowe!");
        }
    }

    public static void drawVerse(int gap, int x) {
        String space = " ";
        String body = "X";
        if (gap >= 0 && x >= 0){
            System.out.println(space.repeat(gap) + body.repeat(x));
        }
        else{
            System.out.println("Nieprawidlowe dane wejsciowe!");
        }
    }
}
