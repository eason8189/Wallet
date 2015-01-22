/** COMP249 Assignment 1
 *  Coins Class
 *  Yang Shen (7159390)
 */
public class Coins {
    private int numOfNickels;
    private int numOfDimes;
    private int numOfQuarters;
    private int numOfLoonies;
    private int numOfToonies;
    private static double coinsTotal=0;

    public Coins(){
        numOfNickels = 0;
        numOfDimes = 0;
        numOfQuarters =0;
        numOfLoonies = 0;
        numOfToonies = 0;
    }

    public Coins(int n, int d, int q, int l,int t){
        numOfNickels = n;
        numOfDimes = d;
        numOfQuarters = q;
        numOfLoonies = l;
        numOfToonies = t;
    }

    public Coins(Coins CopiedCoins){
        numOfLoonies = CopiedCoins.numOfLoonies;
        numOfToonies = CopiedCoins.numOfToonies;
        numOfQuarters = CopiedCoins.numOfQuarters;
        numOfDimes = CopiedCoins.numOfDimes;
        numOfNickels = CopiedCoins.numOfNickels;
    }

    public int getNumOfNickels() {
        return numOfNickels;
    }

    public int getNumOfDimes() {
        return numOfDimes;
    }

    public int getNumOfQuarters() {
        return numOfQuarters;
    }

    public int getNumOfLoonies() {
        return numOfLoonies;
    }

    public int getNumOfToonies() {
        return numOfToonies;
    }

    public static double getCoinsTotal() {
        return coinsTotal;
    }

    public void setNumOfNickels(int numOfNickels) {
        this.numOfNickels = numOfNickels;
    }

    public void setNumOfDimes(int numOfDimes) {
        this.numOfDimes = numOfDimes;
    }

    public void setNumOfQuarters(int numOfQuarters) {
        this.numOfQuarters = numOfQuarters;
    }

    public void setNumOfLoonies(int numOfLoonies) {
        this.numOfLoonies = numOfLoonies;
    }

    public void setNumOfToonies(int numOfToonies) {
        this.numOfToonies = numOfToonies;
    }

    public static void setCoinsTotal(double coinsTotal) {
        Coins.coinsTotal = coinsTotal;
    }

    public void addCoins(int addN, int addD, int addQ, int addL,int addT){
        numOfNickels = numOfNickels + addN;
        numOfDimes = numOfDimes + addD;
        numOfQuarters = numOfQuarters + addQ;
        numOfLoonies = numOfLoonies + addL;
        numOfToonies = numOfToonies + addT;
    }

    public double coinsTotal(){
        return numOfNickels*0.05 + numOfDimes*0.1 + numOfQuarters*0.25 +
                numOfLoonies + numOfToonies*2;
    }

    @Override
    public String toString() {
        return  "Number Of Nickels=" + numOfNickels +
                ", Number Of Dimes=" + numOfDimes +
                ", Number Of Quarters=" + numOfQuarters +
                ", Number Of Loonies=" + numOfLoonies +
                ", Number Of Toonies=" + numOfToonies +
                '}';
    }

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
