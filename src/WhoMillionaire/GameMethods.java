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
