/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.lab.lambda;

/**
 *
 * @author pierpaolo
 */
public class CalculatorLambda {

    interface IntegerMath {

        int operation(int a, int b);
    }

    /**
     *
     * @param a
     * @param b
     * @param op
     * @return
     */
    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        CalculatorLambda myApp = new CalculatorLambda();

        IntegerMath addition = (a, b) -> a + b;
        IntegerMath substraction = (a, b) -> a - b;

        System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " + myApp.operateBinary(20, 10, substraction));

        System.out.println("10 * 2 = " + myApp.operateBinary(10, 2, (a, b) -> a * b));
        System.out.println("10 / 2 = " + myApp.operateBinary(10, 2, (a, b) -> a / b));
        
        System.out.println("10^2 = "+myApp.operateBinary(10, 2, (a,b)-> {int c=1; for (int i=0;i<b;i++) c=c*a; return c;}));

    }

}
