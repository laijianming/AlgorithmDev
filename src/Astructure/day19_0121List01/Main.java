package Astructure.day19_0121List01;

public class Main {

    public static void main(String[] args) {

//        ArrayList<People> arrayList = new ArrayList();
        // 创建插入元素
        People p1 = new People("a");
        People p2 = new People("b");
        People p3 = new People("c");
        People p4 = new People("d");
        People p5 = new People("e");

//        arrayList.add(arrayList.size,p1);
//        arrayList.add(arrayList.size,p2);
//        arrayList.add(arrayList.size,p3);
//        arrayList.add(arrayList.size,p4);
//        arrayList.remove(1);
//        arrayList.isEmpty();
//        arrayList.add(arrayList.size,p5);
//        arrayList.add(arrayList.size,p5);

//        People people = arrayList.get(3);
//        System.out.println(people.name);


        LinkedList linkedList = new LinkedList<People>();
        linkedList.add(linkedList.size,p1);
        linkedList.add(linkedList.size,p2);
        linkedList.add(linkedList.size,p3);
        linkedList.add(1,p4);
        linkedList.remove(3);
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.isEmpty());
        System.out.println("end ... ");


    }


}

class People{
    String name;
    public People(String name){
        this.name = name;
    }
}