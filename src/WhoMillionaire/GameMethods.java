<<<<<<< Updated upstream
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

import java.util.List;
import java.util.Scanner;


/**
 *
 * @author bhara
 */
public class GameMethods 
{
    public static Scanner scan = new Scanner(System.in);
    public void displayIntro()
    {
        
        System.out.println("Welcome To Who Wants To Be A Millionarie!");
        System.out.println("Please enter your name: ");
        Player.setName(scan.nextLine().trim());
        System.out.println("Your name : "+Player.getName());
        //String userName = scan.nextLine().trim();
        //System.out.println("Your name : "+userName);
        System.out.println("");
        System.out.println("The Game Begins!");
    }
    
    public String displayQuestion(Questions ques)
    {
//        System.out.println(ques.getQuestion());
//        
//        for(Answers ans : ques.getAnswers())
//        {
//            displayAnswer(ans);
//        }
        return ques.getQuestion();
    }
    
    public String displayAnswer(Answers ans)
    {
//        StringBuffer Ans = new StringBuffer();
//        Ans.append(ans.getToken().name());
//        Ans.append(". ");
//        Ans.append(ans.getAnswer());
//        System.out.println(Ans.toString());
        return ans.getAnswer();
    }
    
    public void displayLifeLines(List<LifeLines> lifeLines)
    {
        if(lifeLines.isEmpty())
        {
            System.out.println("You have used all your life lines! Goodluck!");
        }
        
        System.out.println("Your Life Lines:");
        for(int i = 0; i < lifeLines.size(); i++)
        {
            System.out.println((i+1) + ". "+lifeLines.get(i));
        }
    }
    
    public void displayWalkMessage()
    {
        System.out.println("Press x at anytime during the game to walk away with your money!");
    }
    
    private AnswerEnum getAnswerFromInput(String input)
    {
        input = input.toUpperCase().trim();
        
        try
        {
            AnswerEnum token = AnswerEnum.valueOf(input);
            return token;
        }
        catch(IllegalArgumentException E)
        {
            return null; //Input token from user does not match with any answer tokens
        }
    }
    
    private LifeLines getLifeLineFromInput(List<LifeLines> lifeLines, String input)
    {
        try
        {
            int index = Integer.parseInt(input) -1;
            
            if(index >= 0 && index < lifeLines.size())
            {
                return lifeLines.get(index);
            } 
        }
        catch(NumberFormatException E)
        {
        
        }
        
        return null;
    }
    
//    public void walkOut()
//    {
//        String walk = scan.nextLine().trim();
//        if(walk == "x" || walk == "X")
//        {
//            System.out.println("You have chosen to walk out!");
//            System.exit(0);
//        }
//        
//    }
    
    public PlayerResponse getResponseToQuestion(List<LifeLines> lifeLines)
    {
        String userInput = scan.nextLine().trim();
      
        AnswerEnum answer = getAnswerFromInput(userInput);
        LifeLines life = getLifeLineFromInput(lifeLines, userInput);
        
        return new PlayerResponse(answer, life);
    }
    
//    public AnswerEnum getWalkResponse(AnswerEnum e)
//    {
//        String userInput = scan.nextLine().trim();
//        
//        AnswerEnum answer = getAnswerFromInput(userInput);
//        
//        return answer;
//    }
    
    public boolean isFinalAnswer()
    {
        String finalAnswer = null;
        
        do
        {
            System.out.println("Is this your final answer? (yes or no)");
            finalAnswer = scan.nextLine().trim();
        }
        while(!isValidFinalResponse(finalAnswer));
        
        finalAnswer = finalAnswer.trim();
        return "Yes".equalsIgnoreCase(finalAnswer) || "Y".equalsIgnoreCase(finalAnswer);
    }
    
    private boolean isValidFinalResponse(String input)
    {
        input = input.trim();
        return input != null && ("Yes".equalsIgnoreCase(input) || "y".equalsIgnoreCase(input)
                || "No".equalsIgnoreCase(input) || "n".equalsIgnoreCase(input));
    }
        
    public void endGame()
    {
        scan.close();
    }
        
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

import java.util.List;


/**
 *
 * @author bhara
 */
public class GameMethods implements GameMethodsInterface
{
    @Override
    public String displayQuestion(Questions ques)
    {
        return ques.getQuestion();
    }
    
    @Override
    public String displayAnswer(Answers ans)
    {
        return ans.getAnswer();
    }
    
    @Override
    public void displayLifeLines(List<LifeLines> lifeLines)
    {
        if(lifeLines.isEmpty())
        {
            System.out.println("You have used all your life lines! Goodluck!");
        }
        
        System.out.println("Your Life Lines:");
        for(int i = 0; i < lifeLines.size(); i++)
        {
            System.out.println((i+1) + ". "+lifeLines.get(i));
        }
    }
    
}
>>>>>>> Stashed changes
