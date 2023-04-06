package com.example.task14;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public TextField Calculate;




    int a = 3;





    public ImageView view1;
    public ImageView view2;
    public ImageView view3;

    public HBox bags;
    public Label coinsCount;


    //создание объекта
    ActionChain action;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        view1.setImage(new Image("bag1.png"));
        view2.setImage(new Image("bag1.png"));
        view3.setImage(new Image("bag1.png"));

        action = new ActionChain(player1);//запуск механизма розыгрыша



        bags.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            a = Integer.parseInt(Calculate.getText());

            if(action==null) return;//если цепочка обработки отсутствует

            if (init())  action.process();//продолжить играть и проверить наличия монетки у игрока

            //else action=null;//завершить игру, сделав обработку недоступной
    });}

    public Player player1 = new Player("Yoo", 0);
    public void onPay(ActionEvent actionEvent) {


        player1.addNumber(1);

    }

    public boolean init(){
        a = Integer.parseInt(Calculate.getText());

        if(! player1.pay(a)) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setHeaderText("НЕ ХВАТАЕТ МОНЕТ!");

            alert.show();

            return false;

        }

        else return true;

    }
    public int getPrivateA(){
        return a;
    }
    public void MouseHover1(MouseEvent mouseEvent) {
        view1.setImage(new Image("bag_outline1.png"));
    }

    public void MouseOff1(MouseEvent mouseEvent) {
        view1.setImage(new Image("bag1.png"));
    }

     public void MouseHover2(MouseEvent mouseEvent) {
        view2.setImage(new Image("bag_outline1.png"));
    }

    public void MouseOff2(MouseEvent mouseEvent) {
        view2.setImage(new Image("bag1.png"));
    }

    public void MouseHover3(MouseEvent mouseEvent) {
        view3.setImage(new Image("bag_outline1.png"));
    }

    public void MouseOff3(MouseEvent mouseEvent) {
        view3.setImage(new Image("bag1.png"));
    }

    public void statusShow() {
        coinsCount.setText(player1.getNumber().toString());
    }



}