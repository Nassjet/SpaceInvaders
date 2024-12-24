import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;
import javax.swing.*;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

import static Forms3D.EnemySpaceShip.drawEnemySpaceShip;
import static InteractionEspace.Placements.*;


public class MainGL implements GLEventListener {
    public static void main(String[] args) {
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        GLJPanel glPanel = new GLJPanel(capabilities);
        MainGL mainGL = new MainGL();
        glPanel.addGLEventListener(mainGL);

        JFrame frame = new JFrame("Cube 3D Rotatif");
        frame.setSize(1080, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(glPanel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        FPSAnimator animator = new FPSAnimator(glPanel, 120, true);
        animator.start();
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(0.1f, 0.1f, 0.1f, 1.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);  // Activer le test de profondeur
    }

    @Override

    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        placerCamera(gl);
        resetShiftY();  // Reset Y au début de chaque frame

        // Dessiner plusieurs lignes
        for (int j = 0; j < 4; j++) {
            resetShiftX();

            for (int i = 0; i < 10; i++) {
                gl.glPushMatrix();  // Sauvegarde l'état actuel
                deplacerGenerationPointFormeX(gl);  // Décale horizontalement
                drawEnemySpaceShip(gl);  // Dessine le cube
                gl.glPopMatrix();  // Restaure la matrice
            }

            deplacerGenerationPointFormeY(gl);  // Décale vers la ligne suivante (vers le bas)
        }
    }


    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU glu = new GLU();
        glu.gluPerspective(45.0, (double) width / height, 1.0, 100.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }
}
