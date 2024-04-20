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
    //以下为利用集合ArrayList可视化输出每一步移动后整个汉诺塔的状态方法说明
    /*
    1.确定参数，盘子的总数int num，3个塔的集合实参ArrayList<Integer> x,y,z
    2.确定主要方法:
    2.1)递归调用的移动方法move1
    2.2)打印的方法，要3个塔横向并排输出，则需一层层遍历每个塔集合的每个元素再输出

    3.定义3个塔整数型集合和运行方法，这样在调用时就无需再定义集合，且使得后续递归调用打印输出塔的顺序不乱
    运行方法为run(int num)
    4.用整数正序列填充第一个塔集合x，构建方法arrayListFill(int num,ArrayList<Integer> a)
    5.构建方法打印输出汉诺塔,
    则先按顺序分别看3个塔在这层是否有元素并输出，此时便完成了一层的输出，再用循环遍历每一层并输出即可
        5.1)构建方法循环遍历打印输出整个汉诺塔，形参为左中右3个塔集合
        print(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c)
        方法内定义3个塔内单个塔的最多盘子数d，for循环遍历数i
        5.2)构建方法检查并输出某塔某层的元素comparePrint(int i, int d, ArrayList<Integer> a)
        关键是判断该塔在该层是否有元素，则需要先拿到3个塔最多盘子的数量d，用d减遍历层数i与该塔的盘子数集合方法.size()比较即可
        同理，确定非最多盘子数的塔的元素下标也可用d、i、.size()计算得到
    6.构建方法递归调用移动盘子，把盘子分为两部分看，上面(num-1)个盘子为一部分，最下面1个盘子为另一部分，
    只需先把上面部分的盘子移到中间的过渡塔，再把下面的盘子移动终点塔，再把上面盘子从过渡塔移到终点塔即可
    然后利用递归执行即可
    则有方法move1(int num, ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c)
    形参a为起始塔，b为过渡塔，c为终点塔，注意和左中右3个塔的实参x,y,z做出区分

    注意在首次执行时先调用方法arrayListFill填充起始塔a
        6.1)若递归到了最上层num==1则将盘子从起始塔顶部移动到终点塔顶部，利用方法removeFirst()和addFirst()
        6.2)若没到最上层则调用move1()进行递归，先把(num-1)个盘子移动过渡塔，move1(num - 1, a, c, b)
        6.3)再把起始塔顶部的1个盘子到终点塔顶部，同5.1)
        6.4)再把过渡塔上的(num-1)个盘子移到终点塔move1(num - 1, b, a, c)
    注意，我们需要在实际执行移动的语句6.1)和6.3)后面打印输出整个汉诺塔，print(x,y,z)
    且注意使用塔的实参x,y,z而非形参a,b,c
     */

    boolean first = true;

    //在此类内定义塔集合和运行方法，在调用时就无需再定义集合，
    //且3个塔的绝对位置可在递归调用时的print()方法打印顺序不乱
    ArrayList<Integer> x = new ArrayList<>();
    ArrayList<Integer> y = new ArrayList<>();
    ArrayList<Integer> z = new ArrayList<>();

    public void run(int num) {
        move1(num, x, y, z);
    }

    public void move1(int num, ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c) {
        if (first) {//如果为首次执行，则给集合a填充元素
            arrayListFill(num, a);
            first = false;
        }
        if (num == 1) {
            int n = a.removeFirst();//
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

    //打印一个塔的一个盘子
    public void comparePrint(int i, int d, ArrayList<Integer> a) {
        if (d - i > a.size()) {//如果此塔被遍历到的层数没有盘子，则输出一个空字符
            System.out.print(" " + "\t");
        } else if (d == a.size()) {//如果此塔是盘子数最多的，则直接输出下标为遍历数的元素
            System.out.print(a.get(i) + "\t");
        } else {//如果此塔被遍历到的层数有盘子，则输出下标为公式的元素
            System.out.print(a.get(a.size() - (d - i)) + "\t");
        }
    }

    //打印整个汉诺塔
    public void print(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c) {
        int d = Math.max(Math.max(a.size(), b.size()), c.size());
        for (int i = 0; i < d; i++) {
            //每次循环为从左往右输出元素的一层
            comparePrint(i, d, a);
            comparePrint(i, d, b);
            comparePrint(i, d, c);
            //一层输出完毕后换行
            System.out.println();
        }
        //整轮结束后换行
        System.out.println();
    }

    //正序列填充塔集合
    public void arrayListFill(int num, ArrayList<Integer> a) {
        for (int i = 0; i < num; i++) {
            a.add(i, i + 1);
        }
    }

}
