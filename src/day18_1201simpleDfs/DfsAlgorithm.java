package day18_1201simpleDfs;

public class DfsAlgorithm {
    static int ans;
    static int[] num = new int[10];
    static boolean[] visit = new boolean[10];
    static int count = 1;

    public static void main(String[] args) {

        dfs(0);



    }


    public static void solve(){

        double sum = num[0] + (double)num[1] / num[2] + (double)(num[3]*100+num[4]*10+num[5])/(num[6]*100+num[7]*10+num[8]);
        System.out.println("come  " + count + "---" + num[0] + num[1] + num[2] + num[3] + num[4]);
        count++;
        if(sum == 10)
        {
            ans ++;
        }

    }

    static void dfs(int index)
    {
        if(index == 5)
        {
            solve();
            return ;
        }
        for(int i = 1 ; i < 6 ; i ++)
        {
            if(!visit[i])
            {
                visit[i] = true;
                num[index] = i;
                dfs(index+1);
                visit[i] = false;
            }
        }
    }

}
