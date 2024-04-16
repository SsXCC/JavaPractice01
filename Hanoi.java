/*
汉诺塔，有编号为a,b,c的3个柱子，初始在a塔从小到大堆叠着n个盘子，
规定上面的盘子一定要比下面的小，要求把盘子移到c塔
*/
public class Hanoi {
    //num盘的数量，a原位置，b过渡位置，c目标位置
    public void move(int num, char a, char b, char c) {
        if (num == 1) {
            //把最下面的盘移到c
            System.out.println(a + "->" + c);
        } else {
            //将盘分成两份，最下面和num-1，把num-1移到b
            move(num - 1, a, c, b);
            //把最下面的盘移到c
            System.out.println(a + "->" + c);
            //把在b的num-1盘移到c
            move(num - 1, b, a, c);
        }
    }





    /*int[] a, b, c;

    public void moveToc(int n) {
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i : a) i += 1;

    }

    public void print() {
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i] + "\t" + b[i] + "\t" + c[i]);
        System.out.println("A\tB\tC");
    }*/
}
