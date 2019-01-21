package Astructure.day19_0121List;

/**
 *  单向链表实现
 * @param <E>
 */
public class LinkedList<E> implements List<E> {

    // 链表元素
    class Node<E>{
        // 下一个节点
        Node next;
        // 节点值
        E e;
        public Node() {
        }
        public Node(E e){
            this.e = e;
        }
    }

    // 链表长度
    int size;

    // 头节点
    private Node head;

    // 尾节点
    private Node tail;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(int index, E e) {
        // 若插入位置大于尾节点后两位，则插入失败
        if(index > size){
            return false;
        }
        // 创建一个新的节点
        Node<E> node = new Node<>(e);
        if(head == null){
            head = node;
            tail = head;
            size++;
            return true;
        }
        // 若 index == size，则直接插入到尾节点
        if(index == size){
            tail.next = node;
            tail = node;
            size++;
            return true;
        }

        // 把节点加入到第 index 位置下
        Node temp = head;
        // 找到 index 的前一个位置 temp
        for(int i = 1; i < index; i ++){
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
        return true;
    }

    @Override
    public boolean remove(int index) {
        // 判断节点位置
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        // 删除该下标位置下的节点
        if(index == 0){ // 删除头节点
            head = head.next;
            size--;
            return true;
        }
        Node temp = head;
        // 找到下标节点并删除
        for(int i = 1; i < size; i ++){
            if(i == index){
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
        return true;
    }

    @Override
    public E get(int index) {
        // 判断节点位置
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        // 找到下标节点
        for(int i = 1; i < size; i ++){
            temp = temp.next;
            if(i == index){
                break;
            }
        }
        return (E) temp.e;
    }

    @Override
    public boolean isEmpty() {
        return size == 0?true:false;
    }
}
