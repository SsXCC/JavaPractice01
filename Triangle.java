public class Triangle {
    public static void HollowTriangle(int line) {
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

    public static void YangHuiTriangle(int line) {
        //杨辉三角1111
    }

}
