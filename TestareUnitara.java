import Model.Polynomial;
import junit.framework.TestCase;

public class TestareUnitara extends TestCase {

    public void testAddPolynomials(){
        Polynomial p1 = new Polynomial("2*x^2 + 3  *x^3");
        Polynomial p2 = new Polynomial("3  *x^3 + 4*x^5");
        String rezultat = "4*x^5 + 6*x^3 + 2*x^2   ";
        assertEquals(rezultat,p1.addPolynomials(p2));

    }

    public void testSubstractPolynomials(){
        Polynomial p1 = new Polynomial("2*x^2 + 3  *x^3");
        Polynomial p2 = new Polynomial("3  *x^3 + 4*x^5");
        String rezultat = "-4*x^5 + 2*x^2   ";
        assertEquals(rezultat,p1.subPolynomials(p2));
    }

    public void testMultiplyPolynomials(){
        Polynomial p1 = new Polynomial("2*x^2 + 3  *x^3");
        Polynomial p2 = new Polynomial("3  *x^3 + 4*x^5");
        String rezultat = "12*x^8 + 8*x^7 + 9*x^6 + 6*x^5   ";
        assertEquals(rezultat,p1.mulPolynomials(p2));
    }

    public void testDividePolynomials(){
        Polynomial p1 = new Polynomial("2*x^3 + 3*x^2 + -1*x^1 + 5*x^0");
        Polynomial p2 = new Polynomial("1*x^0 + -1*x^1 + 1*x^2");
        String rezultat = "2*x^1 + 5*x^0 + 2*x^1   ";
        assertEquals(rezultat,p1.divPolynomials(p2));
    }

    public void testDerivatePolynomial(){
        Polynomial p1 = new Polynomial("2*x^2 + 3*x^3");
        String rezultat = "9*x^2 + 4*x^1   ";
        assertEquals(rezultat,p1.derPolynomial());
    }

    public void testIntegratePolynomial(){
        Polynomial p1 = new Polynomial("2*x^2");
        String rezultat = "0.6666666666666666*x^3   ";
        assertEquals(rezultat,p1.intPolynomial());
    }
}
