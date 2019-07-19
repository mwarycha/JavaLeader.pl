package pl.javaleader.nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;

public class NashornDemo {

    public static void main(String[] args) {

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            engine.eval("print('Hello World from Java Script!');");
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        InputStream inputStream = NashornDemo.class.getClassLoader().getResourceAsStream("script.js");
        Reader targetReader = new InputStreamReader(inputStream);

        try {
            engine.eval(targetReader);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        Invocable invocable = (Invocable) engine;
        Object result = null;
        try {
            result = invocable.invokeFunction("info");
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(result);

    }

    public static String info() {
        return "pl.javaleader.pl";
    }
}
