package longlong;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

//(1300,609)
public abstract class FlyingObject {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	public FlyingObject(int width,int height) {
		this.height = height;
		this.width = width;
		this.x = World.WIDTH+this.width;
		this.y = World.HEIGHT-this.height;
		
	}
	
	public FlyingObject(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public abstract void step();
	public static BufferedImage loadImage(String fileName){
		try{
			BufferedImage img = ImageIO.read(FlyingObject.class.getResource(fileName));
			return img;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public abstract BufferedImage getImage();
	public void paintImage(Graphics g){
		g.drawImage(getImage(),x,y,null);
		
	}
}
