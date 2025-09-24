import java.util.Arrays;

public class Spieler {
    private String name;

    //erster Wert: Spiele insgesamt in dem Spiel
    //zweiter Wert: Spiele gewonnen
    //dritter Wert: Spiele unentschieden
    private int[] statistikSchiffeVersenken;
    private int[] statistikTicTacToe;
    private int[] statistik4Gewinnt;

    public Spieler(){
        name = "kkkk";
    }

    public Spieler(String name) {
        setName(name);
        this.statistikSchiffeVersenken = new int[3];
        this.statistikTicTacToe = new int[3];
        this.statistik4Gewinnt = new int[3];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isBlank()) {
            System.out.println("Bitte Name eingeben");
        } else {
            this.name = name;
        }
    }

    public int[] getStatistikSchiffeVersenken() {
        return statistikSchiffeVersenken;
    }

    public void setStatistikSchiffeVersenken(int[] statistikSchiffeVersenken) {
        this.statistikSchiffeVersenken = statistikSchiffeVersenken;
    }

    public int[] getStatistikTicTacToe() {
        return statistikTicTacToe;
    }

    public void setStatistikTicTacToe(int[] statistikTicTacToe) {
        this.statistikTicTacToe = statistikTicTacToe;
    }

    public int[] getStatistik4Gewinnt() {
        return statistik4Gewinnt;
    }

    public void setStatistik4Gewinnt(int[] statistik4Gewinnt) {
        this.statistik4Gewinnt = statistik4Gewinnt;
    }

    @Override
    public String toString() {
        return  "Name = '" + name + '\'' +
                ", Statistik Schiffe versenken =" + Arrays.toString(statistikSchiffeVersenken) +
                ", Statistik Tic Tac Toe =" + Arrays.toString(statistikTicTacToe) +
                ", Statistik 4 Gewinnt =" + Arrays.toString(statistik4Gewinnt) + "\n";
    }

    public void ticTacToeGewonnen(){
        if (statistikTicTacToe == null){
            statistikTicTacToe = new int[3];
        }
        statistikTicTacToe[0]++;// Spiele gespielt
        statistikTicTacToe[1]++;// Spiele gewonnen
    }

    public void ticTacToeVerloren(){
        if (statistikTicTacToe == null){
            statistikTicTacToe = new int[3];
        }
        statistikTicTacToe[0]++;// Spiele gespielt
    }

    public void ticTacToeUnentschieden(){
        if (statistikTicTacToe == null){
            statistikTicTacToe = new int[3];
        }
        statistikTicTacToe[0]++;// Spiele gespielt
        statistikTicTacToe[2]++;// Unentschieden
    }

    public void vierGewinntGewonnen() {
        if (statistik4Gewinnt == null) {
            statistik4Gewinnt = new int[3];
        }
        statistik4Gewinnt[0]++;
        statistik4Gewinnt[1]++;
    }
    public void vierGewinntVerloren(){
        if (statistikTicTacToe == null){
            statistikTicTacToe = new int[3];
        }
        statistikTicTacToe[0]++;// Spiele gespielt
    }

    public void vierGewinntUnentschieden(){
        if (statistikTicTacToe == null){
            statistikTicTacToe = new int[3];
        }
        statistikTicTacToe[0]++;// Spiele gespielt
        statistikTicTacToe[2]++;// Unentschieden
    }

    public void schiffeVersenkenGewonnen() {
        if (statistikSchiffeVersenken == null) {
            statistikSchiffeVersenken = new int[3];
        }
        statistikSchiffeVersenken[0]++;
        statistikSchiffeVersenken[1]++;
    }

    public void schiffeVersenkenVerloren(){
        if (statistikTicTacToe == null){
            statistikTicTacToe = new int[3];
        }
        statistikTicTacToe[0]++;// Spiele gespielt
    }





}
