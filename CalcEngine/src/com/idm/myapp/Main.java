package com.idm.myapp;

import com.idm.calcengine.Adder;
import com.idm.calcengine.CalculateBase;
import com.idm.calcengine.CalculateHelper;
import com.idm.calcengine.Divider;
import com.idm.calcengine.DynamicHelper;
import com.idm.calcengine.InvalidStatementException;
import com.idm.calcengine.MathEquation;
import com.idm.calcengine.MathProcessing;
import com.idm.calcengine.Multiplier;
import com.idm.calcengine.PowerOf;
import com.idm.calcengine.Subtractor;

public class Main {

    public static void main(String[] args) {
//        useMathEquation();
//        useOverloads();
//        useCalculatorBase();

        // 10MoreAboutDataTypes
//        String[] statements = {
//                "add 1.0",
//                "add xx 25.0",
//                "addX 0.0 0.0",
//                "divide 100.0 50.0",
//                "add 25.0 92.0",
//                "subtract 225.0 17.0",
//                "multiply 11.0 3.0"
//        };
//
//        CalculateHelper helper = new CalculateHelper();
//
//        for (String statement : statements) {
//            try {
//                helper.process(statement);
//                System.out.println(helper); // by default will print object hash code
//            } catch (InvalidStatementException ise) {
//                System.out.println(ise.getMessage());
//                if (ise.getCause() != null) {
//                    System.out.println("  Original exception: " + ise.getCause().getMessage());
//                }
//            }
//        }

        String[] statements = {
                "add 25.0 92.0",
                "power 5.0 2.0"
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new PowerOf()
        });

        for (String statement : statements) {
            String output = helper.process(statement);
            System.out.println(output);
        }

    }

    static void useMathEquation() {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d',100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);
        for (MathEquation equation : equations) {
            equation.execute();
            System.out.print("result = ");
            System.out.println(equation.getResult());
        }
    }

    static void useOverloads() {
        System.out.println();
        System.out.println("Using Overloads.");
        System.out.println();

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        int leftInt = 9;
        int rightInt = 4;

        MathEquation equationOverload = new MathEquation('d');
        equationOverload.execute(leftDouble, rightDouble);
        System.out.print("result=");
        System.out.println(equationOverload.getResult());

        equationOverload.execute(leftInt, rightInt);
        System.out.print("result=");
        System.out.println(equationOverload.getResult());

        equationOverload.execute((double) leftInt, rightInt);
        System.out.print("result=");
        System.out.println(equationOverload.getResult());
    }

    static void useCalculatorBase() {
        System.out.println();
        System.out.println("Using Inheritance");
        System.out.println();

        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Subtractor(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        };

        for (CalculateBase calculator : calculators) {
            calculator.calculate();
            System.out.print("result=");
            System.out.println(calculator.getResult());
        }
    }
}
