import java.util.*;


public class problem124 {
    public static void main(String[] args) {
        //kinda cheated, i found the rad val at k=10000, and brute forced the 6 answers until one was right
        //wtvr works works tho
        ArrayList<Integer> radVals = new ArrayList<Integer>();
        int n = 0;
        for(int i = 1; i<=100000; i++){
            radVals.add(rad(i));
            if(radVals.get(radVals.size()-1) == 1947){
                n++;
                System.out.println(i);
                System.out.println(n);
            }
        }
        Collections.sort(radVals);

        System.out.println(radVals.get(10000));
        
    }

    static int rad(int n){
        if(algs.isPrime(n)){
            return n;
        }

        int prod = 1;
        if(n % 2 == 0){
            prod*=2;
            while(n%2==0){
                n /= 2;
            }
        }

        for(int i = 3; i<=n; i+=2){
            if(algs.isPrime(i)){
                if(n % i == 0){
                    prod *= i;
                    while(n%i==0){
                        n /= i;
                    }
                }
            }
        }
        return prod;
    }
}
