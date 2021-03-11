package Model;

public class Model {

    private Polynomial p1;
    private Polynomial p2;

    public void setP1(Polynomial p1){this.p1 = p1;}

    public void setP2(Polynomial p2){this.p2 = p2;}

    public int checkPolynomials(){
        if(this.p1.notNull() && this.p2.notNull())
            return 1;
        else
        if(!this.p1.notNull() && !this.p2.notNull())
            return -1;
        else
            return 0;
    }

    public String addPolynomials(){return this.p1.addPolynomials(this.p2);}

    public String subPolynomials(){return this.p1.subPolynomials(this.p2);}

    public String mulPolynomials(){
        return this.p1.mulPolynomials(this.p2);
    }

    public String divPolynomials(){return this.p1.divPolynomials(this.p2);}

    public String derPolynomial(){return this.p1.derPolynomial();}

    public String intePolynomial(){return this.p1.intPolynomial();}

}
