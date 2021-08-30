import java.util.Arrays;
import java.util.Scanner;
public class PrimsMST {
   public static void main(String args[]){
       Scanner in=new Scanner(System.in);
       int n=7,INF=999;
       int cost[][]=new int[n+1][n+1];            //starts from 1
       for(int i=0;i<=n;i++){
           for(int j=0;j<=n;j++){
               cost[i][j]=in.nextInt();
           }
       }
       int near[]=new int[n+1];              //starts from 1
       Arrays.fill(near,INF);
       int t[][]=new int[2][n-1];           // starts from 0 to 5 i.e |vertices-1|
       int k,u=-1,v=-1,min=INF;
       // selecting the mincost edge
       for(int i=1;i<=n;i++)
        for(int j=1;j<=n;j++)
            if(cost[i][j]<min){
                min=cost[i][j];
                u=i;
                v=j;
            }
        for(int arr[]:cost){
            for(int x:arr)
                System.out.print(x+" ");
            System.out.println();
        }
        t[0][0]=u;
        t[1][0]=v;
        near[u]=0;
        near[v]=0;
        for(int i=1;i<=n;i++){  //set the near array with either u or v which is near to vertex i   
            if(near[i]!=0){
            if(cost[u][i]<cost[v][i])
                near[i]=u;
            else
                near[i]=v;
                
          }
        }
        //repeatedly finding remaining n-2 edges
        
        for(int i=1;i<n-1;i++){
            min=INF;k=-1;
            for(int j=1;j<=n;j++){
                //System.out.println(cost[i][near[j]]+" "+min);
                if(near[j]!=0 && cost[j][near[j]]<min){
                    min=cost[j][near[j]];
                    k=j;
                }
            }
            t[0][i]=k;
            t[1][i]=near[k];
            near[k]=0;
            for(int j=1;j<=n;j++){
                if(near[j]!=0 && cost[k][j]<cost[j][near[j]]){
                    near[j]=k;
                }
            }
         }
        System.out.println(t[0][0]+"-->"+t[1][0]+" cost "+cost[t[0][0]][t[1][0]]);
        for(int i=1;i<n-1;i++){
            if(t[0][i]==t[0][i-1] || t[0][i]==t[1][i-1]){
                System.out.println(t[0][i]+"-->"+t[1][i]+" cost "+cost[t[0][i]][t[1][i]]);
            }
            else
                System.out.println(t[1][i]+"-->"+t[0][i]+" cost "+cost[t[0][i]][t[1][i]]);
        }
   }
}
