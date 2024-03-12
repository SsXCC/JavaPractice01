public class Triangle {
    //非二维数组输出空心三角
    public static void hollowTriangle(int line) {
        for (int i = 0; i < line ; i++) {
            for (int j = 0; j < line - i - 1 ; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1 ; k++) {
                if (k == 0 || k == 2 * i || i == line - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    //二维数组输出空心三角
    public static void hollowTriangle01(int line) {
        String[][] ht = new String[line][];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < line - i - 1; j++) {
                System.out.print(" ");
            }
            ht[i] = new String[2 * i + 1];
            for (int k = 0; k < 2 * i + 1; k++) {
                if (k == 0 || k == 2 * i || i == line - 1) {
                    ht[i][k] = "*";
                    System.out.print(ht[i][k]);
                } else {
                    ht[i][k] = " ";
                    System.out.print(ht[i][k]);
                }
            }
            System.out.println("");
        }
    }

    public static void yangHuiTriangle(int line) {
        //杨辉三角
        int[][] yht = new int[line][];
        for (int i = 0; i < yht.length; i++) {
            yht[i] = new int[i + 1];
            for (int j = 0; j < yht[i].length; j++) {
                if (j == 0 || j == yht[i].length - 1) {
                    yht[i][j] = 1;
                } else {
                    yht[i][j] = yht[i - 1][j - 1] + yht[i - 1][j];
                }
                System.out.print(yht[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void yangHuiTriangle01(int line) {
        //杨辉三角1
        int[][] yht = new int[line][];
        for (int i = 0; i < yht.length; i++) {
            yht[i] = new int[2 * i + 1];
            for (int k = 0; k < line - i - 1; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                if (j == 0 || j == 2 * i) {
                    yht[i][j] = 1;
                    System.out.print(yht[i][j]);
                } else if (j % 2 != 0) {
                    yht[i][j] = 0;
                    System.out.print(" ");
                } else {
                    yht[i][j] = yht[i - 1][j - 2] + yht[i - 1][j];
                    System.out.print(yht[i][j]);
                }
            }
            System.out.println("");
        }
    }

}
