package longlong;
//((400,280))
import java.awt.image.BufferedImage;

public class Brick extends FlyingObject {
	private int speed;
	private static BufferedImage image;
	static{
		image = loadImage("brick.png");
	}
	public Brick() {
		super(385,World.HEIGHT);
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
