package view.gsonParser;

import com.google.gson.*;
import view.gsonParser.converter.RationalConverter;
import model.Rational.Rational;

public class GsonRationalParser {

    private static Gson gsonParser;

    static {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Rational.class, new RationalConverter());
        gsonParser = builder.create();
    }

    static public Rational getRational(String json){
        return gsonParser.fromJson(json, Rational.class);
    }
    static public String getJsonRational(Rational rational){return gsonParser.toJson(rational);}

}


