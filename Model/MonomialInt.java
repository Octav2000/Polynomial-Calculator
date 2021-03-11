package Model;

public class MonomialInt extends Monomial {

    private int coef;

    public MonomialInt(int coef, int put) {
        super(put);
        this.coef = coef;
    }

    public MonomialInt additionMonomials(MonomialInt m){
        if(checkSamePut(this,m)) {
            if (this.coef != m.getCoef() * (-1))
                return new MonomialInt(m.getCoef() + this.coef, this.getPut());
            else
                return null;
        }
        return null;
    }

    public MonomialInt substractMonomials(MonomialInt m){
        if(checkSamePut(this,m)){
            if(this.coef == m.getCoef())
                return null;
            else
                return new MonomialInt(this.coef - m.coef,this.getPut());
        }
        else
            return null;
    }

    public MonomialInt multiplyMonomials(MonomialInt m){
        return new MonomialInt(this.coef * m.getCoef(),this.getPut() + m.getPut());
    }

    public Monomial divideMonomials(MonomialInt m){
        if(this.coef%m.getCoef() == 0)
            return new MonomialInt(this.coef / m.getCoef(), this.getPut() - m.getPut());
        else
            return new MonomialDouble(this.coef / m.getCoef(), this.getPut() - m.getPut());
    }

    public MonomialInt derivateMonomial(){
        return new MonomialInt(this.coef*this.getPut(),this.getPut()-1);
    }

    public Monomial integrateMonomial(){
        if(this.coef%(this.getPut()+1) == 0)
            return new MonomialInt(this.coef/(this.getPut()+1),this.getPut()+1);
        else
            return new MonomialDouble(this.coef/(this.getPut()+1.0),this.getPut()+1);
    }


    public int getPut(){
        return super.getPut();
    }

    public int getCoef() {
        return coef;
    }
}
