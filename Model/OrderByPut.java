package Model;

import java.util.Comparator;

// CLASS ESSENTIAL FOR ORDERING IN DESCENDING ORDER MONOMIALS DEPENDING ON THEIR EXPONENT
public class OrderByPut implements Comparator<Monomial> {
    @Override
    public int compare(Monomial o1, Monomial o2) {
        if(o1.getPut() < o2.getPut())
            return 1;
        else
        if(o1.getPut() > o2.getPut())
            return -1;
        return 0;
    }
}
