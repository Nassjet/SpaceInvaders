package InteractionEspace;

public class MovementsEnemySpaceShip {
    public static float posX = 0.0f;
    public static float posY = 0.0f;
    private static float speedX = 0.004f;
    private static float speedY = 0.01f;

    public static void updatePositionEnemySpaceShip() {
        posX += speedX;

        if (posX >= 3.0f || posX <= -3.0f) {
            speedX = -speedX;
            speedY = 0.01f;
        }

        if (speedY > 0) {
            posY -= speedY;

            if (posY <= -20.0f) {
                posY = 0.0f;
                speedY = 0.0f;
            }
        }

        if (posY <= 2.0f && speedY > 0) {
            speedY *= 0.99f;
        }
    }
}
