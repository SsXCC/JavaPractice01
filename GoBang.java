import java.util.Scanner;

//五子棋15*15，二维数组应用
public class GoBang {
    //棋盘大小，通过改变值来表示该处有棋子
    int[][] board = new int[15][15];
    //黑子先手
    int p1 = 1;
    //白子后手
    int p2 = 2;
    Scanner input = new Scanner(System.in);
    String str = "";

    //打印棋盘方法
    public void printBoard() {
        //棋盘坐标，行标小写字母a-o，列标大写字母A-O
        char[] col = new char[15];
        for (int i = 0; i < col.length; i++) {
            col[i] = (char) (97 + i);
        }

        char[] row = new char[15];
        System.out.print(" ");
        for (int i = 0; i < row.length; i++) {
            row[i] = (char) (65 + i);
            System.out.print(" " + row[i]);//打印顶部列标
        }
        System.out.println();
        //打印两侧行标和棋盘
        for (int i = 0; i < board.length; i++) {
            System.out.print(col[i] + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(col[i]);
        }
        //打印底部列标
        System.out.print(" ");
        for (char x : row) {
            System.out.print(" " + x);
        }
        System.out.println();
    }

    public void gameStart() {
        //游戏开始，调用打印棋盘方法
        printBoard();
        //如果棋盘未满 或 未分胜负 或 无人投降，则正常循环下棋回合，执行do...while
        do {
            //一次下棋回合，后续补充设置回合时限
            //黑方回合
            if (!isRound(p1)) break;

            if (isFull()) break;

            //白方回合
            if (!isRound(p2)) break;
        } while (true);
    }

    //下棋回合方法，后续补充设置回合时限
    private boolean isRound(int p) {
        //加异常捕获
        if (p == p1)
            System.out.println("黑方回合——请输入落子位置行列标：（如hH），投降请输入gg");
        else if (p == p2)
            System.out.println("白方回合——请输入落子位置行列标：（如hH），投降请输入gg");
        //获取输入，输入错误或取消投降则重新获取
        do {
            str = input.next();
            if (isSurrender(p)) return false;//判断投降
            else if (getLocations(p)) return !isWin();//判断胜负

        } while (true);
    }

    //获取输入的行列标并落子，打印棋盘
    private boolean getLocations(int p) {
        int l, r;
        //输入处于规定范围内的值才可继续，否则循环调用自身
        if (str.length() != 2 || str.charAt(0) < 'a' || str.charAt(0) > 'o'
                || str.charAt(1) < 'A' || str.charAt(1) > 'O') {
            System.out.println("行列标输入错误，请重新输入落子位置行列标：（如hH）");
            return false;
        } else {
            //此时才可获取行列标，并判断落子处是否已有棋子
            l = str.charAt(0) - 97;
            r = str.charAt(1) - 65;
            if (board[l][r] != 0) {
                System.out.println("此处已有棋子，请重新输入落子位置行列标：（如hH）");
                return false;
            } else {
                //落子并打印棋盘
                board[l][r] = p;
                printBoard();
                return true;
            }
        }
    }

    //判断投降
    private boolean isSurrender(int p) {
        while (str.equals("gg")) {
            System.out.println("确定投降吗（确定y，否定n）");
            str = input.next();
            if (str.equals("n")) {
                System.out.println("取消投降，请重新输入落子位置行列标（如hH）");
                str = input.next();
            } else if (str.equals("y")) {
                if (p == p1) {
                    System.out.println("黑方投降,白方胜利！");
                    System.out.println("===============GAME OVER===============");
                    return true;
                }
                if (p == p2) {
                    System.out.println("白方投降,黑方胜利！");
                    System.out.println("===============GAME OVER===============");
                    return true;
                }
            } else {
                System.out.println("输入错误，请重新输入");
                str = "gg";
            }
        }
        return false;
    }

    //判断棋盘是否满
    private boolean isFull() {
        for (int[] i : board) {
            for (int j : i) {
                if (j == 0) return false;
            }
        }
        System.out.println("棋盘已满，未分胜负，平局");
        System.out.println("===============GAME OVER===============");
        return true;
    }

    //判断胜负，构建横竖斜方向的各个数组后，将一维数组存放于临时字符串内并使用contain方法判断是否有5连子
    private boolean isWin() {
        //定义黑白双方各自获胜时棋子连线的表现
        String p1Win = "";
        String p2Win = "";
        for (int i = 0; i < 5; i++) {
            p1Win = p1Win.concat(String.valueOf(p1));
            p2Win = p2Win.concat(String.valueOf(p2));
        }

        //判断每行是否有5连子
        for (int[] i : board) {
            String tempstr = "";
            for (int j : i) {
                tempstr = tempstr.concat(String.valueOf(j));//将一条线的数存放于临时字符串
            }
            //判断是否胜利
            if (tempstr.contains(p1Win)) {
                whoWin(p1);
                return true;
            } else if (tempstr.contains(p2Win)) {
                whoWin(p2);
                return true;
            }
        }

        //判断每列是否有5连子
        int[][] arrRow = new int[15][15];
        //棋盘每列作为一维数组
        for (int i = 0; i < arrRow.length; i++) {
            String tempstr = "";
            for (int j = 0; j < arrRow[i].length; j++) {
                arrRow[i][j] = board[j][i];
                tempstr = tempstr.concat(String.valueOf(arrRow[i][j]));
            }
            //判断是否胜利
            if (tempstr.contains(p1Win)) {
                whoWin(p1);
                return true;
            } else if (tempstr.contains(p2Win)) {
                whoWin(p2);
                return true;
            }
        }

        //判断两个方向斜线是否有5连子
        int[][] arrK01 = new int[21][];
        int[][] arrK02 = new int[21][];
        //两个棋盘斜线二维数组，共有21个一维数组，各自为长度5-15-5
        for (int i = 0; i < board.length; i++) {
            String tempstr01 = "";
            String tempstr02 = "";
            String tempstr03 = "";
            String tempstr04 = "";
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

                    tempstr01 = tempstr01.concat(String.valueOf(arrK01[i][j]));
                    tempstr02 = tempstr02.concat(String.valueOf(arrK02[i][j]));
                } else if (i < board.length - 4) {
                    arrK01[i][j] = board[j][i + j];
                    arrK01[i + 10][j] = board[i + j][j];

                    arrK02[i][j] = board[j][board.length - i - j - 1];
                    arrK02[i + 10][j] = board[board.length - i - j - 1][j];

                    tempstr01 = tempstr01.concat(String.valueOf(arrK01[i][j]));
                    tempstr02 = tempstr02.concat(String.valueOf(arrK01[i + 10][j]));
                    tempstr03 = tempstr03.concat(String.valueOf(arrK02[i][j]));
                    tempstr04 = tempstr04.concat(String.valueOf(arrK02[i + 10][j]));
                }
            }
            //判断是否胜利
            if (tempstr01.contains(p1Win) || tempstr02.contains(p1Win) ||
                    tempstr03.contains(p1Win) || tempstr04.contains(p1Win)) {
                whoWin(p1);
                return true;
            } else if (tempstr01.contains(p2Win) || tempstr02.contains(p2Win) ||
                    tempstr03.contains(p2Win) || tempstr04.contains(p2Win)) {
                whoWin(p2);
                return true;
            }
        }

        return false;
    }

    //判断哪方胜利并打印文字
    private void whoWin(int p) {
        if (p == p1) {
            System.out.println("黑方胜利！");
            System.out.println("===============GAME OVER===============");
        } else if (p == p2) {
            System.out.println("白方胜利！");
            System.out.println("===============GAME OVER===============");
        }
    }
}
