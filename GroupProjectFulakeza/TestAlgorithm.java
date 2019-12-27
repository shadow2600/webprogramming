import java.util.Scanner;

public class TestAlgorithm {

	public static void main(String[] args) {
		RandomAlgorithm R = new RandomAlgorithm(5000, 0, 1000);
		
		System.out.println(R.FCFS(50));	
		System.out.println(R.SCAN(50));

	}

}