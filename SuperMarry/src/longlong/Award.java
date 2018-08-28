package longlong;

import java.awt.image.BufferedImage;

public class Award extends FlyingObject{
	private int speed ;
	private static BufferedImage image;
	static{
		image = loadImage("award.png");
		
	}

	public Award() {
		super(385, World.HEIGHT);
		speed = 8;
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
