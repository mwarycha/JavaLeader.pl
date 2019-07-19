package pl.javaleader.lambda;

interface Operation {
    int doOperation(int a, int b);
}

class OperationImplAddition {
    int doOperation(int a, int b) {
        return a + b;
    }
}

class OperationImplSubtraction {
    static int doOperation(int a, int b) {
        return a - b;
    }
}

public class LambdaDemo {
    public static void main(String[] args) {

        Operation addition = new Operation() {
            @Override
            public int doOperation(int a, int b) {
                return a + b;
            }
        };

        System.out.println(addition.doOperation(2,2));

        Operation subtraction = (x,y) -> x -y;
        System.out.println(subtraction.doOperation(2,2));

        Operation multiply = (int x , int y) -> (x * y);
        System.out.println(multiply.doOperation(2,2));

        Operation division = (int x , int y) -> (x / y);
        System.out.println(division.doOperation(2,2));

        Operation additionWithLambda = (int x , int y) -> {return x + y;};
        System.out.println(additionWithLambda.doOperation(2,2));

        OperationImplAddition operationImplAddition = new OperationImplAddition();
        Operation operation                         = operationImplAddition::doOperation;
        System.out.println(operation.doOperation(2,2));

        Operation operationSubtraction =  OperationImplSubtraction::doOperation;
        System.out.println(operationSubtraction.doOperation(2,2));

    }
}
