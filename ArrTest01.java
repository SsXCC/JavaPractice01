import org.junit.Test;

import java.util.Scanner;

public class ArrTest01 {
    @Test
    public void arrMethod01() {
        //通过输入获取数组长度
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        int n = scanner.nextInt();
        //通过输入获取随机数取值范围
        System.out.println("请依次输入数组取值范围的最小值和最大值：");
        int min = scanner.nextInt();
        int max = scanner.nextInt();
        //通过输入获取想要查找的数
        System.out.println("请输入想要查找的数：");
        int x = scanner.nextInt();
        //定义数组
        int[] arr = new int[n];
        System.out.println("=======================");
        arrMethor02(arr, max, min, x);
        //升序排列数组但降序输出数组
//        int[] arr01 = {1, 2, 3, 4, 5, 6, 7, 8};
        arrSort(arr);
    }

    private static void arrMethor02(int[] arr, int max, int min, int x) {
        //定义数组内的最大值及其下标
        int maxnum = -1;
        int indexmaxnum = 0;
        //定义辅助查找目标值的布尔值
        boolean isTrue = false;
        System.out.println("正序输出数组：");
        for (int i = 0; i < arr.length; i++) {
            //将在[min,max]范围内的随机数赋依次给数组元素
            arr[i] = (int) (Math.random() * max)- (int) (Math.random() * (min - 1)) + 1;
            //正序输出数组
            System.out.print(arr[i] + " ");
            //找出最大值及其下标
            if (arr[i] > maxnum) {
                maxnum = arr[i];
                indexmaxnum = i;
            }
            //判断数组内是否存在查找值
            if (arr[i] == x) {
                isTrue = true;
            }
        }
        System.out.println("");
        //输出数组内最大值及其下标
        System.out.println("数组内最大值：" + maxnum);
        System.out.println("数组内最大值下标：" + indexmaxnum);
        //判断数组内是否有想要查找的数
        if (isTrue == true) {
            System.out.println("数组内有" + x);
        } else {
            System.out.println("数组内没有" + x);
        }
        //倒序输出数组
        System.out.println("倒序输出数组：");
        for (int j = arr.length - 1; j >= 0; j--) {
            System.out.print(arr[j] + " ");
        }
        System.out.println("");
    }

    private static void arrSort(int[] arr) {
        boolean isDone = false;
        System.out.println("降序输出数组：");
        for (int j = 0; j < arr.length - 1; j++) {
            int temp = -1;
            //如果没有交换排序则说明数组已完成排序，后续无需再进交换排序的for循环
            if (isDone == false) {
                //将最大值沉底（升序排列）并输出
                for (int k = 0; k < arr.length - j -1; k++) {
                    if (arr[k] > arr[k + 1]) {
                        temp = arr[k];
                        arr[k] = arr[k + 1];
                        arr[k + 1] = temp;
                    }
                }
            }else {
                System.out.print(arr[arr.length - j - 1]+" ");
                continue;
            }
            if (temp == -1) {
                isDone = true;
            }
            System.out.print(arr[arr.length - j - 1]+" ");
        }
        System.out.print(arr[0]);
    }
}
