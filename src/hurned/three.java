package hurned;

import javax.smartcardio.CardException;

public class three {
	 public static final char BLANK='+'; 
	  public static final char BLACK='��'; 
	  public static final char WHITE='��'; 
	  
	  public static final int MAX = 16;
	  private static final int COUNT = 5;
	private static final String Arrays = null;
	  //����
	  private char[][] board;
	  
	   
	  //��ʼ��Ϸ
	  public void start() {
	    board = new char[MAX][MAX];
	    for(char[] ary: board){
	   Arrays.fill(ary,BLANK) ;
	    }
	  }
	  public char[][] getChessBoard(){
	    return board;
	  }
	  public void addBlack(int x, int y) throws CardException{
	    //@
	    //char blank = '*';
	    //System.out.println( x +"," + y + ":" + board[y][x] + "," + BLANK);
	    if(board[y][x] == BLANK){
	      board[y][x] = BLACK;
	      return;
	    }
	    throw  new CardException(null, null  );
	  }
	  public void addWhite(int x, int y) 
	    throws CardException{
	    if(board[y][x] == BLANK){// x, y λ���ϱ����ǿյĲſ���������
	      board[y][x] = WHITE;
	      return;
	    }
	    throw new CardException(null, null);
	  }
	  public boolean winOnY(char chess, int x, int y){
	    //���ҵ�y�����һ������ blank������
	    int top = y;
	    while(true){
	      if(y==0 || board[y-1][x]!=chess){
	        //���y�Ѿ������̵ı�Ե�� ���ߵ�ǰһ������chess
	        //�Ͳ��ټ���������
	        break;
	      }
	      y--;
	      top = y;
	    }
	    //���ͳ������chess�ĸ����������COUNT����Ӯ��
	    int count = 0;
	    y = top;
	    while(true){
	      if(y==MAX || board[y][x]!=chess){
	        //����ҵ�ͷ ���� ��һ���Ӳ���chess �Ͳ��ټ���ͳ����
	        break;
	      }
	      count++;
	      y++;
	    }
	    return count==COUNT;
	  }
	  public boolean winOnX(char chess, int x, int y){
	    //���ҵ�x�����һ������ blank������
	    int top = x;
	    while(true){
	      if(x==0 || board[y][x-1]!=chess){
	        break;
	      }
	      x--;
	      top = x;
	    }
	    //���ͳ������chess�ĸ����������COUNT����Ӯ��
	    int count = 0;
	    x = top;
	    while(true){
	      if(x==MAX || board[y][x]!=chess){
	        //����ҵ�ͷ ���� ��һ���Ӳ���chess �Ͳ��ټ���ͳ����
	        break;
	      }
	      count++;
	      x++;
	    }
	    return count==COUNT;
	  }
	  public boolean winOnXY(char chess, int x, int y){
	    //����MAX���һ������ blank������
	    int top = y;
	    int left = x;
	    while(true){
	      if(x==0 || y==0 || board[y-1][x-1]!=chess){
	        //���x�Ѿ������̵ı�Ե�� ���ߵ�ǰһ������chess
	        //�Ͳ��ټ���������
	        break;
	      }
	      x--;
	      y--;
	      top = y;
	      left=x;
	    }
	    //���ͳ������chess�ĸ����������COUNT����Ӯ��
	    int count = 0;
	    x = left;
	    y = top;
	    while(true){
	      if(x==MAX || y==MAX || board[y][x]!=chess){
	        //����ҵ�ͷ ���� ��һ���Ӳ���chess �Ͳ��ټ���ͳ����
	        break;
	      }
	      count++;
	      x++;
	      y++;
	    }
	    return count==COUNT;
	  }
	  //chess ���ӣ�'��'/'��'
	  public boolean winOnYX(char chess, int x, int y){
	    //���ҵ�x�����һ������ blank������
	    int top = y;
	    int left = x;
	    while(true){
	      if(x==MAX-1 || y==0 || board[y-1][x+1]!=chess){
	        //���x�Ѿ������̵ı�Ե�� ���ߵ�ǰһ������chess
	        //�Ͳ��ټ���������
	        break;
	      }
	      x++;
	      y--;
	      top = y;
	      left=x;
	    }
	    //���ͳ������chess�ĸ����������COUNT����Ӯ��
	    int count = 0;
	    x = left;
	    y = top;
	    while(true){
	      if(x==0 || y==MAX || board[y][x]!=chess){
	        //����ҵ�ͷ ���� ��һ���Ӳ���chess �Ͳ��ټ���ͳ����
	        break;
	      }
	      count++;
	      x--;
	      y++;
	    }
	    return count==COUNT;
	  }

	  public boolean whiteIsWin(int x, int y) {
	    return winOnY(WHITE, x, y) ||
	          winOnX(WHITE, x, y) ||
	          winOnXY(WHITE, x, y) ||
	          winOnYX(WHITE, x, y);
	  }
	  public boolean blackIsWin(int x, int y) {
	    return winOnY(BLACK, x, y) || 
	      winOnX(BLACK, x, y) ||
	      winOnXY(BLACK, x, y) ||
	      winOnYX(BLACK, x, y);
	  }


}