package Astructure.day18_1024MyLinkedList;

/**
 * 线性表：链式存储
 */
public class MyLinkedList {
    /**
     *  链表节点
     */
    static class Node{
        Object data;
        Node previous;
        Node next;

        public Node() {
        }

        public Node(Object data) {
            this.data = data;
        }
    }
    // 首节点指针
    private Node root;
    // 尾节点指针
    private Node tail;

    // 链表长度
    int length = 0;

    public MyLinkedList() {
        Node root = initLinkedList();
        root.previous = root;
        root.next = root;
        tail = root;
    }

    public MyLinkedList(Object o) {
        Node root = initLinkedList();
        root.data = o;
        root.previous = root;
        root.next = root;
        tail = root;
    }

    /**
     *  初始化链表
     */
    public Node initLinkedList(){
        root = new Node();
        return root;
    }

    /**
     * 添加节点
     * @param o
     */
    public void add(Object o){
        Node node = new Node(o);
        addHandle(node);
        length++;
    }

    public void addHandle(Node node){
        root.previous = node;
        tail.next = node;
        tail = node;
    }

    public Object get(){
      return root.data;
    }

    public Object get(Object o){

        return null;
    }

    public void printLink(){
        Node print = root;
        for(int i = 0; i < length; i++){
            System.out.println(print.data);
            print = print.next;
        }
    }

}
