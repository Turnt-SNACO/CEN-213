package Hanoi;

public class TowerOfHanoi {
	private int numberOfDiscs;
	private int[][] towers;
	
	public TowerOfHanoi(int numberOfDiscs){
		this.numberOfDiscs=numberOfDiscs;
		this.towers=new int[numberOfDiscs][3];
	}
	public static void main(String[] args) {
		TowerOfHanoi t = new TowerOfHanoi(4);

	}

}
