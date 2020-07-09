package lex.xtracer.core;

public class Ray {
	
	// The direction of the ray has to be normalized!
	
	public Vec3 origin;
	public Vec3 direction;
	
	public Vec3 getPointOnRay(double distance) {
		
		return origin.plus(direction.times(distance));
		
	}
	
	public Ray(Vec3 origin, Vec3 direction) {
		this.origin = origin;
		this.direction = direction;
	}
	
}
