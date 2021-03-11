package Model;

public class MonomialDouble extends Monomial {

    private double coef;

    public MonomialDouble(double coef, int put) {
        super(put);
        this.coef = coef;
    }
    public MonomialDouble multiplyMonomials(MonomialInt m){
        return new MonomialDouble(this.coef * m.getCoef(),this.getPut() + m.getPut());
    }

    public int getPut(){
        return super.getPut();
    }

    public double getCoef() {
        return coef;
    }

}
