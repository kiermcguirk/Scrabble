import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class layoutManager {

    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    public layoutManager()
    {
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane,800,800);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createButton("Kier is the big sad  :(");
    }

    public void createButton(String text)
    {
        ScrabbleButton button  = new ScrabbleButton(text);
        mainPane.getChildren().add(button);
    }

    public Stage getStage(){
        return mainStage;
    }

    public AnchorPane getMainPane()
    {
        return mainPane;
    }



}
