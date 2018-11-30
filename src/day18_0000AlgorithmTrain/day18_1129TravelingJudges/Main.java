package day18_0000AlgorithmTrain.day18_1129TravelingJudges;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 *问题描述
 * 　　一组人要担任在一个特定城市举办的比赛的评委，他们需要找到最便宜的租车方式使得每个人都到达目标城市。他们观察发现，如果几个人在旅途的某一段坐同一辆租的车，就可以减少总费用。你的任务就是找出这些人应该采取的路线使得租车的总费用最小。
 * 　　我们假定：
 * 　　1. 租一辆车的费用与它行驶的距离成正比，没有燃油、保险、乘客人数多于一个等产生的额外费用。
 * 　　2. 所有车的费用与行驶距离的比例相同。
 * 　　3. 一辆车可以容纳任意数量的乘客。
 * 　　4. 任意一对城市之间最多只有一条道路直接相连，每条道路都是双向的且长度大于0。
 * 　　5. 每个人的起始城市到目标城市都至少有一种路线。
 * 　　6. 若多个人的路线中经过同一城市，则这些人从该城市到目标城市必乘同一辆车。
 * 　　7. 一个人可以乘一辆车到某个城市，再乘另一辆车离开该城市。
 * 输入格式
 * 　　第一行包含三个整数nc, dc和nr，表示地图上的城市个数，目标城市的编号和地图上的道路条数。
 * 　　接下来nr行每行包含三个整数c1, c2和dist，表示一条长度为dist的双向道路(c1, c2)。
 * 　　接下来一行包含一个整数nj，表示人数。
 * 　　接下来一行包含nj个整数，表示每个人的起始城市。
 * 输出格式
 * 　　第一行包含“distance = ”和一个整数，表示所租的车行驶的最小总距离。
 * 　　接下来nj行每行包含一个人的访问路线，城市按访问顺序给出并用“-”连接。
 * 　　存在多种方案时，选择需要访问到的城市集合元素最少的一种；仍然存在多种方案时，选择集合元素升序排列后字典序最小的一种。
 * 样例输入
 * 5 3 5
 * 1 2 1
 * 2 3 2
 * 3 4 3
 * 4 5 1
 * 2 4 2
 * 2
 * 5 1
 * 样例输出
 * distance = 6
 * 5-4-2-3
 * 1-2-3
 * 样例输入
 * 4 4 3
 * 1 3 1
 * 2 3 2
 * 3 4 2
 * 2
 * 1 2
 * 样例输出
 * distance = 5
 * 1-3-4
 * 2-3-4
 * 样例输入
 * 3 3 3
 * 1 2 2
 * 1 3 3
 * 2 3 1
 * 2
 * 2 1
 * 样例输出
 * distance = 3
 * 2-3
 * 1-2-3
 * 数据规模和约定
 * 　　对于30%的数据，1 <= nc <= 8。
 * 　　对于100%的数据，1 <= nc <= 20，1 <= nj <= 10，1 <= dist <= 100。
 *
 *
 */
public class Main {

    static class Graph {
        private int vertexSize;//顶点数量
        private int[] vertexs;//顶点数组
        private int[][] matrix;
        private static final int MAX_WEIGHT = 1000;
        private boolean[] isVisited;

        public Graph(int vertextSize) {
            this.vertexSize = vertextSize;
            matrix = new int[vertextSize][vertextSize];
            for (int i = 0; i < vertextSize; i++){
                for(int j = 0; j < vertextSize; j++){
                    matrix[i][j] = MAX_WEIGHT;
                }
            }
            vertexs = new int[vertextSize];
            for (int i = 0; i < vertextSize; i++) {
                vertexs[i] = i;
            }
            isVisited = new boolean[vertextSize];
        }


        /**
         * 获取某个顶点的出度
         *
         * @return
         */
        public int getOutDegree(int index) {
            int degree = 0;
            for (int j = 0; j < matrix[index].length; j++) {
                int weight = matrix[index][j];
                if (weight != 0 && weight != MAX_WEIGHT) {
                    degree++;
                }
            }
            return degree;
        }


        /**
         * 入度
         * @return
         */

        /**
         * 获取某个顶点的第一个邻接点
         */
        public int getFirstNeighbor(int index) {
            for (int j = 0; j < vertexSize; j++) {
                System.out.println(index + ":" + j + "---" + matrix[index][j]);
                if (matrix[index][j] > 0 && matrix[index][j] < MAX_WEIGHT) {
                    return j;
                }
            }
            return -1;
        }

        /**
         * 根据前一个邻接点的下标来取得下一个邻接点
         *
         * @param v     表示要找的顶点
         * @param index 表示该顶点相对于哪个邻接点去获取下一个邻接点
         */
        public int getNextNeighbor(int v, int index) {
            for (int j = index + 1; j < vertexSize; j++) {
                System.out.println(v + ":" + j + "====" + matrix[v][j]);
                if (matrix[v][j] > 0 && matrix[v][j] < MAX_WEIGHT) {

                    return j;
                }
            }
            return -1;
        }

        /**
         * 图的深度优先遍历算法
         */
        private void depthFirstSearch(int i) {
            isVisited[i] = true;
            int w = getFirstNeighbor(i);//
            while (w != -1) {
                if (!isVisited[w]) {
                    //需要遍历该顶点
                    depthFirstSearch(w);
                }
                w = getNextNeighbor(i, w);//第一个相对于w的邻接点
            }
        }

