import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GoBang game01 = new GoBang();
        game01.gameStart();//后续仍需完善几个输入判断、异常捕捉和回合倒计时功能
    }
}
class Test_1 {
    @Test
    public void Test1(){
        Hanoi hanoi = new Hanoi();
        //hanoi.move(3, 'A', 'B', 'C');

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        hanoi.move1(3, a, b, c);
    }
    @Test
    public void Test_1() {
//        int i = 66;
//        System.out.printf("%.2f",(10.0/3));
//        for (int x = 0; x < 3; ++x) {
//            System.out.println(x);
//        }
//        Triangle.HollowTriangle(2);
//        String s1 = "runoob";
//        String s2 = "runoob";
//        System.out.println("s1 == s2 is:" + s1 == s2);
//        int[] myArray = {1, 2, 3, 4, 5};
//        ChangeIt.doIt( myArray );
//        for(int j=0; j<myArray.length; j++)
//            System.out.print( myArray[j] + " " );
//        int[] myArray1 = new int[4];
//        for(int j=0; j<myArray1.length; j++)
//            System.out.print( myArray1[j] + " " );
////        int[] myArray2 = null;
////        myArray = myArray2;
////        for(int j=0; j<myArray.length; j++)
////            System.out.print( myArray[j] + " " );
//        Arr arr0 = new Arr();
//        Arr arr1 = new Arr();
//        Arr arr2 = new Arr();
//        Arr[] arrs = {arr0, arr1, arr2};
//        Triangle.YangHuiTriangle(10);
//        Triangle.YangHuiTriangle01(10);
//        Triangle.hollowTriangle(10);
//        Triangle.hollowTriangle01(10);
//        char x = (char) 97;
//        System.out.println(x);
//        int y = 'A';
//        System.out.println(y - 'a');
//        String s1 = null;
//        System.out.println(s1 == "gg");//s1为null时.equals()报错
        int[] l = {1, 0, 1, 1, 1, 1, 0, 0, 0};
        String s = "";
        for (int i : l) {
            s = s.concat(String.valueOf(i));
        }
        System.out.println(s);
        System.out.println(s.contains("11111"));
    }
}
class ChangeIt
{
    static void doIt( int[] z )
    {
        int[] A = null;
        z[0] = 2 ;
        z = A ;
    }
}
