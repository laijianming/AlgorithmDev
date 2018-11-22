package Astructure.day18_1023MylinearList;

import org.junit.Test;

public class TestMyList {

    public static void main(String[] args) {
        // 初始化list
        MyList list = new MyList();
        // 添加元素
        for(int i = 0; i < 103; i++){
            list.add(i);
        }
        // 查找元素
        System.out.println(list.get(88));
        // 修改元素
        list.updata(6,666);
        for (int i = 0; i <= 20 ; i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        // 删除元素
        int o = list.remove(3);
        System.out.println("删除第3个元素" + o);
        for (int i = 0; i <= 20 ; i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();



    }

    @Test
    public void test(){
        int a = 100;
        System.out.println(a >> 2);
        int b = a + a >>2;
        System.out.println(b);
    }

}
