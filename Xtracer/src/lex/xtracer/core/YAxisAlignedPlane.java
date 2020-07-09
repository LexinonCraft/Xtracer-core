package lex.xtracer.core;

public class YAxisAlignedPlane implements Hittable {
	
	public double y;
	public boolean up;
	
	@Override
	public double intersectionTest(Ray ray) {
		
		try {
			
			double distance = (((up ? (-y) : y) - ray.origin.dot(getInwardNormalVector(null))) / (double) ray.direction.dot(getInwardNormalVector(null)));
			
			if(distance <= 0) {
				
				return Double.MAX_VALUE;
				
			} else {
				
				return distance;
				
			}
			
		} catch (ArithmeticException e) {
			
			return Double.MAX_VALUE;
			
		}
		
	}
	
	@Override
	public Vec3 getOutwardNormalVector(Vec3 point) {
		
		if(up) {
			
			return new Vec3(0, 1, 0);
			
		} else {
			
			return new Vec3(0, -1, 0);
			
		}
		
	}
	
	@Override
	public Vec3 getInwardNormalVector(Vec3 point) {
		
		if(up) {
			
			return new Vec3(0, -1, 0);
			
		} else {
			
			return new Vec3(0, 1, 0);
			
		}
		
	}
	
	public YAxisAlignedPlane(double y, boolean up) {
		this.y = y;
		this.up = up;
	}
	
}
