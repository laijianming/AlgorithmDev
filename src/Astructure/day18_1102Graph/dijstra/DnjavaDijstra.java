package Astructure.day18_1102Graph.dijstra;

public class DnjavaDijstra {
	private final static int MAXVEX = 9;
	private final static int MAXWEIGHT = 65535;
	private int shortTablePath[] = new int[MAXVEX];// 记录的是 之前每一次遍历可连接顶点时的 v0到某顶点的最短路径和

	/**
	 * 获取一个图的最短路径
	 */
	public void shortestPathDijstra(Graph graph) {
		int min;
		int k = 0;// 记录下标
		boolean isgetPath[] = new boolean[MAXVEX];
		for (int v = 0; v < graph.getVertexSize(); v++) {
			shortTablePath[v] = graph.getMatrix()[0][v];// 获取v0这一行的权值数组
		}
		shortTablePath[0] = 0;
		isgetPath[0] = true;
		for (int v = 1; v < graph.getVertexSize(); v++) {
			min = MAXWEIGHT;
			// 这个循环是为了找出 当前v0能够连接的最小权值和的顶点
			for (int w = 0; w < graph.getVertexSize(); w++) {
				if (!isgetPath[w] && shortTablePath[w] < min) { //shortTablePath 数组保存v0到Vx的最小权值和
					k = w;
					min = shortTablePath[w];
				}
			}
			// （为什么能够说明是最小权值和呢？  ：因为这是在已有连接（权值和）中选择的最小权值和，故其他连接方式的权值和都一定会大于这种连接方式）
			isgetPath[k] = true;  // 将找到的顶点 置为已访问；
			// 找该节点到所有节点的连接权值和（除去已确定最小权值的连接），判断是否有更小的权值和
			// 更新最小权值和，已原有的最小权值和进行对 各个未最小连接的顶点 的权值 进行相加 然后对神奇数组对应顶点的权值和进行比较，更小则替换
			for (int j = 0; j < graph.getVertexSize(); j++) {
				if(!isgetPath[j]&&(min+graph.getMatrix()[k][j]<shortTablePath[j])){
					shortTablePath[j] = min + graph.getMatrix()[k][j];
				}
			}
		}
		for(int i = 0;i<shortTablePath.length;i++){
			System.out.println("V0到V"+i+"的最短路径为:"+shortTablePath[i]+"\n");
		}

	}

	public static void main(String[] args){
		Graph graph = new Graph(MAXVEX);
		graph.createGraph();
		DnjavaDijstra dijstra = new DnjavaDijstra();
		dijstra.shortestPathDijstra(graph);
	}
}