package longlong;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Marry extends FlyingObject {
	private int speed;
	private int life;
	private static BufferedImage image;
	private int status;
	private int high;
	static{
		image = loadImage("marry.png");
	}
	public Marry() {
		super(256,256);
		this.x = -30;
		this.y = World.HEIGHT-this.height-30;
		speed = 0;
		life = 3;
		status = 0;
		Random random = new Random();
		high = random.nextInt(3);
	
	}
	public void step(){
		if(status==0)
			speed = 0;
		else
			speed = 1;
		x += speed;
	}
	
	@Override
	public BufferedImage getImage() {
		return image;
	}
	public void setStatus(int status){
		this.status = status;
	}
	public void dump(){
		if(high==0){
			y = World.HEIGHT-293-this.height;
		}else if(high==1){
			y = World.HEIGHT-180-this.height;
		}else{
			y = 100;
		}
	}
	public void down(){
		y = this.y = World.HEIGHT-this.height-30;
	}

}
