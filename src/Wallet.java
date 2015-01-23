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
        int index = 0;
        for(int i=0;i< Cards.length;i++){
            if(Cards[i]!=null){
                index++;
            }
        }
        return index;
    }





}
