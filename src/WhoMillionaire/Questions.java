<<<<<<< Updated upstream
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author bhara
 */
public class Questions
{
    private String question;
    private List<Answers> answers;
    private AnswerEnum correct;
   
    public Questions(String ques, AnswerEnum right, Answers ... optionalAnswers)
    {
        this.question = ques;
        this.correct = right;
        this.answers = new ArrayList<>();
        this.answers.addAll(Arrays.asList(optionalAnswers));
    }
    
    public Set<AnswerEnum> getAnsTokens()
    {
        Set<AnswerEnum> token = new HashSet<>();
        for(Answers a : answers)
        {
            token.add(a.getToken());
        }
        
        return token;
    }
    
    public List<Answers> getAnswers()
    {
        return new ArrayList<>(answers);
    }
    
    public void setAnswers(List<Answers> options)
    {
        this.answers = options;
    }
    
    public void removeAnswerIndex(int index)
    {
        answers.remove(index);
    }
    
    public void removeAnswer(Answers a)
    {
        answers.remove(a);
    }
    
    public String getQuestion()
    {
        return this.question;
    }
    
    public void setQuestion(String q)
    {
        this.question = q;
    }
    
    public AnswerEnum getRightAnswer(AnswerEnum answer)
    {
        return correct;
    }
    
    public void setRightAnswer(AnswerEnum answer)
    {
        this.correct = answer;
    }
    
    public boolean isCorrect(AnswerEnum answer)
    {
       return correct == null ? answer == null : correct.equals(answer);
    }
    
    public List<Answers> getWrongAnswers()
    {
        List<Answers> wrongAnswers = new ArrayList<>();
        for(Answers a : answers)
        {
            if(!isCorrect(a.getToken()))
            {
                wrongAnswers.add(a);
            }
        }
        
        return wrongAnswers;

    } 
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author bhara
 */
public class Questions
{
    private String question;
    private List<Answers> answers;
    private AnswerEnum correct;
   
    public Questions(String ques, AnswerEnum right, Answers ... optionalAnswers)
    {
        this.question = ques;
        this.correct = right;
        this.answers = new ArrayList<>();
        this.answers.addAll(Arrays.asList(optionalAnswers));
    }
    
    public Set<AnswerEnum> getAnsTokens()
    {
        Set<AnswerEnum> token = new HashSet<>();
        for(Answers a : answers)
        {
            token.add(a.getToken());
        }
        
        return token;
    }
    
    public List<Answers> getAnswers()
    {
        return new ArrayList<>(answers);
    }
    
    public void setAnswers(List<Answers> options)
    {
        this.answers = options;
    }
    
    public void removeAnswerIndex(int index)
    {
        answers.remove(index);
    }
    
    public void removeAnswer(Answers a)
    {
        answers.remove(a);
    }
    
    public String getQuestion()
    {
        return this.question;
    }
    
    public void setQuestion(String q)
    {
        this.question = q;
    }
    
    public AnswerEnum getRightAnswer(AnswerEnum answer)
    {
        return correct;
    }
    
    public void setRightAnswer(AnswerEnum answer)
    {
        this.correct = answer;
    }
    
    public boolean isCorrect(AnswerEnum answer)
    {
       return correct == null ? answer == null : correct.equals(answer);
    }
    
    public List<Answers> getWrongAnswers()
    {
        List<Answers> wrongAnswers = new ArrayList<>();
        for(Answers a : answers)
        {
            if(!isCorrect(a.getToken()))
            {
                wrongAnswers.add(a);
            }
        }
        
        return wrongAnswers;

    } 
}
>>>>>>> Stashed changes
