package Forms3D;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;

import java.util.ArrayList;
import java.util.Iterator;

public class Shoot {

    private static final float SHOOT_RADIUS = 0.1f;  // Rayon du tir
    private static final float SHOOT_HEIGHT = 1.5f;  // Hauteur du tir
    private static final float SHOOT_SPEED = 0.1f;   // Vitesse de montée du tir

    private static final ArrayList<Shoot> shoots = new ArrayList<>();

    private float posX;
    private float posY;

    // Constructeur : chaque tir a sa propre position initiale
    public Shoot(float x, float y) {
        this.posX = x;
        this.posY = -7.5f; //ajuster la position d'apparition du tir ici
    }

    // Ajouter un tir à la position du vaisseau
    public static void shootFrom(float x, float y) {
        shoots.add(new Shoot(x, y));
    }

    // Dessiner chaque tir et le faire monter
    public static void drawShoot(GL2 gl) {
        GLU glu = new GLU();
        GLUquadric quadric = glu.gluNewQuadric();

        Iterator<Shoot> iterator = shoots.iterator();
        while (iterator.hasNext()) {
            Shoot shoot = iterator.next();

            gl.glPushMatrix();
            gl.glTranslatef(shoot.posX, shoot.posY, 0);
            gl.glRotatef(-90, 1.0f, 0.0f, 0.0f);  // Aligner le cylindre verticalement

            gl.glColor3f(0.9f, 0.1f, 0.1f);
            glu.gluCylinder(quadric, SHOOT_RADIUS, SHOOT_RADIUS, SHOOT_HEIGHT, 20, 20);

            // Dessin du capot du cylindre
            glu.gluDisk(quadric, 0.0f, SHOOT_RADIUS, 20, 1);
            gl.glTranslatef(0.0f, 0.0f, SHOOT_HEIGHT);
            glu.gluDisk(quadric, 0.0f, SHOOT_RADIUS, 20, 1);

            gl.glPopMatrix();

            // Faire monter le tir
            shoot.posY += SHOOT_SPEED;

            // Supprimer le tir s'il dépasse une certaine hauteur (hors écran)
            if (shoot.posY > 30.0f) {
                iterator.remove();
            }
        }
        glu.gluDeleteQuadric(quadric);
    }
}
