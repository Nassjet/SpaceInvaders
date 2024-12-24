package InteractionEspace;

import com.jogamp.opengl.GL2;

public class Placements {
    private static float shiftX = 0.0f;
    private static float shiftY = 0.0f;

    // Décale le point de génération horizontalement
    public static void deplacerGenerationPointFormeX(GL2 gl) {
        gl.glTranslatef(shiftX, shiftY, 0.0f);  // Applique le décalage X et Y
        shiftX += 5.0f;  // Prépare le décalage pour la prochaine forme
    }

    // Décale verticalement pour une nouvelle ligne
    public static void deplacerGenerationPointFormeY(GL2 gl) {
        shiftY -= 5.0f;  // Décalage vers le bas (négatif en Y)
        shiftX = 0.0f;   // Réinitialise la position horizontale
    }

    // Place la caméra
    public static void placerCamera(GL2 gl) {
        gl.glTranslatef(0.0f, -5.0f, -40.0f);  // Caméra reculée
    }

    // Remet à zéro les décalages
    public static void resetShiftX() {
        shiftX = -20.0f;
    }

    public static void resetShiftY() {
        shiftY = 20.0f;  // Place la première ligne au niveau Y = 20
    }
}
