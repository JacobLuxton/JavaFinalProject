/**Purpose: To hold variables and values of cards dealer has and use them 
 * Author: Jacob Luxton
 * Date: March 19th 2021
 * Time: 6:00pm
 */
import java.util.Random;
public class DealersHand {
    //variable to store integer value of card
    private int dealerCards;
    //array to store names of all cards in dealers hand
    private String dealerCardsNames[] = {"", "", "", "", "", "", "", "", "", "", ""};
    //variable to store total value of dealer's cards
    static int dealerCardsTotal;
    //variable to change needed array index
    private int indexOfArray = 0;
    //variable to hold number of aces in dealers hand
    static int ace = 0;
    
    //set dealerCards
    public void setDealerCards(int dealerCards) 
    {
        this.dealerCards = dealerCards;
    }
    //get dealerCards 
    public int getDealerCards() 
    {
        return dealerCards;
    }
    //set dealerCardsNames
    public void setDealerCardsNames(String dealerCardsNames[])
    {
        this.dealerCardsNames = dealerCardsNames;
    }
    //get dealerCardsNames
    public String[] getDealerCardsNames()
    {
        return dealerCardsNames;
    }
    //set dealerCardsTotal
    public void setDealerCardsTotal(int dealerCardsTotal)
    {
        DealersHand.dealerCardsTotal = dealerCardsTotal;
    }
    //get dealerCardsTotal
    public int getDealerCardsTotal()
    {
        return dealerCardsTotal;
    }
    //method that takes the value of dealerCards and sets cardValue and adds to card total
    public String dealersCards()
    {
        String cardValue = String.valueOf(dealerCards);
        switch(cardValue)
        {
            case "1":
                cardValue = "[Ace]";
                //make ace 1 to show dealer has an ace
                ace = 1;
                break;
            case "2":
                cardValue = "[Two]";
                break;
            case "3":
                cardValue = "[Three]";
                break;
            case "4":
                cardValue = "[Four]";
                break;
            case "5":
                cardValue = "[Five]";
                break;
            case "6":
                cardValue = "[Six]";
                break;
            case "7":
                cardValue = "[Seven]";
                break;
            case "8":
                cardValue = "[Eight]";
                break;
            case "9":
                cardValue = "[Nine]";
                break;
            case "10":
                cardValue = "[Ten]";
                break;
            case "11":
                cardValue = "[Jack]";
                //make jack worth 10
                dealerCards = 10;
                break;
            case "12":
                cardValue = "[Queen]";
                //make queen worth 10
                dealerCards = 10;
                break;
            case "13":
                cardValue = "[King]";
                //make king worth 10
                dealerCards = 10;
                break;
        }
        //set array position to card value name
        dealerCardsNames[indexOfArray] = cardValue;
        //increase array for next card name position
        indexOfArray++;
        //add drawn card to dealers total cards value
        dealerCardsTotal = dealerCardsTotal + dealerCards;
        return cardValue;
    }
    //create method that randomly picks a number to set dealerCards as
    public int dealerDraws()
    {
        //new Random and set dealerCards to number between 1-13 (Ace-King)
        Random random = new Random();
        dealerCards = random.nextInt(13) + 1;
        return dealerCards;
    }
    //create method to see if dealer should draw again
    public void dealerDrawsAgain()
    {
        //draw again if dealerCardsTotal is less than 17
        if(dealerCardsTotal < 17)
        {
            //run dealerDraws method
            dealerDraws();
            //show what dealer just drew
            System.out.println("The dealer drew a " + dealersCards());
        }
        //if dealer has 17 or more don't do anything and display message
        else
        {
           System.out.println("Dealer held");
        }
    }
    //display names of all dealers cards
    public void cardNames()
    {
        System.out.println("Dealer Cards:");
        //loop for length of array and only display if array has been set to a name
        for(int i = 0; i < dealerCardsNames.length; i++)
        {
            if(dealerCardsNames[i].equals(""))
            {
                //do nothing
            }
            else
            {
                System.out.println("-" + dealerCardsNames[i]);
            }
        }
    }
    
}
