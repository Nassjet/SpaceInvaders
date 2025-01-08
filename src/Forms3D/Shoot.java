package Forms3D;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import java.util.ArrayList;
import java.util.Iterator;

public class Shoot extends Forme3D{

    private static final float SHOOT_RADIUS = 0.1f;  // Rayon du tir
    private static final float SHOOT_HEIGHT = 1.5f;  // Hauteur du tir
    private static final float SHOOT_SPEED = 0.2f;   // Vitesse de montée du tir

    // Liste des tirs actifs
    public static final ArrayList<Shoot> shoots = new ArrayList<>();


    // Position du tir individuel
    public float posX;
    public float posY;
    public float posZ = 0.0f;  // En 3D si besoin
    public float getPosX() {
        return posX;
    }
    public float getPosY() {
        return posY;
    }
    public float getPosZ() {
        return posZ;
    }



    // Constructeur : chaque tir a sa propre position initiale
    public Shoot(float x, float y) {
        this.posX = x;
        this.posY = y;
    }

    // Ajouter un tir à la position du vaisseau
    public static void shootFrom(float x, float y) {
        shoots.add(new Shoot(x, y));
    }

    private static final GLUquadric quadric = new GLU().gluNewQuadric();  // Crée une fois

    public static void drawShoots(GL2 gl) {
        GLU glu = new GLU();
        Iterator<Shoot> iterator = shoots.iterator();
        while (iterator.hasNext()) {
            Shoot shoot = iterator.next();

            gl.glPushMatrix();
            gl.glTranslatef(shoot.posX, shoot.posY, 0);
            gl.glTranslatef(0.0f, -SHOOT_HEIGHT, 0);  // Décalage vers le bas avant de dessiner
            gl.glRotatef(-90, 1.0f, 0.0f, 0.0f);

            gl.glColor3f(0.9f, 0.1f, 0.1f);
            glu.gluCylinder(quadric, SHOOT_RADIUS, SHOOT_RADIUS, SHOOT_HEIGHT, 20, 20);

            glu.gluDisk(quadric, 0.0f, SHOOT_RADIUS, 20, 1);
            gl.glTranslatef(0.0f, 0.0f, SHOOT_HEIGHT);
            glu.gluDisk(quadric, 0.0f, SHOOT_RADIUS, 20, 1);

            gl.glPopMatrix();
            shoot.posY += SHOOT_SPEED;

            if (shoot.posY > 30.0f) {
                iterator.remove();
            }
        }

    }
    public boolean killEnemySpaceShip(EnemySpaceShip enemySpaceShip) {
        if(this.yPos < enemySpaceShip.getPosY() + enemySpaceShip.getHauteur()
                && this.yPos + this.hauteur > enemySpaceShip.getPosY()
                && this.xPos + this.largeur > enemySpaceShip.getPosX()
                && this.xPos < enemySpaceShip.getPosX() + enemySpaceShip.getLargeur()){
            return true;
        }
        else{return false;}
    }
}
