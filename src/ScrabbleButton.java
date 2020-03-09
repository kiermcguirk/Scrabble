import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.text.Font;

public class ScrabbleButton extends Button {

    private final String STYLE_BUTTON_HOVER = "-fx-background-color: blue;";
    private final String STYLE_BUTTON_NORMAL = "-fx-background-color: green;";

    public ScrabbleButton(String text) {
        setText(text);
        setFontStyle();
        setPrefHeight(49);
        setPrefWidth(170);
        setStyle(STYLE_BUTTON_NORMAL);
    }

    private void setFontStyle() {
        setFont(Font.font("arial", 10));
    }

    private void setHoverStyle() {
        setStyle(STYLE_BUTTON_HOVER);
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 5);
        setLayoutX(getLayoutX() - 5);
        setEffect(new DropShadow());
    }

    private void setButtonReleasedStyle()
    {
        setStyle(STYLE_BUTTON_NORMAL);
        setPrefHeight(45);
        setLayoutY(getLayoutY() - 5);
        setLayoutX(getLayoutX() - 5);
        setEffect(null);
    }

    private void ButtonListenersInit()
    {

    }


}

