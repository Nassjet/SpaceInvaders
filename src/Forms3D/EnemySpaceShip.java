package Forms3D;
import com.jogamp.opengl.*;
public class EnemySpaceShip extends Forme3D {



    private float posX, posY, posZ; // Position du cube
    private float speedY = 0.01f; // Vitesse globale en Y
    public static float angle = 0.0f; // Angle de rotation global
    // Constructeur
    public EnemySpaceShip(float posX, float posY) {
        this.posX = posX;
        this.posY = posY;
    }
    // Méthode pour mettre à jour les positions des cubes
    public void drawingEnemySpaceShip(GL2 gl) {
        gl.glPushMatrix();
        gl.glTranslatef(posX, posY, posZ); // on pose notre cube à cette position
        gl.glRotatef(angle, 1.0f, 1.0f, 1.0f); // tourne dans les 3 sens
        drawEnemySpaceShip(gl);
        gl.glPopMatrix();
        //createHitbox(gl);
    }
    public void createHitbox(GL2 gl) {
        gl.glPushMatrix();
        gl.glTranslatef(posX, posY,0); // on pose notre cube à cette position
        gl.glBegin(GL2.GL_QUADS);
        gl.glShadeModel(GL2.GL_SMOOTH);
        gl.glColor3f(0f, 0f, 0f);
        gl.glVertex3f(-1.5f, -1.5f, 0.0f);
        gl.glVertex3f(1.5f, -1.5f, 0.0f);
        gl.glVertex3f(1.5f, 1.5f, 0.0f);
        gl.glVertex3f(-1.5f, 1.5f, 0.0f);
        gl.glEnd();
        gl.glPopMatrix();
    }

    //dessiner la forme du vaisseau ennemi (cube)
    public void drawEnemySpaceShip(GL2 gl) {
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

        angle += 0.1f; // augmente l'angle de rotation
    }

    public void mouvement() {
        posY -= speedY;  // Commence par descendre

        // Si le vaisseau atteint la limite basse, il remonte
        if (posY < -20) {
            speedY = -speedY;  // Inverse la direction pour remonter
        }

        // Si le vaisseau remonte trop haut, il redescend
        if (posY > 20) {
            speedY = -speedY;
        }
    }


    public static void updateRotation() {
        angle += 0.5f; // Augmente l'angle globalement
    }
    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public float getPosZ() {
        return posZ;
    }
}