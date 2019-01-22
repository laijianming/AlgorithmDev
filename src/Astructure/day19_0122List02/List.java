package Astructure.day19_0122List02;

/**
 *  栈、队列线性表接口
 */
public interface List<E> {
    /**
     *  入栈或入队
     * @param o
     * @return
     */
    boolean push(E o);

    /**
     *  出栈或出队
     * @return
     */
    E pop();

    /**
     *  取栈顶或取队头
     * @return
     */
    E getTop();

    /**
     *  栈或队列是否为空
     * @return
     */
    boolean isEmpty();
}
