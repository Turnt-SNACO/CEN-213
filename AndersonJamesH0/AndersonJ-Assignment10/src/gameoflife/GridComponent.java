package gameoflife;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class GridComponent extends JComponent{
	private boolean[][] dots;
	private int [][]age;
	private Random r;
	public Waka myPac;
	public Waka[] myPacs;
	public GridComponent(){
		super();
		r=new Random();
		dots=new boolean[388][212];
		age=new int[388][212];
		myPac=new Waka(200,200);
		myPacs=new Waka[14];
		
		for (int x=0;x<14;x++){
			myPacs[x] = new Waka(r.nextInt(2000),r.nextInt(1000));
		}
	}
	public void relocPac(int x, int y){
		myPac.setLoc(x,y);
	}
	public void addDot(int x,int y){
		dots[x][y]=true;
		repaint();
	}
	public void removeDot(int x, int y){
		dots[x][y]=false;
		repaint();
	}
	public void updateBools(boolean cells[][], int age[][]){
		for (int x=0;x<388;x++){
			for (int y=0;y<212;y++){
				if (myPac.poop[x][y]==true){
					dots[x][y]=true;
				}
				dots[x][y]=cells[x][y];
				this.age[x][y]=age[x][y];
			}
		}
		repaint();
	}
	public void paintComponent (Graphics gr){
		super.paintComponent(gr);
		Graphics2D gtd = (Graphics2D) gr;
		gtd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		gtd.setBackground(Color.BLACK);
		gtd.clearRect(0, 0, getWidth(), getHeight());
		gtd.setColor(new Color(50,50,50));
		for (int x=0;x<400;x++){
		//	gtd.drawLine(x*5, 0, x*5, 2000);
		//	gtd.drawLine(0, x*5, 2000, x*5);
		}
		
		for (int x=0;x<388;x++){
			for (int y=0;y<212;y++){
				//draw squares
				int r,g,b;
				r=0;g=0;b=0;
				if (age[x][y]<=255){
					r=255;
					g=age[x][y];
				}else if (age[x][y]>255&&age[x][y]<=510){
					g=255;
					r=255-(age[x][y]-255);
				}else if (age[x][y]>510&&age[x][y]<=765){
					g=255;
					b=age[x][y]-510;
				}else if (age[x][y]>765&&age[x][y]<=990){
					b=255;
					g=255-(age[x][y]-765);
				}else if(age[x][y]>990&&age[x][y]<=1245){
					b=255;
					r=age[x][y]-990;
				}else if(age[x][y]>1245){
					r=255;b=255;g=0;
				}
				gtd.setColor(new Color(r,g,b));
				if(dots[x][y]){
					gtd.fill(new Rectangle2D.Double(x*5,y*5,5,5));
				}
			}
		}
		//POOP
				gtd.setColor(new Color(150,100,0));
				for (int x=0;x<388;x++){
					for (int y=0;y<212;y++){
						if (myPac.poop[x][y]){
							
							gtd.fill(new Rectangle2D.Double(x*5,y*5,5,5));
						}
					}
				}
				for (int z=0;z<14;z++){
					for (int x=0;x<388;x++){
						for (int y=0;y<212;y++){
							if (myPacs[z].poop[x][y]){
								gtd.fill(new Rectangle2D.Double(x*5,y*5,5,5));
							}
						}
					}
				}
		//PACS
		boolean pac[][]=new boolean[13][13];
		if (myPac.getPx()<1900)
			pac=myPac.getFrame();
		else{
			if (myPac.isCannibal){
				myPac.setPx(0);
				int which=r.nextInt(14);
				do{
					myPac.setPy(myPacs[which].getPy());
				}while(myPacs[which].isDead==true);
			}else{
				myPac.setPx(0);
				myPac.setPy(r.nextInt(1000));
			}
		}
		gtd.setColor(Color.YELLOW);
		for (int x=0;x<13;x++){
			for (int y=0;y<13;y++){
				if (pac[x][y]){
					if (myPac.isCannibal)gtd.setColor(Color.RED);
					gtd.fill(new Rectangle2D.Double(myPac.getPx()+x,myPac.getPy()+y,1,1));
				}
			}
		}
		myPac.advancePac();
		gtd.setColor(Color.YELLOW);
		for (int x=0;x<14;x++){
			boolean pacs[][]=new boolean[13][13];
			if (myPacs[x].getPx()<1900)
			pacs=myPacs[x].getFrame();
			else{
				myPacs[x].setPx(0);
				myPacs[x].setPy(r.nextInt(1000));
			}
			for (int y=0;y<13;y++){
				for (int z=0;z<13;z++){
					if (pacs[y][z]){
						if (myPacs[x].isCannibal)gtd.setColor(Color.RED);
						gtd.fill(new Rectangle2D.Double(myPacs[x].getPx()+y,myPacs[x].getPy()+z,1,1));
					}
				}
			}
		myPacs[x].advancePac();
		
		
		}
		
		
	}
}
