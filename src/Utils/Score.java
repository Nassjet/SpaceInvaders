package Utils;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.awt.TextRenderer;

import java.awt.*;

public class Score {
    private static int score = 0;
    private TextRenderer textRenderer;

    public void init(GLAutoDrawable drawable) {
        textRenderer = new TextRenderer(new Font("SansSerif", Font.BOLD, 14));
    }
    public void displayScore(GLAutoDrawable drawable) {
        // Affiche les éléments du jeu ici (vaisseaux, tirs, etc.)

        // Afficher le score
        textRenderer.beginRendering(800, 600); // Dimensions de la fenêtre
        textRenderer.setColor(1.0f, 1.0f, 1.0f, 1.0f); // Couleur blanche
        textRenderer.draw("Score: " + Score.getScore(), 10, 550); // Position du texte
        textRenderer.endRendering();
    }
    // Méthode pour augmenter le score
    public static void addScore(int points) {
        score += points;
    }

    // Méthode pour obtenir le score
    public static int getScore() {
        return score;
    }
}
