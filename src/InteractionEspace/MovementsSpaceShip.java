package InteractionEspace;

import Forms3D.Shoot;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementsSpaceShip implements KeyListener {
    public static float posX = 0f;
    public static float speedX = 0.2f;

    // Tableau pour suivre l'état des touches (256 = max keyCode)
    private boolean[] keys = new boolean[256];

    @Override
    public void keyTyped(KeyEvent e) {
        // Non utilisé ici
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Enregistrer la touche pressée
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Marquer la touche comme relâchée
        keys[e.getKeyCode()] = false;
    }

    // Méthode pour mettre à jour la position du vaisseau
    public void update() {
        // Déplacement à gauche
        if (keys[KeyEvent.VK_LEFT] && posX > -20) {
            posX -= speedX;
        }
        // Déplacement à droite
        if (keys[KeyEvent.VK_RIGHT] && posX < 20) {
            posX += speedX;
        }
        // Tir
        if (keys[KeyEvent.VK_SPACE]) {
            float shootStartY = -6.25f;
            Shoot.shootFrom(posX, shootStartY);
            keys[KeyEvent.VK_SPACE] = false; // Empêche de tirer en continu
        }
    }
}
