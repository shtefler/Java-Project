package com.ruhmatoo.ruhmatoo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Peaklass extends Application {
    private GridPane piletiRuut;
    private TextArea tekst;
    private Set<Integer> tõmmatudNumbrid;

    @Override
    public void start(Stage lava) {
        String kasutajanimi = küsiKasutajanimi();
        if (kasutajanimi == null || kasutajanimi.trim().isEmpty()) {
            System.exit(0);  // kui nimi jäetakse tühjaks, siis lõpetatakse programm
        }

        tõmmatudNumbrid = new HashSet<>();

        Button uusPiletNupp = new Button("Genereeri pilet");
        Button tõmbaNupp = new Button("Tõmba number");
        tõmbaNupp.setDisable(true);

        uusPiletNupp.setOnAction(e -> {
            tõmmatudNumbrid.clear();
            tekst.clear();
            piletiRuut.getChildren().clear();
            looPilet();
            tõmbaNupp.setDisable(false);
        });

        tõmbaNupp.setOnAction(e -> {
            int number = tõmbaUnikaalne();
            String silt = vormindaLabel(number);
            tekst.appendText(silt + " ");
            märgiLahter(number);
        });

        piletiRuut = new GridPane();
        piletiRuut.setHgap(10);
        piletiRuut.setVgap(10);
        piletiRuut.setPadding(new Insets(10));

        tekst = new TextArea();
        tekst.setEditable(false);
        tekst.setPrefHeight(200);

        HBox nupud = new HBox(10, uusPiletNupp, tõmbaNupp);
        nupud.setAlignment(Pos.CENTER);

        VBox juur = new VBox(10, nupud, piletiRuut, tekst);
        juur.setPadding(new Insets(15));
        VBox.setVgrow(piletiRuut, Priority.ALWAYS);
        VBox.setVgrow(tekst, Priority.ALWAYS);

        Scene stseen = new Scene(juur, 450, 600);
        lava.setScene(stseen);
        lava.setTitle( "Kasutaja " + kasutajanimi + " pilet");
        lava.show();
    }

    private String küsiKasutajanimi() {
        TextInputDialog dialoog = new TextInputDialog();
        dialoog.setTitle("Kasutajanimi");
        dialoog.setHeaderText("Sisesta oma nimi:");
        dialoog.setContentText("Nimi:");

        return dialoog.showAndWait().orElse(null);
    }

    private void looPilet() {
        String[] päised = { "B", "I", "N", "G", "O" };
        for (int i = 0; i < 5; i++) {
            Label päis = new Label(päised[i]);
            päis.setStyle("-fx-font-weight: bold; -fx-underline: true;");
            piletiRuut.add(päis, i, 0);
        }

        ArrayList<ArrayList<Integer>> pilet = PiletiGenereerija.getPiletiAL();
        for (int rida = 1; rida <= 5; rida++) {
            for (int veerg = 0; veerg < 5; veerg++) {
                Integer arv = pilet.get(veerg).get(rida - 1);
                Label lahter = new Label(arv.toString());
                lahter.setMinSize(50, 50);
                lahter.setAlignment(Pos.CENTER);
                piletiRuut.add(lahter, veerg, rida);
            }
        }
    }

    private int tõmbaUnikaalne() {
        Random juhus = new Random();
        int n;
        do {
            n = juhus.nextInt(75) + 1;
        } while (tõmmatudNumbrid.contains(n));
        tõmmatudNumbrid.add(n);
        return n;
    }

    private String vormindaLabel(int num) {
        if (num < 16) return "B" + num;
        else if (num < 31) return "I" + num;
        else if (num < 46) return "N" + num;
        else if (num < 61) return "G" + num;
        else return "O" + num;
    }

    private void märgiLahter(int num) {
        String tekst = String.valueOf(num);
        for (Node element : piletiRuut.getChildren()) {
            if (element instanceof Label && ((Label) element).getText().equals(tekst)) {
                ((Label) element).setStyle("-fx-background-color: lightgreen; -fx-font-weight: bold;");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
