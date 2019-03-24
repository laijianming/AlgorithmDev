package day19_0228getTreasure;

/**
 * X 国王有一个地宫宝库。 是 n x m 个格子的矩阵。 每个格子放一件宝贝。 每个宝贝贴着价值标签。
 * 地宫的入口在左上角，出口在右下角。
 * 小明被带到地宫的入口，国王要求他只能向右或向下行走。
 * 走过某个格子时，如果那个格子中的宝贝价值比小明手中任意宝贝价值都大，小明
 * 就可以拿起它（当然，也可以不拿）。
 * 当小明走到出口时，如果他手中的宝贝恰好是 k 件，则这些宝贝就可以送给小明。
 * 请你帮小明算一算，在给定的局面下，他有多少种不同的行动方案能获得这 k 件宝
 * 贝。
 * 【数据格式】
 * 输入一行 3 个整数，用空格分开： n m k (1<=n,m<=50, 1<=k<=12)
 * 接下来有 n 行数据，每行有 m 个整数 Ci (0<=Ci<=12) 代表这个格子上的宝物的
 * 价值
 * 要求输出一个整数，表示正好取 k 个宝贝的行动方案数。该数字可能很大，输出它
 * 对 1000000007 取模的结果。
 */
public class Main {

    public static void main(String[] args) {


        // 1、构建一个对应的邻接矩阵 -- 给对应的右一和下一一条有向边

        // 2、求出有多少种从起点到终点的方式  -- 深度遍历

        // 3、求出每种方式取k件宝物的取法种数  -- Cmn 排列组合

    }

}
