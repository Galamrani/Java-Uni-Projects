import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;

public class Controller {

    @FXML
    private Canvas canvas;

    @FXML
    private void generateShapes() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            double x = random.nextDouble() * canvas.getWidth();
            double y = random.nextDouble() * canvas.getHeight();

            double width = random.nextDouble() * canvas.getWidth() / 4;
            double height = random.nextDouble() * canvas.getHeight() / 4;

            if (random.nextBoolean()) {
                gc.setFill(randomColor());
                gc.fillRect(x, y, width, height);
            } else {
                gc.setStroke(randomColor());
                gc.strokeOval(x, y, width, height);
            }
        }
    }

    private Color randomColor() {
        Random random = new Random();
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}
