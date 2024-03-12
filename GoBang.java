import java.util.Scanner;

//五子棋15*15，二维数组应用
public class GoBang {
    //棋盘大小，通过改变值来表示该处有棋子
    int[][] board = new int[15][15];
    int l = 'h' - 97;
    int r = 'H' - 65;
    //黑子先手
    int p1 = 1;
    //白子后手
    int p2 = 2;
    Scanner input = new Scanner(System.in);
    String str = "";

    //打印棋盘方法
    public void printBorad() {
        //棋盘坐标，行标小写字母a-o，列标大写字母A-O
        char[] line = new char[15];
        for (int i = 0; i < line.length; i++) {
            line[i] = (char) (97 + i);
        }

        char[] row = new char[15];
        System.out.print(" ");
        for (int i = 0; i < row.length; i++) {
            row[i] = (char) (65 + i);
            System.out.print(" " + row[i]);//打印顶部列标
        }
        System.out.println("");
        //打印两侧行标和棋盘
        for (int i = 0; i < board.length; i++) {
            System.out.print(line[i] + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(line[i]);
        }
        //打印底部列标
        System.out.print(" ");
        for (char x : row) {
            System.out.print(" " + x);
        }
        System.out.println("");
    }

    public void gameStart() {
        //游戏开始，调用打印棋盘方法
        printBorad();
        //如果棋盘未满 或 未分胜负 或 无人投降，则正常循环下棋回合，执行do...while
        do {
            //一次下棋回合，后续补充设置回合时限
            //黑方回合
            if (isRound(p1)) ;
            else break;

            if (isFull()) break;

            //白方回合
            if (isRound(p2)) ;
            else break;
        } while (true);
    }

    //下棋回合方法，后续补充设置回合时限
    private boolean isRound(int p) {
        //加异常捕获
        if (p == p1)
            System.out.println("黑方回合——请输入落子位置行列标：（如hH），投降请输入gg");
        else if (p == p2)
            System.out.println("白方回合——请输入落子位置行列标：（如hH），投降请输入gg");

        str = input.next();
        if (isSurrender(p)) return false;//判断投降
        else getLocations(p);
        if (isWin()) return false;//判断胜负

        return true;
    }

    //获取输入的行列标并落子，打印棋盘
    private void getLocations(int p) {
        //输入处于规定范围内的值才可继续，否则循环调用自身
        if (str.length() != 2 || str.charAt(0) < 'a' || str.charAt(0) > 'o'
                || str.charAt(1) < 'A' || str.charAt(1) > 'O') {
            System.out.println("行列标输入错误，请重新输入落子位置行列标：（如hH）");
            str = input.next();
            getLocations(p);
        } else {
            //此时才可获取行列标，并判断落子处是否已有棋子
            l = str.charAt(0) - 97;
            r = str.charAt(1) - 65;
            if (board[l][r] != 0) {
                System.out.println("此处已有棋子，请重新输入落子位置行列标：（如hH）");
                str = input.next();
                getLocations(p);
            } else {
                //落子并打印棋盘
                board[l][r] = p;
                printBorad();
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
                System.out.println("输入错误，请重新输入（确定y，否定n）");
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

    //判断胜负
    private boolean isWin() {
        return false;
    }

}
