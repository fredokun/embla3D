package gameEngine.light;

import org.joml.Vector3f;

public class AmbiantLight {
	private Vector3f color;
	private  float intensity;
	//Value put in the shader
	private Vector3f shaderValue;
	
	public AmbiantLight(Vector3f color, float intensity){
		this.color = color;
		this.intensity = intensity;
		this.shaderValue= new Vector3f(color.x*intensity,color.y *intensity,color.z*intensity);
	}
	
	public AmbiantLight(){
		this.color = new Vector3f(1f,1f,1f);
		this.intensity=1f;
		this.shaderValue = new Vector3f(1f,1f,1f);
	}

	public AmbiantLight(float intensity){
		this.color = new Vector3f(1f,1f,1f);
		this.intensity=intensity;
		this.shaderValue = new Vector3f(color.x *intensity,color.y *intensity,color.z *intensity);
	}
	
	public void setColor(Vector3f color) {
		this.color = color;
		this.shaderValue= new Vector3f(color.x *intensity,color.y *intensity,color.z *intensity);
}

	public void setIntensity(float intensity) {
		this.intensity = intensity;
		this.shaderValue= new Vector3f(color.x *intensity,color.y *intensity,color.z*intensity);
}

	public Vector3f getColor() {
		return color;
	}

	public float getIntensity() {
		return intensity;
	}

	public Vector3f getShaderValue() {
		return shaderValue;
	}	
}
