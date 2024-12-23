package Forms3D;

import com.jogamp.opengl.GL2;

public class PlacementsEnemySpaceShip {
    private static float shift = -10.0f;  // Position de départ pour l'axe X

    public static void deplacerGenerationPointForme(GL2 gl) {
        gl.glTranslatef(shift, 0.0f, 0.0f);  // Déplacer selon l'axe X

        // Augmenter la variable shift pour la prochaine forme
        shift += 2.0f;  // Décalage de 2 unités sur l'axe X pour chaque nouvelle forme
    }


    public static void placerForme() {

    }
}
