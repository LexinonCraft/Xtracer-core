package lex.xtracer.core;

public class PointLight {
	
	public Vec3 position;
	
	public double getDiffuseReflection(Vec3 surfacePoint, Vec3 outwardNormal) {
		
		Vec3 shadowRay = position.minus(surfacePoint);
		
		double dotProduct = shadowRay.dot(outwardNormal);
		
		if(dotProduct <= 0) {
			
			return 0;
			
		} else {
			
			return dotProduct / shadowRay.length();
			
		}
		
	}
	
	public PointLight(Vec3 position) {
		this.position = position;
	}
	
}
