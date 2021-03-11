package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {

    private final JFrame frame;
    private JLabel labelOp;
    private JTextField textPol1;
    private JTextField textPol2;
    private JTextField textResult;
    private JButton buttonAddition;
    private JButton buttonSubstract;
    private JButton buttonMultiplication;
    private JButton buttonDivison;
    private JButton buttonDerivation;
    private JButton buttonIntegration;
    private JButton buttonEquals;


    public View() {
        frame = new JFrame("Polynomial Calculator");
        frame.getContentPane().setBackground(new Color(106, 90, 205));
        frame.setBounds(100, 100, 1000, 600);
        frame.getContentPane().setLayout(null);

        labels();
        textFields();
        buttons();
        frame.setVisible(true);
    }
    private void labels() {
        JLabel labelPol1 = new JLabel("Polynomial 1:");
        labelPol1.setForeground(new Color(192, 192, 192));
        labelPol1.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPol1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelPol1.setBounds(10, 10, 100, 50);
        frame.getContentPane().add(labelPol1);

        JLabel labelPol2 = new JLabel("Polynomial 2:");
        labelPol2.setForeground(new Color(192, 192, 192));
        labelPol2.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPol2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelPol2.setBounds(10, 110, 100, 50);
        frame.getContentPane().add(labelPol2);

        JLabel labelRezultat = new JLabel("Result:");
        labelRezultat.setForeground(new Color(192, 192, 192));
        labelRezultat.setHorizontalAlignment(SwingConstants.RIGHT);
        labelRezultat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelRezultat.setBounds(10, 210, 100, 50);
        frame.getContentPane().add(labelRezultat);

        labelOp = new JLabel("Sign");
        labelOp.setForeground(new Color(192, 192, 192));
        labelOp.setHorizontalAlignment(SwingConstants.CENTER);
        labelOp.setFont(new Font("Tahoma", Font.PLAIN, 40));
        labelOp.setBounds(400, 60, 300, 50);
        frame.getContentPane().add(labelOp);

        JLabel labelEgal = new JLabel("=");
        labelEgal.setForeground(new Color(192, 192, 192));
        labelEgal.setHorizontalAlignment(SwingConstants.CENTER);
        labelEgal.setFont(new Font("Tahoma", Font.PLAIN, 40));
        labelEgal.setBounds(499, 162, 100, 50);
        frame.getContentPane().add(labelEgal);
    }
    private void textFields() {
        textPol1 = new JTextField();
        textPol1.setForeground(new Color(0, 128, 0));
        textPol1.setBackground(new Color(255, 255, 255));
        textPol1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textPol1.setColumns(100);
        textPol1.setBounds(120, 10, 850, 50);
        frame.getContentPane().add(textPol1);


        textPol2 = new JTextField();
        textPol2.setForeground(new Color(0, 128, 0));
        textPol2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textPol2.setColumns(10);
        textPol2.setBounds(120, 110, 850, 50);
        frame.getContentPane().add(textPol2);

        textResult = new JTextField();
        textResult.setForeground(new Color(0, 0, 205));
        textResult.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textResult.setBounds(120, 210, 850, 50);
        frame.getContentPane().add(textResult);
        textResult.setColumns(10);
    }
    private void buttons() {
        buttonAddition = new JButton("+");
        buttonAddition.setFont(new Font("Tahoma", Font.PLAIN, 40));
        buttonAddition.setBounds(10, 300, 100, 70);
        frame.getContentPane().add(buttonAddition);

        buttonSubstract = new JButton("-");
        buttonSubstract.setFont(new Font("Tahoma", Font.PLAIN, 40));
        buttonSubstract.setBounds(10, 425, 100, 70);
        frame.getContentPane().add(buttonSubstract);

        buttonMultiplication = new JButton("X");
        buttonMultiplication.setFont(new Font("Tahoma", Font.PLAIN, 40));
        buttonMultiplication.setBounds(230, 300, 100, 70);
        frame.getContentPane().add(buttonMultiplication);

        buttonDivison = new JButton("/");
        buttonDivison.setFont(new Font("Tahoma", Font.PLAIN, 40));
        buttonDivison.setBounds(230, 425, 100, 70);
        frame.getContentPane().add(buttonDivison);

        buttonDerivation = new JButton("Derivation");
        buttonDerivation.setFont(new Font("Tahoma", Font.PLAIN, 25));
        buttonDerivation.setBounds(430, 300, 170, 70);
        frame.getContentPane().add(buttonDerivation);

        buttonIntegration = new JButton("Integration");
        buttonIntegration.setFont(new Font("Tahoma", Font.PLAIN, 24));
        buttonIntegration.setBounds(430, 425, 170, 70);
        frame.getContentPane().add(buttonIntegration);

        buttonEquals = new JButton("=");
        buttonEquals.setFont(new Font("Tahoma", Font.PLAIN, 60));
        buttonEquals.setBounds(730, 301, 235, 195);
        frame.getContentPane().add(buttonEquals);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //  ----- METHODS TO GET THE STRING ( POLYNOMIALS ) FROM THE TEXT FIELDS ----- //
    public String getPol1(){
        return this.textPol1.getText();
    }
    public String getPol2(){
        return this.textPol2.getText();
    }

    //  -------- GET/SET THE SIGN AFTER YOU PRESS THE OPERATION YOU WANT -------- //
    public String getOp(){
        return this.labelOp.getText();
    }
    public void setOp(String op){
        this.labelOp.setText(op);
    }

    //  -------- SETTING THE RESULT AFTER AN OPERATION ------ //
    public void setResult(String result){
        this.textResult.setText(result);
    }

    //   ----------------- LISTENERS FOR ALL 7 BUTTONS -----------------  //
    public void addAddListener(ActionListener add){this.buttonAddition.addActionListener(add);}
    public void addSubstractListener(ActionListener sub){this.buttonSubstract.addActionListener(sub);}
    public void addMultiplyListener(ActionListener mul){this.buttonMultiplication.addActionListener(mul);}
    public void addDivisionListener(ActionListener div){this.buttonDivison.addActionListener(div);}
    public void addDerivationListener(ActionListener der){this.buttonDerivation.addActionListener(der);}
    public void addIntegrationListener(ActionListener inte){this.buttonIntegration.addActionListener(inte);}
    public void addEqualsListener(ActionListener eq){this.buttonEquals.addActionListener(eq);};

}
