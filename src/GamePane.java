import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by Dmitriy on 17.02.2016.
 */
public class GamePane {
    private Pane gamePane;
    private Label tour1Label;
    private Label tour2Label;
    private Label tour3Label;
    private Label superGameLabel;
    private Label backLabel;
    private Scene gameScene;
    private ImageView gameBackground;

    public GamePane() {
        gameBackground = new ImageView(new Image(Main.getPathToResource("images/play.jpg")));
        gameBackground.setFitHeight(Main.SCREEN_SIZE.getHeight());//подгон под высоту
        gameBackground.setFitWidth(Main.SCREEN_SIZE.getWidth());//подгон под ширину
        gameBackground.setSmooth(true);//сглаживание

        gamePane = new Pane();

        tour1Label = new Label("1 тур");
        tour1Label.setCursor(Cursor.HAND);
        tour1Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.03);
        tour1Label.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.1);
        tour1Label.setId("gamePaneLabel");

        tour2Label = new Label("2 тур");
        tour2Label.setCursor(Cursor.HAND);
        tour2Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.03);
        tour2Label.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.2);
        tour2Label.setId("gamePaneLabel");

        tour3Label = new Label("3 тур");
        tour3Label.setCursor(Cursor.HAND);
        tour3Label.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.03);
        tour3Label.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.3);
        tour3Label.setId("gamePaneLabel");

        superGameLabel = new Label("Супер-игра");
        superGameLabel.setCursor(Cursor.HAND);
        superGameLabel.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.03);
        superGameLabel.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.4);
        superGameLabel.setId("gamePaneLabel");

        backLabel = new Label("Назад");
        backLabel.setCursor(Cursor.HAND);
        backLabel.setLayoutX(Main.SCREEN_SIZE.getWidth() * 0.03);
        backLabel.setLayoutY(Main.SCREEN_SIZE.getHeight() * 0.5);
        backLabel.setId("gamePaneLabel");

        gameScene = new Scene(gamePane, Main.SCREEN_SIZE.getWidth(), Main.SCREEN_SIZE.getHeight());
        gameScene.getStylesheets().add(Main.getPathToResource("css/style.css"));
        gamePane.getChildren().addAll(gameBackground, tour1Label, tour2Label, tour3Label, superGameLabel, backLabel);
    }

    public Label getTour1Label() {
        return tour1Label;
    }

    public Label getTour2Label() {
        return tour2Label;
    }

    public Label getTour3Label() {
        return tour3Label;
    }

    public Label getSuperGameLabel() {
        return superGameLabel;
    }

    public Label getBackLabel() {
        return backLabel;
    }

    public Scene getGameScene() {
        return gameScene;
    }

}
