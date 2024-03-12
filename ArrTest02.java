import org.junit.jupiter.api.Test;

public class ArrTest02 {
    public ArrTest02() {
    }

    @Test
    public void homeWork01() {
        char[] arr1 = {'a', 'b', 'c', 'd'};
        char[] arr2 = arr1;
        arr1[2] = '乘';
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr1[i] + "," + arr2[i]);

        }
    }
}
