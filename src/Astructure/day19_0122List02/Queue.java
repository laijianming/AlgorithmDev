package Astructure.day19_0122List02;

/**
 *  队列的实现
 *  FIFO 先进先出
 * @param <E>
 */
public interface Queue<E> extends List<E> { }

/**
 *  顺序队列（数组实现）
 * @param <E>
 */
class ArrayQueue<E> implements Queue<E>{

    // 顺序队列的存储空间
    private E[] queue;

    // 队头指针
    public int head = 0;

    // 队尾指针
    public int tail = 0;

    // 队列的大小
    public int size = 0;

    // 队列的最大空间
    private int MAX_SIZE = 50;

    // 初始化队列
    public ArrayQueue(){
        queue = (E[]) new Object[MAX_SIZE];
    }

    /**
     *  入队
     * @param e
     * @return
     */
    @Override
    public boolean push(E e) {
        // 判断是否队满
        if(size == MAX_SIZE){
            throw new IndexOutOfBoundsException("队列已满！！");
        }
        // 在队尾的后一位插入元素并更新队尾
        queue[tail] = e;
        if(tail >= MAX_SIZE - 1){
            tail = 0;
        }else {
            tail ++;
        }
        size++;
        return true;
    }

    /**
     *  出队
     * @return
     */
    @Override
    public E pop() {
        if(isEmpty()){
            throw new IndexOutOfBoundsException("队列已空！！");
        }
        // 取队头并更新队头
        E e = queue[head];
        if(head >= MAX_SIZE - 1){
            head = 0;
        }else {
            head ++;
        }
        size --;
        return e;
    }

    /**
     *  取队头但不出队
     * @return
     */
    @Override
    public E getTop() {
        if(isEmpty()){
            throw new IndexOutOfBoundsException("队列已空！！");
        }
        // 取队头
        return queue[head];
    }

    @Override
    public boolean isEmpty() {
        return (size == 0)?true:false;
    }
}

/**
 *  链式队列（链表实现）
 * @param <E>
 */
class LinkedQueue<E> implements Queue<E>{

    /**
     *  元素节点类
     * @param <E>
     */
    class Node<E>{
        E e;
        Node next;
        public Node(E e){
            this.e = e;
        }
    }

    // 队头指针
    private Node<E> head;

    // 队尾指针
    private Node<E> tail;

    // 队列的大小
    public int size;

    /**
     *  入队
     * @param e
     * @return
     */
    @Override
    public boolean push(E e) {
        // 在队尾的后一位插入元素并更新队尾
        Node node = new Node(e);
        tail.next = node;
        tail = node;
        size++;
        return true;
    }

    /**
     *  出队
     * @return
     */
    @Override
    public E pop() {
        // 取队头并更新队头
        E e = head.e;
        head = head.next;
        size --;
        return e;
    }

    /**
     *  取队头但不出队
     * @return
     */
    @Override
    public E getTop() {
        if(isEmpty()){
            throw new IndexOutOfBoundsException("队列已空！！");
        }
        // 取队头
        return head.e;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0)?true:false;
    }
}