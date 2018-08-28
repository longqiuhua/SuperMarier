package longlong;

import java.awt.image.BufferedImage;

public class Monster extends FlyingObject{
	private int speed;
	private static BufferedImage image;
	static{
		image = loadImage("monster.png");
	}
	public Monster() {
		super(370,290);
		speed = 2;
	}

	@Override
	public void step() {
		x -= speed;
		
	}

	int index = 0;
	
	public BufferedImage getImage() {
		return image;
	}
}
