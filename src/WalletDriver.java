import java.util.Scanner;

/** @author Yang Shen
 */

public class WalletDriver {

    private static int command = 0;
    public static Scanner kb = new Scanner(System.in);

    public static void main(String arg[]) {

        Wallet[] Wallet = new Wallet[5];

        Coins coin0 = new Coins(5, 5, 5, 5, 5);
        Coins coin1 = new Coins(coin0);

        CreditCard[] card1 = new CreditCard[4];
        card1[0] = new CreditCard(CreditCardType.Visa, "Lucy", 8, 2015);
        card1[1] = new CreditCard(CreditCardType.MasterCard, "Thomas", 9, 2025);
        card1[2] = new CreditCard(CreditCardType.AmericanExpress, "Jason", 10, 2020);
        card1[3] = new CreditCard(CreditCardType.AmericanExpress, "Smith", 3, 2019);

        CreditCard[] card2 = new CreditCard[3];
        card2[0] = new CreditCard(CreditCardType.MasterCard, "Laura", 8, 2015);
        card2[1] = new CreditCard(CreditCardType.AmericanExpress, "Jack", 8, 2015);
        card2[2] = new CreditCard(CreditCardType.Visa, "Franky", 8, 2015);

        Wallet[0] = new Wallet(coin0, card1);
        Wallet[1] = new Wallet(coin1, card2);

        Coins coins2 = new Coins(5, 5, 5, 15, 0);
        CreditCard[] card3 = new CreditCard[2];
        card3[0] = new CreditCard(CreditCardType.Visa, "Lily", 4, 2017);
        card3[1] = new CreditCard(CreditCardType.AmericanExpress, "Jennifer", 10, 2018);

        Wallet[2] = new Wallet(coins2, card3);

        Coins coins3 = new Coins(20, 20, 20, 20, 20);
        Coins coins4 = new Coins(coins3);
        Wallet[3] = new Wallet(coins3, null);
        Wallet[4] = new Wallet(coins4, null);



        boolean tryAgain =true;

        do {
            System.out.print("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n\n"
                    + "Welcome to Ethan's Wallet Application\n\n"
                    + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n\n" +
                    "What do you want to do? \n" +
                    "1. See the content of all wallets\n" +
                    "2. See the content of one wallet\n" +
                    "3. List wallets with same amount of money\n" +
                    "4. List wallets with same coins\n" +
                    "5. List wallets with same amount of money and same number of credit cards\n" +
                    "6. Add a credit card to an existing wallet\n" +
                    "7. Remove an existing credit card from a wallet\n" +
                    "8. Update the expiry date of an existing credit card\n" +
                    "9. Add coins to a wallet\n" +
                    "0. To quit\n" +
                    "Please enter your choice: ");
            command = kb.nextInt();
            kb.nextLine();

            if (command == 1) {

                for (int i = 0; i < Wallet.length; i++) {
                    if (Wallet[i].Cards == null) {

                        System.out.println("In wallet " + (i));
                        System.out.println("There is no credit card.");
                        System.out.println(Wallet[i].toString());
                    } else {

                        System.out.println("In wallet " + (i) + ".\nThere are " + Wallet[i].getTotalNumOfCreditCard() + " credit cards.");
                        System.out.println(Wallet[i].toString() + "\n");
                    }
                }

                tryAgain =false;

            }

            else if (command == 2)
            {
                boolean reTry;

                do
                {
                    reTry = false;
                    System.out.println("There are " + Wallet.length + " wallets, please select a wallet from 0 to " + (Wallet.length-1));
                    int walletIndex = kb.nextInt();

                    if (walletIndex < Wallet.length)
                        System.out.println(Wallet[walletIndex].toString());
                    else
                    {
                        System.out.println("Sorry ,there is not such a wallet, please try again");
                        reTry = true;
                    }
                }
                while (reTry);

                tryAgain =false;

            }

            else if (command == 3)
            {
                for (int i = 0; i < Wallet.length - 1; i++)
                {
                    for (int j = i + 1; j < Wallet.length; j++)
                    {
                        if (Wallet[i].equalsCoinsValue(Wallet[j]))
                        {
                            System.out.print("Wallet " + (i) + " and wallet " + (j) +
                                    " both have $" +
                                    Wallet[i].getTotalCoinsValue() + "\n");
                        }
                    }
                }

                tryAgain =false;
            }

            else if (command == 4)
            {
                System.out.println("List of wallets with same coins.");
                for (int i = 0; i < Wallet.length - 1; i++)
                {
                    for (int j = i + 1; j < Wallet.length; j++)
                    {
                        if (Wallet[i].equalsCoinsType(Wallet[j]))
                        {
                            System.out.print("Wallet " + (i) + " and wallet " + (j) + " both have" +"\n" +
                                    Wallet[j].Coins.toString() + "\n");
                        }
                    }
                }

                tryAgain =false;
            }

            else if (command == 5)
            {
                System.out.println("List of wallets with same amount of money and same number of credit cards:");
                for (int i = 0; i < Wallet.length - 1; i++)
                {
                    for (int j = i + 1; j < Wallet.length; j++)
                    {
                        if (Wallet[i].equals(Wallet[j]))
                            System.out.print("Wallet " + (i) + " and wallet " + (j) + ".\n");
                    }
                }

                tryAgain =false;
            }

            else if (command == 6)
            {
                System.out.println("There are " + Wallet.length + " wallets, to which wallet you want to add a credit card? Please select from 0 to 4.");
                int selectedWallet = kb.nextInt();
                System.out.println("You have selected wallet " + selectedWallet + ", please enter the holder's name.");
                Scanner kb1 = new Scanner(System.in);
                String name = kb1.nextLine();
                System.out.println("The card holder's name is " + name + ", please enter the type of credit card, MasterCard, Visa, or AmericanExpress.");
                Scanner kb2 = new Scanner(System.in);
                String cardType = kb2.nextLine();

                System.out.println("Please set the expired month and year, separate by space");
                int month = kb.nextInt();
                int year = kb.nextInt();

                CreditCard newCard = new CreditCard(CreditCardType.valueOf(cardType),name,month,year);
                Wallet[selectedWallet].addCreditCard(newCard);
                System.out.println("Right now you have " + Wallet[selectedWallet].getTotalNumOfCreditCard() + " credit cards");

                tryAgain =false;
            }

            else if (command == 7)
            {
                System.out.println("There are " + Wallet.length + " wallets, from which wallet you want to remove a credit card? Please select from 0 to 4");
                int walletNum = kb.nextInt();
                int walletIndex = walletNum;

                if (Wallet[walletNum].getTotalNumOfCreditCard() == 0)
                    System.out.println("Sorry, there is not credit card in wallet " + walletNum);

                else
                {
                    System.out.println("In wallet " + walletNum + ", there are " +
                            Wallet[walletNum].getTotalNumOfCreditCard() + "credit cards");
                    System.out.println("Which card you want to remove? From 0 to " + Wallet[walletNum].getTotalNumOfCreditCard());
                    int choice = kb.nextInt();
                    Wallet[walletIndex].removeCreditCard(choice);
                    System.out.println("Right now you have " + Wallet[walletIndex].getTotalNumOfCreditCard() + " credit cards, with one card removed.");
                }

                tryAgain =false;
            }

            else if (command == 8)
            {
                System.out.println("There are " + Wallet.length + " wallets, from which wallet you want to update a credit card? Please select from 0 to 4");
                int walletIndex = kb.nextInt();
                if (Wallet[walletIndex].getTotalNumOfCreditCard() == 0)
                    System.out.println("Sorry, there is no credit card.");

                System.out.println("There are " + Wallet[walletIndex].getTotalNumOfCreditCard() + " credit cards in wallet " + (walletIndex + 1));
                System.out.println("Which card you want to update? From 0 to " + (Wallet[walletIndex].getTotalNumOfCreditCard()-1));
                int cardIndex = kb.nextInt();
                if ((cardIndex > 0) && (cardIndex < Wallet[walletIndex].getTotalNumOfCreditCard()))
                {
                    System.out.println("Enter new expiry month number and year (separate by a space):");
                    int newMonth = kb.nextInt();
                    int newYear = kb.nextInt();
                    Wallet[walletIndex].Cards[cardIndex].setExpiryMonth(newMonth);
                    Wallet[walletIndex].Cards[cardIndex].setExpiryYear(newYear);
                    System.out.println("Expiry date is updated.");
                }
                else
                    System.out.println("Card number " + (cardIndex) + " does not exist.");

                tryAgain =false;
            }

            else if(command == 9)
            {
                System.out.println("There are " + Wallet.length + " wallets, to which wallet you want to add coins? Please select from 0 to 4.");
                int walletIndex = kb.nextInt();
                System.out.println("There are $" + Wallet[walletIndex].getTotalCoinsValue() + " in the wallet");
                System.out.println("How many nickels, dimes, quarters, loonies and toonies do you want to add to wallet "
                        + walletIndex  + " ?\n" + "Enter 5 numbers separated by a space");
                int nickel = kb.nextInt();
                int dime = kb.nextInt();
                int quarter = kb.nextInt();
                int loonie = kb.nextInt();
                int toonie = kb.nextInt();
                Wallet[walletIndex].Coins.addCoins(nickel, dime, quarter, loonie, toonie);
                System.out.println("You now have " + Wallet[walletIndex].getTotalCoinsValue());

                tryAgain =false;
            }

            else if (command == 0)
            {
                System.out.println("Thank you for using Ethan's wallet application!");
                System.exit(0);
            }
            else
            {
                System.out.println("Sorry, that is not a valid choice, please try again.");
                tryAgain = false;
            }

        }while (tryAgain==false);

    }


}

