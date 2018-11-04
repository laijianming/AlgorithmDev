package day18_1102Graph;

/**
 * 有向图
 */
public class Graph {
    private int vertexSize; //顶点数量
    private int[] vertexs; // 顶点数组
    private int[][] matrix; // 邻接矩阵
    private static int MAX_WEIGHT = 10086; // 最大权值，即没有边
    private int MAX_VERTEX_SIZE;  // 最大节点数量

    // 初始化顶点数量
    public Graph(int vertexSize) {
        this.vertexSize = vertexSize;
        MAX_VERTEX_SIZE = vertexSize;
        matrix = new int[vertexSize][];
    }

    public int getVertexSize(){
        return this.vertexSize;
    }

    // 获取一个节点的出度
    public int getOut(int index){

        int x = 0;
        for(int i = 0; i < vertexSize; i++){
              if(matrix[index-1][i] > 0 && matrix[index-1][i] != 10086){
                    x++;
              }
        }
        return x;
    }

    // 获取一个节点的入度
    public int getIn(int index){
        int x = 0;
        for(int i = 0; i < vertexSize; i++){
            if(matrix[i][index-1] > 0 && matrix[i][index-1] != 10086){
                x++;
            }
        }
        return x;
    }

    // 获取两个节点间的权值
    public int getWeight(int v1, int v2){
        int weight = matrix[v1-1][v2-1];
        return (weight == 0) ? 0 : (weight == Graph.MAX_WEIGHT?MAX_WEIGHT:weight);
    }


    // 插入一个节点
    public void insert(int[] node){
        if(vertexSize >= MAX_VERTEX_SIZE){
            capacity();
        }
        matrix[vertexSize++] = node;
    }

    // 扩容
    public void capacity(){
        int flag = MAX_VERTEX_SIZE;
        MAX_VERTEX_SIZE = MAX_VERTEX_SIZE + (MAX_VERTEX_SIZE >> 1);
        int[][] oldMatrix = matrix;
        matrix = new int[MAX_VERTEX_SIZE][];
        for(int i = 0; i < flag; i++){
            matrix[i] = oldMatrix[i];
        }
    }


    public static void main(String[] args) {

        Graph graph = new Graph(5);
        int[] a1 = new int[]{0, MAX_WEIGHT, MAX_WEIGHT,MAX_WEIGHT,6};
        int[] a2 = new int[]{9, 0, 3,MAX_WEIGHT,MAX_WEIGHT};
        int[] a3 = new int[]{2, MAX_WEIGHT, 0,5,MAX_WEIGHT};
        int[] a4 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT,0,1};
        int[] a5 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT,MAX_WEIGHT,0};
        graph.matrix[0] = a1;
        graph.matrix[1] = a2;
        graph.matrix[2] = a3;
        graph.matrix[3] = a4;
        graph.matrix[4] = a5;
        System.out.println("图中的节点数：" + graph.getVertexSize());
        System.out.println("该节点的出度为：" + graph.getOut(5));
        System.out.println("该节点的入度为：" + graph.getIn(1));
        System.out.println("2 1 节点间的权值为：" + graph.getWeight(2, 1));

        int[] a6 = new int[]{1, 2, 3,4,5,0};
        graph.insert(a6);
        System.out.println("新插入节点的出度为：" + graph.getOut(6));


    }




}
