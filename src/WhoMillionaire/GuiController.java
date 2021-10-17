/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

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
    public GuiModel model;
    public static DBManager dmb = new DBManager();
    public static DBSetup dbs = new DBSetup();
    
    public GuiController(GuiView view, GuiModel model)
    {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
        this.view.addMouseListener(this);
        model.createTable();
    }

    int i = 0;
    public static int score = 0;
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == view.answerA) 
        {
            if (view.randomQuestion.isCorrect(AnswerEnum.A)) 
            {
                System.out.println("Correct!");
                view.lifeUsed.setText("Correct!");
                view.questions.remove(view.randomIndex);
                view.updateScreenIfCorrect();
                
                if (score == 1100000) 
                {
                    score = 1000000;
                }
                else
                {
                    score += 100000;
                }
                
                view.repaint();

                if (i == view.moneyLabels.length) 
                {
                    System.out.println("Congratulations! You are now a millionaire");
                    System.out.println("Thank you for playing");
                    view.disableAnswerButtons();
                    view.disableLifeLines();
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
                view.lifeUsed.setText("Incorrect! Game Over!"+"\n"
                        + " Your Score: "+view.moneyLabels[i].getText());
                view.disableAnswerButtons();
                view.disableLifeLines();
            }
        }
        
        if (e.getSource() == view.answerB) 
        {         
            if (view.randomQuestion.isCorrect(AnswerEnum.B)) 
            {
                System.out.println("Correct!");
                view.lifeUsed.setText("Correct!");
                view.questions.remove(view.randomIndex);
                view.updateScreenIfCorrect();
                if (score == 1100000) 
                {
                    score = 1000000;
                }
                else
                {
                    score += 100000;
                }

                if (i == view.moneyLabels.length) 
                {
                    System.out.println("Congratulations! You are now a millionaire");
                    System.out.println("Thank you for playing");
                    view.disableAnswerButtons();
                    view.disableLifeLines();
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
                view.lifeUsed.setText("Incorrect! Game Over!"+"\n"
                        + " Your Score: "+view.moneyLabels[i].getText());
                view.disableAnswerButtons();
                view.disableLifeLines();
            }
        }
        
        if (e.getSource() == view.answerC) 
        {
            if (view.randomQuestion.isCorrect(AnswerEnum.C)) 
            {
                System.out.println("Correct!");
                view.lifeUsed.setText("Correct!");
                view.questions.remove(view.randomIndex);
                view.updateScreenIfCorrect();
                if (score == 1100000) 
                {
                    score = 1000000;
                }
                else
                {
                    score += 100000;
                }

                if (i == view.moneyLabels.length) 
                {
                    System.out.println("Congratulations! You are now a millionaire");
                    System.out.println("Thank you for playing");
                    view.disableAnswerButtons();
                    view.disableLifeLines();
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
                view.lifeUsed.setText("Incorrect! Game Over!"+"\n"
                        + " Your Score: "+view.moneyLabels[i].getText());
                view.disableAnswerButtons();
                view.disableLifeLines();
            }
        }

        if (e.getSource() == view.answerD) 
        {
            if (view.randomQuestion.isCorrect(AnswerEnum.D)) 
            {
                System.out.println("Correct!");
                view.lifeUsed.setText("Correct!");
                view.questions.remove(view.randomIndex);
                view.updateScreenIfCorrect();
                if (score == 1100000) 
                {
                    score = 1000000;
                }
                else
                {
                    score += 100000;
                }

                if (i == view.moneyLabels.length) 
                {
                    System.out.println("Congratulations! You are now a millionaire");
                    System.out.println("Thank you for playing");
                    view.disableAnswerButtons();
                    view.disableLifeLines();
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
                view.lifeUsed.setText("Incorrect! Game Over!"+"\n"
                        + " Your Score: "+view.moneyLabels[i].getText());
                view.disableAnswerButtons();
                view.disableLifeLines();
            }
        }
        
        if(e.getSource() == view.nameContinue)
        {
            Player.setName(view.playerName.getText());
            System.out.println("Player Name: "+Player.getName());
            view.startGame();
            score = 0;
            i = 0;
            view.resetMoney();
            view.repaint();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        Random rand2 = new Random();
        if (e.getComponent().equals(view.fiftyFifty) && view.fiftyFifty.isEnabled()) 
        {
            if(view.lifeOptions.get(0) == null)
            {
                System.out.println("You have already used this life line!");
                view.lifeUsed.setText("You have already used this lifeline!");
            }
            else
            {
                view.lifeOptions.set(0, null);

                System.out.println("50:50 Clicked!");
                view.lifeUsed.setText("You have chosen to use 50:50 life line!");
                ImageIcon fifty = new ImageIcon("./src/WhoMillionaire/Images/5050used.png");
                Image image2 = fifty.getImage();
                Image newImage2 = image2.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                ImageIcon newFifty = new ImageIcon(newImage2);
                view.fiftyFifty.setIcon(newFifty);

                for (int i = 0; i < 2; i++) 
                {
                    view.lifeOptions.set(0, null);
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

        if (e.getComponent().equals(view.friend) && view.friend.isEnabled()) 
        {
            if(view.lifeOptions.get(1) == null)
            {
                System.out.println("You have already used this lifeline!");
                view.lifeUsed.setText("You have already used this lifeline!");
            }
            else
            {
                System.out.println("Friend Clicked!");
                view.lifeUsed.setText("Your friend believes that the correct answer is option B!");
                view.lifeOptions.set(1, null);
                System.out.println("Your friend believes that the correct answer is option B!");
                ImageIcon friendOption = new ImageIcon("./src/WhoMillionaire/Images/Friendused.png");
                Image image2 = friendOption.getImage();
                Image newImage2 = image2.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                ImageIcon newFifty = new ImageIcon(newImage2);
                view.friend.setIcon(newFifty);
            }
            
        }

        if (e.getComponent().equals(view.audience) && view.audience.isEnabled()) 
        {
            if(view.lifeOptions.get(2) == null)
            {
                System.out.println("You have already used this lifeline!");
                view.lifeUsed.setText("You have already used this lifeline!");
            }
            else
            {
                view.lifeUsed.setText("50% voted B. 25% voted D. 25% did not vote!");
                view.lifeOptions.set(2,null);
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
        
        if(e.getComponent().equals(view.start))
        {
            model.connect();
            view.enterNameScreen();
        }
        
        if(e.getComponent().equals(view.instructions))
        {
            view.instructionsScreen();
        }
        
        if(e.getComponent().equals(view.quit))
        {
            model.executeStatement();
            model.closeConn();
            view.quitGame();
        }
        
        if(e.getComponent().equals(view.backFromGame))
        {
            view.MainMenu();
            //view.repaint();
        }
        
        if(e.getComponent().equals(view.backFromInst))
        {
            view.MainMenu();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        if(e.getComponent().equals(view.start))
        {
            view.start.setForeground(Color.yellow);
        }
        
        if(e.getComponent().equals(view.instructions))
        {
            view.instructions.setForeground(Color.yellow);
        }
        
        if(e.getComponent().equals(view.quit))
        {
            view.quit.setForeground(Color.yellow);
        }
        
        if(e.getComponent().equals(view.backFromGame))
        {
            view.backFromGame.setForeground(Color.yellow);
        }
        
        if(e.getComponent().equals(view.backFromInst))
        {
            view.backFromInst.setForeground(Color.yellow);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        if(e.getComponent().equals(view.start))
        {
            view.start.setForeground(Color.lightGray);
        }
        
        if(e.getComponent().equals(view.instructions))
        {
            view.instructions.setForeground(Color.lightGray);
        }
        
        if(e.getComponent().equals(view.quit))
        {
            view.quit.setForeground(Color.lightGray);
        }
        
        if(e.getComponent().equals(view.backFromGame))
        {
            view.backFromGame.setForeground(Color.lightGray);
        }
        
        if(e.getComponent().equals(view.backFromInst))
        {
            view.backFromInst.setForeground(Color.lightGray);
        }
    }
    
}
