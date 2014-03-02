package algdat.dataStructures;

public class Fraction {
    long n; //numerator
    long d; //denominator
    
    public Fraction(long n, long d){
        this.n = n;
        this.d = d;
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
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    @Override
    //Use top line when strict fractions are wanted. Second line outputs integers instead of fractions when denominator == 1.
    public String toString() {
        //return n + "/" + d;
        return n + (d == 1 ? "" : "/" + d);
    }
    
    public Fraction copy(){
        return new Fraction(n, d);
    }
    
    public static void main(String[] args) {
        Fraction a = new Fraction(2, 5);
        Fraction b = new Fraction(2, 4);
        a.sub(b);
        System.out.println(a);
    }

}
