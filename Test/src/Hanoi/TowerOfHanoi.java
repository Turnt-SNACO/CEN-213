package Hanoi;

public class TowerOfHanoi {
	private int numberOfDiscs;
	public int[][] towers;
	
	public TowerOfHanoi(int numberOfDiscs){
		this.numberOfDiscs=numberOfDiscs;
		this.towers=new int[numberOfDiscs][3];
		for (int x=0;x<numberOfDiscs;x++){
			towers[x][0]=x+1;
		}
	}
	public int topDisc(int peg, int top){
		if (towers[top][peg]==0)
			return top+1;
		else if (towers[top][peg]==1)
			return top;
		else
			return topDisc(peg,top-1);
	}
	public void moveDisc(int source, int destination){
		towers[topDisc(destination,this.numberOfDiscs-1)-1][destination]=towers[topDisc(source,this.numberOfDiscs-1)][source];
		towers[topDisc(source,this.numberOfDiscs-1)][source]=0;
	}
	//feed arg numDiscs as numberOfDiscs
	public void moveTower(int numDiscs,int start, int aux, int end){
		if (numDiscs>=1){
			moveTower(numDiscs-1,start,end,aux);
			for (int x=0;x<getNumberOfDiscs();x++){
				for (int y=0;y<3;y++){
					if (towers[x][y]==0)
						System.out.print(" | ");
					else
						System.out.print(" "+towers[x][y]+" ");
				}
				System.out.println();
			}
			System.out.println("---------");
			moveDisc(start,end);
			moveTower(numDiscs-1,aux,start,end);
		}
		else if (numDiscs==1)
			moveDisc(start,end);
	}
	public int getNumberOfDiscs() {
		return numberOfDiscs;
	}
	public static void main(String[] args) {
		TowerOfHanoi t = new TowerOfHanoi(3);
		t.moveTower(t.numberOfDiscs,0,1,2);
		for (int x=0;x<t.getNumberOfDiscs();x++){
			for (int y=0;y<3;y++){
				if (t.towers[x][y]==0)
					System.out.print(" | ");
				else
					System.out.print(" "+t.towers[x][y]+" ");
			}
			System.out.println();
		}
	}

}