        /**
         * 对外公开的深度优先遍历
         */

        public void depthFirstSearch() {
            isVisited = new boolean[vertexSize];
            for (int i = 0; i < vertexSize; i++) {
                if (!isVisited[i]) {
                    depthFirstSearch(i);
                }
            }
            isVisited = new boolean[vertexSize];
        }

        public void broadFirstSearch() {
            isVisited = new boolean[vertexSize];
            for (int i = 0; i < vertexSize; i++) {
                if (!isVisited[i]) {
                    broadFirstSearch(i);
                }
            }
        }

        /**
         * 实现广度优先遍历
         *
         * @param i
         */
        private void broadFirstSearch(int i) {
            int u, w;
            LinkedList<Integer> queue = new LinkedList<Integer>();
            isVisited[i] = true;
            queue.add(i);//第一次把v0加到队列
            while (!queue.isEmpty()) {
                u = (Integer) (queue.removeFirst()).intValue();
                w = getFirstNeighbor(u);
                while (w != -1) {
                    if (!isVisited[w]) {
                        isVisited[w] = true;
                        queue.add(w);
                    }
                    w = getNextNeighbor(u, w);
                }
            }
        }

        /**
         * prim 普里姆算法
         */
        public void prim(int start, int end) {
            int[] lowcost = new int[vertexSize];//最小代价顶点权值的数组,为0表示已经获取最小权值
            int[] adjvex = new int[vertexSize];//放顶点权值
            int min, minId, sum = 0;
            StringBuilder minPath = new StringBuilder();
            minPath.append(start);
            for (int i = 1; i < vertexSize; i++) {
                lowcost[i] = matrix[start][i];
            }
            for (int i = 1; i < end; i++) {
                min = MAX_WEIGHT;
                minId = 0;
                // 找 lowcost中最小的权值下标（节点）
                for (int j = 0; j < vertexSize; j++) {
                    if (lowcost[j] < min && lowcost[j] > 0) {
                        min = lowcost[j];
                        minId = j;
                    }
                }
                // 找到一个 连接的 最小点
                lowcost[minId] = 0; // 将已遍历的节点权值置0
                minPath.append("-");
                minPath.append(minId);
                // 把第minId行的权值与lowcost比较，小的权值放上去替换
                // 找刚刚遍历的节点所在的邻接矩阵行的权值与lowcost进行比较，替换出更小的权值并且记录是 minId 所连接的（在adjvex对应下标记录minId即可）
                for (int j = 1; j < vertexSize; j++) {
                    if (lowcost[j] != 0 && matrix[minId][j] < lowcost[j]) {
                        lowcost[j] = matrix[minId][j];
                        adjvex[j] = minId;
                    }
                }
            }
            System.out.println(minPath);
        }

        /**
         * 图的广度优先搜索算法
         */

        /**
         * 获取两个顶点之间的权值
         *
         * @return
         */
        public int getWeight(int v1, int v2) {
            int weight = matrix[v1][v2];
            return weight == 0 ? 0 : (weight == MAX_WEIGHT ? -1 : weight);
        }
    }


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str1 = s.nextLine();
        String[] nc_dc_nr = str1.split(" ");// nc 城市个数；dc 目标城市标号； nr 地图道路条数
        int nc = Integer.parseInt(nc_dc_nr[0]);
        int dc = Integer.parseInt(nc_dc_nr[1]);
        int nr = Integer.parseInt(nc_dc_nr[2]);
        int[][] nodes = new int[nr][3]; // 存放即将输入的 节点 节点 权值
        // 输入节点间的权值
        int flag = nr;
        String str2;
        for(int i = 0; i < nr; i++){
            str2 = s.nextLine();
            String[] node = str2.split(" ");
            for(int j = 0; j < 3; j++){
                nodes[i][j] = Integer.parseInt(node[j]);
            }
        }
        int peoples = s.nextInt(); // 存放人数
        int[] sourceNode = new int[peoples]; // 存放对应的起始地址
        s.nextLine();
        String str3 = s.nextLine();
        String[] str3s = str3.split(" ");
        for(int i = 0; i < peoples; i++) {
            sourceNode[i] = Integer.parseInt(str3s[i]);
        }

       // int destination = s.nextInt(); // 目的节点

        // ------------------- 数据输入完毕 ----------------------
        /**
         * 参数:
         *
         * nc 城市个数；dc 目标城市标号； nr 地图道路条数
         * int[][] nodes 输入的 节点 节点 权值；
         * peoples 人数
         * int[] sourceNode 各个起始地址
         * destination 目的节点
         */

        // 创建图
        Graph graph = createGraph(nodes, nc);

        // 先求出 起点到终点的 最小路径
        graph.prim(1,3);



        Main main = new Main();



    }


     /**
     *  创建图
     * @param nodes  输入的 节点 节点 权值； 节点下标为数组下标 +1
     * @param vertextSize 城市个数
     * @return
     */
     public static Graph createGraph(int[][] nodes,int vertextSize){
        Graph graph = new Graph(vertextSize);
        // 设置邻接矩阵（初始为 全部节点都未相互连接）
        for(int i = 0; i < vertextSize; i++){
            graph.matrix[nodes[i][0] - 1][nodes[i][1] - 1] = nodes[i][2];
            graph.matrix[nodes[i][1] - 1][nodes[i][0] - 1] = nodes[i][2];
        }
        return graph;
     }

}
