package yaw.engine.items;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import yaw.engine.meshs.Material;
import yaw.engine.meshs.Mesh;

/**
 * An ItemObject is a concrete 3D item associated to a Mesh
 */
public class ItemObject extends Item {

    private Mesh mesh;

    public ItemObject(String id, Vector3f position, Vector3f orientation, float scale, Mesh mesh){
        super(id, position, orientation, scale);
        this.mesh= mesh;
    }

    @Override
    public void revolveAround(Vector3f center, float degX, float degY, float degZ) {

        Vector4f pos = new Vector4f(position, 1f);
        pos.add(-center.x, -center.y, -center.z, 0);
        Matrix4f trans = new Matrix4f();
        trans.rotateX((float) Math.toRadians(degX));
        trans.rotateY((float) Math.toRadians(degY));
        trans.rotateZ((float) Math.toRadians(degZ));
        trans.transform(pos);
        pos.add(center.x, center.y, center.z, 0);
        position = new Vector3f(pos.x, pos.y, pos.z);
    }

    @Override
    public void repelBy(Vector3f center, float dist) {
        Vector3f dif = new Vector3f(position.x - center.x, position.y - center.y, position.z - center.z);
        float norm = dif.length();
        if (norm != 0) {
            float move = (dist / norm) + 1;
            dif.mul(move);
            dif.add(center);
            position = dif;
        }
    }



    // MeshOld Gestion
    public Mesh getMesh(){ return mesh; }

    public float getReflectance() {
        return this.getMesh().getMaterial().getReflectance();
    }

    public void setReflectance(float refl) {
        this.getMesh().getMaterial().setReflectance(refl);
    }

    public Vector3f getColor() {
        return this.getMesh().getMaterial().getColor();
    }

    public void setColor(Vector3f color) {
        this.getMesh().setMaterial(new Material(color, 0.f));
    }


    // In case of input Feature
    @Override
    public void update() {

    }
}