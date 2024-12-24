package Forms3D;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;

public class Shoot {

    private static final float SHOOT_RADIUS = 0.1f;  // Rayon du cylindre (tir)
    private static final float SHOOT_HEIGHT = 1.5f;  // Hauteur du tir

    public static void drawShoot(GL2 gl) {
        GLU glu = new GLU();
        GLUquadric quadric = glu.gluNewQuadric();

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.0f, 0.0f);  // Position de départ (peut être ajustée dynamiquement plus tard)
        gl.glRotatef(-90, 1.0f, 0.0f, 0.0f);  // Aligner le cylindre verticalement

        gl.glColor3f(0.9f, 0.1f, 0.1f);  // Rouge doux pour le tir
        glu.gluCylinder(quadric, SHOOT_RADIUS, SHOOT_RADIUS, SHOOT_HEIGHT, 20, 20);

        // Dessin du capot du cylindre (fermeture en haut)
        glu.gluDisk(quadric, 0.0f, SHOOT_RADIUS, 20, 1);
        gl.glTranslatef(0.0f, 0.0f, SHOOT_HEIGHT);
        glu.gluDisk(quadric, 0.0f, SHOOT_RADIUS, 20, 1);

        gl.glPopMatrix();
        glu.gluDeleteQuadric(quadric);
    }
}
