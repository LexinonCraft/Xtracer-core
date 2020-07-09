package lex.xtracer.core;

public class Plane implements Hittable {
	
	public Vec3 point;
	public Vec3 inwardNormalVector;
	
	@Override
	public double intersectionTest(Ray ray) {
		
		try {
			
			double distance = (point.minus(ray.origin).dot(inwardNormalVector)) / ray.direction.dot(inwardNormalVector);
			
			if(distance <= 0) {
				
				return Double.MAX_VALUE;
				
			} else {
				
				return distance;
				
			}
			
		} catch(ArithmeticException e) {
			
			return Double.MAX_VALUE;
			
		}
		
	}
	
	@Override
	public Vec3 getOutwardNormalVector(Vec3 point) {
		
		return new Vec3().minus(inwardNormalVector);
		
	}
	
	@Override
	public Vec3 getInwardNormalVector(Vec3 point) {
		
		return inwardNormalVector;
		
	}
	
	public Plane(Vec3 point, Vec3 inwardNormalVector) {
		this.point = point;
		this.inwardNormalVector = inwardNormalVector;
	}
	
	public class PreCalculated implements Hittable {
		
		private double d;	// = point.dot(inwardNormalVector)
		private Vec3 inwardNormalVector;
		
		@Override
		public double intersectionTest(Ray ray) {
			
			try {
				
				double distance = (d - ray.origin.dot(inwardNormalVector)) / ray.direction.dot(inwardNormalVector);
				
				if(distance <= 0) {
					
					return Double.MAX_VALUE;
					
				} else {
					
					return distance;
					
				}
				
			} catch(ArithmeticException e) {
				
				return Double.MAX_VALUE;
				
			}
			
		}
		
		@Override
		public Vec3 getOutwardNormalVector(Vec3 point) {
			
			return new Vec3().minus(inwardNormalVector);
			
		}
		
		@Override
		public Vec3 getInwardNormalVector(Vec3 point) {
			
			return inwardNormalVector;
			
		}
		
		public void update() {
			
			inwardNormalVector = Plane.this.inwardNormalVector;
			d = inwardNormalVector.dot(Plane.this.point);
			
		}
		
		public PreCalculated() {
			
			inwardNormalVector = Plane.this.inwardNormalVector;
			d = inwardNormalVector.dot(Plane.this.point);
			
		}
		
	}
	
}
