package InteractionEspace;

import Forms3D.EnemySpaceShip;
import Forms3D.Shoot;
import Utils.Score;

import java.util.ArrayList;
import java.util.Iterator;

public class Collision {
    /**
     * Gère les collisions entre les tirs actifs et les ennemis.
     *
     * @param shoots  Liste des tirs actifs.
     * @param enemies Liste des ennemis actifs.
     */
    public static void handleCollisions(ArrayList<Shoot> shoots, ArrayList<EnemySpaceShip> enemies) {
        // Parcourir les tirs actifs
        Iterator<Shoot> shootIterator = shoots.iterator();
        while (shootIterator.hasNext()) {
            Shoot shoot = shootIterator.next();
            boolean hit = false;

            // Parcourir les ennemis pour détecter les collisions
            Iterator<EnemySpaceShip> enemyIterator = enemies.iterator();
            while (enemyIterator.hasNext()) {
                EnemySpaceShip enemy = enemyIterator.next();

                // Vérifier si le tir touche l'ennemi
                if (isColliding(shoot, enemy)) {
                    enemyIterator.remove();
                    hit = true;
                    Score.addScore(100);
                    break; // Un tir ne peut toucher qu'un seul ennemi
                }
            }

            // Si un tir a touché un ennemi, on le retire de la liste des tirs
            if (hit) {
                shootIterator.remove();
            }
        }
    }

    /**
     * Vérifie si un tir et un ennemi sont en collision.
     *
     * @param shoot Le tir à vérifier.
     * @param enemy Le vaisseau ennemi à vérifier.
     * @return true si le tir touche l'ennemi, false sinon.
     */
    private static boolean isColliding(Shoot shoot, EnemySpaceShip enemy) {
        // Exemple de détection basique : comparer les positions
        float shootX = shoot.getPosX();
        float shootY = shoot.getPosY();
        float enemyX = enemy.getPosX();
        float enemyY = enemy.getPosY();

        // Approximation de la hitbox (tu peux ajuster la taille selon tes besoins)
        float hitboxSize = 1.5f; // Taille approximative
        return Math.abs(shootX - enemyX) < hitboxSize && Math.abs(shootY - enemyY) < hitboxSize;
    }
}
