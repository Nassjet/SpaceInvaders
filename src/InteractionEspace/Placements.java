package InteractionEspace;

import com.jogamp.opengl.GL2;

public class Placements {
    private static float shiftX = 0.0f;
    private static float shiftY = 0.0f;
    public static void placerCamera(GL2 gl) {
        gl.glTranslatef(0.0f, -5.0f, -40.0f);  // Caméra reculée
    }

    public static void placerSpaceShip(GL2 gl) {
        gl.glTranslatef(0, -8, 0.0f);
    }
}