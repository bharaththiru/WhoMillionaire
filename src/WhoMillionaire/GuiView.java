/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

import static WhoMillionaire.GUI.lifeOptions;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author bhara
 */
public class GuiView extends JFrame implements Observer
{
    private static GameFunctions functions;
    private static GameMethods methods;
    private static Questions ques;
    static Questions randomQuestion;
    static List<Questions> questions;
    private static Set<AnswerEnum> answersEnums;
    public static List<LifeLines> lifeOptions = new ArrayList<>();
    private static Answers a;
    private static int rows = 2;
    private static int cols = 2;
    static int randomIndex = -1;
    private static Random rand = new Random();

    private static List<Answers> answersText;

    JButton answerA;
    JButton answerB;
    JButton answerC;
    JButton answerD;
    private JButton finalYes;
    private JButton finalNo;
    private JButton start = new JButton("Start Game");
    private JButton instructions = new JButton ("Instructions");
    private JButton quit = new JButton("Quit");

    private JLabel main;
    private JLabel fiftyFifty;
    private JLabel audience;
    private JLabel friend;
    private JLabel question;
    JLabel lifeUsed;
    
    private JTextArea instructionDesc = new JTextArea();
    
    private String[] money = {"$100000", "$200000", "$300000", "$400000", "$500000", "$600000", "$700000", "$800000", "$900000", "$950000", "$1000000"};
    
    JLabel[] moneyLabels;
    private JPanel answerButtons;
    private JPanel questionPanel;
    private JPanel centerPanel;
    private JPanel lifeLines;
    private JPanel moneyPanel;
    private JPanel finalPanel;
    private JPanel southPanel;
    private JPanel leftPanel;
    private JPanel mainMenuPanel;
    private JPanel instructionsPanel;
    
    public GuiView()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        mainMenuPanel.add(start);
        mainMenuPanel.add(instructions);
        mainMenuPanel.add(quit);
    }
    
    public void startGame()
    {
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

        answerB = new JButton();
        answerB.setText(answersText.get(1).getToken() + ". " + answersText.get(1).getAnswer());

        answerC = new JButton();
        answerC.setText(answersText.get(2).getToken() + ". " + answersText.get(2).getAnswer());

        answerD = new JButton();
        answerD.setText(answersText.get(3).getToken() + ". " + answersText.get(3).getAnswer());
        
        finalYes = new JButton("YES");
        finalYes.setSize(20, 30);
        
        finalNo = new JButton("NO");
        finalNo.setSize(20,30);

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

        audience = new JLabel("");
        ImageIcon aud = new ImageIcon("./src/WhoMillionaire/Images/audience.png");
        Image image3 = aud.getImage();
        Image newImage3 = image3.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon newAud = new ImageIcon(newImage3);
        audience.setIcon(newAud);
        audience.setText("Ask Audience");
        audience.setForeground(Color.lightGray);

        friend = new JLabel("");
        ImageIcon fri = new ImageIcon("./src/WhoMillionaire/Images/friend.png");
        Image image4 = fri.getImage();
        Image newImage4 = image4.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon newFri = new ImageIcon(newImage4);
        friend.setIcon(newFri);
        friend.setText("Phone Friend");
        friend.setForeground(Color.lightGray);

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
        
        this.getContentPane().removeAll();
        southPanel.setVisible(true);
        centerPanel.setVisible(true);
        lifeLines.setVisible(true);
        moneyPanel.setVisible(true);
        
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(lifeLines, BorderLayout.NORTH);
        //this.add(southPanel, BorderLayout.EAST);
        this.add(moneyPanel, BorderLayout.EAST);
        
        this.revalidate();
        this.repaint();
    }
    
    public void instructionsScreen()
    {
        instructionsPanel.add(instructionDesc);
        instructionDesc.setText("How to play!");
        
        this.getContentPane().removeAll();
        instructionsPanel.setVisible(true);
        this.add(instructionsPanel);
        
        this.revalidate();
        this.repaint();
    }
    
    public void quitGame()
    {
        System.exit(0);
    }
    
    public void addActionListener(ActionListener listener)
    {
        answerA.addActionListener(listener);
        answerB.addActionListener(listener);
        answerC.addActionListener(listener);
        answerD.addActionListener(listener);
        finalYes.addActionListener(listener);
        finalNo.addActionListener(listener);
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
    
    public void addMouseListener(MouseListener mouse)
    {
        fiftyFifty.addMouseListener(mouse);
        audience.addMouseListener(mouse);
        friend.addMouseListener(mouse);
    }

    @Override
    public void update(Observable o, Object arg) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
