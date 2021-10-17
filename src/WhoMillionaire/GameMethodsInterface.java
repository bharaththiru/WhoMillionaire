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
public interface GameMethodsInterface 
{
    public String displayQuestion(Questions ques);
    
    public String displayAnswer(Answers ans);
    
    public void displayLifeLines(List<LifeLines> lifeLines);
    
}
