public class problem144 {
    public static void main(String[] args) {

        double lastX = 1.4; // first x
        double lastY = -9.6; // first x
        double M = (-10.1 - 9.6) / (lastX); // first slope
        double nextX;
        double nextY;
        int bounces = 1;

        while (true) {

            double tangent = -1 / ((-4 * lastX) / lastY);//tangent line
            M = Math.tan(-Math.atan(M) + (2 * Math.atan(tangent))); //angle/slope fuckery

            double a = 4 + M * M; //compress quadradic formula
            double b = ((-2 * M * M * lastX) + 2 * M * lastY); //compress quadradic formula
            double c = (lastX * lastX * M * M - 2 * lastX * M * lastY + lastY * lastY - 100);//compress quadradic formula
            double xCand1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a); //-b+...
            double xCand2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a); //-b-...

            double a2 = 4 + M * M; //compress "quadradic" formula
            double b2 = 2 * lastY - 2 * M * lastX; //compress "quadradic" formula
            double stuff = -(lastY * lastY) + 2 * M * lastY * lastX + 25 * M * M + 100 - M * M * lastX * lastX; //stuff under radical
            double yCand1 = (2 * (b2 + M * Math.sqrt(stuff))) / a2; //-b+...
            double yCand2 = (2 * (b2 - M * Math.sqrt(stuff))) / a2; //-b-...

            //one cand will be the point on the oval we have, 
            //the other will be the next point, but due to java rounding errors, 
            //i just went with the one that is further away from the point we have

            if (Math.abs(lastX - xCand2) > Math.abs(lastX - xCand1)) {
                nextX = xCand2;
            } else {
                nextX = xCand1;
            }

            if (Math.abs(lastY - yCand2) > Math.abs(lastY - yCand1)) {
                nextY = yCand2;
            } else {
                nextY = yCand1;
            }

            //change "last point"
            lastX = nextX;
            lastY = nextY;

            if (Math.abs(lastX) <= .01 && lastY > 0) { //check if we left the oval
                break;
            }

            bounces++;//counter
        }
        System.out.println(bounces);
    }
}
