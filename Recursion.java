public class Recursion {
    public int fibonacci(int n) {
        if (n >= 1) {
            if (n == 1 || n == 2) return 1;
            else return fibonacci(n - 2) + fibonacci(n - 1);
        } else {
            System.out.println("请输入大于0的整数");
            return -1;
        }
    }
}
