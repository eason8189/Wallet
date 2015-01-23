import java.util.Scanner;

/** COMP249 Assignment 1
 *  Wallet Class
 *  Yang Shen (7159390)
 */

public class Wallet {
    private Coins Coins;
    private Card [] Cards;

    public Wallet(){
        Coins = new Coins();
        Cards = new Card[10];
    }

    public Wallet(Coins coins, Card[] cards) {
        this.Coins = coins;
        this.Cards = cards;
    }

    public boolean equalsCoinsValue(Wallet o) {
        if (this == o) return true;
        if (!(o instanceof Wallet)) return false;

        Wallet wallet = (Wallet) o;

        if (Coins.getCoinsTotal() != 0 ? Coins.getCoinsTotal() != wallet.Coins.getCoinsTotal() : wallet.Coins != null)
            return false;

        else
            return true;
    }

    public boolean equalsCoinsType(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wallet)) return false;

        Wallet wallet = (Wallet) o;

        if (Coins.getNumOfNickels() != wallet.Coins.getNumOfNickels()
                || Coins.getNumOfDimes() != wallet.Coins.getNumOfDimes()
                || Coins.getNumOfLoonies() != wallet.Coins.getNumOfLoonies()
                ||Coins.getNumOfToonies() != wallet.Coins.getNumOfToonies())
            return false;

        else
            return true;
    }

    public double getTotalCoinsValue(Wallet wallet){
        return wallet.Coins.coinsTotal();
    }

    public int getTotalNumOfCreditCard(Wallet wallet){
        int numOfCreditCard = 0;
        for(int i=0;i< Cards.length;i++){
            if(Cards[i]!=null){
                numOfCreditCard++;
            }
        }
        return numOfCreditCard;
    }

    public String addCreditCard(CreditCardType creditCardType, String cardHolder, int expiryMonth, int expiryYear){
        Scanner kb = new Scanner(System.in);
        creditCardType =

        for(int i=0; i<Cards.length; i++){
            while(Cards[i] == null);
                Cards [i] = new Card();
            break;
        }

        return "There are "+Cards.length+1 +" credit card in this wallet now.";
    }

    public void removeCreditCard(){


    }

}
