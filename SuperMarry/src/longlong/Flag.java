package longlong;

import java.awt.image.BufferedImage;

public class Flag extends FlyingObject{
	private int speed ;
	private static BufferedImage image;
	static{
		image = loadImage("flag.png");
	}
	public Flag() {
		super(330,World.HEIGHT);
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
