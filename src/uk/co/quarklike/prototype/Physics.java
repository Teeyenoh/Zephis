package uk.co.quarklike.prototype;

public class Physics {
	public static int maxRange(float force, float mass, float height) {
		float impulse = force * 0.1f;
		float u = impulse / mass;
		float g = -9.81f;
		float time = (float) ((-Math.sqrt(-2 * (g * height))) / g);
		return (int) Math.round(u * time);
	}
}
