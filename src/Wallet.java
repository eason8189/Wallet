import java.util.Arrays;

/** @author Yang Shen
 */


    //Attributes of Wallet, contains Coins class and an array of Cards.
public class Wallet {
    public Coins Coins;
    public CreditCard [] Cards;


    //Default Constructor
    public Wallet(){
        Coins = null;
        Cards = null;
    }


    //Parametrized Constructor
    public Wallet(Coins coins, CreditCard[] cards) {
        this.Coins = new Coins(coins);
        this.Cards = cards;
    }


    /**
     * This method compares if to Wallet's Coins' value are equal.
     * @return true if both class are equal, false otherwise.
     */
    public boolean equalsCoinsValue(Wallet w)
    {
        return (Coins.coinsTotal() == w.Coins.coinsTotal());
    }

    /**
     * This method compares if to Wallet's Coins' type are equal.
     * @return true if both class are equal, false otherwise.
     */
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


    /**
     * This method access the total value of a coin class.
     * @return the coin class' total.
     */
    public double getTotalCoinsValue(){
        return Coins.coinsTotal();
    }

    /**
     * This method access the total number of a credit card stored.
     * @return the total number of credit card.
     */
    public int getTotalNumOfCreditCard(){
        int numOfCreditCard = 0;
        for(int i=0;i< Cards.length;i++){
            if(Cards[i]!=null){
                numOfCreditCard++;
            }
        }
        return numOfCreditCard;
    }

    /**
     * This method adds a new credit card to the credit card array created.
     * By doing so, a temperate array that has extra memory location is created for store the new credit card.
     * @param newCard the new credit card to be added.
     */
    public void addCreditCard(CreditCard newCard) {
        if (this.getTotalNumOfCreditCard() == 0) {
            int i = 1;
            CreditCard[] temp = new CreditCard[i];
            temp[0] = new CreditCard(newCard);
            this.Cards = temp;

        } else {
            CreditCard[] temp = new CreditCard[this.getTotalNumOfCreditCard() + 1];

            for (int i = 0; i < Cards.length; i++)
                temp[i] = new CreditCard(Cards[i]);
            temp[this.getTotalNumOfCreditCard()] = new CreditCard(newCard);
            this.Cards = temp;
        }
    }

    /**
     * This method remove a existing credit card from a credit card array.
     * By doing so, a temperate array that has one less memory location is created for copy the remaining credit card.
     * @param index the credit card index to be deleted..
     */
    public boolean removeCreditCard(int index){

            if (Cards.length == 0)// If a wallet has no credit, it makes no sense to delete one.
                return false;
            else
            {
                CreditCard [] temp = new CreditCard [Cards.length - 1];

                for (int i = 0; i < index; i++)
                    temp[i] = new CreditCard(Cards[i]);

                for (int i = index+1; i < Cards.length;i++)
                    temp[i-1] =  new CreditCard(Cards[i]);
                this.Cards = temp;

                return true;
            }

        }
    /**
     * This method sets the new expiry month and year for a credit card.
     * @param index,m,y are the credit card index, new month, and new year, respectively.
     */
    public void updateMonthandYear(int index, int m, int y){

            Cards[index].setExpiryMonth(m);
            Cards[index].setExpiryYear(y);

    }

    /**
     * This method add the new coins to an existing wallet.
     * @param nickel,dime,quarter,loonie,toonie, are nickel,dime,quarter,loonie,and toonie respectively.
     */
    public double addCoinsToWallet(int nickel, int dime, int quarter, int loonie, int toonie){
        Coins.addCoins(nickel, dime, quarter, loonie, toonie);
        return Coins.coinsTotal();
    }

    /**
     * This method compares to wallet object.
     * @return true if both objects are equal, false otherwise.
     */
    public boolean equals(Wallet o) {
        if (this == o) return true;
        if (!(o instanceof Wallet)) return false;

        Wallet wallet = (Wallet) o;

        if (!Arrays.equals(Cards, wallet.Cards)) return false;
        if (Coins.coinsTotal() != wallet.Coins.coinsTotal()) return false;

        return true;
    }

    /**
     * This method lists the detail of coins' value and credit card of a wallet object.
     * @return a list of detail.
     */
    public String toString() {
        return "Wallet Detail:\n" +
                "Coins' Value:\n" + Coins.toString() +
                "\nCredit Cards:\n" + Arrays.toString(Cards);
    }

    /**
     * A method which will return a string with just the breakdown of the coins.
     * @return the break down of the coins.
     */
    public String coinsDetail()
    {
        return Coins.toString();
    }
}
