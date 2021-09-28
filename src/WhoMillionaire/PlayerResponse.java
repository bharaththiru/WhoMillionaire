/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

/**
 *
 * @author bhara
 */
public class PlayerResponse 
{

    
    private LifeLines lifeLine;
    private AnswerEnum answer;
    private AnswerEnum Walk;
    private Questions question;
    public PlayerResponse(AnswerEnum token, LifeLines life)
    {
        lifeLine= life;
        answer = token;
    }
    
     public LifeLines getLifeLine() 
    {
        return lifeLine;
    }

    public void setLifeLine(LifeLines life) 
    {
        this.lifeLine = life;
    }
    
     public AnswerEnum getAnswer() 
    {
        return answer;
    }

    public void setAnswer(AnswerEnum answerToken) 
    {
        this.answer = answerToken;
    }
    
    public AnswerEnum getWalk() 
    {
        return Walk;
    }

    public void setWalk(AnswerEnum walkAway) {
        this.Walk = walkAway;
    }

    public Questions getQuestion() 
    {
        return question;
    }
}
