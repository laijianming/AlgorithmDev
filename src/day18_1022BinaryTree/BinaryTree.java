package day18_1022BinaryTree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *  二叉树
 */
public class BinaryTree {

    TreeNode root;
    /**
     * 树节点
     */
    static class TreeNode{
        private Object data;
        private TreeNode leftChild;
        private TreeNode rightChild;
        public TreeNode() {
        }

        public TreeNode(Object data) {
            this.data = data;
        }

    }

    /**
     * 初始化树
     * @return
     */
    public TreeNode initTree(String data){
        TreeNode root = new TreeNode(data);
        this.root = root;
        return root;
    }

    /**
     *  递归：
     *    前序遍历
     */
    public void preTree(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        if(node.leftChild != null){
            preTree(node.leftChild);
        }
        if(node.rightChild != null){
            preTree(node.rightChild);
        }

    }



    /**
     * 利用先序遍历的规律来创建二叉数
     * @param data
     */
    public  TreeNode createTree(ArrayList<Object> data){
        // A B D # # E # # C H # # I # #
        // 创建根节点
        TreeNode node = null;
        if (data.get(0) == "#"){
            data.remove(0);
            return node;
        }
        node = new TreeNode(data.get(0));
        if(root == null){
            root = new TreeNode(data.get(0));
            node = root;
        }
        data.remove(0);
        node.leftChild = createTree(data);
        node.rightChild = createTree(data);
        return node;

    }

    /**
     * 先序遍历
     *      非递归
     * @param node
     */
    public void preOrder(TreeNode node){
        Stack<TreeNode> s = new Stack<>();
        while (node != null || !s.empty()){
            if(node != null){
                System.out.print(node.data + " ");
                s.push(node);
            }
            if(node.leftChild != null){
                node = node.leftChild;
            }else if(node.rightChild != null){
                node = node.rightChild;
            }else{
                s.pop();
                node = null;
                while(!s.empty()){
                    if((node = s.pop().rightChild) != null){
                        break;
                    }
                }
            }
        }
    }


    /**
     * 测试树
     * @param args
     */
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        // 构造树结构
//        TreeNode root = binaryTree.initTree("A");
//        root.leftChild = new TreeNode("B");
//        root.rightChild = new TreeNode("C");
//        root.leftChild.leftChild = new TreeNode("D");
//        root.leftChild.rightChild = new TreeNode("E");
//        root.rightChild.leftChild = new TreeNode("H");
//        root.rightChild.rightChild = new TreeNode("I");
//        // 测试递归前序遍历 A B D E C H I
//        binaryTree.preTree(root);
        // A B D # # E # # C H # # I # #
        Object[] data = {"A", "B" , "D" , "#" , "#" , "E" , "#" , "#" , "C" , "H" , "#" , "#" , "I" , "#" , "#"};
        List<Object> datas = Arrays.asList( data);
        ArrayList<Object> arrayList = new ArrayList<>(datas);
        System.out.println(arrayList.get(0));
        binaryTree.createTree(arrayList);
        System.out.println("\n迭代遍历二叉树");
        binaryTree.preTree(binaryTree.root);
        System.out.println("\n非迭代遍历二叉树");
        binaryTree.preOrder(binaryTree.root);
    }

}
