package longlong;

import java.awt.image.BufferedImage;

public class Key extends FlyingObject{
	private int speed;
	private static BufferedImage image;
	static{
		image = loadImage("key.png");
	}
	public Key() {
		super(380,World.HEIGHT);
		speed = 1;
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
