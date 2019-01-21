package Astructure.day19_0121List;

/**
 *  线性表接口
 */
public interface List<E> {

    /**
     *  求元素个数
     * @return
     */
    int size();

    /**
     *  插入元素
     *  param index 插入的位置
     * @param e 插入的元素
     * @return
     */
    boolean add(int index, E e);

    /**
     *  删除元素
     * @param index 删除元素的下标
     * @return
     */
    boolean remove(int index);

    /**
     *  获取指定下标的元素
     * @param index 元素下标
     * @return
     */
    E get(int index);

    /**
     *  判断集合是否为空
     * @return
     */
    boolean isEmpty();



}
