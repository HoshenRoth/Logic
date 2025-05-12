
public class Logic {

    public static int solutionsCounter = 0;
    public static boolean[][] bord;

    public static void printBoard(boolean[][] bord) {
        System.out.println("########");
        for (int i=0; i<bord.length; i++){
            for (int j=0; j<bord[i].length; j++){
                if (bord[i][j]){
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }


    public static boolean checkBoard(int raw, int column, boolean[][] bord) {
        //בדיקת שורות
        for (int i=0; i<bord[raw].length; i++){
            if (i!=column && bord[raw][i]){
                return false;
            }
        }
        //בדיקת עמודות
        for (int j=0; j<bord.length; j++){
            if (j!=raw && bord[j][column]){
                return false;
            }
        }

        //בדיקת אלכסון מימין- למעלה לשמאל- למטה
        for (int i=column, j=raw; i>=0 && j>=0; i--, j--){
            if (i!=column && j!=raw && bord[j][i]){
                return false;
            }
        }
        for (int i=column, j=raw; i<bord[0].length && j<bord.length; i++, j++){
            if (i!=column && j!= raw && bord[j][i]){
                return false;
            }
        }

        //בדיקת אלכסון משמאל- למעלה לימין- למטה
        for (int i = column, j = raw; i < bord[0].length && j >= 0; i++, j--){
            if (i!= column && j!= raw && bord[j][i]){
                return false;
            }
        }
        for (int i=column, j=raw; i>=0 && j<bord.length; i--, j++){
            if (i!=column && j!=raw && bord[j][i]){
                return false;
            }
        }

        return true;
    }


    public static void placeQueensRecursive(int column, boolean[][] bord) {
        if (column>= bord[0].length){
            solutionsCounter++;
            printBoard(bord);
            return;
        }
        for (int raw=0; raw<bord.length; raw++){
            if (checkBoard(raw, column, bord)){
                bord[raw][column]= true;
                placeQueensRecursive(column+1, bord);
                bord[raw][column]= false;
            }
        }
    }


    public static int countSolutions(Queen[] queens) {
        solutionsCounter = 0;
        bord = new boolean[Main.bord_size][Main.bord_size];
        for (int i = 0; i < Main.bord_size; i++) {
            int s = queens[i].getInSquare();
            if (s != -1){
                bord[s / Main.bord_size][s % Main.bord_size] = true;
            }
        }
        placeQueensRecursive(0, bord);
        return solutionsCounter;
    }
}
