import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class ScrabbleButton extends Button {

    private final String STYLE_BUTTON_HOVER = "-fx-background-color: blue;";
    private final String STYLE_BUTTON_NORMAL = "-fx-background-color: pink; -fx-font: 15 arial; -fx-font-color: white ";

    public ScrabbleButton(String text)
    {
        setText(text);
        setFontStyle();
        setPrefHeight(49);
        setPrefWidth(170);
        setStyle(STYLE_BUTTON_NORMAL);
        ButtonListenersInit();
    }

    private void setFontStyle() {
        setFont(Font.font("Verdana", 15));
    }

    private void setHoverStyle() {
        setStyle(STYLE_BUTTON_HOVER);
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 5);
        setLayoutX(getLayoutX() - 5);
        setEffect(new DropShadow());
    }

    private void setButtonPressedStyle(){
        setStyle(STYLE_BUTTON_HOVER);
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4);
    }


    private void setButtonReleasedStyle()
    {
        setStyle(STYLE_BUTTON_NORMAL);
        setPrefHeight(45);
        setLayoutY(getLayoutY() - 5);
        setLayoutX(getLayoutX() - 5);
        setEffect(null);
    }

    private void ButtonListenersInit(){

        setOnMousePressed(new EventHandler<MouseEvent>(){
    @Override
        public void handle(MouseEvent event){
        if(event.getButton().equals(MouseButton.PRIMARY)){
            setButtonPressedStyle();
        }
        }
    });


        setOnMouseReleased(new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
            if(event.getButton().equals(MouseButton.PRIMARY)){
                setButtonReleasedStyle();
            }
        }
    });


        setOnMouseEntered(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                setEffect(new DropShadow());
            }
        });


        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                setEffect(null);
            }
        });
    }
}

