package longlong;

import java.awt.image.BufferedImage;

public class BigBarrier extends FlyingObject{
	private int speed;
    private static BufferedImage image;
    static{
    	image = loadImage("blueBarrier.png");
    	
    }
	public BigBarrier() {
		super(380,293);
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
