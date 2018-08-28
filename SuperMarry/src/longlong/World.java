package longlong;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class World extends JPanel{
	public static BufferedImage gameover;
	private int state = 0;
	static{
		gameover = FlyingObject.loadImage("background.JPG");
	}
	public static final int WIDTH = 1500;
	public static final int HEIGHT = 701;
	public static final int GAME_OVER = 3;
	Marry marry = new Marry();
    FlyingObject[] barrier = {};
    Background background = new Background();
	Brick[] brick = {};
	Bullet[] bullet = {};
	Flag[]  flag ={};
	Key[] key ={};
	Money[] money = {};
	Mushroom[] mushroom = {};
	Monster[] monster = {};
	Award[] award ={};
	
	
	
    public FlyingObject nextOne(){
    	Random random = new Random();
    	int ran = random.nextInt(100);
    	if(ran<25){
    		return new Monster();
    	}else if(ran<45){
    		return new Barrier();	
    	}else if(ran<65){
    		return new BigBarrier();
    	}else if(ran<70){
    		return new Money();
    	}else if(ran<90){
    		return new Brick();
    	}else if(ran<99){
    		return new Award();
    	}else{
    		return new Flag();
    	}
    }
    
    int index = 0 ;
	public void barrierAction(){
		if(index++%500==0){
		FlyingObject obj = nextOne();
		if(obj instanceof Monster){
			monster = Arrays.copyOf(monster, monster.length+1);
			monster[monster.length-1] = (Monster)obj;
		}
		if(obj instanceof Barrier){
			barrier = Arrays.copyOf(barrier, barrier.length+1);
			barrier[barrier.length-1] = (Barrier)obj;
		}
		if(obj instanceof BigBarrier){
			barrier = Arrays.copyOf(barrier, barrier.length+1);
			barrier[barrier.length-1] = (BigBarrier)obj;
		}
		if(obj instanceof Money){
			money = Arrays.copyOf(money, money.length+1);
			money[money.length-1] = (Money)obj;
		}
		if(obj instanceof Brick){
			brick = Arrays.copyOf(brick, brick.length+1);
			brick[brick.length-1] = (Brick)obj;
		}
		if(obj instanceof Flag){
			flag = Arrays.copyOf(flag, flag.length+1);
			flag[flag.length-1] = (Flag)obj;
		}
		if(obj instanceof Award){
			award = Arrays.copyOf(award, award.length+1);
			award[award.length-1] = (Award)obj;
		}
		}
		
	}
	
	public void stepAction(){
		//marry.step();
		/*
		background.step();
		for(int i=0;i<flag.length;i++){
			flag[i].step();
		}
		for(int i=0;i<barrier.length;i++){
			barrier[i].step();
		}
		for(int i=0;i<brick.length;i++){
			brick[i].step();
		}
		*/
		for(int i=0;i<bullet.length;i++){
			bullet[i].step();
		}
		
		for(int i=0;i<key.length;i++){
		    key[i].step();
		}
	
		for(int i=0;i<money.length;i++){
			money[i].step();
		}
		for(int i=0;i<mushroom.length;i++){
			mushroom[i].step();
		}
		 
		for(int i=0;i<monster.length;i++){
			monster[i].step();
		}
		/*
		for(int i=0;i<award.length;i++){
			award[i].step();
		}
		*/
		
		
		
	}
	
	private int intervel = 10;
	public void action(){
		KeyAdapter k = new KeyAdapter() {
			
			
		};
		
		
		MouseAdapter l = new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				marry.down();
				System.out.println("fuidh");
				
				
			}
			public void mouseWheelMoved(MouseWheelEvent E){
				//marry.dump();
				//state = GAME_OVER;
				marry.setStatus(30);
				marry.step();
				background.step();
				for(int i=0;i<flag.length;i++){
					flag[i].step();
				}
				for(int i=0;i<barrier.length;i++){
					barrier[i].step();
				}
				for(int i=0;i<brick.length;i++){
					brick[i].step();
				}
			
			}
			public void mouseExited(MouseEvent e){
				//state = GAME_OVER;
				marry.dump();
			}
			public void mouseMoved(MouseEvent e){
				//marry.setStatus(30);
				//marry.step();
			}
		};
		this.addMouseListener(l);
		this.addMouseMotionListener(l);
		this.addMouseWheelListener(l);
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			public  void run(){
				barrierAction();
				stepAction();
				repaint();
			}
		}, intervel, intervel);
		
	}
	public void paint(Graphics g){
		background.paintImage(g);
		for(int i=0;i<flag.length;i++){
		flag[i].paintImage(g);
		}
		for(int i=0;i<barrier.length;i++){
			barrier[i].paintImage(g);
		}
		
		for(int i=0;i<brick.length;i++){
			brick[i].paintImage(g);
		}
		
		for(int i=0;i<bullet.length;i++){
			bullet[i].paintImage(g);
		}
		
		for(int i=0;i<key.length;i++){
			key[i].paintImage(g);
		}
	
		for(int i=0;i<mushroom.length;i++){
			mushroom[i].paintImage(g);
		}
		
		for(int i=0;i<monster.length;i++){
			monster[i].paintImage(g);
		}
		for(int i=0;i<award.length;i++){
			award[i].paintImage(g);
		}
		marry.paintImage(g);
		if(state==GAME_OVER){
		   g.drawImage(gameover,0,0,null);
		   
		}
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		World world = new World();
		frame.add(world);
		frame.setSize(1500, 701);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		world.action();
	}

}
