package view.gsonParser;

import com.google.gson.*;
import view.gsonParser.converter.MatrixConverter;
import model.Matrix.Matrix;

public class GsonMatrixParser {
    private static Gson gsonParser;

    static {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Matrix.class, new MatrixConverter());
        gsonParser = builder.create();
    }

    static public Matrix getMatrix(String jsonString){
        Matrix matrix = gsonParser.fromJson(jsonString, Matrix.class);
        return matrix;
    }
    static public String getJsonMatrix(Matrix matrix){
        return gsonParser.toJson(matrix);
    }

}
