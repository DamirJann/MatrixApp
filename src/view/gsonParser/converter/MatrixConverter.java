package view.gsonParser.converter;

import com.google.gson.*;
import model.Matrix.Matrix;
import model.Rational.Rational;
import view.gsonParser.GsonRationalParser;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MatrixConverter implements JsonDeserializer<Matrix>{
    public Matrix deserialize(JsonElement json, Type type,
                              JsonDeserializationContext context) throws JsonParseException {
        ArrayList<ArrayList<Rational>> mainMatrixArray = new ArrayList<>();
        ArrayList<ArrayList<Rational>> augmentedMatrixArray = new ArrayList<>();

        JsonArray mainMatrixJsonArray = json.getAsJsonObject().get("mainMatrix").getAsJsonArray();
        for (int i = 0; i < mainMatrixJsonArray.size(); i++){
            mainMatrixArray.add(new ArrayList<>());
            for (int j = 0; j < mainMatrixJsonArray.get(i).getAsJsonArray().size(); j++){
                Rational rational = GsonRationalParser.getRational(mainMatrixJsonArray.get(i).getAsJsonArray().get(j).toString());
                mainMatrixArray.get(i).add(rational);
            }
        }

        JsonArray augmentedMatrixJsonArray = json.getAsJsonObject().has("augmentedMatrix") ? json.getAsJsonObject().get("augmentedMatrix").getAsJsonArray():
                                                                                                         new JsonArray();
        for (int i = 0; i < augmentedMatrixJsonArray.size(); i++){
            augmentedMatrixArray.add(new ArrayList<>());
            for (int j = 0; j < augmentedMatrixJsonArray.get(i).getAsJsonArray().size(); j++){
                Rational rational = GsonRationalParser.getRational(augmentedMatrixJsonArray.get(i).getAsJsonArray().get(j).toString());
                augmentedMatrixArray.get(i).add(rational);
            }
        }

        return new Matrix(mainMatrixArray, augmentedMatrixArray);
    }
}
