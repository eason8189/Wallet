/** @author Yang Shen
 */

    //Credit Card Attributes
public class CreditCard {
    private CreditCardType CreditCardType;
    private String cardHolder;
    private int expiryMonth;
    private int expiryYear;


    //Default Constructor
    public CreditCard(){
        CreditCardType = null;
        cardHolder = null;
        expiryMonth = 0;
        expiryYear = 0;
    }


    //Parametrized Constructor
    public CreditCard(CreditCardType creditCardType, String cardHolder, int expiryMonth, int expiryYear) {
        CreditCardType = creditCardType;
        this.cardHolder = cardHolder;

        //Check for illegal entry of expiry month.
        if(expiryMonth < 1 || expiryMonth > 12)
            this.expiryMonth = 0;
        else
            this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
    }


    //Copy Constructor
    public CreditCard(CreditCard cards){
        CreditCardType = cards.CreditCardType;
        cardHolder = cards.cardHolder;
        expiryMonth = cards.expiryMonth;
        expiryYear = cards.expiryYear;
    }

    //Accessors

    /**
     * This method access the type of credit card.
     * @return the credit card type.
     */
    public CreditCardType getCreditCardType() {
        return CreditCardType;
    }

    /**
     * This method access the name of credit card.
     * @return the credit card name.
     */
    public String getCardHolder() {
        return cardHolder;
    }

    /**
     * This method access the expiry month of credit card.
     * @return the credit card expiry month.
     */
    public int getExpiryMonth() {
        return expiryMonth;
    }

    /**
     * This method access the expiry year of credit card.
     * @return the credit card expiry year.
     */
    public int getExpiryYear() {
        return expiryYear;
    }


    //Mutators

    /**
     * This method set the expiry month of credit card.
     * The method check if the entry is a valid month number, otherwise it set to 0.
     * @param expiryMonth the month to be set.
     */
    public void setExpiryMonth(int expiryMonth) {
        if(expiryMonth < 1 || expiryMonth > 12)
            this.expiryMonth = 0;
        else
            this.expiryMonth = expiryMonth;
    }

    /**
     * This method set the expiry year of credit card.
     * @param expiryYear the year to be set.
     */
    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }


    /**
     * This method shows the list of each credit card stored.
     * The method add an "0" before if the expiry month of a credit card is less than 10.
     * @return the list of credit card.
     */
    @Override
    public String toString() {
        if(expiryMonth<10)
        return "Credit Card Detail: "+ CreditCardType +
                ", Card Holder's Name: " + cardHolder +
                ", Expiry Date= 0" + expiryMonth +"/"+
                 expiryYear + ".";
        else
            return "Credit Card Detail: "+ CreditCardType +
                    ", Card Holder's Name: " + cardHolder +
                    ", Expiry Date= " + expiryMonth +"/"+
                    expiryYear + ".";
    }


    /**
     * This method checks if two credit card object are equal.
     * @return true if both object are equal, false otherwise.
     */
    public boolean equals(CreditCard o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard)) return false;

        CreditCard cards = (CreditCard) o;

        if (expiryMonth != cards.expiryMonth) return false;
        if (expiryYear != cards.expiryYear) return false;
        if (CreditCardType != cards.CreditCardType) return false;
        if (!cardHolder.equals(cards.cardHolder)) return false;

        return true;
    }


}


