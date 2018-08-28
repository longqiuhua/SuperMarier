package longlong;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;

public class Background extends FlyingObject{
	private int x1 ;//= 1300;
	private int speed;
	private static BufferedImage image;
	static{
		image = loadImage("background2.PNG");
	}
	public Background() {
		super(0,0,World.WIDTH,World.HEIGHT);
		x1 = World.WIDTH;
		speed = 8;
	}

	@Override
	public void step() {
		x -= speed;
		x1 -= speed;
		if(x<=-World.WIDTH){
			x = World.WIDTH;
		}
		if(x1<=-World.WIDTH){
			x1 = World.WIDTH;
		}
	}
	public void paintImage(Graphics g){
		g.drawImage(getImage(),x,y,null);
		g.drawImage(getImage(),x1,y,null);
		
	}
	@Override
	public BufferedImage getImage() {
		return image;
	}

}
