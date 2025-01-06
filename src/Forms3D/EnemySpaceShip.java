package Forms3D;
import com.jogamp.opengl.*;

import static InteractionEspace.MovementsEnemySpaceShip.*;

public class EnemySpaceShip {


    private float posX, posY, posZ; // Position du cube
    private static float globalSpeedX = 0.004f; // Vitesse globale en X
    private static float globalSpeedY = 0.01f; // Vitesse globale en Y
    public static float angle = 0.0f; // Angle de rotation global

    // Constructeur
    public EnemySpaceShip(float posX, float posY) {
        this.posX = posX;
        this.posY = posY;
    }
    // Méthode pour mettre à jour les positions des cubes

    public void draw(GL2 gl) {
        gl.glPushMatrix();
        gl.glTranslatef(posX, posY, posZ);
        gl.glRotatef(angle, 0.0f, 1.0f, 0.0f); // Rotation autour de l'axe Y
        drawEnemySpaceShip(gl); // Dessiner le cube
        gl.glPopMatrix();
    }
    public static void drawEnemySpaceShip(GL2 gl) {
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

        angle += 0.10f;

        // Appeler les méthodes de déplacement
        updatePositionEnemySpaceShip();
    }
    public void mouvement() {
        posX += globalSpeedX;

        // Inverser la direction si le cube atteint les bords
        if (posX >= 3.0f || posX <= -3.0f) {
            globalSpeedX = -globalSpeedX;
            globalSpeedY = 0.01f;
        }

        // Gestion du mouvement vertical
        if (globalSpeedY > 0) {
            posY -= globalSpeedY;
            if (posY <= -20.0f) {
                posY = 0.0f;
                globalSpeedY = 0.0f;
            }
        }
    }
    public static void updateRotation() {
        angle += 0.5f; // Augmente l'angle globalement
    }
    public float getPosX() {
        return posX;
    }
}