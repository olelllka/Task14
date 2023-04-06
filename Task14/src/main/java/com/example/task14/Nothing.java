package com.example.task14;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

import static com.example.task14.ActionChain.LOSS;
import static com.example.task14.ActionChain.NOTHING;

public class Nothing extends Handler{
    Player player;
    public Nothing(Handler processor, Player player) {
        super(processor);
        this.player = player;
    }
    HelloController hel = new HelloController();
    int temp_value = hel.getPrivateA();
    public boolean process(Integer request) {

        if (request != NOTHING) return super.process(request);// не свой запрос передается дальше по цепочке

        else {//свой, обрабатывается здесь

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Вы sdfasfasfs");

            alert.setHeaderText("НИЧЬЯ");

            player.addNumber(temp_value);

            ButtonType replay = new ButtonType("Продолжить играть", ButtonBar.ButtonData.YES);


            alert.getButtonTypes().clear();

            alert.getButtonTypes().addAll(replay);

            alert.showAndWait();
            return true;
        }

}}
