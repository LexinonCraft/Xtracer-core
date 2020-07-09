package lex.xtracer.core;

public interface Hittable {
	
	public double intersectionTest(Ray ray);
	
	public Vec3 getOutwardNormalVector(Vec3 point);
	public Vec3 getInwardNormalVector(Vec3 point);
	
}
