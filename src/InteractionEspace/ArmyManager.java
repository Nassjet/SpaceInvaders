package InteractionEspace;

import Forms3D.Shoot;
import com.jogamp.opengl.GL2;
import Forms3D.EnemySpaceShip;
import java.util.ArrayList;
import java.util.Iterator;

public class ArmyManager {
    private static final int ENEMY_COUNT = 16; // Nombre total de vaisseaux ennemis
    public ArrayList<EnemySpaceShip> enemies; // Liste des vaisseaux ennemis

    public ArmyManager() {
        // Initialiser les vaisseaux ennemis avec des positions différentes
        enemies = new ArrayList<>();
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 8; col++) {
                enemies.add(new EnemySpaceShip(-18.0f + col * 5.0f, 20.0f - row * 5.0f));
            }
        }
    }

    public void display(GL2 gl) {
        // Dessiner et mettre à jour chaque vaisseau
        Iterator<EnemySpaceShip> enemyIterator = enemies.iterator();
        while (enemyIterator.hasNext()) {
            EnemySpaceShip enemy = enemyIterator.next();
            enemy.mouvement();
            enemy.drawingEnemySpaceShip(gl);
        }

        // Gérer les collisions avec les tirs
        Collision.handleCollisions(Shoot.shoots, enemies);
    }


}
