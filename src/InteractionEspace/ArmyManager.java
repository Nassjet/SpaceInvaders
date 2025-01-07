package InteractionEspace;
import com.jogamp.opengl.*;
import javax.swing.*;

import Forms3D.EnemySpaceShip;

public class ArmyManager {
    private static final int ENEMY_COUNT = 16; // Nombre total de vaisseaux ennemis
    private EnemySpaceShip[] enemies; // Tableau pour stocker les vaisseaux
    public ArmyManager() {
        // Initialiser les vaisseaux ennemis avec des positions différentes
        enemies = new EnemySpaceShip[ENEMY_COUNT];
        int index = 0;
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 8; col++) {
                enemies[index++] = new EnemySpaceShip(-18.0f + col * 5.0f, 20.0f - row * 5.0f);
            }
        }
    }
    public void display(GL2 gl) {
        // Dessiner et mettre à jour chaque vaisseau
        for (EnemySpaceShip enemy : enemies) {
            enemy.mouvement();
            enemy.drawingEnemySpaceShip(gl); // Dessine le vaisseau
        }
    }
}
