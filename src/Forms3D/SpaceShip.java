package Forms3D;

import com.jogamp.opengl.GL2;

public class SpaceShip extends Forme3D {

    private static float shipAngle = 0.0f;

    public static void drawSpaceShip(GL2 gl) {
        gl.glPushMatrix();

        gl.glRotatef(shipAngle, 0.0f, 1.0f, 0.0f);

        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glColor3f(0.7f, 0.75f, 0.8f);

        // Face avant
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f);

        // Face droite
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);

        // Face arrière
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);

        // Face gauche
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);

        gl.glEnd();

        // Base carrée
        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(0.6f, 0.65f, 0.7f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glEnd();

        gl.glPopMatrix();

        shipAngle += 0.1f;
    }
}