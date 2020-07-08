package model.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class checkerCalculateServlet {
    public static void main(String[] args) throws IOException {
        Path java = Paths.get("web\\..\\web");
        System.out.println(Files.exists(java));

    }






}
