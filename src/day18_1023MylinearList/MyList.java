package day18_1023MylinearList;

/**
 * 线性表：顺序存取
 */
public class MyList {

    private int MAXSIZE = 100;

    private Object[] objs;

    // 当前最后一个元素的下标
    private int index = 0;

    private int TRUE = 1;
    private int FALSE = 0;

    public MyList() {
        initList();
    }

    public MyList(int MAXSIZE, Object[] objs) {
        this.MAXSIZE = MAXSIZE;
        this.objs = objs;
    }

    /**
     * 初始化list
     * @return
     */
    public Object[] initList(){
        index = 0;
        objs = new Object[MAXSIZE];
        return objs;
    }

    /**
     * 添加元素
     * @return
     */
    public int add(Object o){
        if(index == MAXSIZE){
            // 扩容
            incrCapacity();
        }
        objs[index] = o;
        index++;
        return TRUE;
    }

    /**
     * 扩容
     */
    private void incrCapacity() {
        System.out.println("MyList进行了一次扩容");
        index = 0;
        Object[] oldObjs = objs;
        MAXSIZE = MAXSIZE + (MAXSIZE >> 1);
        objs = initList();
        for(int i = 0;i < oldObjs.length;i++){
            objs[i] = oldObjs[i];
            index++;
        }
        index--;
    }

    /**
     * 查找元素
     * @return
     */
    public Object get(int flag){
        if(flag < 0 || flag >= MAXSIZE){
            return new RuntimeException("OUTOFBOUNDS");
        }
        return objs[flag];
    }

    /**
     * 删除元素
     */
    public int remove(int flag){
        if(flag < 0 || flag >= MAXSIZE){
            new RuntimeException("OUTOFBOUNDS");
        }
        int o = (int) objs[flag];
        for(int i = flag;i < index - 1;i++){
            objs[i] = objs[i+1];
        }
        index--;
        return o;
    }

    /**
     * 修改元素
     */
    public int updata(int flag,Object o){
        if(flag < 0 || flag >= MAXSIZE){
            new RuntimeException("OUTOFBOUNDS");
        }
        objs[flag] = o;
        return TRUE;
    }




}
