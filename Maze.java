public class Maze {
    //走迷宫的思路
    /*
    用数字表示迷宫格子通行状态
    1.先构建二维数组画迷宫，障碍用数字1表示
    2.构建走迷宫的递归方法，根据起点和终点位置来决定走上下左右方向的优先级
    无障碍且没走过的用数字0表示
    无障碍且能到终点用数字2表示
    无障碍但是死路用数字3表示
     */


    //用二维数组画迷宫，障碍用数字1表示
    int[][] map;
    int size;

    public void run(int l) {
        createMaze(l);
        findWay(1, 1);
        printMaze(map);
    }

    //走迷宫的递归方法
    public boolean findWay(int i, int j) {
        if (map[size - 2][size - 2] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (findWay(i + 1, j)) {
                    return true;
                } else if (findWay(i, j + 1)) {
                    return true;
                } else if (findWay(i - 1, j)) {
                    return true;
                } else if (findWay(i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public void createMaze(int l) {
        size = l;
        map = new int[size][size];
        for (int i = 0; i <size ; i++) {
            if (i == 0 || i == size - 1) {
                for (int j = 0; j < size; j++) {
                    map[i][j] = 1;
                }
            } else if (i == 3) {
                for (int j = 1; j < 4; j++) {
                    map[i][j] = 1;
                }
            } else if (i == 5) {
                for (int j = 2; j < size; j++) {
                    map[i][j] = 1;
                }
            }
            /*else if (i==(int) ((Math.random()*(size-2))+1)) {
                for (int j = 1; j < ; j++) {

                }
            }*/
            map[i][0] = 1;
            map[i][size - 1] = 1;
        }
        //a[size-3]
        printMaze(map);
    }

    public void printMaze(int[][] arr) {
        for (int[] x : arr) {
            for (int i : x) System.out.print(i + " ");
            System.out.println();
        }
        System.out.println();
    }
}
