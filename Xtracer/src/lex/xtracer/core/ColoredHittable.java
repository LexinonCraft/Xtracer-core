package lex.xtracer.core;

public class ColoredHittable implements Hittable {
	
	public Hittable hittable;
	public HDRColor color;
	
	@Override
	public double intersectionTest(Ray ray) {
		return hittable.intersectionTest(ray);
	}
	
	@Override
	public Vec3 getOutwardNormalVector(Vec3 point) {
		return hittable.getOutwardNormalVector(point);
	}
	
	@Override
	public Vec3 getInwardNormalVector(Vec3 point) {
		return hittable.getInwardNormalVector(point);
	}
	
	public ColoredHittable(Hittable hittable, HDRColor color) {
		this.hittable = hittable;
		this.color = color;
	}
	
}
