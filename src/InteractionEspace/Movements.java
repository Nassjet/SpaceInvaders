package InteractionEspace;

public class Movements {
    public static float posX = 0.0f;
    public static float posY = 0.0f;
    private static float speedX = 0.005f;
    private static float speedY = 0.01f;
    public static void updatePosition() {
        posX += speedX;

        // Mouvement en zigzag avec descente progressive
        if (posX >= 5.0f || posX <= -5.0f) {
            speedX = -speedX;  // Inversion horizontale
            speedY = 0.01f;    // Déclenchement de la descente progressive
        }

        // Descente progressive
        if (speedY > 0) {
            posY -= speedY;

            // Réduction de speedY pour ralentir progressivement
            if (posY <= -20.0f) {
                posY = 0.0f;  // Réinitialisation du haut
                speedY = 0.0f;
            }
        }

        // Réduit speedY après chaque "rebond" vertical pour lisser la descente
        if (posY <= 2.0f && speedY > 0) {
            speedY *= 0.99f;  // Ralentissement progressif
        }
    }
}
