/**Purpose: To store players coins and use values from dealer and players hand to determine game outcome
 * Author: Jacob Luxton
 * Date: March 31st 2021
 * Time: 5:00pm
 */
public class GameOutcome {
    //create static variable for game coins
    static int coins;
    //create string for telling user game outcome
    private String gameOutcome;
    //int variable for players total cards
    private int playersHand;
    //int variable for dealers total cards
    private int dealersHand;
    
    // get coins
    public int getCoins() {
        return coins;
    }
    //set gameOutcome
    public void setGameOutCome(String gameOutcome)
    {
        this.gameOutcome = gameOutcome;
    }
    //get gameOutcome
    public String getGameOutcome()
    {
        return gameOutcome;
    }
    //set playersHand
    public void setPlayersHand(int playersHand)
    {
        this.playersHand = playersHand;
    }
    //get playersHand
    public int getPlayersHand()
    {
        return playersHand;
    }
    //set dealersHand
    public void setDealersHand(int dealersHand)
    {
        this.dealersHand = dealersHand;
    }
    //get dealersHand
    public int getDealersHand()
    {
        return dealersHand;
    }
    //method that determines who wins the game depending on total in player and dealer's hand
    public String winner()
    {
        //if player gets 21 and dealer is less than 21, set coins and outcome
        if(playersHand == 21 && dealersHand < 21)
        {
            gameOutcome = "You Got 21! You WIN! \n$Coins + 5$";
            coins = coins + 5;
        }else 
            //if player has 21 and dealer has more than 21 set coins and outcome
            if(playersHand == 21 && dealersHand > 21)
            {
                gameOutcome = "You Got 21! You WIN! The dealer busted \n$Coins + 5$";
                coins = coins + 5;
            }else 
                //if player has more than 21 and dealer has 21, set coins and outcome
                if(playersHand > 21 && dealersHand == 21)
                {
                    gameOutcome = "You Busted! The Dealer got  21! \n$Coins - 5$";
                    coins = coins - 5;
                }
                else 
                    //if player has less than 21 and dealer has 21, set coins and outcome
                    if(playersHand < 21 && dealersHand == 21)
                    {
                        gameOutcome = "The Dealer got 21! \n$Coins - 5$";
                        coins = coins - 5;
                    }
                    else 
                        //if player has more than 21 and dealer has less than 21, set coins and outcome
                        if(playersHand > 21 && dealersHand < 21)
                        {
                            gameOutcome = "You Busted! The Dealer Wins! \n$Coins - 5$";
                            coins = coins - 5;
                        }
                        else 
                            //if player and dealer have the same total, set coins and outcome
                            if(playersHand == dealersHand)
                            {
                                gameOutcome = "It's a Tie!";
                            }
                            else 
                                //if player has less than 21 and dealer has more than 21, set coins and outcome
                                if(playersHand < 21 && dealersHand > 21)
                                {
                                    gameOutcome= "The Dealer Busted! You WIN! \n$Coins + 5$";
                                    coins = coins + 5;
                                }
                                else 
                                    //if player has more than 21 and dealer has more than 21, set coins and outcome
                                    if(playersHand > 21 && dealersHand > 21)
                                    {
                                    gameOutcome = "You Both Busted!";
                                    }
                                    else 
                                        //if player has less than 21 and dealer has less than 21
                                        if(playersHand < 21 && dealersHand < 21)
                                        {
                                            //if players hand is less than dealers, set coins and outcome
                                            if(playersHand < dealersHand)
                                            {
                                                gameOutcome = "The Dealers total is higher than yours, the Dealer Wins! \n$Coins - 5$";
                                                coins = coins - 5;
                                            }
                                            else 
                                                //if players hand is more than dealers, set coins and outcome
                                                if(playersHand > dealersHand)
                                                {
                                                    gameOutcome = "Your total is higher than the Dealers, You WIN! \n$Coins + 5$";
                                                    coins = coins + 5;
                                                }
                                    }
                                    return gameOutcome;
    }
    //method that takes two integers (players aces and card total) to determine if ace is high or low
    public int ace(int ace, int playersCardsTotal)
    {
        //if players hand is less than 21 and they have an ace, and if 10 is added to there hand there total wont go over 21
        //adding 10 to hand not 11 because ace is already set to the value of 1
        if(playersCardsTotal < 21 && ace == 1 && playersCardsTotal + 10 <= 21)
        {
            //make players card total plus 10 and make ace two for next time code is ran
            playersCardsTotal = playersCardsTotal + 10;
            PlayersHand.ace = 2;
        }else 
            //otherwise if players hand is greater than 21 and ace is set to high, set ace to low
            if(playersCardsTotal > 21 && ace == 2)
            {
                //subtract 10 from players card total and set ace to 1 again
                playersCardsTotal = playersCardsTotal - 10;
                PlayersHand.ace = 1;
            }
            return playersCardsTotal;
    }
    //method to check aces in dealers hand and whether it should be high or low
    public static void ace()
    {
        //if dealers hand is less than 21 and they have an ace, and if 10 is added to dealers hand it will not go over 21
        if(DealersHand.dealerCardsTotal < 21 && DealersHand.ace == 1 && DealersHand.dealerCardsTotal + 10 <= 21)
        {
            //add 10 to dealers card total
            DealersHand.dealerCardsTotal = DealersHand.dealerCardsTotal + 10;
            //set ace to 2 for next time code is ran
            DealersHand.ace = 2;
        }else 
            //otherwise if dealers hand is over 21 and ace is set to 11
            if(DealersHand.dealerCardsTotal > 21 && DealersHand.ace == 2)
            {
                //set ace low by subracting 10 from dealers hand
                DealersHand.dealerCardsTotal = DealersHand.dealerCardsTotal - 10;
                //reset ace to one for next time code is ran
                DealersHand.ace = 1;
            }
    }
}
