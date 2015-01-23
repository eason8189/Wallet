import java.util.Arrays;

/** COMP249 Assignment 1
 *  Wallet Class
 *  Yang Shen (7159390)
 */

public class Wallet {
    private Coins Coins;
    private Card [] Cards;

    public Wallet(){
        Coins = null;
        Cards = null;
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

    public int getTotalNumOfCreditCard(){
        int numOfCreditCard = 0;
        for(int i=0;i< Cards.length;i++){
            if(Cards[i]!=null){
                numOfCreditCard++;
            }
        }
        return numOfCreditCard;
    }

    public void addCreditCard(Card newCard) {
        if (this.getTotalNumOfCreditCard() == 0) {
            int i = 1;
            Card[] temp = new Card[1];
            temp[0] = new Card(newCard);
            this.Cards = temp;

        } else {
            Card[] temp = new Card[this.getTotalNumOfCreditCard() + 1];

            for (int i = 0; i < Cards.length; i++)
                temp[i] = new Card(Cards[i]);
            temp[this.getTotalNumOfCreditCard()] = new Card(newCard);
            this.Cards = temp;
        }
    }

    public boolean removeCreditCard(int index){

            if (Cards.length == 0)// If a wallet has no credit, it makes no sense to delete one.
                return false;
            else
            {
                Card [] temp = new Card [Cards.length - 1];

                for (int i = 0; i < index; i++)
                    temp[i] = new Card(Cards[i]);

                int indexPlus = index+1;
                for (int i = indexPlus; i < temp.length;indexPlus++)
                    temp[i-1] =  new Card(Cards[i]);
                this.Cards = temp;

                return true;
            }

        }

    public void updateMonthandYear(int index, int m, int y){

            Cards[index].setExpiryMonth(m);
            Cards[index].setExpiryYear(y);

    }

    public double addCoinsToWallet(int nickel, int dime, int quarter, int loonie, int toonie){
        Coins.addCoins(nickel, dime, quarter, loonie, toonie);
        return Coins.coinsTotal();
    }

    public boolean equals(Wallet o) {
        if (this == o) return true;
        if (!(o instanceof Wallet)) return false;

        Wallet wallet = (Wallet) o;

        if (!Arrays.equals(Cards, wallet.Cards)) return false;
        if (Coins.coinsTotal() != wallet.Coins.coinsTotal()) return false;

        return true;
    }

    public String toString() {
        return "Wallet Detail:\n" +
                "Coins' Value:\n" + Coins.toString() +
                "\nCredit Cards:\n" + Arrays.toString(Cards);
    }

    public String coinsDetail()
    {
        return Coins.toString();
    }
}
