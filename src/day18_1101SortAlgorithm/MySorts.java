package day18_1101SortAlgorithm;

import org.junit.Test;

import java.util.Date;

public class MySorts {
    static int[] numbers;
    static int[] copy;
    static int start;

    public static void main(String[] args) {
        // 对10w条不同的随机数进行测试时间
        init();
        System.out.println("开始1w条随机数排序 -- 从 " + start + " 条开始打印");

        // 测试冒泡排序
        System.out.println("冒泡:");
        long time1 = getTime();
        bubbleSort(numbers);
        long time2 = getTime();
        print();
        long time = time2 - time1;
        System.out.println("执行时间： " + time);
        numbers = copy;  // 复原

        // 测试快速排序
        System.out.println("快速:");
        long time3 = getTime();
        quick(numbers);
        long time4 = getTime();
        print();
        time = time4 - time3;
        System.out.println("执行时间： " + time);
        numbers = copy;  // 复原

        // 测试选择排序
        System.out.println("选择:");
        long time5 = getTime();
        selectSort(numbers);
        long time6 = getTime();
        print();
        time = time6 - time5;
        System.out.println("执行时间： " + time);
        numbers = copy;  // 复原

        // 测试插入排序
        System.out.println("插入:");
        long time7 = getTime();
        insertSort(numbers);
        long time8 = getTime();
        print();
        time = time8 - time7;
        System.out.println("执行时间： " + time);
        numbers = copy;  // 复原

        // 测试希尔排序
        System.out.println("希尔:");
        long time9 = getTime();
        shellSort(numbers);
        long time10 = getTime();
        print();
        time = time10 - time9;
        System.out.println("执行时间： " + time);
        numbers = copy;  // 复原
    }

    public static void init() {
        numbers = new int[10000];
        int a = 0;
        boolean flag = false;
        for (int i = 0; i < 10000; ) {
            a = (int) (Math.random() * 1000000);
            for (int j = 0; j <= i; j++) {
                if (numbers[j] == a) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                numbers[i] = a;
                i++;
            }
            flag = false;
        }
        copy = numbers;
        start = (int) (Math.random() * 1000);
    }

    public static void print() {
        for (int i = start; i < start + 10; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    public static long getTime() {
        Date d = new Date();
        return d.getTime();
    }

    /**
     * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * @param numbers 需要排序的整型数组
     */
    public static void bubbleSort(int[] numbers) {
        int temp = 0;
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {  //交换两数位置
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

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


    /**
     * 选择排序算法
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
     * 以此类推，直到所有元素均排序完毕。
     *
     * @param numbers
     */
    public static void selectSort(int[] numbers) {
        int size = numbers.length; //数组长度
        int temp = 0; //中间变量

        for (int i = 0; i < size; i++) {
            int k = i;   //待确定的位置
            //选择出应该在第i个位置的数
            for (int j = size - 1; j > i; j--) {
                if (numbers[j] < numbers[k]) {
                    k = j;
                }
            }
            //交换两个数
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
        }
    }


    /**
     * 插入排序
     * <p>
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 将新元素插入到该位置中
     * 重复步骤2
     *
     * @param numbers 待排序数组
     */
    public static void insertSort(int[] numbers) {
        int size = numbers.length;
        int temp = 0;
        int j = 0;

        for (int i = 0; i < size; i++) {
            temp = numbers[i];
            //假如temp比前面的值小，则将前面的值后移
            for (j = i; j > 0 && temp < numbers[j - 1]; j--) {
                numbers[j] = numbers[j - 1];
            }
            numbers[j] = temp;
        }
    }


    /**
     * 希尔排序的原理:根据需求，如果你想要结果从大到小排列，它会首先将数组进行分组，然后将较大值移到前面，较小值
     * 移到后面，最后将整个数组进行插入排序，这样比起一开始就用插入排序减少了数据交换和移动的次数，可以说希尔排序是加强
     * 版的插入排序
     * 拿数组5, 2, 8, 9, 1, 3，4来说，数组长度为7，当increment为3时，数组分为两个序列
     * 5，2，8和9，1，3，4，第一次排序，9和5比较，1和2比较，3和8比较，4和比其下标值小increment的数组值相比较
     * 此例子是按照从大到小排列，所以大的会排在前面，第一次排序后数组为9, 2, 8, 5, 1, 3，4
     * 第一次后increment的值变为3/2=1,此时对数组进行插入排序，
     * 实现数组从大到小排
     */

    public static void shellSort(int[] data) {
        int j = 0;
        int temp = 0;
        //每次将步长缩短为原来的一半
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < data.length; i++) {
                temp = data[i];
                for (j = i; j >= increment; j -= increment) {
                    if (temp > data[j - increment])//如想从小到大排只需修改这里
                    {
                        data[j] = data[j - increment];
                    } else {
                        break;
                    }

                }
                data[j] = temp;
            }

        }
    }


    /**
     * 归并排序
     * 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。
     * 然后再把有序子序列合并为整体有序序列
     *
     * 时间复杂度为O(nlogn)
     * 稳定排序方式
     *
     * @param nums 待排序数组
     * @return 输出有序数组
     */
    public static int[] sort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            sort(nums, low, mid);
            // 右边
            sort(nums, mid + 1, high);
            // 左右归并
            merge(nums, low, mid, high);
        }
        return nums;
    }

    /**
     * 将数组中low到high位置的数进行排序
     *
     * @param numbers 待排序数组
     * @param low  待排的开始位置
     * @param mid  待排中间位置
     * @param high 待排结束位置
     */
    public static void merge(int[] numbers, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (numbers[i] < numbers[j]) {
                temp[k++] = numbers[i++];
            } else {
                temp[k++] = numbers[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = numbers[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = numbers[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            numbers[k2 + low] = temp[k2];
        }
    }


    /**
     * 对data数组从0到lastIndex建大顶堆
     * <p>
     * 初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个 堆，这时堆的根节点的数最大。
     * 然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。
     * 依此类推，直到只有两个节点的堆，并对 它们作交换，最后得到有n个节点的有序序列。
     * 从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。
     * 所以堆排序有两个函数组成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。
     *
     * @param numbers
     * @param lastIndex
     */
    public static void buildMaxHeap(int[] numbers, int lastIndex) {
        //从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            //k保存正在判断的节点
            int k = i;
            //如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                //k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    //若果右子节点的值较大
                    if (numbers[biggerIndex] < numbers[biggerIndex + 1]) {
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if (numbers[k] < numbers[biggerIndex]) {
                    //交换他们
                    swap(numbers, k, biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    //交换
    public static void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }


    @Test
    public void test() {
        int[] a = {3, 8, 6, 7, 9};
        quick(a);
        for (int i : a) {
            System.out.println(i);
        }

    }


}
