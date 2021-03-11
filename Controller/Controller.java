package Controller;

import View.*;
import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private final Model model;
    private final View pview;

    //     CONSTRUCTOR     //
    public Controller(View view, Model model) {
        this.model = model;
        this.pview = view;
        this.pview.addAddListener(new AdditionListener());
        this.pview.addSubstractListener(new SubstractListener());
        this.pview.addMultiplyListener(new MultiplyListener());
        this.pview.addDivisionListener(new DivisionListener());
        this.pview.addDerivationListener(new DerivationListener());
        this.pview.addIntegrationListener(new IntegrationListener());
        this.pview.addEqualsListener(new EqualsListener());

    }

    //  ----- BUTTON LISTENERS ( CHANGING THE SIGN DEPENDING ON WHICH BUTTON WAS PRESSED ) ----- //

    class AdditionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pview.setOp("+");
        }
    }

    class SubstractListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pview.setOp("-");
        }
    }

    class MultiplyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pview.setOp("*");
        }
    }

    class DivisionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pview.setOp("/");
        }
    }

    class DerivationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pview.setOp("Derivation");
        }
    }

    class IntegrationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pview.setOp("Integration");
        }
    }

    class EqualsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //   GETTING THE OPERATION SIGN AND SETTING THE 2 POLYNOMIALS   //
            String op = pview.getOp();
            model.setP1(new Polynomial(pview.getPol1()));
            model.setP2(new Polynomial(pview.getPol2()));

            // DEPENDING ON THE OPERATION SIGN IT WILL BE EXECUTED THE FOLLOWING  //
            switch (op) {

                case "+" -> {
                    if (model.checkPolynomials() == 1)
                        pview.setResult(model.addPolynomials());
                    else
                        JOptionPane.showMessageDialog(null, "Ambele polinoame trebuie completate", "ATENTIE!", JOptionPane.WARNING_MESSAGE);
                }
                case "-" -> {
                    if (model.checkPolynomials() == 1)
                        pview.setResult(model.subPolynomials());
                    else
                        JOptionPane.showMessageDialog(null, "Ambele polinoame trebuie completate", "ATENTIE!", JOptionPane.WARNING_MESSAGE);
                }
                case "*" -> {
                    if (model.checkPolynomials() == 1)
                        pview.setResult(model.mulPolynomials());
                    else
                        JOptionPane.showMessageDialog(null, "Ambele polinoame trebuie completate", "ATENTIE!", JOptionPane.WARNING_MESSAGE);
                }
                case "/" ->{
                    if (model.checkPolynomials() == 1)
                        pview.setResult(model.divPolynomials());
                    else
                        JOptionPane.showMessageDialog(null, "Ambele polinoame trebuie completate", "ATENTIE!", JOptionPane.WARNING_MESSAGE);
                }

                case "Derivation" -> {
                    if (model.checkPolynomials() == 0) {
                        if (!pview.getPol1().equals(""))
                            pview.setResult(model.derPolynomial());
                        else
                            JOptionPane.showMessageDialog(null, "Numai primul polinom trebuie completat", "ATENTIE!", JOptionPane.WARNING_MESSAGE);
                    } else
                        JOptionPane.showMessageDialog(null, "Numai primul polinom trebuie completat", "ATENTIE!", JOptionPane.WARNING_MESSAGE);
                }


                case "Integration" -> {
                    if (model.checkPolynomials() == 0) {
                        if (!pview.getPol1().equals(""))
                            pview.setResult(model.intePolynomial());
                        else
                            JOptionPane.showMessageDialog(null, "Numai primul polinom trebuie completat", "ATENTIE!", JOptionPane.WARNING_MESSAGE);
                    } else
                        JOptionPane.showMessageDialog(null, "Numai primul polinom trebuie completat", "ATENTIE!", JOptionPane.WARNING_MESSAGE);
                }

            }
        }
    }

    public static void main(String[] args) {
        new Controller(new View(),new Model());
    }
}
