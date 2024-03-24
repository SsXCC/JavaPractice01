import org.junit.jupiter.api.Test;

public class Recursion {
    //斐波那契，a(0)=a(1)=1,a(n-2)+a(n-1)
    public int fibonacci(int n) {
        if (n >= 1) {
            if (n == 1 || n == 2) return 1;
            else return fibonacci(n - 2) + fibonacci(n - 1);
        } else {
            System.out.println("请输入大于0的整数");
            return -1;
        }
    }

    @Test
    public void getFibonacci() {
        System.out.println(fibonacci(10));
    }

    //猴子吃桃，有若干个桃子，每天吃一半再吃一个，第10天没吃前正好还有1个桃子，求桃子数量
    //设倒数第n天，桃子数量peach
    public int monkeyPeach(int day) {
        int peach;
        if (day == 1) return peach = 1;
        else {
            return peach = (monkeyPeach(day - 1) + 1) * 2;
        }
    }

    @Test
    public void getMonkeyPeach() {
        System.out.println(monkeyPeach(10));
    }

//    public int maze(int map[][], int n, int m) {
//
//    }
}
