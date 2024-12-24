package Forms3D;
import com.jogamp.opengl.*;

import static InteractionEspace.Movements.*;

public class EnemySpaceShip {

    public static float angle = 0.0f;  // Angle de rotation


    public static void drawEnemySpaceShip(GL2 gl) {
        gl.glTranslatef(posX, posY, 0.0f);
        gl.glRotatef(angle, 0.0f, 1.0f, 0.0f);  // Rotation verticale

        // Dessin du cube avec des couleurs pastel
        gl.glBegin(GL2.GL_QUADS);
        gl.glShadeModel(GL2.GL_SMOOTH);

        // Face avant (rouge doux)
        gl.glColor3f(0.9f, 0.5f, 0.5f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);

        // Face arrière (vert pastel)
        gl.glColor3f(0.6f, 0.8f, 0.6f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);

        // Face gauche (bleu clair)
        gl.glColor3f(0.5f, 0.7f, 0.9f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);

        // Face droite (jaune pâle)
        gl.glColor3f(0.9f, 0.9f, 0.5f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f);

        // Face supérieure (violet doux)
        gl.glColor3f(0.8f, 0.6f, 0.9f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);

        // Face inférieure (orange clair)
        gl.glColor3f(0.9f, 0.7f, 0.5f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glVertex3f(1.0f, -1.0f, 1.0f);
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);

        gl.glEnd();

        angle += 0.01f;

        // Appeler les méthodes de déplacement
        updatePosition();
    }

    // Déplace en X puis en Y puis en X puis en Y

}
