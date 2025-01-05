import Forms3D.Shoot;
import Forms3D.SpaceShip;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;
import javax.swing.*;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import InteractionEspace.MovementsSpaceShip;

import static Forms3D.EnemySpaceShip.drawEnemySpaceShip;
import static Forms3D.SpaceShip.drawSpaceShip;
import static InteractionEspace.Placements.*;


public class MainGL implements GLEventListener {
    private MovementsSpaceShip movementSpaceShip = new MovementsSpaceShip();  // Instanciation du mouvement

    public static void main(String[] args) {
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        GLJPanel glPanel = new GLJPanel(capabilities);
        MainGL mainGL = new MainGL();
        glPanel.addGLEventListener(mainGL);

        // Ajout du KeyListener pour capturer les touches clavier
        glPanel.addKeyListener(mainGL.movementSpaceShip);
        glPanel.setFocusable(true);  // Permet au panel de recevoir les événements clavier
        glPanel.requestFocus();

        JFrame frame = new JFrame("Space Invaders");
        frame.setSize(1080, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(glPanel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        FPSAnimator animator = new FPSAnimator(glPanel, 60, true);
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
        movementSpaceShip.update();

        // === Dessin du vaisseau ===
        gl.glPushMatrix();
        gl.glTranslatef(MovementsSpaceShip.posX, 0.0f, 0.0f);
        placerSpaceShip(gl);
        drawSpaceShip(gl);
        gl.glPopMatrix();

        // === Dessiner les tirs ===
        Shoot.drawShoots(gl);

        // === Dessin des ennemis ===
        resetShiftY();
        for (int j = 0; j < 2; j++) {
            resetShiftX();
            for (int i = 0; i < 8; i++) {
                gl.glPushMatrix();
                deplacerGenerationPointFormeX(gl);
                drawEnemySpaceShip(gl);
                gl.glPopMatrix();
            }
            deplacerGenerationPointFormeY(gl);
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
