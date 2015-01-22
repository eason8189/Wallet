/** COMP249 Assignment 1
 *  Wallet Class
 *  Yang Shen (7159390)
 */

public class Wallet {
    private Coins Coins;
    private Cards [] Cards;

    public Wallet(){
        Coins = new Coins();
        Cards = new Cards[10];
    }

    public Wallet(Coins coins, Cards[] cards) {
        this.Coins = coins;
        this.Cards = cards;
    }
}
