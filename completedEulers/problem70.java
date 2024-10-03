public class problem70 { //about 12 sec to find answer, could speed up by only checking prime*prime?
    public static void main(String[] args) {
        algs algs = new algs();
        int bestNum = 0;
        double bestRatio = 99999999;
        for(int i = 2; i<Math.pow(10, 7); i++){
            int phiVal = phi(i);
            if(bestRatio > i/(double)phiVal){ //quicker than fingerprint
                if(algs.fingerprint(i) == algs.fingerprint(phiVal)){
                    bestNum = i;
                    bestRatio = i/(double)phiVal;
                    //System.out.println(i + " " + phiVal);
                }
            }
            
        }
        System.out.println(bestNum);
    }

    static int phi(int n)
    {
        int result = n; 
        for (int p = 2; p * p <= n; ++p)
        {
            if (n % p == 0) 
            {
                while (n % p == 0)
                    n /= p;
                result -= result / p;
            }
        }
        if (n > 1)
            result -= result / n;
        return result;
    }
}
