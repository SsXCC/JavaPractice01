public class EightQueen {
    //八皇后，在8*8的棋盘上，在每列放置一个皇后棋子，要求棋子之间上下左右和斜线方向均只有1个棋子，列出所有可能的情况
    /*
    1.用一维数组即可表示棋子坐标
    2.落子方法
        2.1首次进入方法时创建指定长度的数组并记录长度值
        2.2从首行开始，for循环遍历列数且内含递归方法，递归参数控制行数，注意边界条件并调用打印方法
    3.判断是否为有效落子的方法
    4.打印棋盘棋子的方法
     */
    int[] a;
    boolean ifFirst = true;
    int size;

    /*
    落子的递归方法，size=i为棋子总数（棋盘大小），
    注意i-1为最大行数且从第0行开始，行数下标则为[a.length - i]，递归参数递减为(i-1)
    达到边界条件即最后一行则不调用自身而调用打印棋盘方法
    */
    public void drop(int i) {
        if (ifFirst) {
            int[] a = new int[i];
            size = i;
            ifFirst = false;
        }
        for (int j = 0; j < size; j++) {
            if (ifOK(a, a.length - i, j)) {
                a[a.length - i] = j;
                if (i > 1) drop(i - 1);
                else print(a);
            }
        }

    }

    //判断上下左右和斜线方向是否有重复棋子，将要落子的所处行数为i，列数为q，j为之前落子的各个行数
    public boolean ifOK(int[] a, int i, int q) {
        for (int j = 0; j < i; j++) {
            if (q == a[j] || Math.abs(q - a[j]) == (i - j))//满足处于同一列或两条斜线上则此格子不满足条件
                return false;
        }
        return true;//遍历完之前所有行均无不满足条件的情况则满足条件
    }

    //遍历每一行打印棋盘棋子，*表示空格子，数字表示棋子
    public void print(int[] a) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < a[i]; j++) //在棋子前面输出空格子
                System.out.print("*" + " ");

            System.out.print(a[i] + " ");//输出棋子

            for (int j = 0; j < a.length - a[i] - 1; j++) //在棋子后面输出空格子
                System.out.print("*" + " ");

            System.out.println();
        }
        System.out.println();
    }

}
