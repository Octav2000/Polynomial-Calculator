package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Polynomial {
    private ArrayList<Monomial> monoame = new ArrayList<>();

    public Polynomial(String x) {
        if (!x.equals("")) {
            x = x.replace(" ", "");
            String aux;
            String[] a = x.split("[+]");
            for (int i = 0; i < a.length; i++) {
                aux = a[i];
                aux = aux.replace('*', ' ');
                aux = aux.replace('x', ' ');
                aux = aux.replace('^', ' ');
                Scanner read = new Scanner(aux);
                try {
                    this.monoame.add(new MonomialInt(read.nextInt(), read.nextInt()));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Introdu polinomul de forma:\ncoeficient*x^putere + ...", "ATENTIE!", JOptionPane.WARNING_MESSAGE);
                }
            }
            OrderByPut o = new OrderByPut();
            this.monoame = addDuplicates(this.monoame);
            this.monoame.sort(o);
        }
    }

    public ArrayList<Monomial> getMonoamials() {
        return this.monoame;
    };

    public boolean notNull(){
        return this.monoame.size()>0;
    }

    public ArrayList<Monomial> addDuplicates(ArrayList<Monomial> rezultat) {
        for (int i = 0; i < rezultat.size() - 1; i++)
            for (int j = i + 1; j < rezultat.size(); j++) {
                //daca au aceeasi putere
                if (rezultat.get(i).getPut() == rezultat.get(j).getPut()) {
                    //daca suma lor are coeficientul 0
                    if (((MonomialInt)rezultat.get(i)).additionMonomials(((MonomialInt) rezultat.get(j))) == null) {
                        rezultat.remove(rezultat.get(j));
                        rezultat.remove(rezultat.get(i));
                        if (i > 0)
                            i--;
                        if (j > 0)
                            j--;
                    } else {
                        //daca suma lor nu are coeficientul 0
                        rezultat.add(((MonomialInt) rezultat.get(i)).additionMonomials((MonomialInt) rezultat.get(j)));
                        rezultat.remove(rezultat.get(j));
                        rezultat.remove(rezultat.get(i));
                        if (i > 0)
                            i--;
                        if (j > 0)
                            j--;
                    }
                }
            }
        return rezultat;
    }

    public String addPolynomials(Polynomial p){
        ArrayList<Monomial> rezultat = new ArrayList<>();
        int i = 0, j = 0;
        while (i < this.monoame.size() && j < p.getMonoamials().size()) {
            if (this.monoame.get(i).getPut() > p.getMonoamials().get(j).getPut()) {
                rezultat.add( this.monoame.get(i));
                i++;
            } else if (this.monoame.get(i).getPut() < p.getMonoamials().get(j).getPut()) {
                rezultat.add( p.getMonoamials().get(j));
                j++;
            } else if (((MonomialInt)this.monoame.get(i)).additionMonomials((MonomialInt) p.getMonoamials().get(j)) != null) {
                rezultat.add(((MonomialInt)this.monoame.get(i)).additionMonomials((MonomialInt) p.getMonoamials().get(j)));
                i++;
                j++;
            } else {
                i++;
                j++;
            }
        }
        if (i != this.monoame.size())
            while (i < this.monoame.size()) {
                rezultat.add( this.monoame.get(i));
                i++;
            }
        if (j != p.getMonoamials().size())
            while (j < p.getMonoamials().size()) {
                rezultat.add( p.getMonoamials().get(j));
                j++;
            }
        return printResult(rezultat);
    }

    public String subPolynomials(Polynomial p){
        ArrayList<Monomial> rezultat = new ArrayList<>();
        int i = 0, j = 0;
        while (i < this.monoame.size() && j < p.getMonoamials().size()) {
            if (this.monoame.get(i).getPut() > p.getMonoamials().get(j).getPut()) {
                rezultat.add( this.monoame.get(i));
                i++;
            } else if (this.monoame.get(i).getPut() < p.getMonoamials().get(j).getPut()) {
                rezultat.add(new MonomialInt(((MonomialInt)p.getMonoamials().get(j)).getCoef() * (-1), p.getMonoamials().get(j).getPut()));
                j++;
            } else if (((MonomialInt)this.monoame.get(i)).substractMonomials((MonomialInt) p.getMonoamials().get(j)) != null) {
                rezultat.add(((MonomialInt) this.monoame.get(i)).substractMonomials((MonomialInt) p.getMonoamials().get(j)));
                i++;
                j++;
            } else {
                i++;
                j++;
            }
        }
        if (i != this.monoame.size())
            while (i < this.monoame.size()) {
                rezultat.add( this.monoame.get(i));
                i++;
            }
        if (j != p.getMonoamials().size())
            while (j < p.getMonoamials().size()) {
                rezultat.add(p.getMonoamials().get(j));
                j++;
            }
        return printResult(rezultat);
    }

    public String mulPolynomials(Polynomial p){
        ArrayList<Monomial> rezultat = new ArrayList<>();
        for(Monomial m1 : this.monoame) {
            for (Monomial m2 : p.getMonoamials())
                rezultat.add(new MonomialInt(((MonomialInt) m1).multiplyMonomials((MonomialInt) m2).getCoef(), ((MonomialInt) m1).multiplyMonomials((MonomialInt) m2).getPut()));
        }
        rezultat = addDuplicates(rezultat);
        return printResult(rezultat);
    }

    public ArrayList<Monomial> mulPoMo(Monomial m){
        ArrayList<Monomial> rez = new ArrayList<>();
        for(Monomial x : this.monoame){
            if(m instanceof MonomialInt)
                rez.add(((MonomialInt) m).multiplyMonomials((MonomialInt)x));
            else
                if(m instanceof MonomialDouble)
                    rez.add(((MonomialDouble) m).multiplyMonomials((MonomialInt) x));
        }
        return rez;
    }

    public String divPolynomials(Polynomial p){
        ArrayList<Monomial> rezultat = new ArrayList<>();
        Polynomial divident = new Polynomial(printResult(this.monoame));

        while(divident.getMonoamials().get(0).getPut() >= p.getMonoamials().get(0).getPut()){
            rezultat.add(((MonomialInt) divident.getMonoamials().get(0)).divideMonomials(((MonomialInt)p.getMonoamials().get(0))));
            Polynomial newPol = new Polynomial(printResult(p.mulPoMo(((MonomialInt) divident.getMonoamials().get(0)).divideMonomials(((MonomialInt)p.getMonoamials().get(0))))));
            divident = new Polynomial(divident.subPolynomials(newPol));
        }

        rezultat.addAll(divident.getMonoamials());
        return printResultDivision(rezultat);
    }

    public String derPolynomial(){
        ArrayList<Monomial> rezultat = new ArrayList<>();
        for(Monomial m : this.monoame)
            rezultat.add(((MonomialInt)m).derivateMonomial());
        return printResult(rezultat);
    }

    public String intPolynomial(){
        ArrayList<Monomial> rezultat = new ArrayList<>();
        for(Monomial m :  this.monoame){
                rezultat.add(((MonomialInt)m).integrateMonomial());
        }
        return printResult(rezultat);
    }

    public String printResult(ArrayList<Monomial> rezultat) {
        String result = "";
        OrderByPut o = new OrderByPut();
        Collections.sort(rezultat, o);
        for (Monomial m : rezultat)
            if(m instanceof MonomialInt)
                result = result + ((MonomialInt)m).getCoef() + "*x^" + m.getPut() + " + ";
            else
                result = result + ((MonomialDouble)m).getCoef() + "*x^" + m.getPut() + " + ";
        char[] chars = result.toCharArray();
        if (result.length() > 0) {
            chars[result.length() - 2] = ' ';
            return String.valueOf(chars);
        } else
            return "0";
    }

    public String printResultDivision(ArrayList<Monomial> rezultat){
        String result = "";
        for (Monomial m : rezultat)
            if(m instanceof MonomialInt)
                result = result + ((MonomialInt)m).getCoef() + "*x^" + m.getPut() + " + ";
            else
                result = result + ((MonomialDouble)m).getCoef() + "*x^" + m.getPut() + " + ";
        char[] chars = result.toCharArray();
        if (result.length() > 0) {
            chars[result.length() - 2] = ' ';
            return String.valueOf(chars);
        } else
            return "0";
    }
}
