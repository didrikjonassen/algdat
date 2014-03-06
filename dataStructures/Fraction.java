package algdat.dataStructures;

public class Fraction {
    long n; //numerator
    long d; //denominator
    
    public Fraction(long n, long d){
        this.n = n;
        this.d = d;
        reduce();
    }
    
    public void reduce(){
        long g = gcd(n, d);
        n /= g;
        d /= g;
        //Makes sure the fraction is proper when negative numbers are involved.
        if(d < 0){
            n *= -1;
            d *= -1;
        }
    }
    
    public void mul(Fraction f){
        n *= f.n;
        d *= f.d;
        reduce();
    }
    
    public void div(Fraction f){
        n *= f.d;
        d *= f.n;
        reduce();
    }
    
    public void add(Fraction f){
        n = n*f.d + d*f.n;
        d *= f.d;
        reduce();
    }
    
    public void sub(Fraction f){
        n = n*f.d - d*f.n;
        d *= f.d;
        reduce();
    }
    
    public static long gcd(long a, long b){
        return b==0 ? a : gcd(b, a%b);
    }

    @Override
    //Use top line when strict fractions are wanted. Second line outputs integers instead of fractions when denominator == 1.
    public String toString() {
        //return n + "/" + d;
        return n + (d == 1 ? "" : "/" + d);
    }
    
    public static Fraction valueOf(double d){
        long l = Double.doubleToLongBits(d);
        long sign = (l & Long.MIN_VALUE);
        sign = ((sign+2) % 3) - 1;
        Fraction fraction = new Fraction(sign * (l & 0x000fffffffffffffL | 0x0010000000000000L), 0x0010000000000000L);
        long expl = ((l & 0x7ff0000000000000L) >> (13*4)) - 1023;
        if(expl < 0){
            expl = -expl;
            long g = Fraction.gcd(fraction.n, 1 << expl);
            fraction.n /= g;
            fraction.d *= (1<<expl)/g;
        }
        else{
            long g = Fraction.gcd(fraction.d, 1 << expl);
            fraction.d /= g;
            fraction.n *= (1 << expl)/g;
        }
        fraction.reduce();
        return fraction;
    }
    
    public Fraction copy(){
        return new Fraction(n, d);
    }

}
