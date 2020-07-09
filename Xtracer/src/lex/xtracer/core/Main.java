package lex.xtracer.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import java.awt.Color;

public class Main {

	public static void main(String[] args) throws IOException {
		
		final double FOCAL_LENGTH = .72;
		final double CAMERA_WIDTH = 1.28;
		final double CAMERA_HEIGHT = .72;
		final String PATH = "D:\\Xtracer\\Outputs";
		final int X_RESOLUTION = 1920;
		final int Y_RESOLUTION = 1080;
		final HDRColor AMBIENT_COLOR = HDRColor.WHITE().times(0.05);
		
		File f = new File(PATH + "\\" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + "_XtracerOutput.png");
		f.createNewFile();
		
		BufferedImage image = new BufferedImage(X_RESOLUTION, Y_RESOLUTION, BufferedImage.TYPE_INT_ARGB);
		
		Sphere sphere = new Sphere(new Vec3(1, 0, 4), 1);
		Plane plane = new Plane(new Vec3(0.5, 0, 2.5), new Vec3(1, -2, 0.5).getNormalized());
		Polygon polygon = new Polygon(new Vec3(-18.256, -1.5, -12), new Vec3(1, -0.5, 3.5), new Vec3(-10, 10.5, 3));
//		YAxisAlignedPlane yPlane = new YAxisAlignedPlane(1, false);
		PointLight light = new PointLight(new Vec3(0.5, -0.5, 1.5));
		
		double halfCameraWidth = CAMERA_WIDTH / 2.;
		double halfCameraHeight = CAMERA_HEIGHT / 2.;
		double widthOfAPixel = CAMERA_WIDTH / (double) image.getWidth();
		double heightOfAPixel = CAMERA_HEIGHT / (double) image.getHeight();
		
		Sphere lightBulb = new Sphere(light.position, 0.2);
		
		for(int x = 0; x < image.getWidth(); x++) {
			
			for(int y = 0; y < image.getHeight(); y++) {
				
				Ray ray = new Ray(new Vec3(0, 0, -30), new Vec3(widthOfAPixel * x - halfCameraWidth, heightOfAPixel * (Y_RESOLUTION - y) - halfCameraHeight, FOCAL_LENGTH).getNormalized());
				double distance = polygon.intersectionTest(ray);
				
				if(distance < Double.MAX_VALUE && distance > 0) {
					
//					image.setRGB(x, y, HDRColor.RED().toRGBColor().getRGB());
					
//					image.setRGB(x, y, new Color((int) (255 * light.getDiffuseReflection(ray.getPointOnRay(distance), sphere.getOutwardNormalVector(ray.getPointOnRay(distance)))), 0, 0, 255).getRGB());
					
//					image.setRGB(x, y, new Color(0, (int) (255 - 50 * distance), 0, 255).getRGB());
					
					Vec3 intersection = ray.getPointOnRay(distance);
					HDRColor pointLightIllumination = HDRColor.WHITE().times(light.getDiffuseReflection(intersection, polygon.getOutwardNormalVector(intersection)));
					
					HDRColor color = HDRColor.RED().times(pointLightIllumination.plus(AMBIENT_COLOR));
					
					image.setRGB(x, y, color.toRGBColor().getRGB());
					
				} else {
					
					image.setRGB(x, y, new Color(0, 0, 0, 0).getRGB());
					
				}
				
				if(lightBulb.intersectionTest(ray) < Double.MAX_VALUE) {
					
					image.setRGB(x, y, Color.WHITE.getRGB());
					
				}
				
			}
			
		}
		
		ImageIO.write(image, "png", f);
		
	}

}
