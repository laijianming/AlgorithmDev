import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestIdea {

    static int[] numbers;

    /**
     * 快速排序
     * <p>
     * 大量数据时比冒泡排序要快很多，但数据到达一个量的时候，会产生栈溢出
     * 通过循环递归的层数过多，导致栈溢出
     * <p>
     * 故快速排序不适合“大量”数据排序的时候使用
     *
     * @param numbers 带排序数组
     */
    public static void quick(int[] numbers) {
        if (numbers.length > 0) {
            //查看数组是否为空
            quickSort(numbers, 0, numbers.length - 1);
        }
    }


    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     *
     * @param numbers 带查找数组
     * @param low     开始位置
     * @param high    结束位置
     * @return 中轴所在位置
     */
    public static int getMiddle(int[] numbers, int low, int high) {
        int temp = numbers[low]; //数组的第一个作为中轴
        while (low < high) {
            while (low < high && numbers[high] > temp) {
                high--;
            }
            numbers[low] = numbers[high];//比中轴小的记录移到低端
            while (low < high && numbers[low] < temp) {
                low++;
            }
            numbers[high] = numbers[low]; //比中轴大的记录移到高端
        }
        numbers[low] = temp; //中轴记录到尾
        return low; // 返回中轴的位置
    }


    /**
     * @param numbers 带排序数组
     * @param low     开始位置
     * @param high    结束位置
     */
    public static void quickSort(int[] numbers, int low, int high) {
        if (low < high) {
            int middle = getMiddle(numbers, low, high); //将numbers数组进行一分为二
            quickSort(numbers, low, middle - 1);   //对低字段表进行递归排序
            quickSort(numbers, middle + 1, high); //对高字段表进行递归排序
        }
    }

    public static void main(String[] args) {
        numbers = new int[]{10, 6, 16, 2};
        quick(numbers);
        System.out.println(Arrays.toString(numbers));
    }

}