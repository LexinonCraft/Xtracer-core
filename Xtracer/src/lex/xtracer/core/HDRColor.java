package lex.xtracer.core;

import java.awt.Color;

public class HDRColor {
	
	public double red;
	public double green;
	public double blue;
	
	public HDRColor plus(HDRColor color) {
		
		return new HDRColor(red + color.red, green + color.green, blue + color.blue);
		
	}
	
	public HDRColor minus(HDRColor color) {
		
		return new HDRColor(red - color.red, green - color.green, blue - color.blue);
		
	}
	
	public HDRColor times(double d) {
		
		return new HDRColor(red * d, green * d, blue * d);
		
	}
	
	public HDRColor by(double d) {
		
		return new HDRColor(red / d, green / d, blue / d);
		
	}
	
	public HDRColor times(HDRColor color) {
		
		return new HDRColor(red * color.red, green * color.green, blue * color.blue);
		
	}
	
	public HDRColor by(HDRColor color) {
		
		return new HDRColor(red / color.red, green / color.green, blue / color.blue);
		
	}
	
	public void add(HDRColor color) {
		
		red += color.red;
		green += color.green;
		blue += color.blue;
		
	}
	
	public void subtract(HDRColor color) {
		
		red -= color.red;
		green -= color.green;
		blue -= color.blue;
		
	}
	
	public void multiply(double d) {
		
		red *= d;
		green *= d;
		blue *= d;
		
	}
	
	public void divide(double d) {
		
		red /= d;
		green /= d;
		blue /= d;
		
	}
	
	public void multiply(HDRColor color) {
		
		red *= color.red;
		green *= color.green;
		blue *= color.blue;
		
	}
	
	public void divide(HDRColor color) {
		
		red /= color.red;
		green /= color.green;
		blue /= color.blue;
		
	}
	
	public Color toRGBColor() {
		
		int tempRed;
		int tempGreen;
		int tempBlue;
		
		if(red > 1) {
			
			tempRed = 255;
			
		} else {
			
			tempRed = (int) (255 * red);
			
		}
		
		if(green > 1) {
			
			tempGreen = 255;
			
		} else {
			
			tempGreen = (int) (255 * green);
			
		}
		
		if(blue > 1) {
			
			tempBlue = 255;
			
		} else {
			
			tempBlue = (int) (255 * blue);
			
		}
		
		return new Color(tempRed, tempGreen, tempBlue, 255);
		
	}
	
	public HDRColor(double red, double green, double blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public HDRColor(Color color) {
		
		red = color.getRed();
		green = color.getGreen();
		blue = color.getBlue();
		
	}
	
	public static HDRColor RED() {return new HDRColor(1, 0, 0);}
	public static HDRColor ORANGE() {return new HDRColor(1, 0.5, 0);}
	public static HDRColor YELLOW() {return new HDRColor(1, 1, 0);}
	public static HDRColor GREEN() {return new HDRColor(0, 1, 0);}
	public static HDRColor BLUE() {return new HDRColor(0, 0, 1);}
	public static HDRColor PURPLE() {return new HDRColor(1, 0, 1);}
	public static HDRColor BLACK() {return new HDRColor(0, 0, 0);}
	public static HDRColor GRAY() {return new HDRColor(0.5, 0.5, 0.5);}
	public static HDRColor WHITE() {return new HDRColor(1, 1, 1);}
	
}
