/** COMP249 Assignment 1
 *  Cards Class
 *  Yang Shen (7159390)
 */
public class Cards {
    private CreditCardType CreditCardType;
    private String cardHolder;
    private int expiryMonth;
    private int expiryYear;

    public Cards(){
        CreditCardType = null;
        cardHolder = null;
        expiryMonth = 0;
        expiryYear = 0;
    }

    public Cards(CreditCardType creditCardType, String cardHolder, int expiryMonth, int expiryYear) {
        CreditCardType = creditCardType;
        this.cardHolder = cardHolder;
        if(expiryMonth < 1 || expiryMonth > 12)
            this.expiryMonth = 0;
        else
            this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
    }

    public Cards(Cards cards){
        CreditCardType = cards.CreditCardType;
        cardHolder = cards.cardHolder;
        expiryMonth = cards.expiryMonth;
        expiryYear = cards.expiryYear;
    }

    public CreditCardType getCreditCardType() {
        return CreditCardType;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryMonth(int expiryMonth) {
        if(expiryMonth < 1 || expiryMonth > 12)
            this.expiryMonth = 0;
        else
            this.expiryMonth = expiryMonth;
    }

    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cards)) return false;

        Cards cards = (Cards) o;

        if (expiryMonth != cards.expiryMonth) return false;
        if (expiryYear != cards.expiryYear) return false;
        if (CreditCardType != cards.CreditCardType) return false;
        if (!cardHolder.equals(cards.cardHolder)) return false;

        return true;
    }


}


