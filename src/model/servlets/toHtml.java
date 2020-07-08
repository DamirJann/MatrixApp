package model.servlets;

public class toHtml {
    public static String toHtml(String str){
        return "<html>" +
                "<body>" +
                "<h1>" + str + "</h1>" +
                "</body>" +
                "</html>";
    }
}
