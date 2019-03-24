
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    double eps=1e-6;
    List<Vertex> list=new ArrayList<Main.Vertex>();
    public static void main(String[] args) {
        new Main().run();
    }
    class Vertex{
        double x;
        double y;
        public Vertex(double x,double y){
            this.x=x;
            this.y=y;
        }

    }
    public double getTime(Vertex x1,Vertex x2,int v){
        return Math.sqrt(Math.pow(x2.x-x1.x, 2)+Math.pow(x2.y-x1.y, 2))/v;
    }
    public double getDis(Vertex x1,Vertex x2){
        return Math.sqrt(Math.pow(x2.x-x1.x, 2)+Math.pow(x2.y-x1.y, 2));
    }
    public Vertex getMid(Vertex x1,Vertex x2){
        return new Vertex((x1.x+x2.x)/2, (x1.y+x2.y)/2);
    }
    public double min(double a, double b) { return a < b ? a : b; }
    public double max(double a, double b) { return a > b ? a : b; }

    //(ca x cd)·(cb x cd)<=0 则说明ca cb先对于cd的方向不同，则a b在线段cd的两侧，则相交
    /**判断线段是否相交
     * @param a 点
     * @param b
     * @param c
     * @param d
     * @return
     */
    public boolean isIntersect(Vertex a,Vertex b,Vertex c,Vertex d){
        if(min(a.x, b.x) > max(c.x, d.x) || min(a.y, b.y) > max(c.y, d.y) || min(c.x, d.x) > max(a.x, b.x) || min(c.y, d.y) > max(a.y, b.y) ){
            return false;
        }
        double h, i, j, k;
        h = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        i = (b.x - a.x) * (d.y - a.y) - (b.y - a.y) * (d.x - a.x);
        j = (d.x - c.x) * (a.y - c.y) - (d.y - c.y) * (a.x - c.x);
        k = (d.x - c.x) * (b.y - c.y) - (d.y - c.y) * (b.x - c.x);
        return h * i <= eps && j * k <= eps;
    }
    /**是否共线
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public boolean isGongxian(Vertex a,Vertex b,Vertex c,Vertex d){
        double u;//分别记录两个向量
        u=(b.x-a.x)*(d.y-c.y)-(b.y-a.y)*(d.x-c.x);
        if(u==0){
            return true;
        }else{
            return false;
        }
    }
    /**判断点是否在多边形内
     * @param p
     * @return
     */
    public boolean rayCasting(Vertex p){
        boolean flag=false;
        int next=0;
        for (int i = 0; i <list.size(); i++) {
            if(i+1==list.size()){
                next=0;
            }else{
                next=i+1;
            }
            Vertex s=list.get(i);
            Vertex t=list.get(next);
            if((p.x==s.x&&p.y==s.y)||(p.x==t.x&&p.y==t.y)){
                return true;
            }
            if((s.y<p.y&&t.y>=p.y)||(s.y>=p.y&&t.y<p.y)){
                double x=s.x+(p.y-s.y)*(t.x-s.x)/(t.y-s.y);
                if(x==p.x){
                    return true;
                }
                if(x>p.x){
                    flag=!flag;
                }
            }
        }
        return flag?true:false;
    }
    /**判断是否穿越传送带
     * @param a 起点
     * @param p 终点
     * @return
     */
    public boolean judge(Vertex a,Vertex p){
        int next=0;
        int count=0;
        int G_count=0;
        int i=0;
        boolean re=false;
        for(;i<list.size();i++){
            if(i+1==list.size()){
                next=0;
            }else{
                next=i+1;
            }
            re = isIntersect(a,p,list.get(i),list.get(next));
            if(a.equals(list.get(i))||a.equals(list.get(next))||p.equals(list.get(i))||p.equals(list.get(next))){
                if(isGongxian(a,p,list.get(i),list.get(next))){
                    G_count++;
                }
            }
            if(re)count++;
        }
        if(G_count==1&&count<=3){
            return false;
        }
        if(list.contains(a)&&list.contains(p)&&count==4){
            if(rayCasting(getMid(a, p))){
                return true;
            }else{
                return false;
            }
        }
        if((list.contains(a)&&count==2)||count==1){
            return false;
        }else{
            return true;
        }
    }
    /**得到远点到相遇点的最短路径
     * @param p
     * @param l_time
     * @param vl
     * @param vp
     * @param vertexNum
     * @return
     */
    public double getMinLength(Vertex p,double l_time,int vl,int vp,int vertexNum){
        double new_time=0;
        double p_time=0;
        double start_time=0-l_time;
        double temp=0-l_time;
        l_time=0-l_time;
        int start_i=0;
        int end_i=0;
        int next=0;
        int i=0;
        //寻找相遇点  到达某个顶点的时间<p点到达顶点的时间      到达某个顶点的时间>p点到顶点达的时间  之间为有相遇点
        while(true){
            if((i+1)==vertexNum){
                next=0;
            }else if((i+1)<=vertexNum){
                next=i+1;
            }else{
                i=0;
                next=i+1;
            }
            l_time+=getTime(list.get(i),list.get(next),vl);
            p_time=getTime(list.get(next),p,vp);
            if(p_time>l_time){
                start_i=next;
                start_time=l_time;
            }else if(p_time==l_time){
                start_i=next;
                end_i=next;
                break;
            }else{
                end_i=next;
                break;
            }
            i++;
        }
        //计算相遇点坐标   二分法
        Vertex start=list.get(start_i);
        Vertex end=list.get(end_i);
        int count=0;
        double mid_time=0;
        Vertex mid = null ;
        while(count<50){
            mid = getMid(start, end);
            mid_time=getTime(p, mid, vp);
            new_time=start_time+getTime(list.get(start_i), mid, vl);
            if(new_time<mid_time){
                start=mid;
            }else if(new_time==mid_time){
                start=mid;
                end=mid;
                break;
            }else{
                end=mid;
            }
            count++;
        }
        //判断原点到相遇点的线段是否与各个边相交   如果相交则找到逆时针第一个不相交的顶点为新的原点 不相交则结束
        double le=0;
        double time=0;
        boolean result = judge(mid, p);
        if(result){
            int index=getNearestPoint(p,end_i,vertexNum);
            Vertex v=list.get(index);
            le=getDis(p, v);
            time=le/vp-temp;
            le+=getMinLength(v, time, vl,vp,vertexNum);
        }else{
            le=getDis(p, mid);
        }
        return le;
    }
    /**寻找多边形最近的不相交的点
     * @param p
     * @param end_i
     * @param vertexNum
     * @return
     */
    public int getNearestPoint(Vertex p,int end_i,int vertexNum){
        for (int j = end_i; j <vertexNum; j++) {
            Vertex v=list.get(j);
            boolean ver_result = judge(v, p);
            if(!ver_result){
                return j;
            }
        }
        return -1;
    }
    public void run(){
        Scanner sc=new Scanner(System.in);
        int vertexNum = sc.nextInt();
        int number=1;
        while(vertexNum!=0){
            list.clear();
            for (int i = 0; i < vertexNum; i++) {
                int x=sc.nextInt();
                int y=sc.nextInt();
                Vertex v=new Vertex(x,y);
                list.add(v);
            }
            int px=sc.nextInt();
            int py=sc.nextInt();
            Vertex p=new Vertex(px, py);
            int vl=sc.nextInt();
            int vp=sc.nextInt();
            double length=getMinLength(p,0,vl,vp,vertexNum);
            double minTime=length/vp;
            double time = Double.parseDouble(new java.text.DecimalFormat("#.00").format(minTime));
            int fen=(int)time;
            String miao=new java.text.DecimalFormat("#").format((time-fen)*60);
            if(miao.length()==1){
                miao="0"+miao;
            }
            System.out.println("Case "+number+": Time = "+fen+":"+miao);
            number++;
            vertexNum = sc.nextInt();
        }
    }
}