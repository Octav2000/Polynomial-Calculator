package Model;

public class Monomial {
    private int put;

    public Monomial(int put) {
        this.put = put;
    }

    public boolean checkSamePut(Monomial m1, Monomial m2) {
        return m1.getPut() == m2.getPut();
    }

    public int getPut() {
        return put;
    }
}
