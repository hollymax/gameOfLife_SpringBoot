package eu.trans.gameoflife.gameOfLife.service;

import org.springframework.stereotype.Service;

@Service
public class GamesOfLife_Service {


    private static void drawBoard(int[][] plansza, int szerokosc, int wysokosc, String msg) {
        System.out.println(msg);
        for (int i = 0; i < szerokosc; i++)
        {
            for (int j = 0; j < wysokosc; j++)
            {
                if (plansza[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }

    }
    static void kolejnaGeneracja(int[][] plansza, int szerokosc, int wysokosc) {


        int[][] przygotowanieSymulacji = przygotowanieSymulacji(plansza, szerokosc, wysokosc);


        for (int h = 0; h < 10; h++){
            int [][] seria = kolejnaGeneracjaInt(kolejnaGeneracjaInt(przygotowanieSymulacji,szerokosc,wysokosc),szerokosc,wysokosc);
        }

    }
    static int [][] przygotowanieSymulacji(int[][] plansza,int szerokosc, int wysokosc) {
        int [][] symulacja = new int[szerokosc][wysokosc];

        for (int l = 1; l < szerokosc - 1; l++) {
            for (int m = 1; m < wysokosc - 1; m++) {

                int zyjacysasiad = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        zyjacysasiad += plansza[l + i][m + j];
                zyjacysasiad -= plansza[l][m];

                if ((plansza[l][m] == 1) &&(zyjacysasiad <2))
                    symulacja[l][m]=0;
                else if ((plansza[l][m] == 1) && (zyjacysasiad >3))
                    symulacja[l][m] = 0;
                else if ((plansza[l][m] == 0) && (zyjacysasiad == 3))
                    symulacja[l][m] = 1;
                else symulacja[l][m] = plansza [l][m];
            }
        }
        return symulacja;

    }

    int [][] kolejnaGeneracjaInt(int[][] plansza, int szerokosc, int wysokosc) {
        int[][] przygotowanieSymulacji = przygotowanieSymulacji(plansza, szerokosc, wysokosc);


        drawBoard(plansza, szerokosc, wysokosc, "Kolejna generacja");
        return przygotowanieSymulacji;


    }

    public static void showBoard(int[][] plansza, int szerokosc, int wysokosc, String msg) {
    }
}

