/**Purpose: to hold values for Mad Match Games and set them, and determine game outcome
 * Author: Jacob Luxton
 * Date: April 7th 2021
 * Time: 3:00pm
 */
import java.util.Random;
public class MadMatch {
    //create ascii photos
    private String pear = "*****(/*******(/)*******_|_******/###|****/#####|**|#######|**|#####/*";
    private String seven = "***********/######/******/#/******/#/******/#/******/#/***************";
    private String cherries = "****(/)*******/|*******/**|****/#|*/#|**|###|###|**|#/*|#/************";
    private String moon = "*************/###>****/#/******/#/*******|#|********|#|********|###>**";
    //create Strings to hold ascii
    private String firstSlot;
    private String secondSlot;
    private String thirdSlot;
    //create variables to hold numbers
    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;
    //get FirstSlot
    public String getFirstSlot()
    {
        return firstSlot;
    }
    //get SecondSlot
    public String getSecondSlot()
    {
        return secondSlot;
    }
    //get ThirdSlot
    public String getThirdSlot()
    {
        return thirdSlot;
    }
    //method that randomly sets values that determines which ascii photo is used
    public void pickValues()
    {
        //create new random scanner
        Random rd = new Random();
        //set first number to random int 0-3
        firstNumber = rd.nextInt(4);
        //depending on what firstnumber is, set firstSlot to a specific image
        switch(firstNumber)
        {
            case 0:
                firstSlot = pear;
                break;
            case 1:
                firstSlot = seven;
                break;
            case 2:
                firstSlot = cherries;
                break;
            case 3: 
                firstSlot = moon;
                break;
        }
        //set second number to random int 0-3
        secondNumber = rd.nextInt(4);
        //depending on what second number is, set second slot to a specific image
        switch(secondNumber)
        {
            case 0:
                secondSlot = pear;
                break;
            case 1:
                secondSlot = seven;
                break;
            case 2:
                secondSlot = cherries;
                break;
            case 3:
                secondSlot = moon;
                break;
        }
        //set third number to random int 0-3
        thirdNumber = rd.nextInt(4);
        //depending on what third number is, set third slot to a specific image
        switch(thirdNumber)
        {
            case 0:
                thirdSlot = pear;
                break;
            case 1:
                thirdSlot = seven;
                break;
            case 2:
                thirdSlot = cherries;
                break;
            case 3:
                thirdSlot = moon;
                break;
        }
    }
    //create method that returns a StringBuilder and takes 3 string arguments
    public StringBuilder showItem(String firstSlot, String secondSlot, String thridSlot)
    {
        //instantiate a new StringBuilder
        StringBuilder sb = new StringBuilder();
        //set first line of stringbuilder to first 10 characters of each ascci image 
        sb.insert(sb.length(), firstSlot.substring(0,9) + " " + secondSlot.substring(0,9) + " " + thirdSlot.substring(0,9) + "\n");
        //set second line to next 10 characters of each image
        sb.insert(sb.length(), firstSlot.substring(10,19) + " " + secondSlot.substring(10,19) + " " + thirdSlot.substring(10,19) + "\n");
        //set third line to next 10 chracters of each image
        sb.insert(sb.length(), firstSlot.substring(20,29) + " " + secondSlot.substring(20,29) + " " + thirdSlot.substring(20,29) + "\n");
        //set fourth line to next 10 chracters of each image
        sb.insert(sb.length(), firstSlot.substring(30,39) + " " + secondSlot.substring(30,39) + " " + thirdSlot.substring(30,39) + "\n");
        //set fith line to next 10 chracters of each image
        sb.insert(sb.length(), firstSlot.substring(40,49) + " " + secondSlot.substring(40,49) + " " + thirdSlot.substring(40,49) + "\n");
        //set sixth line to next 10 chracters of each image
        sb.insert(sb.length(), firstSlot.substring(50,59) + " " + secondSlot.substring(50,59) + " " + thirdSlot.substring(50,59) + "\n");
        //set seventh line to next 10 chracters of each image
        sb.insert(sb.length(), firstSlot.substring(60,69) + " " + secondSlot.substring(60,69) + " " + thirdSlot.substring(60,69) + "\n");
        return sb;
    }
    //create method to determine outcome of the game
    public void gameOutcome()
    {
        //if all 3 strings are 7 image outprint winnings and set coins
        if(firstSlot == seven && secondSlot == seven && thirdSlot == seven)
        {
            System.out.println("You Got Three 7's!!! You Won The Jack Pot!!! \n$Coins +100000$");
            GameOutcome.coins = GameOutcome.coins + 1000000;
        }else
            //if all 3 strings are the same of any other image output winnings and set coins
            if(firstNumber == secondNumber && secondNumber == thirdNumber)
            {
                System.out.println("You Got Three Of A Kind! \n$Coins + 20$");
                GameOutcome.coins = GameOutcome.coins + 20;
            }else
                //if any two strings are the same output winnings and set coins
                if(firstNumber == secondNumber || secondNumber == thirdNumber || firstNumber == thirdNumber)
                {
                    System.out.println("You Got Two Of A Kind \n$Coins + 15$");
                    GameOutcome.coins = GameOutcome.coins + 15;
                }else
                    //if none match output results and coins
                    {
                        System.out.println("You Didn't Win Anything...");
                        GameOutcome.coins = GameOutcome.coins - 15;
                    }
    }
    
}