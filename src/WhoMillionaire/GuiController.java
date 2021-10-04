/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

import static WhoMillionaire.GUI.lifeOptions;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author bhara
 */
public class GuiController implements ActionListener, MouseListener
{
    public GuiView view;
    
    public GuiController(GuiView view)
    {
        this.view = view;
        this.view.addActionListener(this);
        this.view.addMouseListener(this);
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

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        Random rand2 = new Random();
        if (e.getComponent().equals(view.fiftyFifty)) 
        {
            if(lifeOptions.get(0) == null)
            {
                System.out.println("You have already used this life line!");
                view.lifeUsed.setText("You have already used this lifeline!");
            }
            else
            {
                lifeOptions.set(0, null);

                System.out.println("50:50 Clicked!");
                view.lifeUsed.setText("You have chosen to use 50:50 life line!");
                ImageIcon fifty = new ImageIcon("./src/WhoMillionaire/Images/5050used.png");
                Image image2 = fifty.getImage();
                Image newImage2 = image2.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                ImageIcon newFifty = new ImageIcon(newImage2);
                view.fiftyFifty.setIcon(newFifty);

                for (int i = 0; i < 2; i++) 
                {
                    lifeOptions.set(0, null);
                    List<Answers> incorrectAns = view.randomQuestion.getWrongAnswers();
                    int randIndex = rand2.nextInt(view.randomQuestion.getWrongAnswers().size());
                    Answers randomAns = incorrectAns.get(randIndex);
                    view.randomQuestion.removeAnswer(randomAns);

                    if (view.answersText.get(0).getToken() == randomAns.getToken()) 
                    {
                        view.answerA.setText("");
                    } else if (view.answersText.get(1).getToken() == randomAns.getToken()) 
                    {
                        view.answerB.setText("");
                    } else if (view.answersText.get(2).getToken() == randomAns.getToken()) 
                    {
                        view.answerC.setText("");
                    } else if (view.answersText.get(3).getToken() == randomAns.getToken()) 
                    {
                        view.answerD.setText("");
                    }
                }
            }
        }

        if (e.getComponent().equals(view.friend)) 
        {
            if(lifeOptions.get(1) == null)
            {
                System.out.println("You have already used this lifeline!");
            }
            else
            {
                System.out.println("Friend Clicked!");
                view.lifeUsed.setText("Your friend believes that the correct answer is option B!");
                lifeOptions.set(1, null);
                System.out.println("Your friend believes that the correct answer is option B!");
                ImageIcon friendOption = new ImageIcon("./src/WhoMillionaire/Images/Friendused.png");
                Image image2 = friendOption.getImage();
                Image newImage2 = image2.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                ImageIcon newFifty = new ImageIcon(newImage2);
                view.friend.setIcon(newFifty);
            }
            
        }

        if (e.getComponent().equals(view.audience)) 
        {
            if(lifeOptions.get(2) == null)
            {
                System.out.println("You have already used this lifeline!");
            }
            else
            {
                view.lifeUsed.setText("50% voted B. 25% voted D. 25% did not vote!");
                lifeOptions.set(2,null);
                System.out.println("Audience clicked!");
                System.out.println("50% of the audience voted for option B!");
                System.out.println("25% of the audiece voted for option D!");
                System.out.println("25% of the audience did not vote!");
                ImageIcon audOption = new ImageIcon("./src/WhoMillionaire/Images/Audienceused.png");
                Image image2 = audOption.getImage();
                Image newImage2 = image2.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                ImageIcon newFifty = new ImageIcon(newImage2);
                view.audience.setIcon(newFifty);
            }
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
