package Astructure.day19_0121List01;

/**
 *  顺序表实现
 */
public class ArrayList<E> implements List<E> {

    // 元素集合
    private E[] arrayList;

    // 集合大小
    int size;

    // 集合最大大小
    private int MAX_SIZE = 50;

    public ArrayList() {
        arrayList = (E[]) new Object[MAX_SIZE];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(int index, E o) {
        // 下标值是否正确
        if(index < 0 || index >= MAX_SIZE){
            throw new IndexOutOfBoundsException();
        }
        // 若集合容量已达最大值，则返回false，插入失败
        if(size >= MAX_SIZE - 1){
            return false;
        }
        // 把该下标及之后的元素全部往后移一位
        for(int i = size; i > index; i--){
            arrayList[i] = arrayList[i - 1];
        }
        arrayList[index] = o;
        size++;
        return true;
    }

    @Override
    public boolean remove(int index) {
        // 下标值是否正确
        if(index < 0 || index >= MAX_SIZE){
            throw new IndexOutOfBoundsException();
        }
        // 将该下标之后的值往前移一位，覆盖掉下标原来的值
        for(int i = index; i < size - 1; i++){
            arrayList[i] = arrayList[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public E get(int index) {
        // 下标值是否正确
        if(index < 0 || index >= MAX_SIZE){
            throw new IndexOutOfBoundsException();
        }
        // 返回该下标的值
        return arrayList[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0? true:false;
    }
}
