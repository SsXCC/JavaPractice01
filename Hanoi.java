/*
汉诺塔，有编号为a,b,c的3个柱子，初始在a塔从小到大堆叠着n个盘子，
规定上面的盘子一定要比下面的小，要求把盘子移到c塔
*/
public class Hanoi {
    int[] a, b, c;

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
    }
}
