/** @author Yang Shen
 */


    //Attributes
public class Coins {
    private int numOfNickels;
    private int numOfDimes;
    private int numOfQuarters;
    private int numOfLoonies;
    private int numOfToonies;
    private static double coinsTotal=0;

    //Default Constructor
    public Coins(){
        numOfNickels = 0;
        numOfDimes = 0;
        numOfQuarters =0;
        numOfLoonies = 0;
        numOfToonies = 0;
    }


    //Parametrized Constructor
    public Coins(int n, int d, int q, int l,int t){
        numOfNickels = n;
        numOfDimes = d;
        numOfQuarters = q;
        numOfLoonies = l;
        numOfToonies = t;
    }


    //Copy Constructor
    public Coins(Coins CopiedCoins){
        numOfLoonies = CopiedCoins.numOfLoonies;
        numOfToonies = CopiedCoins.numOfToonies;
        numOfQuarters = CopiedCoins.numOfQuarters;
        numOfDimes = CopiedCoins.numOfDimes;
        numOfNickels = CopiedCoins.numOfNickels;
    }


    //Accessor
    /**
     * This method access the number of nickels within coins.
     * @return The number of nickels
     */
    public int getNumOfNickels() {
        return numOfNickels;
    }

    /**
     * This method access the number of dimes within coins.
     * @return The number of dimes
     */
    public int getNumOfDimes() {
        return numOfDimes;
    }

    /**
     * This method access the number of quarters within coins.
     * @return The number of quarters
     */
    public int getNumOfQuarters() {
        return numOfQuarters;
    }

    /**
     * This method access the number of loonies within coins.
     * @return The number of loonies
     */
    public int getNumOfLoonies() {
        return numOfLoonies;
    }

    /**
     * This method access the number of toonies within coins.
     * @return The number of toonies
     */
    public int getNumOfToonies() {
        return numOfToonies;
    }

    /**
     * This method access the total value of coins.
     * @return The total value of all coins.
     */
    public static double getCoinsTotal() {
        return coinsTotal;
    }


    //Mutator
    /**
     * This method set the number of nickels.
     * @param numOfNickels the number of nickels to be set.
     */
    public void setNumOfNickels(int numOfNickels) {
        this.numOfNickels = numOfNickels;
    }

    /**
     * This method set the number of dimes.
     * @param numOfDimes the number of dimes to be set.
     */
    public void setNumOfDimes(int numOfDimes) {
        this.numOfDimes = numOfDimes;
    }

    /**
     * This method set the number of quarters.
     * @param numOfQuarters the number of quarters to be set.
     */
    public void setNumOfQuarters(int numOfQuarters) {
        this.numOfQuarters = numOfQuarters;
    }

    /**
     * This method set the number of Loonies.
     * @param numOfLoonies the number of loonies to be set.
     */
    public void setNumOfLoonies(int numOfLoonies) {
        this.numOfLoonies = numOfLoonies;
    }

    /**
     * This method set the number of Toonies.
     * @param numOfToonies the number of toonies to be set.
     */
    public void setNumOfToonies(int numOfToonies) {
        this.numOfToonies = numOfToonies;
    }

    /**
     * This method set the number of Coins.
     * @param coinsTotal the number of coins to be set.
     */
    public static void setCoinsTotal(double coinsTotal) {
        Coins.coinsTotal = coinsTotal;
    }


    //Methods:
    /**
     * This method add the desire coins to the class.
     * @param addN,addQ,addL,addT the number of nickels,dimes,quarters,loonies,and toonies to be set.
     */
    public void addCoins(int addN, int addD, int addQ, int addL,int addT){
        numOfNickels = numOfNickels + addN;
        numOfDimes = numOfDimes + addD;
        numOfQuarters = numOfQuarters + addQ;
        numOfLoonies = numOfLoonies + addL;
        numOfToonies = numOfToonies + addT;
    }


    /**
     * This method calculates the total value of all coins, by multiplying to their own value.
     * @return The total value of coins.
     */
    public double coinsTotal(){
        return numOfNickels*0.05 + numOfDimes*0.1 + numOfQuarters*0.25 +
                numOfLoonies + numOfToonies*2;
    }

    /**
     * This method shows the detail number of each coin type.
     * @return the list of coin number.
     */
    @Override
    public String toString() {
        return  "Number Of Nickels=" + numOfNickels +
                "\nNumber Of Dimes=" + numOfDimes +
                "\nNumber Of Quarters=" + numOfQuarters +
                "\nNumber Of Loonies=" + numOfLoonies +
                "\nNumber Of Toonies=" + numOfToonies +
                '}';
    }

    /**
     * This method compares two coin object are equal.
     * @return true if both objects are equal, false otherwise.
     */
    public boolean equals(Coins o) {
        if (this == o) return true;
        if (!(o instanceof Coins)) return false;

        Coins coins = (Coins) o;

        if (numOfDimes != coins.numOfDimes) return false;
        if (numOfLoonies != coins.numOfLoonies) return false;
        if (numOfNickels != coins.numOfNickels) return false;
        if (numOfQuarters != coins.numOfQuarters) return false;
        if (numOfToonies != coins.numOfToonies) return false;

        return true;
    }

}
