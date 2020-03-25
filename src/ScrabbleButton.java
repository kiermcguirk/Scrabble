import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
public class ScrabbleButton extends Button {

    //Setting the different button styles
    private final String STYLE_BUTTON_HOVER = "-fx-cursor: hand;-fx-background-color: \n" + "black,\n" + "linear-gradient(#5cb811 0%, #268a16 20%, #268a16 100%),\n" + "linear-gradient(#5cb811, #268a16)," + "radial-gradient(center 50% 0%, radius 100%, rgba(189, 230, 181, 1), rgba(255,255,255,0));\n" + "-fx-background-radius:6px;\n" + "-fx-background-insets: 0,1,2,0;\n" + "-fx-text-fill: black;\n" + "-fx-effect: dropshadow( three-pass-box , black , 5, 0.0 , 0 , 1 );\n" + "-fx-font-family: \"Arial\";\n" + "-fx-text-fill: linear-gradient(black, #303108);\n" + "-fx-font-size: 12px;\n" + "-fx-padding: 6px 9px";
    private final String STYLE_BUTTON_NORMAL = "-fx-cursor: pointer; -fx-background-color: \n" + "#77d42a,\n" + "linear-gradient(#5cb811 0%, #268a16 20%, #268a16 100%),\n" + "linear-gradient(#5cb811, #268a16)," + "radial-gradient(center 50% 0%, radius 100%, rgba(189, 230, 181, 1), rgba(255,255,255,0));\n" + "-fx-background-radius:6px;\n" + "-fx-background-insets: 0,1,2,0;\n" + "-fx-text-fill: black;\n" + "-fx-effect: dropshadow( three-pass-box , black , 5, 0.0 , 0 , 1 );\n" + "-fx-font-family: \"Arial\";\n" + "-fx-text-fill: linear-gradient(black, #303108);\n" + "-fx-font-size: 12px;\n" + "-fx-padding: 6px 9px;";
    private final String STYLE_BUTTON_PRESSED = "-fx-scale-y: 0.9;\n" + "-fx-scale-x: 0.9;" +  "-fx-cursor: hand;-fx-background-color: \n" + "black,\n" + "linear-gradient(#5cb811 0%, #268a16 20%, #268a16 100%),\n" + "linear-gradient(#5cb811, #268a16)," + "radial-gradient(center 50% 0%, radius 100%, rgba(189, 230, 181, 1), rgba(255,255,255,0));\n" + "-fx-background-radius:6px;\n" + "-fx-background-insets: 0,1,2,0;\n" + "-fx-text-fill: black;\n" + "-fx-effect: dropshadow( three-pass-box , black , 5, 0.0 , 0 , 1 );\n" + "-fx-font-family: \"Arial\";\n" + "-fx-text-fill: linear-gradient(black, #303108);\n" + "-fx-font-size: 13px;\n" + "-fx-padding: 6px 9px";

    //Applying characteristics to the buttons
    public ScrabbleButton(String text)
    {
        setText(text);
        setFontStyle();
        setPrefHeight(45);
        setPrefWidth(80);
        setStyle(STYLE_BUTTON_NORMAL);
        ButtonListenersInit();
    }

    //Function for font
    private void setFontStyle() {
        setFont(Font.font("Verdana", 12));
    }

    //Function for hover style
    private void setHoverStyle() {
        setStyle(STYLE_BUTTON_HOVER);
        setCursor(Cursor.HAND);
        setPrefHeight(45);
    }

    //Function to change style of button once pressed
    private void setButtonPressedStyle(){
        setStyle(STYLE_BUTTON_PRESSED);
        setPrefHeight(45);

    }



    //Function of style of released button
    private void setButtonReleasedStyle()
    {
        setStyle(STYLE_BUTTON_NORMAL);
        setPrefHeight(45);
        setEffect(null);
    }

    //Setting characteristics to button
    private void ButtonListenersInit(){

        DropShadow rollOverColor = new DropShadow();
        rollOverColor.setColor(Color.ORANGERED);
        DropShadow clickColor = new DropShadow();
        clickColor.setColor(Color.DARKBLUE);


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
                setHoverStyle();
            }
        });


        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                setButtonReleasedStyle();
            }
        });
    }
}

