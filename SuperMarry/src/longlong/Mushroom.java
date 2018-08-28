package longlong;

import java.awt.image.BufferedImage;

public class Mushroom extends FlyingObject {
	private int speed;
	private static BufferedImage image;
	static{
		image = loadImage("mushroom.png");
	}

	public Mushroom() {
		super(385,275);
		
	}
	
	@Override
	public void step() {
		x -= speed;
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}

}
