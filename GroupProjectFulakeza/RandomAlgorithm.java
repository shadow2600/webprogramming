import java.util.Arrays;
import java.util.Random;
import java.util.Comparator;


public class RandomAlgorithm {
	
	private int req;
	private int Cnder;
    private int[] Cylinder;
	private int b;
	private int l;	
	
	private static Random rand = new Random();
	
	public RandomAlgorithm(int Cnder, int b, int requests) {
		this.Cnder = Cnder;
		this.b = b;
		this.l = Cnder + b;
		this.requests = requests;
		RandomRequest(requests);
		
	}
	
	public int FCFS(int position) {
		if(IsIncorrect(position)) {
			 System.err.println("Wrong Position");
			 return -1;
		}	
		int[] queue = Cylinder.clone();						
		return Distance(queue, position);
	}
	

	public int SCAN(int position) {
		if(IsIncorrect(position)) {
			 System.err.println("Wrong Position");
			 return -1;
		}
		
		
		int[] queue = new int[Cylinder.length + 2];
		
		System.arraycopy(Cylinder, 0, queue, 0, Cylinder.length);
		
		
		queue[queue.length - 2] = 0;
		queue[queue.length - 1] = position;
		Arrays.sort(queue);
		
		int index = Arrays.binarySearch(queue, position);
		int[] left = new int[index];
		
		for(int i = index - 1; i > 0; i--) {
			left[index - i - 1] = queue[i];
		}
		
		for(int i = 0; i < left.length; i++) {
			queue[i] = left[i];
		}
		
		return Distance(queue, position);
	}
	
	public void RandomRequest(int n) {
		Cylinder = new int[n];
		for(int i = 0; i < n; i++) {
			Cylinder[i] = b + rand.nextInt(Cnder);
		}
	}
	
	private int Distance(int [] queue, int position) {
		
		int headMovement = Math.abs(queue[0] - position);

		for(int i = 1; i < queue.length; i++) {
			headMovement += Math.abs(queue[i] - queue[i - 1]);
		}
		
		return headMovement;
	}
	
	private boolean IsIncorrect(int position) {

		if(position < 0 || position >= l) {
			return true;
		}
		return false;
	}

	public int getRequests() {
		return requests;
	}

	public void setRequests(int requests) {
		this.requests = requests;
	}

	public int getCnder() {
		return Cnder;
	}

	public void setCnder(int Cnder) {
		this.Cnder = Cnder;
	}

	public int getb() {
		return b;
	}

	public void setb(int b) {
		this.b = b;
	}
}