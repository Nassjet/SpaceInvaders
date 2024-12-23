import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.awt.GLJPanel;
import javax.swing.JFrame;

public class MainGL implements GLEventListener {
    public static void main(String[] args) {
        // Configuration du profil OpenGL
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // Création du panneau OpenGL
        GLJPanel glPanel = new GLJPanel(capabilities);
        glPanel.addGLEventListener(new MainGL());

        // Configuration de la fenêtre
        JFrame frame = new JFrame("JOGL Test");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(glPanel);
        frame.setVisible(true);
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        // Efface l'écran
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        // Commence le dessin
        gl.glBegin(GL2.GL_TRIANGLES);

        // Définit les couleurs et les sommets du triangle
        gl.glColor3f(1.0f, 0.0f, 0.0f);  // Rouge
        gl.glVertex2f(-0.5f, -0.5f);

        gl.glColor3f(0.0f, 1.0f, 0.0f);  // Vert
        gl.glVertex2f(0.5f, -0.5f);

        gl.glColor3f(0.0f, 0.0f, 1.0f);  // Bleu
        gl.glVertex2f(0.0f, 0.5f);

        // Fin du dessin
        gl.glEnd();

        // Force l'exécution des commandes OpenGL
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glViewport(0, 0, width, height);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        // Méthode de nettoyage si nécessaire
    }
}