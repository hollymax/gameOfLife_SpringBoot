package eu.trans.gameoflife.gameOfLife.controller;

import eu.trans.gameoflife.gameOfLife.Tablica;
import eu.trans.gameoflife.gameOfLife.service.GamesOfLife_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GamesOfLife_Controller<drawBoard> {
    GamesOfLife_Service gamesOfLifeService = new GamesOfLife_Service();

    int szerokosc = 5;
    int wysokosc = 5;

    int[][] plansza = {{0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
    };
//    @Autowired
//    private Tablica Tablica;

    @GetMapping("/game")
    public void drawBoard() {
        GamesOfLife_Service.drawBoard(plansza,szerokosc,wysokosc,"msg");
    }
}
