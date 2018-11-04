import org.junit.Test;

public class TestIdea {


    public void print(){
        System.out.println("我是父类的方法");
    }

    public static void main(String[] args) {
        TestIdea t = new TestIdea();
        t.print();
    }


}
class child extends TestIdea{

    @Override
    public void print() {
//        super.print();
        System.out.println("我的子类的方法");
    }

    @Test
    public void test1() {

    }

    public static void main(String[] args) {
        TestIdea c = new child();
        c.print();
    }

}