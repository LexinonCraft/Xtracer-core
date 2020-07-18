package lex.xtracer.core;

public class Plane {
	
	public Vec3 point;
	public Vec3 inwardNormalVector;
	
	public Plane(Vec3 point, Vec3 inwardNormalVector) {
		this.point = point;
		this.inwardNormalVector = inwardNormalVector;
	}
	
	public class Hittable implements lex.xtracer.core.Hittable {
		
		public double a;
		
		@Override
		public double intersectionTest(Ray ray) {
			
			try {
				
				double distance = (a - ray.origin.dot(inwardNormalVector)) / ray.direction.dot(inwardNormalVector);
				
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
			
			a = point.dot(inwardNormalVector);
			
		}
		
		public Hittable() {
			
			update();
			
		}
		
	}
	
}
