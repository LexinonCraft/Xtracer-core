package lex.xtracer.core;

public class Sphere implements Hittable {
	
	public Vec3 center;
	public double radius;
	
	@Override
	public double intersectionTest(Ray ray) {
		
		Vec3 g = ray.origin.minus(center);
		double b = 2 * g.dot(ray.direction);
		double c = g.dot(g) - radius * radius;
		
		double discriminant = b * b - 4 * c;
		
		if(discriminant < 0) {
			
			return Double.MAX_VALUE;
			
		} else if(discriminant > 0) {
			
			double sqrt = Math.sqrt(discriminant);
			double distance1 = (-b + sqrt) / 2.;
			double distance2 = (-b - sqrt) / 2.;
			
			boolean distance1positive = distance1 > 0;
			boolean distance2positive = distance2 > 0;
			
			if(distance1positive && distance2positive) {
				
				if(distance1 < distance2) {
					
					return distance1;
					
				} else {
					
					return distance2;
					
				}
				
			} else if(distance1positive) {
				
				return distance1;
				
			} else if(distance2positive) {
				
				return distance2;
				
			} else {
				
				return Double.MAX_VALUE;
				
			}
				
		} else {
			
			double distance = (-b) / 2.;
			
			if(distance > 0) {
				
				return distance;
				
			} else {
				
				return Double.MAX_VALUE;
				
			}
			
		}
		
	}
	
	@Override
	public Vec3 getOutwardNormalVector(Vec3 point) {
		
		return point.minus(center);
		
	}
	
	@Override
	public Vec3 getInwardNormalVector(Vec3 point) {
		
		return center.minus(point);
		
	}
	
	public Sphere(Vec3 center, double radius) {
		this.center = center;
		this.radius = radius;
	}
	
}
