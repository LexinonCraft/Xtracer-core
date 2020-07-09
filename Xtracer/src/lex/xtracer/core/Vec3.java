package lex.xtracer.core;

public class Vec3 {
	
	public double x;
	public double y;
	public double z;
	
	public Vec3 plus(Vec3 vec) {
		
		return new Vec3(x + vec.x, y + vec.y, z + vec.z);
		
	}
	
	public Vec3 minus(Vec3 vec) {
		
		return new Vec3(x - vec.x, y - vec.y, z - vec.z);
		
	}
	
	public Vec3 times(double d) {
		
		return new Vec3(x * d, y * d, z * d);
		
	}
	
	public Vec3 by(double d) {
		
		return new Vec3(x / d, y / d, z / d);
		
	}
	
	public void add(Vec3 vec) {
		
		x += vec.x;
		y += vec.y;
		z += vec.z;
		
	}
	
	public void subtract(Vec3 vec) {
		
		x -= vec.x;
		y -= vec.y;
		z -= vec.z;
		
	}
	
	public void multiply(double d) {
		
		x *= d;
		y *= d;
		z *= d;
		
	}
	
	public void divide(double d) {
		
		x /= d;
		y /= d;
		z /= d;
		
	}
	
	public double dot(Vec3 vec) {
		
		return x * vec.x + y * vec.y + z * vec.z;
		
	}
	
	public Vec3 cross(Vec3 vec) {
		
		return new Vec3(y * vec.z - z * vec.y, z * vec.x - x * vec.z, x * vec.y - y * vec.x);
		
	}
	
	public double length() {
		
		return Math.sqrt(dot(this));
		
	}
	
	public void normalize() {
		
		double length = length();
		x /= length;
		y /= length;
		z /= length;
		
	}
	
	public Vec3 getNormalized()	 {
		
		double length = length();
		return new Vec3(x / length, y / length, z / length);
		
	}
	
	public Vec3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vec3() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
}
