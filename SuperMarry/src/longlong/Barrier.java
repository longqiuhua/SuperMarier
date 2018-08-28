package longlong;

import java.awt.image.BufferedImage;

public class Barrier extends FlyingObject{
	private int speed;
	private static BufferedImage image;
	static{
		image = loadImage("greenBarrier.png");
	}
	public Barrier() {
		super(400,180);
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
