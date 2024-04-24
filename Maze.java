public class Maze {
    //走迷宫的思路
    /*
    用数字表示迷宫格子通行状态
    1.先构建二维数组画迷宫，障碍用数字1表示
    2.构建走迷宫的递归方法，根据起点和终点位置来决定走上下左右方向的优先级
    无障碍且非死路用数字0表示
    无障碍但是死路用数字2表示
    终点用数字3表示
     */


    //用二维数组画迷宫，障碍用数字1表示
    int[][] a;

    public void creatMaze(int size) {
        for (int i = 0; i <size ; i++) {
            if (i == 0 || i == size - 1) {
                for (int j = 0; j < size; j++) {
                    a[i][j] = 1;
                }
            } else {
                a[i][0] = 1;
                a[i][size - 1] = 1;
            }
        }
        //a[size-3]
    }
    public void printMaze() {


    }

    //走迷宫的递归方法
    public void findWay() {

    }
}
