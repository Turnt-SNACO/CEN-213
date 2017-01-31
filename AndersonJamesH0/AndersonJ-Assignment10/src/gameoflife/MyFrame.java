package gameoflife;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;


@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	//Array
	boolean grid[][];
	int age[][];
	//Listener
	private MouseListener mListen;
	private MouseMotionListener mmListen;
	private KeyListener kListen;
	private ActionListener aListen;
	//Object
	GridComponent gc;
	//GUI
	private Container pane;
	private JButton togTime;
	//Other
	private Timer t;
	public MyFrame(){
		super();
		grid=new boolean[388][212];
		age=new int[388][212];
		for (int x=0;x<388;x++){
			for (int y=0;y<212;y++){
				age[x][y]=0;
			}
		}
		mListen=new TogSpot();
		mmListen=new DragSpots();
		aListen=new TogTime();
		gc = new GridComponent();
		Animate animator = new Animate();
		t=new Timer(10,animator);
		togTime=new JButton("Toggle Time");
		togTime.addActionListener(aListen);
		pane=getContentPane();
		pane.add(gc, BorderLayout.CENTER);
		pane.add(togTime,BorderLayout.SOUTH);
		pane.addKeyListener(kListen);
		pane.addMouseListener(mListen);
		pane.addMouseMotionListener(mmListen);
		setSize(306,355);
		setTitle("Grid");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	private class TogTime implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (t.isRunning()){
				t.stop();
			}else
				t.start();
		}
	}
	private class DragSpots implements MouseMotionListener{
		public void mouseDragged(MouseEvent m) {
			int x= m.getX()/5;
			int y= m.getY()/5;
			if (t.isRunning()){
				gc.relocPac(m.getX(), m.getY());
			}else{
				try{
					gc.addDot(x-1, y-1);		gc.addDot(x, y-1);	gc.addDot(x+1, y-1);
					gc.addDot(x-1, y);			gc.addDot(x, y);	gc.addDot(x+1, y);
					gc.addDot(x-1, y+1);		gc.addDot(x, y+1);	gc.addDot(x+1, y+1);
					grid[x-1][y-1]=true;		grid[x][y-1]=true;	grid[x+1][y-1]=true;
					grid[x-1][y]=true;			grid[x][y]=true;	grid[x+1][y]=true;
					grid[x-1][y+1]=true;		grid[x][y+1]=true;	grid[x+1][y+1]=true;
					
					gc.addDot(x-3, y-3);		gc.addDot(x, y-3);	gc.addDot(x+3, y-3);
					gc.addDot(x-3, y);			gc.addDot(x, y);	gc.addDot(x+3, y);
					gc.addDot(x-3, y+3);		gc.addDot(x, y+3);	gc.addDot(x+3, y+3);
					grid[x-3][y-3]=true;		grid[x][y-3]=true;	grid[x+3][y-3]=true;
					grid[x-3][y]=true;			grid[x][y]=true;	grid[x+3][y]=true;
					grid[x-3][y+3]=true;		grid[x][y+3]=true;	grid[x+3][y+3]=true;
					
				/*	gc.addDot(x-4, y-4);		gc.addDot(x, y-4);	gc.addDot(x+4, y-4);
					gc.addDot(x-4, y);			gc.addDot(x, y);	gc.addDot(x+4, y);
					gc.addDot(x-4, y+4);		gc.addDot(x, y+4);	gc.addDot(x+4, y+4);
					grid[x-4][y-4]=true;		grid[x][y-4]=true;	grid[x+4][y-4]=true;
					grid[x-4][y]=true;			grid[x][y]=true;	grid[x+4][y]=true;
					grid[x-4][y+4]=true;		grid[x][y+4]=true;	grid[x+4][y+4]=true;
				*/	
					gc.addDot(x-5, y-5);		gc.addDot(x, y-5);	gc.addDot(x+5, y-5);
					gc.addDot(x-5, y);			gc.addDot(x, y);	gc.addDot(x+5, y);
					gc.addDot(x-5, y+5);		gc.addDot(x, y+5);	gc.addDot(x+5, y+5);
					grid[x-5][y-5]=true;		grid[x][y-5]=true;	grid[x+5][y-5]=true;
					grid[x-5][y]=true;			grid[x][y]=true;	grid[x+5][y]=true;
					grid[x-5][y+5]=true;		grid[x][y+5]=true;	grid[x+5][y+5]=true;
				}catch(ArrayIndexOutOfBoundsException e){
					//Do Nothing
				}
				finally{
					//Clean up
				}
			}
			
		}
		public void mouseMoved(MouseEvent m) {
		}
	}
	private class TogSpot implements MouseListener{
		public void mouseClicked(MouseEvent m) {
			int x= m.getX()/5;
			int y= m.getY()/5;
			gc.addDot(x, y);
			grid[x][y]=true;
		}
		public void mouseEntered(MouseEvent arg0) {
		}
		public void mouseExited(MouseEvent arg0) {
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
			
		}
	}
	private class Animate implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			boolean [][] newGrid = new boolean[388][212];
			for (int n=0;n<388;n++){
				for (int m=0;m<212;m++){
					newGrid[n][m]=false;
				}
			}
			for (int x=0;x<388;x++){
				for (int y=0;y<212;y++){
					int count=0;
					if (x!=0&&y!=0&&grid[x-1][y-1])count++;		if (y!=0&&grid[x][y-1])count++;		if (y!=0&&x!=387&&grid[x+1][y-1])count++;
					if (x!=0&&grid[x-1][y])count++;													if (x!=387&&grid[x+1][y])count++;
					if (x!=0&&y!=211&&grid[x-1][y+1])count++;	if (y!=211&&grid[x][y+1])count++;	if (x!=387&&y!=211&&grid[x+1][y+1])count++;
										
					if(count==3){newGrid[x][y]=true;age[x][y]++;}
					else if(count==2){newGrid[x][y]=grid[x][y];age[x][y]++;}
					else if(count<2){newGrid[x][y]=false;age[x][y]=0;}
					else if(count>3){newGrid[x][y]=false;age[x][y]=0;}
				}
			}
			for (int x=1;x<388;x++){
				for (int y=1;y<212;y++){
					grid[x][y]=newGrid[x][y];
				}
			}
			for (int r=1;r<12;r++){
				for (int s=1;s<12;s++){
					if (grid[(gc.myPac.getPx()+r)/5][(gc.myPac.getPy()+s)/5]){
						gc.myPac.poopClock++;
					}
					grid[(gc.myPac.getPx()+r)/5][(gc.myPac.getPy()+s)/5]=false;
					
				}
			}
			for (int q=0;q<14;q++){
				for (int r=1;r<12;r++){
					for (int s=1;s<12;s++){
						if (grid[(gc.myPacs[q].getPx()+r)/5][(gc.myPacs[q].getPy()+s)/5]){
							gc.myPacs[q].poopClock++;
						}
						grid[(gc.myPacs[q].getPx()+r)/5][(gc.myPacs[q].getPy()+s)/5]=false;
					}
				}
			}
			//Poop Code
			if (gc.myPac.needsToPoop){
				gc.myPac.pooped();
			}
			for (int x=0;x<14;x++){
				if (gc.myPacs[x].needsToPoop){
					gc.myPacs[x].pooped();
				}
			}
			//Cannibal Code
				for (int y=0;y<14;y++){
					if (gc.myPac.getPx()<=gc.myPacs[y].getPx()+12&&
						gc.myPac.getPx()>=gc.myPacs[y].getPx()&&
						gc.myPac.getPy()>=gc.myPacs[y].getPy()&&
						gc.myPac.getPy()<=gc.myPacs[y].getPy()+12){
						
							gc.myPacs[y].killPac();
							gc.myPac.isCannibal=true;
					}
				}
			
			
			gc.updateBools(newGrid,age);
			
			
		}
	}
	public static void main(String[]args){
		@SuppressWarnings("unused")
		MyFrame f = new MyFrame();
	}
}
