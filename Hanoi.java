import java.util.ArrayList;

/*
汉诺塔，有编号为a,b,c的3个柱子，初始在a塔从小到大堆叠着n个盘子，
规定上面的盘子一定要比下面的小，要求把盘子移到c塔
*/
public class Hanoi {
    //num盘的数量，a原位置，b过渡位置，c目标位置
    public void move(int num, char a, char b, char c) {
        if (num == 1) {
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

    boolean first = true;

    ArrayList<Integer> x = new ArrayList<>();
    ArrayList<Integer> y = new ArrayList<>();
    ArrayList<Integer> z = new ArrayList<>();

    public void run(int num) {
        move1(num, x, y, z);
    }

    public void arrayListFill(int num, ArrayList<Integer> a) {
        for (int i = 0; i < num; i++) {
            a.add(i, i + 1);
        }
    }


    public void move1(int num, ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c) {
        if (first) {
            arrayListFill(num, a);
            first = false;
        }
        if (num == 1) {
            int n = a.removeFirst();
            c.addFirst(n);
            print(x, y, z);
        } else {
            move1(num - 1, a, c, b);
            int m = a.removeFirst();
            c.addFirst(m);
            print(x, y, z);
            move1(num - 1, b, a, c);

        }
    }


    public void comparePrint(int i, int d, ArrayList<Integer> a) {
        if (d - i > a.size()) {
            System.out.print(" \t");
        } else if (d == a.size()) {
            System.out.print(a.get(i) + "\t");
        } else {
            System.out.print(a.get(a.size() - (d - i)) + "\t");
        }
    }

    public void print(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c) {
        int d = Math.max(Math.max(a.size(), b.size()), c.size());
        for (int i = 0; i < d; i++) {
            comparePrint(i, d, a);
            comparePrint(i, d, b);
            comparePrint(i, d, c);
            System.out.println();
        }
        System.out.println();
    }


    /*;

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
