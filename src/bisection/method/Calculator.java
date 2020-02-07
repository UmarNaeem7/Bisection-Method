package bisection.method;

import static java.lang.Math.pow;

public class Calculator {
    double left;
    double right;
    double tolerance;
    double x;
    double sq_x;
    double cube_x;
    double constant;
    double midY;

    public Calculator(double left, double right, double tolerance, double x, double sq_x, double cube_x, double constant) {
        this.left = left;
        this.right = right;
        this.tolerance = tolerance;
        this.x = x;
        this.sq_x = sq_x;
        this.cube_x = cube_x;
        this.constant = constant;
    }
    
    public double calculate(){
        int iterations = 0;
        
        double mid = (left+right)/2;
        midY = (cube_x*pow(mid,3)) + (sq_x*pow(mid, 2)) + (x*mid) + constant;
        while((midY)>tolerance){
        
            //calculate values of y=f(x) at left and right values
            double leftY = (cube_x*pow(left,3)) + (sq_x*pow(left, 2)) + (x*left) + constant;
            //double rightY = (cube_x*right) + (sq_x*right) + (x*right) + constant;


            midY = (cube_x*pow(mid,3)) + (sq_x*pow(mid, 2)) + (x*mid) + constant;

            if (midY>0)
                if (leftY<0)
                    right = mid;
                else
                    left = mid;
            else
                if (leftY>0)
                    right = mid;
                else
                    left = mid;

            mid = (left+right)/2;
            iterations++;
        }
        System.out.println(iterations);
        return mid;
    }  
}
