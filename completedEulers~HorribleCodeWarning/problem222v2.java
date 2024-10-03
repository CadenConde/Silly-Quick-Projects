import java.math.BigDecimal;
import java.math.MathContext;

public class problem222v2 {
    public static void main(String[] args) {
        //double len = 50;
        MathContext mc = new MathContext(50);
        MathContext mc2 = new MathContext(7);
        int counter = 0;

        BigDecimal centX = new BigDecimal(50);
        BigDecimal centY = new BigDecimal(50);

        int[] rad = {50,48,46,44,42,40,38,36,34,32,30,31,33,35,37,39,41,43,45,47,49};
        //int[] rad = {50};

        for(int rIndex = 1; rIndex<rad.length; rIndex++){
            int r = rad[rIndex];
            //System.out.println(centX + " " + centY);
            BigDecimal newCentY;

            if(counter%2 == 0){ //alternate top/bottom of tube
                newCentY = new BigDecimal(100-r);
            }
            else{
                newCentY = new BigDecimal(r);
            }

            BigDecimal newCentX = centY.subtract(newCentY).pow(2);
            newCentX = new BigDecimal(Math.pow((r+rad[rIndex-1]),2)).subtract(newCentX);
            newCentX = newCentX.sqrt(mc);
            newCentX = newCentX.add(centX);

            centX = newCentX;
            centY = newCentY;
            //System.out.println(centX);
            counter++;
        }
        //System.out.println(centX + " " + centY);
        System.out.println(centX.add(new BigDecimal(rad[rad.length-1])).multiply(new BigDecimal(1000)).round(mc2));
    }
}
