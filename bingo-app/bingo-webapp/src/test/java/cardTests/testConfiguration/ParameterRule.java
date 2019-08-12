package cardTests.testConfiguration;

import helpers.PrinterHelper;
import javafx.util.Pair;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import java.util.List;

public class ParameterRule implements MethodRule {

    private int parameterIndex = 0;

    public  List<List<Pair<Integer, Integer>>> parameters;

    public ParameterRule(List<List<Pair<Integer, Integer>>> someParameters){
        parameters = someParameters;
    }

    public List<Pair<Integer, Integer>> getParameter(){
        return parameters.get(parameterIndex);
    }

    @Override
    public Statement apply(Statement statement, FrameworkMethod frameworkMethod, Object o) {
        return new Statement (){
            public void evaluate(){
                for (int i = 0; i < parameters.size(); i++){
                    PrinterHelper.printLog("\nwinners pattern indexes" + parameters.get(i).toString() + "\n");
                    parameterIndex = i;
                    try {
                        statement.evaluate();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            }
        };
    }
}