package gameoflife;

import java.util.Random;

public class Waka {
	private boolean f[][][];
	public boolean poop[][];
	public boolean needsToPoop,isCannibal,isDead,isSick;
	private int tick,px,py,dir,speed;
	private Random r;
	public int poopClock,sickClock;
	public Waka(int px, int py){
		tick=0;
		isCannibal=false;
		poop = new boolean[388][212];
		poopClock=0;
		r= new Random();
		speed=r.nextInt(3)+1;
		this.px=px;
		this.py=py;
		dir=1;
		f=new boolean[3][13][13];
		//Frame 1
		f[0][0][0]=false;	f[0][1][0]=false;	f[0][2][0]=false;	f[0][3][0]=false;	f[0][4][0]=true;	f[0][5][0]=true;	f[0][6][0]=true;	f[0][7][0]=true;	f[0][8][0]=true;	f[0][9][0]=false;	f[0][10][0]=false;	f[0][11][0]=false;	f[0][12][0]=false;
		f[0][0][1]=false;	f[0][1][1]=false;	f[0][2][1]=true;	f[0][3][1]=true;	f[0][4][1]=true;	f[0][5][1]=true;	f[0][6][1]=true;	f[0][7][1]=true;	f[0][8][1]=true;	f[0][9][1]=true;	f[0][10][1]=true;	f[0][11][1]=false;	f[0][12][1]=false;
		f[0][0][2]=false;	f[0][1][2]=false;	f[0][2][2]=true;	f[0][3][2]=true;	f[0][4][2]=true;	f[0][5][2]=true;	f[0][6][2]=true;	f[0][7][2]=true;	f[0][8][2]=true;	f[0][9][2]=true;	f[0][10][2]=true;	f[0][11][2]=false;	f[0][12][2]=false;
		f[0][0][3]=false;	f[0][1][3]=false;	f[0][2][3]=true;	f[0][3][3]=true;	f[0][4][3]=true;	f[0][5][3]=true;	f[0][6][3]=true;	f[0][7][3]=true;	f[0][8][3]=true;	f[0][9][3]=true;	f[0][10][3]=true;	f[0][11][3]=false;	f[0][12][3]=false;
		for (int x=0;x<13;x++){
			for (int y=4;y<9;y++){
				f[0][x][y]=true;
			}
		}
		f[0][0][9]=false;	f[0][1][9]=false;	f[0][2][9]=true;	f[0][3][9]=true;	f[0][4][9]=true;	f[0][5][9]=true;	f[0][6][9]=true;	f[0][7][9]=true;	f[0][8][9]=true;	f[0][9][9]=true;	f[0][10][9]=true;	f[0][11][9]=false;		f[0][12][9]=false;
		f[0][0][10]=false;	f[0][1][10]=false;	f[0][2][10]=true;	f[0][3][10]=true;	f[0][4][10]=true;	f[0][5][10]=true;	f[0][6][10]=true;	f[0][7][10]=true;	f[0][8][10]=true;	f[0][9][10]=true;	f[0][10][10]=true;	f[0][11][10]=false;		f[0][12][10]=false;
		f[0][0][11]=false;	f[0][1][11]=false;	f[0][9][11]=true;	f[0][3][11]=true;	f[0][4][11]=true;	f[0][5][11]=true;	f[0][6][11]=true;	f[0][7][11]=true;	f[0][8][11]=true;	f[0][9][11]=true;	f[0][10][11]=true;	f[0][11][11]=false;		f[0][12][11]=false;
		f[0][0][12]=false;	f[0][1][12]=false;	f[0][9][12]=false;	f[0][3][12]=false;	f[0][4][12]=true;	f[0][5][12]=true;	f[0][6][12]=true;	f[0][7][12]=true;	f[0][8][12]=true;	f[0][9][12]=false;	f[0][10][12]=false;	f[0][11][12]=false;		f[0][12][12]=false;
		//Frame 2
		f[1][0][0]=false;	f[1][1][0]=false;	f[1][2][0]=false;	f[1][3][0]=false;	f[1][4][0]=true;	f[1][5][0]=true;	f[1][6][0]=true;	f[1][7][0]=true;	f[1][8][0]=true;	f[1][9][0]=false;	f[1][10][0]=false;	f[1][11][0]=false;	f[1][12][0]=false;
		f[1][0][1]=false;	f[1][1][1]=false;	f[1][2][1]=true;	f[1][3][1]=true;	f[1][4][1]=true;	f[1][5][1]=true;	f[1][6][1]=true;	f[1][7][1]=true;	f[1][8][1]=true;	f[1][9][1]=true;	f[1][10][1]=true;	f[1][11][1]=false;	f[1][12][1]=false;
		f[1][0][2]=false;	f[1][1][2]=false;	f[1][2][2]=true;	f[1][3][2]=true;	f[1][4][2]=true;	f[1][5][2]=true;	f[1][6][2]=true;	f[1][7][2]=true;	f[1][8][2]=true;	f[1][9][2]=true;	f[1][10][2]=true;	f[1][11][2]=false;	f[1][12][2]=false;
		f[1][0][3]=false;	f[1][1][3]=false;	f[1][2][3]=true;	f[1][3][3]=true;	f[1][4][3]=true;	f[1][5][3]=true;	f[1][6][3]=true;	f[1][7][3]=true;	f[1][8][3]=true;	f[1][9][3]=true;	f[1][10][3]=true;	f[1][11][3]=false;	f[1][12][3]=false;
		f[1][0][4]=true;	f[1][1][4]=true;	f[1][2][4]=true;	f[1][3][4]=true;	f[1][4][4]=true;	f[1][5][4]=true;	f[1][6][4]=true;	f[1][7][4]=true;	f[1][8][4]=true;	f[1][9][4]=true;	f[1][10][4]=false;	f[1][11][4]=false;	f[1][12][4]=false;
		f[1][0][5]=true;	f[1][1][5]=true;	f[1][2][5]=true;	f[1][3][5]=true;	f[1][4][5]=true;	f[1][5][5]=true;	f[1][6][5]=true;	f[1][7][5]=false;	f[1][8][5]=false;	f[1][9][5]=false;	f[1][10][5]=false;	f[1][11][5]=false;	f[1][12][5]=false;
		f[1][0][6]=true;	f[1][1][6]=true;	f[1][2][6]=true;	f[1][3][6]=true;	f[1][4][6]=false;	f[1][5][6]=false;	f[1][6][6]=false;	f[1][7][6]=false;	f[1][8][6]=false;	f[1][9][6]=false;	f[1][10][6]=false;	f[1][11][6]=false;	f[1][12][6]=false;
		f[1][0][7]=true;	f[1][1][7]=true;	f[1][2][7]=true;	f[1][3][7]=true;	f[1][4][7]=true;	f[1][5][7]=true;	f[1][6][7]=true;	f[1][7][7]=false;	f[1][8][7]=false;	f[1][9][7]=false;	f[1][10][7]=false;	f[1][11][7]=false;	f[1][12][7]=false;
		f[1][0][8]=true;	f[1][1][8]=true;	f[1][2][8]=true;	f[1][3][8]=true;	f[1][4][8]=true;	f[1][5][8]=true;	f[1][6][8]=true;	f[1][7][8]=true;	f[1][8][8]=true;	f[1][9][8]=true;	f[1][10][8]=false;	f[1][11][8]=false;	f[1][12][8]=false;
		f[1][0][9]=false;	f[1][1][9]=false;	f[1][2][9]=true;	f[1][3][9]=true;	f[1][4][9]=true;	f[1][5][9]=true;	f[1][6][9]=true;	f[1][7][9]=true;	f[1][8][9]=true;	f[1][9][9]=true;	f[1][10][9]=true;	f[1][11][9]=false;		f[1][12][9]=false;
		f[1][0][10]=false;	f[1][1][10]=false;	f[1][2][10]=true;	f[1][3][10]=true;	f[1][4][10]=true;	f[1][5][10]=true;	f[1][6][10]=true;	f[1][7][10]=true;	f[1][8][10]=true;	f[1][9][10]=true;	f[1][10][10]=true;	f[1][11][10]=false;		f[1][12][10]=false;
		f[1][0][11]=false;	f[1][1][11]=false;	f[1][9][11]=true;	f[1][3][11]=true;	f[1][4][11]=true;	f[1][5][11]=true;	f[1][6][11]=true;	f[1][7][11]=true;	f[1][8][11]=true;	f[1][9][11]=true;	f[1][10][11]=true;	f[1][11][11]=false;		f[1][12][11]=false;
		f[1][0][12]=false;	f[1][1][12]=false;	f[1][9][12]=false;	f[1][3][12]=false;	f[1][4][12]=true;	f[1][5][12]=true;	f[1][6][12]=true;	f[1][7][12]=true;	f[1][8][12]=true;	f[1][9][12]=false;	f[1][10][12]=false;	f[1][11][12]=false;		f[1][12][12]=false;
		//Frame 3
		f[2][0][0]=false;	f[2][1][0]=false;	f[2][2][0]=false;	f[2][3][0]=false;	f[2][4][0]=true;	f[2][5][0]=true;	f[2][6][0]=true;	f[2][7][0]=true;	f[2][8][0]=true;	f[2][9][0]=false;	f[2][10][0]=false;	f[2][11][0]=false;	f[2][12][0]=false;
		f[2][0][1]=false;	f[2][1][1]=false;	f[2][2][1]=true;	f[2][3][1]=true;	f[2][4][1]=true;	f[2][5][1]=true;	f[2][6][1]=true;	f[2][7][1]=true;	f[2][8][1]=true;	f[2][9][1]=false;	f[2][10][1]=false;	f[2][11][1]=false;	f[2][12][1]=false;
		f[2][0][2]=false;	f[2][1][2]=false;	f[2][2][2]=true;	f[2][3][2]=true;	f[2][4][2]=true;	f[2][5][2]=true;	f[2][6][2]=true;	f[2][7][2]=true;	f[2][8][2]=true;	f[2][9][2]=false;	f[2][10][2]=false;	f[2][11][2]=false;	f[2][12][2]=false;
		f[2][0][3]=false;	f[2][1][3]=true;	f[2][2][3]=true;	f[2][3][3]=true;	f[2][4][3]=true;	f[2][5][3]=true;	f[2][6][3]=true;	f[2][7][3]=true;	f[2][8][3]=true;	f[2][9][3]=false;	f[2][10][3]=false;	f[2][11][3]=false;	f[2][12][3]=false;
		f[2][0][4]=false;	f[2][1][4]=true;	f[2][2][4]=true;	f[2][3][4]=true;	f[2][4][4]=true;	f[2][5][4]=true;	f[2][6][4]=true;	f[2][7][4]=false;	f[2][8][4]=false;	f[2][9][4]=false;	f[2][10][4]=false;	f[2][11][4]=false;	f[2][12][4]=false;
		f[2][0][5]=true;	f[2][1][5]=true;	f[2][2][5]=true;	f[2][3][5]=true;	f[2][4][5]=true;	f[2][5][5]=false;	f[2][6][5]=false;	f[2][7][5]=false;	f[2][8][5]=false;	f[2][9][5]=false;	f[2][10][5]=false;	f[2][11][5]=false;	f[2][12][5]=false;
		
		f[2][0][6]=true;	f[2][1][6]=true;	f[2][2][6]=true;	f[2][3][6]=true;	f[2][4][6]=false;	f[2][5][6]=false;	f[2][6][6]=false;	f[2][7][6]=false;	f[2][8][6]=false;	f[2][9][6]=false;	f[2][10][6]=false;	f[2][11][6]=false;	f[2][12][6]=false;
		
		f[2][0][7]=true;	f[2][1][7]=true;	f[2][2][7]=true;	f[2][3][7]=true;	f[2][4][7]=true;	f[2][5][7]=false;	f[2][6][7]=false;	f[2][7][7]=false;	f[2][8][7]=false;	f[2][9][7]=false;	f[2][10][7]=false;	f[2][11][7]=false;	f[2][12][7]=false;
		f[2][0][8]=false;	f[2][1][8]=true;	f[2][2][8]=true;	f[2][3][8]=true;	f[2][4][8]=true;	f[2][5][8]=true;	f[2][6][8]=true;	f[2][7][8]=false;	f[2][8][8]=false;	f[2][9][8]=false;	f[2][10][8]=false;	f[2][11][8]=false;	f[2][12][8]=false;
		f[2][0][9]=false;	f[2][1][9]=true;	f[2][2][9]=true;	f[2][3][9]=true;	f[2][4][9]=true;	f[2][5][9]=true;	f[2][6][9]=true;	f[2][7][9]=true;	f[2][8][9]=true;	f[2][9][9]=false;	f[2][10][9]=false;	f[2][11][9]=false;		f[2][12][9]=false;
		f[2][0][10]=false;	f[2][1][10]=false;	f[2][2][10]=true;	f[2][3][10]=true;	f[2][4][10]=true;	f[2][5][10]=true;	f[2][6][10]=true;	f[2][7][10]=true;	f[2][8][10]=true;	f[2][9][10]=false;	f[2][10][10]=false;	f[2][11][10]=false;		f[2][12][10]=false;
		f[2][0][11]=false;	f[2][1][11]=false;	f[2][9][11]=true;	f[2][3][11]=true;	f[2][4][11]=true;	f[2][5][11]=true;	f[2][6][11]=true;	f[2][7][11]=true;	f[2][8][11]=true;	f[2][9][11]=false;	f[2][10][11]=false;	f[2][11][11]=false;		f[2][12][11]=false;
		f[2][0][12]=false;	f[2][1][12]=false;	f[2][9][12]=false;	f[2][3][12]=false;	f[2][4][12]=true;	f[2][5][12]=true;	f[2][6][12]=true;	f[2][7][12]=true;	f[2][8][12]=true;	f[2][9][12]=false;	f[2][10][12]=false;	f[2][11][12]=false;		f[2][12][12]=false;
	}
	public boolean[][] getFrame(){
		return f[tick/4];
	}
	public void pooped(){
		poop[(px+7)/5][(py+7)/5]=true;	
		needsToPoop=false;
		poopClock=0;
	}
	public void killPac(){
		for (int x=0;x<3;x++)
			for (int y=0;y<13;y++)
				for (int z=0;z<13;z++)
					f[x][y][z]=false;
	}
	public void advancePac(){
		tick++;
		if (isCannibal){
			speed=6;
		}
		if (poopClock==10){
			needsToPoop=true;
		}
		
		if (isSick){
			speed=1;
		}
		if (tick==12){
			tick=0;
		}
		switch(dir){
		case 0:	px-=speed;
		case 1: px+=speed;
		case 2: py-=speed;
		case 3: py+=speed;	
		}
	}
	public void setPx(int px) {
		this.px = px;
	}
	public void setPy(int py) {
		this.py = py;
	}
	public void setLoc(int x, int y){
		px=x;	py=y;
	}
	public int getPx(){
		return px;
	}
	public int getPy(){
		return py;
	}
}
