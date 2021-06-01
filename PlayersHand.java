/**Purpose: To hold variables and values of cards in players hand and use them
 * Author: Jacob Luxton
 * Date: March 19th 2021
 * Time: 6:00pm
 */
import java.util.Random;
public class PlayersHand
{
    //variable to store value for cards
    private int playerCards;
    //array to store all cards in players hand
    private String[] playerCardsNames = {"", "", "", "", "", "", "", "", "", "", ""};
    //variable to store total value of cards
    private static int playerCardsTotal = 0;
    //variable to change location of needed index
    private int indexOfArray = 0;
    //variable to hold number of aces
    static int ace;

    // set playerCards
    public void setPlayerCards(int cards) 
    {
        this.playerCards = cards;
    }
    // get playerCards
    public int getPlayerCards() 
    {
        return playerCards;
    }
    //set playerCardsNames
    public void setPlayerCardsNames(String playerCardsNames[])
    {
        this.playerCardsNames = playerCardsNames;
    }
    //get playerCardsNames
    public String[] getPlayerCardsNames()
    {
        return playerCardsNames;
    }
    //set playerCardsTotal
    public void setPlayerCardsTotal(int playerCardsTotal)
    {
        PlayersHand.playerCardsTotal = playerCardsTotal;
    }
    //get playerCardsTotal
    public int getPlayerCardsTotal()
    {
        return playerCardsTotal;
    }
    //method that takes the value of playerCards and sets cardValue and adds to card total
    public String playersCards()
    {
        //set card value to the value of playercards as a string
        String cardValue = String.valueOf(playerCards);
        //depending on what cardValue is originally, set it to a card name
        switch(cardValue)
        {
            case "1":
                cardValue = "[Ace]";
                //make ace 1 to show there is an ace in players hand
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
                //make jacks worth 10
                playerCards = 10;
                break;
            case "12":
                cardValue = "[Queen]";
                //make queens worth 10
                playerCards = 10;
                break;
            case "13":
                cardValue = "[King]";
                //make kings worth 10
                playerCards = 10;
                break;
        }
        //set index of playerCardsNames from wherever indexOfArray is and set it to cardValue
        playerCardsNames[indexOfArray] = cardValue;
        //increase indexOfArray to set next array index
        indexOfArray++;
        //add card value that was drawn to total amount of cards
        playerCardsTotal = playerCardsTotal + playerCards;
        return cardValue;
    }
    //create method that picks number randomly to set playerCards as
    public int playerDraws()
    {
        //new Random 
        Random random = new Random();
        //make players cards a value between 1-13 (Ace-King)
        playerCards = random.nextInt(13) + 1;
        return playerCards;
    }
    //display all names of cards in players hand
    public void cardNames()
    {
        System.out.println("Your Cards:");
        //loop through array until it reaches end of array, display cards as long as they are set to a name
        for(int i = 0; i < playerCardsNames.length; i++)
        {
            if(playerCardsNames[i].equals(""))
            {
                //do nothing
            }
            else
            {
                System.out.println("-" + playerCardsNames[i]);
            }
        }
    }
    
}