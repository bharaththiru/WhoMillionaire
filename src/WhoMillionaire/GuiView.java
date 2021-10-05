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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
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
import javax.swing.JTextField;

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
    //Scanner scan = new Scanner(System.in);

    static List<Answers> answersText;

    JButton answerA = new JButton();
    JButton answerB = new JButton();
    JButton answerC = new JButton();
    JButton answerD = new JButton();
    JButton finalYes = new JButton("YES");
    JButton finalNo = new JButton("NO");
    JButton nameContinue = new JButton ("Continue");

    private JLabel main = new JLabel("");
    JLabel fiftyFifty = new JLabel("");
    JLabel audience = new JLabel("");
    JLabel friend = new JLabel("");
    private JLabel question = new JLabel("Question");
    JLabel lifeUsed = new JLabel("");
    JLabel menuTitle = new JLabel("Who Wants To Be A Millionaire");
    JLabel start = new JLabel("Start Game");
    JLabel instructions = new JLabel("Instructions");
    JLabel quit = new JLabel("Quit");
    JLabel backFromGame = new JLabel("Back");
    JLabel backFromInst = new JLabel("Back");
    private JLabel author = new JLabel("By: Bharath Thirunahari");

    private JTextArea instructionDesc = new JTextArea();
    JTextField playerName = new JTextField("Enter your name.");
    
    private String[] money = {"$100000", "$200000", "$300000", "$400000", "$500000", "$600000", "$700000", "$800000", "$900000", "$950000", "$1000000"};
    
    JLabel[] moneyLabels = new JLabel[money.length];
    private JPanel answerButtons = new JPanel();
    private JPanel questionPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel lifeLines = new JPanel();
    private JPanel moneyPanel = new JPanel();
    private JPanel finalPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private JPanel leftPanel;
    private JPanel mainMenuPanel = new JPanel(new GridBagLayout());
    private JPanel instructionsPanel = new JPanel();
    private JPanel menuTitlePanel = new JPanel();
    private JPanel authorPanel = new JPanel(new BorderLayout());
    private JPanel namePanel = new JPanel(new BorderLayout());
    private GridBagConstraints mainMenuGbc = new GridBagConstraints();
    
    public GuiView()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,500);
        this.setLocationRelativeTo(null);
        this.MainMenu();
        this.setVisible(true);
    }
    
    public void MainMenu()
    {
        menuTitle.setFont(new Font(menuTitle.getFont().getName(), menuTitle.getFont().getSize(), 50));
        menuTitle.setForeground(Color.white);
        menuTitlePanel.setBackground(Color.black);
        menuTitlePanel.add(menuTitle);
        
        author.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        author.setForeground(Color.lightGray);
        authorPanel.setBackground(Color.black);
        authorPanel.add(author, BorderLayout.WEST);
        
        mainMenuPanel.setLayout(new GridBagLayout());
        mainMenuPanel.setBackground(Color.black);
        mainMenuPanel.setBorder(BorderFactory.createLineBorder(Color.blue, 10));
        //gbc for start button:
        mainMenuGbc.gridx = this.getWidth()/2;
        mainMenuGbc.gridy = 100;
        mainMenuGbc.gridheight = 50;
        mainMenuGbc.insets = new Insets(30,30,30,30);
        start.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        start.setForeground(Color.lightGray);
        mainMenuPanel.add(start, mainMenuGbc);
        
        //gbc for instructions button:
        mainMenuGbc.gridx = this.getWidth()/2;
        mainMenuGbc.gridy = 200;
        mainMenuGbc.gridheight = 50;
        instructions.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        instructions.setForeground(Color.lightGray);
        mainMenuPanel.add(instructions, mainMenuGbc);
        
        //gbc for start button:
        mainMenuGbc.gridx = this.getWidth()/2;
        mainMenuGbc.gridy = 300;
        mainMenuGbc.gridheight = 50;
        quit.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        quit.setForeground(Color.lightGray);
        mainMenuPanel.add(quit, mainMenuGbc);
        
        backFromGame.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        backFromGame.setForeground(Color.lightGray);
        
        backFromInst.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        backFromInst.setForeground(Color.lightGray);
        
        mainMenuPanel.setVisible(true);
        menuTitlePanel.setVisible(true);
        authorPanel.setVisible(true);
        
        this.getContentPane().removeAll();
        this.add(menuTitlePanel, BorderLayout.NORTH);
        this.add(authorPanel, BorderLayout.SOUTH);
        this.add(mainMenuPanel);
        
        this.revalidate();
        this.repaint();
    }
    
    public void enterNameScreen()
    {
        namePanel.setBackground(Color.black);
        namePanel.add(playerName, BorderLayout.NORTH);
        namePanel.add(nameContinue, BorderLayout.SOUTH);
        namePanel.setVisible(true);
        
        this.getContentPane().removeAll();
        this.add(namePanel);
        this.validate();
        this.repaint();
        
    }
    
    public void startGame()
    {
        this.getContentPane().removeAll();
        
        questions = functions.loadQuestions();
        randomIndex = rand.nextInt(questions.size());
        randomQuestion = questions.get(randomIndex);
        answersText = randomQuestion.getAnswers();
        answersEnums = randomQuestion.getAnsTokens();
        methods = new GameMethods();
        
        lifeOptions.addAll(Arrays.asList(LifeLines.values()));
        
        answerButtons.setLayout(new GridLayout(2, 2));
        answerButtons.setBounds(100, 250, 300, 100);
        
        finalPanel.setBackground(Color.black);
        //finalPanel.setLayout(new GridLayout(1,2));

        
        southPanel.setLayout(new BorderLayout());
        southPanel.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        southPanel.setBackground(Color.black);
        southPanel.setPreferredSize(new Dimension(500, 135));
        
        moneyPanel.setLayout(new GridLayout(12, 1));
        moneyPanel.setBackground(Color.black);
        moneyPanel.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        
        answerA.setText(answersText.get(0).getToken() + ". " + answersText.get(0).getAnswer());
        answerB.setText(answersText.get(1).getToken() + ". " + answersText.get(1).getAnswer());
        answerC.setText(answersText.get(2).getToken() + ". " + answersText.get(2).getAnswer());
        answerD.setText(answersText.get(3).getToken() + ". " + answersText.get(3).getAnswer());
        finalYes.setSize(20, 30);
        finalNo.setSize(20,30);
        
        question.setFont(new Font(question.getFont().getFontName(), question.getFont().getStyle(), 17));
        question.setForeground(Color.white);;
        question.setText(methods.displayQuestion(randomQuestion));
        question.setHorizontalAlignment(JLabel.CENTER);
        
        lifeUsed.setFont(new Font(question.getFont().getName(), question.getFont().getSize(), 17));
        lifeUsed.setForeground(Color.white);
        lifeUsed.setHorizontalAlignment(JLabel.CENTER);
        
        ImageIcon logo = new ImageIcon("./src/WhoMillionaire/Images/main logo.png");
        Image image1 = logo.getImage();
        Image newImage1 = image1.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon newLogo = new ImageIcon(newImage1);
        main.setIcon(newLogo);
        
        ImageIcon fifty = new ImageIcon("./src/WhoMillionaire/Images/5050.png");
        Image image2 = fifty.getImage();
        Image newImage2 = image2.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon newFifty = new ImageIcon(newImage2);
        fiftyFifty.setIcon(newFifty);
        fiftyFifty.setText("50:50");
        fiftyFifty.setForeground(Color.lightGray);
        
        ImageIcon aud = new ImageIcon("./src/WhoMillionaire/Images/audience.png");
        Image image3 = aud.getImage();
        Image newImage3 = image3.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon newAud = new ImageIcon(newImage3);
        audience.setIcon(newAud);
        audience.setText("Ask Audience");
        audience.setForeground(Color.lightGray);
        
        ImageIcon fri = new ImageIcon("./src/WhoMillionaire/Images/friend.png");
        Image image4 = fri.getImage();
        Image newImage4 = image4.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon newFri = new ImageIcon(newImage4);
        friend.setIcon(newFri);
        friend.setText("Phone Friend");
        friend.setForeground(Color.lightGray);
        
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
        
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.black);
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.blue, 10));
        
        lifeLines.add(fiftyFifty);
        lifeLines.add(audience);
        lifeLines.add(friend);
        lifeLines.setBackground(Color.black);
        
        centerPanel.add(answerButtons, BorderLayout.CENTER);
        centerPanel.add(finalPanel, BorderLayout.SOUTH);
        
        questionPanel.setLayout(new BorderLayout());
        centerPanel.add(question, BorderLayout.NORTH);
        southPanel.add(lifeUsed, BorderLayout.CENTER);
        southPanel.add(quit, BorderLayout.EAST);
        southPanel.add(backFromGame, BorderLayout.WEST);
        
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
        instructionsPanel.add(backFromInst, BorderLayout.SOUTH);
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
        nameContinue.addActionListener(listener);
    }
    
    public void addMouseListener(MouseListener mouse)
    {
        fiftyFifty.addMouseListener(mouse);
        audience.addMouseListener(mouse);
        friend.addMouseListener(mouse);
        start.addMouseListener(mouse);
        instructions.addMouseListener(mouse);
        quit.addMouseListener(mouse);
        backFromGame.addMouseListener(mouse);
        backFromInst.addMouseListener(mouse);
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
     
    @Override
    public void update(Observable o, Object arg) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
