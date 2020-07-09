package lex.xtracer.core;

public class Polygon implements Hittable {
	
	public Vec3 A;
	public Vec3 B;
	public Vec3 C;
	
	public Polygon(Vec3 A, Vec3 B, Vec3 C) {
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	@Override
	public double intersectionTest(Ray ray) {
		
		Vec3 inwardNormalVector = getInwardNormalVector(null);
		
		try {
			
			double distance = (A.dot(inwardNormalVector) - ray.origin.dot(inwardNormalVector)) / ray.direction.dot(inwardNormalVector);
			
			if(distance <= 0) return Double.MAX_VALUE;
			
			Vec3 a = ray.getPointOnRay(distance).minus(A);
			
			Vec3 b = B.minus(A);
			Vec3 c = C.minus(A);
			
			double beta = (a.dot(b) * c.dot(c) - a.dot(c) * c.dot(b)) / (c.dot(c) * b.dot(b) - c.dot(b) * b.dot(c));
			double gamma = (a.dot(c) * b.dot(b) - a.dot(b) * b.dot(c)) / (c.dot(c) * b.dot(b) - c.dot(b) * b.dot(c));
			
//			System.out.println("beta == " + beta);
			
			if(beta >= 0 && gamma >= 0 && beta + gamma <= 1) {
				
				return distance;
				
			} else {
				
				return Double.MAX_VALUE;
				
			}
			
} 			catch (ArithmeticException e) {
				
				return Double.MAX_VALUE;
				
			}
		
	}
	
	@Override
	public Vec3 getOutwardNormalVector(Vec3 point) {
		
		return C.minus(A).cross(B.minus(A)).getNormalized();
		
	}
	
	@Override
	public Vec3 getInwardNormalVector(Vec3 point) {
		
		return B.minus(A).cross(C.minus(A)).getNormalized();
		
	}
	
}
