package longlong;

import java.awt.image.BufferedImage;

public class Money extends FlyingObject{
	private int speed;
	private static BufferedImage image;
    static{
    	image = loadImage("money.png");
    }
	public Money() {
		super(256,256);
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
