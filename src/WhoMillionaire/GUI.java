/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author bhara
 */
public class GUI extends JPanel implements ActionListener, MouseListener 
{

    private static GameFunctions functions;
    private static GameMethods methods;
    private static Questions ques;
    private static Questions randomQuestion;
    private static List<Questions> questions;
    private static Set<AnswerEnum> answersEnums;
    public static List<LifeLines> lifeOptions = new ArrayList<>();
    private static Answers a;
    private static int rows = 2;
    private static int cols = 2;
    private static int randomIndex = -1;
    private static Random rand = new Random();

    private static List<Answers> answersText;

    private JButton answerA;
    private JButton answerB;
    private JButton answerC;
    private JButton answerD;
    private JButton finalYes;
    private JButton finalNo;

    private JLabel main;
    private JLabel fiftyFifty;
    private JLabel audience;
    private JLabel friend;
    private JLabel question;
    private JLabel lifeUsed;
    
    private String[] money = {"$100000", "$200000", "$300000", "$400000", "$500000", "$600000", "$700000", "$800000", "$900000", "$950000", "$1000000"};
    
    private JLabel[] moneyLabels;
    private JPanel answerButtons;
    private JPanel questionPanel;
    private JPanel centerPanel;
    private JPanel lifeLines;
    private JPanel moneyPanel;
    private JPanel finalPanel;
    private JPanel southPanel;
    private JPanel leftPanel;
    
