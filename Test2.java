import org.junit.jupiter.api.Test;

public class Test2 {
    @Test
    //从横竖斜方向遍历五子棋棋盘而构建的数组
    public void test01() {
        int[][] board = new int[15][15];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = i;
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");

        int[][] arrRow = new int[15][15];
        //棋盘每列作为一维数组
        for (int i = 0; i < arrRow.length; i++) {
            for (int j = 0; j < arrRow[i].length; j++) {
                arrRow[i][j] = board[j][i];
                System.out.print(arrRow[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");

        int[][] arrK01 = new int[21][];
        int[][] arrK02 = new int[21][];
        //两个棋盘斜线数组，长度5-15-5
        for (int i = 0; i < board.length; i++) {
            if (i == 0) {
                arrK01[i] = new int[board.length];
                arrK02[i] = new int[board.length];
            } else if (i < board.length - 4) {
                arrK01[i] = new int[board.length - i];
                arrK01[i + 10] = new int[board.length - i];
                arrK02[i] = new int[board.length - i];
                arrK02[i + 10] = new int[board.length - i];
            }

            for (int j = 0; j < board[i].length - i; j++) {
                if (i == 0) {
                    arrK01[i][j] = board[j][i + j];
                    arrK02[i][j] = board[j][board.length - i - j - 1];
                } else if (i < board.length - 4) {
                    arrK01[i][j] = board[j][i + j];
                    arrK01[i + 10][j] = board[i + j][j];

                    arrK02[i][j] = board[j][board.length - i - j - 1];
                    arrK02[i + 10][j] = board[board.length - i - j - 1][j];
                }
            }
        }
        for (int i = 0; i < arrK01.length; i++) {
            for (int j = 0; j < arrK01[i].length; j++) {
                System.out.print(arrK01[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");

        for (int i = 0; i < arrK02.length; i++) {
            for (int j = 0; j < arrK02[i].length; j++) {
                System.out.print(arrK02[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

}
