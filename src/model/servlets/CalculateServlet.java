package model.servlets;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import model.calculator.Calculator;
import model.calculator.Token;
import view.Variable;
import view.gsonParser.GsonTokenParser;
import view.gsonParser.GsonVariableParser;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;



@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // забираем json элемент
        JsonObject jsonObject = new Gson().fromJson(req.getReader().lines().reduce((s1, s2) -> s1 + '\n' + s2).orElse(""), JsonObject.class);
        // парсим массив переменных и строку с выражением
        JsonArray jsonArrayVariable = jsonObject.get("variablePull").getAsJsonArray();
        ArrayList<Variable> variables = new ArrayList<>();
        for (JsonElement variable : jsonArrayVariable) {
            variables.add(GsonVariableParser.getVariable(variable.toString()));
        }

        String inputExpression = jsonObject.get("inputExpression").getAsString();


        // создаём калькулятор
        Calculator calculator = new Calculator(variables);
        calculator.evaluate(inputExpression);

        // отправляем результат
        Token result = calculator.evaluate(inputExpression);

        if ("OK".equals(calculator.status)) {
            resp.getWriter().print(GsonTokenParser.getJsonToken(result));
        } else {
            resp.getWriter().write(calculator.status);
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // взяли два параметра
        resp.getWriter().println("<html>" +
                "<body><h1>" + 3423 + "</h1></body>" +
                "</html>");
//        JsonObject jsonObject_variablePull = (JsonObject) req.getAttribute("variablePull");
//        JsonObject jsonObject_inputExpression = (JsonObject) req.getAttribute("inputExpression");
//


    }
}

