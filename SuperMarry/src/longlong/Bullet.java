package longlong;

import java.awt.image.BufferedImage;

public class Bullet extends FlyingObject{
	private int speed;
	private static BufferedImage image;
	static{
		image = loadImage("bullet2.png");
		
	}

	public Bullet(int x,int y) {
		super(x,y,256,256);
		speed = 3;
	}

	@Override
	public void step() {
		x += speed;
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}
	public void moveTo(int x,int y){
		this.x = x;
		this.y = y;
	}

}
