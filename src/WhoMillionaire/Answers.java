<<<<<<< Updated upstream
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
public class Answers 
{
    private String answer;
    private AnswerEnum token;
    
    
    public Answers(AnswerEnum x, String ans)
    {
        this.answer = ans;
        this.token = x;
    }
    
    public AnswerEnum getToken()
    {
        return token;
    }
    public void setToken(AnswerEnum ans)
    {
        this.token = ans;
    }
    
    public void setAnswer(String ans)
    {
        this.answer = ans;
    }
    
    public String getAnswer()
    {
        return this.answer;
    }
    
        @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((answer == null) ? 0 : answer.hashCode());
        result = prime * result + ((token == null) ? 0 : token.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        Answers other = (Answers) obj;
        if (answer == null) 
        {
            if (other.answer != null)
            {
                return false;
            }
        } 
        else if (!answer.equals(other.answer))
        {
            return false;
        }
        if (token == null) 
        {
            if (other.token != null)
            {
                return false;
            }
        } 
        else if (!token.equals(other.token))
        {
            return false;
        }
        return true;
        
    }
}
=======
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
public class Answers 
{
    private String answer;
    private AnswerEnum token;
    
    
    public Answers(AnswerEnum x, String ans)
    {
        this.answer = ans;
        this.token = x;
    }
    
    public AnswerEnum getToken()
    {
        return token;
    }
    public void setToken(AnswerEnum ans)
    {
        this.token = ans;
    }
    
    public void setAnswer(String ans)
    {
        this.answer = ans;
    }
    
    public String getAnswer()
    {
        return this.answer;
    }
    
        @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((answer == null) ? 0 : answer.hashCode());
        result = prime * result + ((token == null) ? 0 : token.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        Answers other = (Answers) obj;
        if (answer == null) 
        {
            if (other.answer != null)
            {
                return false;
            }
        } 
        else if (!answer.equals(other.answer))
        {
            return false;
        }
        if (token == null) 
        {
            if (other.token != null)
            {
                return false;
            }
        } 
        else if (!token.equals(other.token))
        {
            return false;
        }
        return true;
        
    }
}
>>>>>>> Stashed changes
