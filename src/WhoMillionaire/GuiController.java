/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author bhara
 */
public class GuiController implements ActionListener
{
    public GuiView view;
    
    public GuiController(GuiView view)
    {
        this.view = view;
        this.view.addActionListener(this);
    }

    int i = 0;
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == view.answerA) 
        {
            view.lifeUsed.setText("");
            if (view.randomQuestion.isCorrect(AnswerEnum.A)) 
            {
                System.out.println("Correct!");
                view.lifeUsed.setText("Correct!");
                view.questions.remove(view.randomIndex);
                view.updateScreenIfCorrect();
                view.repaint();
                
                if(i == view.moneyLabels.length)
                {
                    System.out.println("Congratulations! You are now a millionaire");
                    System.out.println("Thank you for playing");
                }
                else
                {
                    view.moneyLabels[i].setForeground(Color.yellow);
                    i++;
                }
               
            } 
            else 
            {
                System.out.println("Incorrect!");
                view.lifeUsed.setText("Incorrect!");
            }

        }

        if (e.getSource() == view.answerB) 
        {
            view.lifeUsed.setText("");
            if (view.randomQuestion.isCorrect(AnswerEnum.B)) 
            {
                System.out.println("Correct!");
                view.lifeUsed.setText("Correct!");
                view.questions.remove(view.randomIndex);
                view.updateScreenIfCorrect();
                
                if(i == view.moneyLabels.length)
                {
                    System.out.println("Congratulations! You are now a millionaire");
                    System.out.println("Thank you for playing");
                }
                else
                {
                    view.moneyLabels[i].setForeground(Color.yellow);
                    i++;
                }
            } 
            else 
            {
                System.out.println("Incorrect!");
                view.lifeUsed.setText("Incorrect!");
            }
        }

        if (e.getSource() == view.answerC) 
        {
            view.lifeUsed.setText("");
            if (view.randomQuestion.isCorrect(AnswerEnum.C)) 
            {
                System.out.println("Correct!");
                view.lifeUsed.setText("Correct!");
                view.questions.remove(view.randomIndex);
                view.updateScreenIfCorrect();
                
                if(i == view.moneyLabels.length)
                {
                    System.out.println("Congratulations! You are now a millionaire");
                    System.out.println("Thank you for playing");
                }
                else
                {
                    view.moneyLabels[i].setForeground(Color.yellow);
                    i++;
                }
            } 
            else 
            {
                System.out.println("Incorrect!");
                view.lifeUsed.setText("Incorrect!");
            }
        }

        if (e.getSource() == view.answerD) 
        {
            view.lifeUsed.setText("");
            if (view.randomQuestion.isCorrect(AnswerEnum.D)) 
            {
                System.out.println("Correct!");
                view.lifeUsed.setText("Correct!");
                view.questions.remove(view.randomIndex);
                view.updateScreenIfCorrect();
                
                if(i == view.moneyLabels.length)
                {
                    System.out.println("Congratulations! You are now a millionaire");
                    System.out.println("Thank you for playing");
                }
                else
                {
                    view.moneyLabels[i].setForeground(Color.yellow);
                    i++;
                }
                view.repaint();
            } 
            else 
            {
                System.out.println("Incorrect!");
                view.lifeUsed.setText("Incorrect!");
            }
        }

    }
    
}