    public GUI() {
        super(new BorderLayout());
        questions = functions.loadQuestions();
        randomIndex = rand.nextInt(questions.size());
        randomQuestion = questions.get(randomIndex);
        answersText = randomQuestion.getAnswers();
        answersEnums = randomQuestion.getAnsTokens();
        methods = new GameMethods();
        
        lifeOptions.addAll(Arrays.asList(LifeLines.values()));

        answerButtons = new JPanel();
        answerButtons.setLayout(new GridLayout(2, 2));
        answerButtons.setBounds(100, 250, 300, 100);
        
        finalPanel = new JPanel();
        finalPanel.setBackground(Color.black);
        //finalPanel.setLayout(new GridLayout(1,2));
        
        southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        southPanel.setBackground(Color.black);
        southPanel.setPreferredSize(new Dimension(500, 135));

        moneyPanel = new JPanel();
        moneyPanel.setLayout(new GridLayout(12, 1));
        moneyPanel.setBackground(Color.black);
        moneyPanel.setBorder(BorderFactory.createLineBorder(Color.black, 10));

        answerA = new JButton();
        answerA.setText(answersText.get(0).getToken() + ". " + answersText.get(0).getAnswer());
        answerA.addActionListener(this);

        answerB = new JButton();
        answerB.setText(answersText.get(1).getToken() + ". " + answersText.get(1).getAnswer());
        answerB.addActionListener(this);

        answerC = new JButton();
        answerC.setText(answersText.get(2).getToken() + ". " + answersText.get(2).getAnswer());
        answerC.addActionListener(this);

        answerD = new JButton();
        answerD.setText(answersText.get(3).getToken() + ". " + answersText.get(3).getAnswer());
        answerD.addActionListener(this);
        
        finalYes = new JButton("YES");
        finalYes.setSize(20, 30);
        finalYes.addActionListener(this);
        
        finalNo = new JButton("NO");
        finalNo.setSize(20,30);
        finalNo.addActionListener(this);

        question = new JLabel("Question");
        question.setFont(new Font(question.getFont().getFontName(), question.getFont().getStyle(), 17));
        question.setForeground(Color.white);;
        question.setText(methods.displayQuestion(randomQuestion));
        question.setHorizontalAlignment(JLabel.CENTER);
        
        lifeUsed = new JLabel("");
        lifeUsed.setFont(new Font(question.getFont().getName(), question.getFont().getSize(), 17));
        lifeUsed.setForeground(Color.white);
        lifeUsed.setHorizontalAlignment(JLabel.CENTER);

        main = new JLabel("");
        ImageIcon logo = new ImageIcon("./src/WhoMillionaire/Images/main logo.png");
        Image image1 = logo.getImage();
        Image newImage1 = image1.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon newLogo = new ImageIcon(newImage1);
        main.setIcon(newLogo);

        fiftyFifty = new JLabel("");
        ImageIcon fifty = new ImageIcon("./src/WhoMillionaire/Images/5050.png");
        Image image2 = fifty.getImage();
        Image newImage2 = image2.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon newFifty = new ImageIcon(newImage2);
        fiftyFifty.setIcon(newFifty);
        fiftyFifty.setText("50:50");
        fiftyFifty.setForeground(Color.lightGray);
        fiftyFifty.addMouseListener(this);

        audience = new JLabel("");
        ImageIcon aud = new ImageIcon("./src/WhoMillionaire/Images/audience.png");
        Image image3 = aud.getImage();
        Image newImage3 = image3.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon newAud = new ImageIcon(newImage3);
        audience.setIcon(newAud);
        audience.setText("Ask Audience");
        audience.setForeground(Color.lightGray);
        audience.addMouseListener(this);

        friend = new JLabel("");
        ImageIcon fri = new ImageIcon("./src/WhoMillionaire/Images/friend.png");
        Image image4 = fri.getImage();
        Image newImage4 = image4.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon newFri = new ImageIcon(newImage4);
        friend.setIcon(newFri);
        friend.setText("Phone Friend");
        friend.setForeground(Color.lightGray);
        friend.addMouseListener(this);

        moneyLabels = new JLabel[money.length];
        for (int i = 0; i < money.length; i++) 
        {
            moneyLabels[i] = new JLabel();
            moneyLabels[i].setText(money[i]);
            moneyLabels[i].setFont(new Font(moneyLabels[i].getFont().getFontName(), moneyLabels[i].getFont().getSize(), 20));
            moneyLabels[i].setForeground(Color.white);
        }

        int i = moneyLabels.length - 1;
        while (i >= 0) {
            moneyPanel.add(moneyLabels[i]);
            i--;
        }
        
        answerButtons.add(answerA);
        answerButtons.add(answerB);
        answerButtons.add(answerC);
        answerButtons.add(answerD);
        
        finalPanel.add(finalYes);
        finalPanel.add(finalNo);

        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.black);
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.blue, 10));

        lifeLines = new JPanel();
        lifeLines.add(fiftyFifty);
        lifeLines.add(audience);
        lifeLines.add(friend);
        lifeLines.setBackground(Color.black);
        
        centerPanel.add(answerButtons, BorderLayout.CENTER);
        centerPanel.add(finalPanel, BorderLayout.SOUTH);

        questionPanel = new JPanel();
        questionPanel.setLayout(new BorderLayout());
        centerPanel.add(question, BorderLayout.NORTH);
        southPanel.add(lifeUsed, BorderLayout.CENTER);

        this.add(southPanel, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(lifeLines, BorderLayout.NORTH);
        //this.add(southPanel, BorderLayout.EAST);
        this.add(moneyPanel, BorderLayout.EAST);
    }
    
    int i = 0;
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        if (e.getSource() == answerA) 
        {
            lifeUsed.setText("");
            if (randomQuestion.isCorrect(AnswerEnum.A)) 
            {
                System.out.println("Correct!");
                lifeUsed.setText("Correct!");
                questions.remove(randomIndex);
                updateScreenIfCorrect();
                this.repaint();
                
                if(i == moneyLabels.length)
                {
                    System.out.println("Congratulations! You are now a millionaire");
                    System.out.println("Thank you for playing");
                }
                else
                {
                    moneyLabels[i].setForeground(Color.yellow);
                    i++;
                }
               
            } 
            else 
            {
                System.out.println("Incorrect!");
                lifeUsed.setText("Incorrect!");
            }

        }

        if (e.getSource() == answerB) 
        {
            lifeUsed.setText("");
            if (randomQuestion.isCorrect(AnswerEnum.B)) 
            {
                System.out.println("Correct!");
                lifeUsed.setText("Correct!");
                questions.remove(randomIndex);
                updateScreenIfCorrect();
                
                if(i == moneyLabels.length)
                {
                    System.out.println("Congratulations! You are now a millionaire");
                    System.out.println("Thank you for playing");
                }
                else
                {
                    moneyLabels[i].setForeground(Color.yellow);
                    i++;
                }
            } 
            else 
            {
                System.out.println("Incorrect!");
                lifeUsed.setText("Incorrect!");
            }
        }

        if (e.getSource() == answerC) 
        {
            lifeUsed.setText("");
            if (randomQuestion.isCorrect(AnswerEnum.C)) 
            {
                System.out.println("Correct!");
                lifeUsed.setText("Correct!");
                questions.remove(randomIndex);
                updateScreenIfCorrect();
                
                if(i == moneyLabels.length)
                {
                    System.out.println("Congratulations! You are now a millionaire");
                    System.out.println("Thank you for playing");
                }
                else
                {
                    moneyLabels[i].setForeground(Color.yellow);
                    i++;
                }
            } 
            else 
            {
                System.out.println("Incorrect!");
                lifeUsed.setText("Incorrect!");
            }
        }

        if (e.getSource() == answerD) 
        {
            lifeUsed.setText("");
            if (randomQuestion.isCorrect(AnswerEnum.D)) 
            {
                System.out.println("Correct!");
                lifeUsed.setText("Correct!");
                questions.remove(randomIndex);
                updateScreenIfCorrect();
                
                if(i == moneyLabels.length)
                {
                    System.out.println("Congratulations! You are now a millionaire");
                    System.out.println("Thank you for playing");
                }
                else
                {
                    moneyLabels[i].setForeground(Color.yellow);
                    i++;
                }
                this.repaint();
            } 
            else 
            {
                System.out.println("Incorrect!");
                lifeUsed.setText("Incorrect!");
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        Random rand2 = new Random();
        if (e.getComponent().equals(fiftyFifty)) 
        {
            if(lifeOptions.get(0) == null)
            {
                System.out.println("You have already used this life line!");
                lifeUsed.setText("You have already used this lifeline!");
            }
            else
            {
                lifeOptions.set(0, null);

                System.out.println("50:50 Clicked!");
                lifeUsed.setText("You have chosen to use 50:50 life line!");
                ImageIcon fifty = new ImageIcon("./src/WhoMillionaire/Images/5050used.png");
                Image image2 = fifty.getImage();
                Image newImage2 = image2.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                ImageIcon newFifty = new ImageIcon(newImage2);
                fiftyFifty.setIcon(newFifty);

                for (int i = 0; i < 2; i++) 
                {
                    lifeOptions.set(0, null);
                    List<Answers> incorrectAns = randomQuestion.getWrongAnswers();
                    int randIndex = rand2.nextInt(randomQuestion.getWrongAnswers().size());
                    Answers randomAns = incorrectAns.get(randIndex);
                    randomQuestion.removeAnswer(randomAns);

                    if (answersText.get(0).getToken() == randomAns.getToken()) 
                    {
                        answerA.setText("");
                    } else if (answersText.get(1).getToken() == randomAns.getToken()) 
                    {
                        answerB.setText("");
                    } else if (answersText.get(2).getToken() == randomAns.getToken()) 
                    {
                        answerC.setText("");
                    } else if (answersText.get(3).getToken() == randomAns.getToken()) 
                    {
                        answerD.setText("");
                    }
                }
            }
        }

        if (e.getComponent().equals(friend)) 
        {
            if(lifeOptions.get(1) == null)
            {
                System.out.println("You have already used this lifeline!");
            }
            else
            {
                System.out.println("Friend Clicked!");
                lifeUsed.setText("Your friend believes that the correct answer is option B!");
                lifeOptions.set(1, null);
                System.out.println("Your friend believes that the correct answer is option B!");
                ImageIcon friendOption = new ImageIcon("./src/WhoMillionaire/Images/Friendused.png");
                Image image2 = friendOption.getImage();
                Image newImage2 = image2.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                ImageIcon newFifty = new ImageIcon(newImage2);
                friend.setIcon(newFifty);
            }
            
        }

        if (e.getComponent().equals(audience)) 
        {
            if(lifeOptions.get(2) == null)
            {
                System.out.println("You have already used this lifeline!");
            }
            else
            {
                lifeUsed.setText("50% voted B. 25% voted D. 25% did not vote!");
                lifeOptions.set(2,null);
                System.out.println("Audience clicked!");
                System.out.println("50% of the audience voted for option B!");
                System.out.println("25% of the audiece voted for option D!");
                System.out.println("25% of the audience did not vote!");
                ImageIcon audOption = new ImageIcon("./src/WhoMillionaire/Images/Audienceused.png");
                Image image2 = audOption.getImage();
                Image newImage2 = image2.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                ImageIcon newFifty = new ImageIcon(newImage2);
                audience.setIcon(newFifty);
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

    public void updateScreenIfCorrect() 
    {
        if(questions.size() == 0)
        {
            System.out.println("No more questions left!");
            System.out.println("Congratulations! You are now a millionaire");
            System.out.println("Thank you for playing");
            
            lifeUsed.setText("Congratulations! You are now a millionaire");
        }
        else
        {
            randomIndex = rand.nextInt(questions.size());
            randomQuestion = questions.get(randomIndex);
            answersText = randomQuestion.getAnswers();
            question.setText(randomQuestion.getQuestion());
            answerA.setText(answersText.get(0).getToken() + ". " + answersText.get(0).getAnswer());
            answerB.setText(answersText.get(1).getToken() + ". " + answersText.get(1).getAnswer());
            answerC.setText(answersText.get(2).getToken() + ". " + answersText.get(2).getAnswer());
            answerD.setText(answersText.get(3).getToken() + ". " + answersText.get(3).getAnswer());
        }
        
    }

    public static void main(String[] args) 
    {
        JFrame game = new JFrame("Who Wants To Be A Millionaire");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.getContentPane().add(new GUI());
        game.setSize(800, 600);
        game.pack();
        game.setVisible(true);
    }
}
