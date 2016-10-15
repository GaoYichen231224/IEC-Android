package hurned;

public class two {

	public static void main(String[] args) {
		int i,j;
		System.out.println("³Ë·¨±í");
		for(i=1;i<=9;i++){
			for(j=1;j<=i;j++){
				System.out.print(i+"*"+j+"="+i*j);
				System.out.print("   ");
			}
			System.out.println();
		}
	}

}
