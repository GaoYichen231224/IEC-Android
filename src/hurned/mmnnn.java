package hurned;

import java.util.Scanner;  

public class mmnnn {
	//��ά������Ϊ����  
	private static char[][] board=new char[16][16];  
    //����������Ŀ  
    private static int cnt;  
    //�ֱ�������1,2������  
    private static char[] qizi={'��','��'};  
    //�˷����������  
    private static int[] dx={-1,0,-1,-1,1,1,0,1};  
    private static int[] dy={0,-1,-1,1,-1,1,1,0};  
      
    //������  
    private static int CheckInput(int x,int y){  
          
        if(board[x][y]!='+')  
            return 0;  
        if(x<1||x>15||y<1||y>15)  
            return 0;  
        return 1;  
    }  
      
        //�߽���  
    private static int Check(int x,int y){  
        if(x>15||x<1||y>15||y<1)  
            return 0;  
        return 1;  
    }  
    //�������Ƿ��ʤ,��Ҫ������ұ�ţ�����ǰ�������  
    private static int CheckAns(int num,int x,int y){  
        if(cnt==15*15)  
            return 1;  
        //���� ��б ��б �ĸ������ж��Ƿ��������������һ��  
        for(int i=0;i<4;i++){  
            int sum=1;  
            int xx=x+dx[i];  
            int yy=y+dy[i];  
            while(board[xx][yy]==qizi[num]&&Check(xx,yy)==1){  
                sum++;  
                xx=xx+dx[i];  
                yy=yy+dy[i];  
            }  
            xx=x+dx[7-i];  
            yy=y+dy[7-i];  
            while(board[xx][yy]==qizi[num]&&Check(xx,yy)==1){  
                sum++;  
                xx=xx+dx[7-i];  
                yy=yy+dy[7-i];  
            }  
            if(sum>=5)  
                return 1;  
        }  
        return 0;  
    }  
      
    //��ʼ��  
    private static void Init(){  
        cnt=0;  
        for(int i=1;i<=15;i++)  
            for(int j=1;j<=15;j++)  
                board[i][j]='+';  
    }  
      
    //�������  
    private static void Print(){  
        int i,j;  
        for(i=1;i<=15;i++){  
            for(j=1;j<=15;j++){  
                  
                System.out.print(board[i][j]);  
            }  
            System.out.println();  
        }  
    }  
      
    public static int run(){  
          
        int x,y;  
        Init();  
        //��ǰ���ֱ��,Ĭ��0������  
        int num=0;  
        while(true){  
            Print();  
            System.out.print(num+1+"��ѡ�������������������,Ӧ��x y��ʽ: ");  
            Scanner sc =new Scanner(System.in);  
            while(true){  
                x=sc.nextInt();  
                y=sc.nextInt();  
                if(CheckInput(x,y)==1)  
                    break;  
                System.out.print("�������겻�Ϸ������������룺 ");  
            }  
            board[x][y]=qizi[num];  
            if(CheckAns(num,x,y)==1){  
                return num+1;  
            }  
            num=1-num;  
        }  
    }  
      
    public static void main(String[] args){  
          
        System.out.println("��ӭʹ��������!");  
        int ans=run(); 
        System.out.println("��ϲ"+ans+"��ѡ�ֻ�����յ�ʤ��");  
    }  
}  
