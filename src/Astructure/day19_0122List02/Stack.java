package Astructure.day19_0122List02;


/**
 *  栈的实现
 *  FILO 先进后出
 */
public interface Stack<E> extends List<E> { }

/**
 *  顺序栈
 * @param <E>
 */
class ArrayStack<E> implements Stack<E>{

    // 顺序栈的存储空间
    private E[] stack;

    // 栈顶指针
    private int heap = -1;

    // 栈的大小
    public int size;

    // 栈的最大空间
    private int MAX_SIZE = 50;

    // 初始化栈
    public ArrayStack(){
        stack = (E[]) new Object[MAX_SIZE];
    }

    /**
     * 入栈
     * @param e 入栈元素
     * @return
     */
    @Override
    public boolean push(E e) {
        // 判断是否栈满
        if(size >= MAX_SIZE){
            return false;
        }
        //入栈
        size++;
        stack[++heap] = e;
        return true;
    }

    /**
     *  出栈
     * @return
     */
    @Override
    public E pop() {
        if(isEmpty()){
            throw new StackOverflowError("栈已为空！！");
        }
        // 出栈
        size--;
        return stack[heap--];
    }

    /**
     *  取栈顶元素但不出栈
     * @return
     */
    @Override
    public E getTop() {
        if(isEmpty()){
            throw new StackOverflowError("栈已为空！！");
        }
        return stack[heap];
    }

    /**
     *  判断栈是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (heap == -1)?true:false;
    }
}

/**
 *  链栈
 * @param <E>
 */
class LinkedStack<E> implements Stack<E>{

    /**
     *  元素节点类
     * @param <E>
     */
    class Node<E>{
        E e;
        Node pre;
        Node next;
        public Node(E e){
            this.e = e;
        }
    }

    // 栈顶指针
    private Node<E> heap;

    // 栈的大小
    public int size;


    /**
     *  入栈
     * @param o
     * @return
     */
    @Override
    public boolean push(E e) {
        // 创建节点
        Node<E> node = new Node<>(e);
        size++;
        // 若栈顶为空，则给栈顶赋值
        if(heap == null){
            heap = node;
            return true;
        }
        // 连接原栈顶与新节点
        heap.next = node;
        node.pre = heap;
        heap = node; // 更新栈顶
        return true;
    }

    /**
     *  出栈
     * @return
     */
    @Override
    public E pop() {
        if(heap == null){
            throw new StackOverflowError("栈已为空！！");
        }
        size--;
        E e = heap.e; // 取栈顶元素值
        heap = heap.pre; // 更新栈顶
        return e;
    }

    /**
     *  取栈顶元素但不出栈
     * @return
     */
    @Override
    public E getTop() {
        if(heap == null){
            throw new StackOverflowError("栈已为空！！");
        }
        return heap.e;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0)?true:false;
    }
}
