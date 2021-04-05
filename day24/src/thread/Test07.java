package thread;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Test07 {
	public static void main(String[] args) throws AWTException, IOException {
		//화면 캡쳐
		Robot r=new Robot();
		Rectangle rect=new Rectangle(0,0,1400,1050);
		BufferedImage img=r.createScreenCapture(rect);
		
		ImageIO.write(img,"png",new File("kh","capture.png"));
		
		
	}

}
