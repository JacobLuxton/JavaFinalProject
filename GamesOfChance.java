/**Purpose: To use values in all other classes and run their methods in the main method
 * Author: Jacob Luxton
 * Date: March 31st 2021
 * Time: 5:00pm
 */
//import scanner
import java.util.Scanner;
public class GamesOfChance {
    public static void main (String [] args)
    {
        //instantiate new scanner
        Scanner in = new Scanner(System.in);
        //create boolean to determine if game continues
        boolean runGame = true;
        //create int to determine which game is played
        int game = 0;
        GameOutcome.coins = 20;
        System.out.println("**************************************");
        System.out.println("WELCOME TO JJL's Games of Chance!!!");
        System.out.println("**************************************");
        System.out.println("** Starting coins = 20 **");
        //as long as runGame is true, continue game
        while(runGame == true)
        {
            //ask user which game they would like to play or exit
            System.out.println("Would you like to play a game of 1.Twenty One or 2.Mad Match? (1 or 2)");
            System.out.println("Type 'no' to exit");
            String play = in.nextLine();
            //if player chooses 1 run game 1
            if(play.equalsIgnoreCase("1"))
            {
                game = 1;
                runGame = true;
            }else
                //if user chooses 2 run game 2
                if(play.equalsIgnoreCase("2"))
                {
                    game = 2;
                    runGame = true;
                }
                else 
                    //if user says no exit game completely
                    if(play.equalsIgnoreCase("no"))
                    {
                        game = 0;
                        runGame = false;
                        break;
                    }
            //if user chose Mad Match, execute code
            if(game == 2)
            {
                do{
                    //tell user what the game is and how it works
                    System.out.println("WELCOME TO MAD MATCH!!");
                    System.out.println("Purpose of game is to get a match of two of a kind or 3 of a kind");
                    System.out.println("--------------------------------------------");
                    System.out.println("The possible Items are:");
                    //show user what all the possible images to get are
                    System.out.println("   PEAR       SEVEN     CHERRY      MOON");
                    System.out.println("*****(/*** ********** ****(/)*** **********");
                    System.out.println("****(/)*** */######/* ***(|***** ***/###>**");
                    System.out.println("****_|_*** *****/#/** ***/*|**** **/#/*****");
                    System.out.println("***/###|** ****/#/*** */#|*/#|** */#/******");
                    System.out.println("**/#####|* ***/#/**** |###|###|* *|#|******");
                    System.out.println("*|#######| **/#/***** *|#/*|#/** **|#|*****");
                    System.out.println("**|#####/* ********** ********** ***|###>**");
                    System.out.println("--------------------------------------------");
                    System.out.println("If you get 3 sevens you win the jackpot, if you get 3 of a kind you get * +20 * coins");
                    System.out.println("If you get 2 of a kind you get * +15 * coins, If you do not match any you loose * -15 * coins");
                    System.out.println("--------------------------------------------");
                    System.out.println("Would You Like To Play A Game? (yes or no)");
                    play = in.nextLine();
                    //determine whether user wants to play this game or not
                    if(play.equalsIgnoreCase("yes"))
                    {
                        game = 2;
                        break;
                    }
                    else
                        if(play.equalsIgnoreCase("no"))
                        {
                            game = 0;
                            break;
                        }   
                }
                while(true);
            }
            //if user chose Twenty One, execute code
            if(game == 1)
            {
                //tell user how game works and what the goal is
                System.out.println("WELCOME TO THE GAME TWENTY ONE");
                System.out.println("The purpose of the game is to get * 21 * total out of all cards you draw against the dealer");
                System.out.println("Cards Two to Ten are worth their face value, Ace's can be 1 or 11, and Jack,Queen,King are worth 10");
                System.out.println("If you win you get * -5 * coins, if you lose you lose * +5 * coins");
                System.out.println("____________________________________________________________________");
                while(true)
                {
                    System.out.println("Would you like to play a game? (yes or no)");
                    play = in.nextLine();
                    //determine whether user wants to play this game or not
                    if(play.equalsIgnoreCase("yes"))
                    {
                        game = 1;
                        break;
                    }
                    else
                        if(play.equalsIgnoreCase("no"))
                        {
                            game = 0;
                            break;
                        }   
                }
            }
            //if user chose Mad Match, run game
            while(game == 2)
            {
                //instantiate new Mad Match object
                MadMatch madMatch = new MadMatch();
                //run method to pick the 3 values
                madMatch.pickValues();
                //print out the 3 ascii images that were randomly set using a method that returns them as a string builder
                System.out.println(madMatch.showItem(madMatch.getFirstSlot(), madMatch.getSecondSlot(), madMatch.getThirdSlot()));
                //run method that shows what the outcome of the game is
                madMatch.gameOutcome();
                System.out.println("Coins -" + GameOutcome.coins);
                //run code till user gives a proper answer
                while(true)
                {
                    //ask user if they would like to play again
                    System.out.println("Would you like to play again?");
                    play = in.nextLine();
                    //if user says yes run game again else if user says no exit game
                    if(play.equalsIgnoreCase("yes"))
                    {
                        game = 2;
                        break;
                    }
                    else
                        if(play.equalsIgnoreCase("no"))
                        {
                            game = 0;
                            break;
                        }   
                }
            }
            //if user chose Twenty One, run game
            while (game == 1)
            {
                //instatiate a new object for PlayersHand, DealersHand, and GameOutcome
                PlayersHand playersHand = new PlayersHand();
                DealersHand dealersHand = new DealersHand();
                GameOutcome gameOutcome = new GameOutcome();
                //set dealers total and players total to 0 for new round
                dealersHand.setDealerCardsTotal(0);
                playersHand.setPlayerCardsTotal(0);
                //set dealers and players number of aces to 0 for new round
                DealersHand.ace = 0;
                PlayersHand.ace = 0;
                //draw a new card for player and dealer
                playersHand.playerDraws();
                dealersHand.dealerDraws();

                //tell user what they drew and what user drew
                System.out.println("You drew a " + playersHand.playersCards());
                System.out.println("The Dealer drew a " + dealersHand.dealersCards());
                System.out.println("----------------------");
                //run as long as player nor dealers hand is equal to 21 or over 21
                while (playersHand.getPlayerCardsTotal() < 21 && dealersHand.getDealerCardsTotal() < 21)
                {
                    //ask user if they would like to draw new card or hold
                    System.out.println("What would you like to do? (draw or hold)");
                    //create string to hold user input
                    String action = in.nextLine();
                    System.out.println("----------------------");
                    //if user chooses to draw, execute code
                    if(action.equalsIgnoreCase("draw"))
                    {
                        //player draws a new card, run method
                        playersHand.playerDraws();
                        //tell player what they drew
                        System.out.println("You drew a " + playersHand.playersCards());
                        //run method that displays all of players cards
                        playersHand.cardNames();
                        //set players total cards depending on whether they have an ace or not and determine what ace's value should be set to
                        playersHand.setPlayerCardsTotal(gameOutcome.ace(PlayersHand.ace, playersHand.getPlayerCardsTotal()));
                        //show player what there card total is
                        System.out.println("Your Total: " + playersHand.getPlayerCardsTotal());
                        System.out.println("----------------------");
                        //run method that determines whether dealer should draw again or not
                        dealersHand.dealerDrawsAgain();
                        //run method that shows all of dealers cards
                        dealersHand.cardNames();
                        //run method that determines whether dealers ace should be high or low
                        GameOutcome.ace();
                        //display dealers total cards value
                        System.out.println("Dealer Total: " + dealersHand.getDealerCardsTotal());
                        System.out.println("----------------------");
                    }else 
                        //if user chooses to hold, execute code
                        if(action.equalsIgnoreCase("hold"))
                        {
                            //as long as dealer's total cards value is less than 17 and player's cards total is not more that 21, run code
                            while(dealersHand.getDealerCardsTotal() < 17 && playersHand.getPlayerCardsTotal() < 22)
                            {
                                //check to see if dealer should draw again and if so, do so
                                dealersHand.dealerDrawsAgain();
                                //display all names of cards dealer has
                                dealersHand.cardNames();
                                //determine what dealer's ace should be if they have one
                                GameOutcome.ace();
                                //display dealers cards total value
                                System.out.println("Dealer Total: " + dealersHand.getDealerCardsTotal());
                                System.out.println("--------------------------");
                            }
                            break;
                        }
                }
                //set players hand in GameOutcome to playersHand in PlayersHand
                gameOutcome.setPlayersHand(playersHand.getPlayerCardsTotal());
                //set Dealers hand in GameOutcome to dealersHand in DealersHand
                gameOutcome.setDealersHand(dealersHand.getDealerCardsTotal());
                //print method that determines outcome of game
                System.out.println(gameOutcome.winner());
                //print players total coins
                System.out.println("Total Coins: " + gameOutcome.getCoins());
                //if player runs out of coins, display message and end game
                if(GameOutcome.coins < 1)
                {
                    System.out.println("**** Sorry Your ran out of Coins! ****");
                    runGame = false;
                    game = 0;
                }
                else 
                {
                    while(true)
                    {
                        //ask user if they would like to play another game
                        System.out.println("Would you like to play again? (yes or no)");
                        //set users input to a string
                        play = in.nextLine();
                        //if player says yes run game again
                        if(play.equalsIgnoreCase("yes"))
                        {
                            game = 1;
                            break;
                        }else
                            //if user says no exit game
                            if(play.equalsIgnoreCase("no"))
                            {
                                game = 0;
                                break;
                            }
                    }
                    System.out.println("---------------------");
                }
            }
        }   
        //thank user for playing and close scanner
        System.out.println("Thanks for playing!");
        in.close();
    }
}
