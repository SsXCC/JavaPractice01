import org.junit.jupiter.api.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class Main {
    public static void main(String[] args) {
        GoBang game01 = new GoBang();
        game01.gameStart();
//        game01.printBorad();
    }
}
class Test_1 {
    public Test_1() {
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
        int y = 'A';
        System.out.println(y - 'a');
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
