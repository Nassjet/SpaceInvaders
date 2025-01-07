package InteractionEspace;

import Forms3D.EnemySpaceShip;
import Forms3D.Shoot;
public class Collision {

    public boolean checkCollision(Shoot projectile, EnemySpaceShip target) {
        // Calcul de la distance entre le projectile et la cible
        float dx = projectile.getPosX() - target.getPosX();
        float dy = projectile.getPosY() - target.getPosY();
        float dz = projectile.getPosZ() - target.getPosZ();
        float distance = (float) Math.sqrt(dx * dx + dy * dy + dz * dz);

        // Définir une distance minimale de collision
        float collisionThreshold = 0.2f;

        // Si la distance est inférieure à la distance de collision, il y a collision
        return distance < collisionThreshold;
    }
}
