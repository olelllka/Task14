package com.example.task14;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

import static com.example.task14.ActionChain.LOSS;

public class NegativeHandler extends Handler{
    Player player;
    public NegativeHandler(Handler processor, Player player) {
        super(processor);
        this.player = player;
    }

    public boolean process(Integer request) {

        if (request != LOSS) return super.process(request);// не свой запрос передается дальше по цепочке

        else {//свой, обрабатывается здесь

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Вы проиграли!");

            alert.setHeaderText("ПОРАЖЕНИЕ!");


            ButtonType replay = new ButtonType("Продолжить играть", ButtonBar.ButtonData.YES);

            alert.getButtonTypes().clear();

            alert.getButtonTypes().addAll(replay);

            alert.showAndWait();
            return true;

        }
    }}
