package model.Matrix;

import model.Rational.Rational;
import view.gsonParser.GsonMatrixParser;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    private final String pathToTest = "web" +File.separator + "resources" + File.separator + "matrixTest";


    private String getJsonStringIn(String fileName){
        try {
            return new String(Files.readAllBytes(Paths.get(pathToTest+ File.separator + "in" + File.separator + fileName + "In.json")));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private String getJsonStringOut(String fileName){
        try {
            return new String(Files.readAllBytes(Paths.get(pathToTest+File.separator+"Out"+File.separator+fileName+"Out.json")));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private String getMethodName(){
        return (new Throwable()).getStackTrace()[1].getMethodName();
    }

    @Test
    public void constructor1(){

        Matrix actual = new Matrix(3,3);
        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));
        assertEquals(expected, actual);
    }

    @Test
    public void constructor2(){

        Matrix actual = new Matrix(2,2);
        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));

        assertEquals(expected, actual);
    }

    @Test
    public void constructor3(){

        Matrix actual = new Matrix(1,1);
        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));

        assertEquals(expected, actual);
    }


    @Test
    public void swipeColumn1(){
        Matrix actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName()));
        actual.swipeColumn(0,1);

        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));

        assertEquals(expected, actual);
    }

    @Test
    public void swipeRow1(){
        Matrix actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName()));
        actual.swipeRow(0,1);

        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));

        assertEquals(expected, actual);
    }

    @Test
    public void addRow1(){
        Matrix actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName()));
        actual.addRow(0,1, new Rational(1,1));

        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));

        assertEquals(expected, actual);
    }


    @Test
    public void mlpRow1(){
        Matrix actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName()));
        actual.mlpRow(1, new Rational(1,3));

        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));

        assertEquals(expected, actual);
    }

    @Test
    public void getDeterminantOfTriangleMatrix1(){
        Rational actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getDeterminantOfTriangleMatrix();
        Rational expected = new Rational (45,28);

        assertEquals(expected, actual);
    }

    @Test
    public void getInverseMatrix1() {
        Matrix actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getInverseMatrix();
        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));

        assertEquals(expected, actual);

    }

    @Test
    public void getInverseMatrix2() {
        Matrix actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getInverseMatrix();

        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));

        assertEquals(expected, actual);

    }

    @Test
    public void getInverseMatrix3() {
        Matrix actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getInverseMatrix();

        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));

        assertEquals(expected, actual);

    }


    @Test
    public void add1() {
        Matrix actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName()+".1"))
                                        .add(GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName()+".2")));

        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));

        assertEquals(expected, actual);

    }

    @Test
    public void mlp1() {
        Matrix actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName()+".1"))
                .mlp(GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName()+".2")));

        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));

        assertEquals(expected, actual);
    }


    @Test
    public void mlp2() {
        Matrix actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName()+".1"))
                                        .mlp(GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName()+".2")));

        System.out.println(actual.add(actual).toString());
        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));

        assertEquals(expected, actual);

    }

    @Test
    public void mlp3() {
        Matrix a = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName()+".1"));
        Matrix b = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName()+".2"));

        System.out.println(a);
        System.out.println(a.toIMatrix());
        System.out.println(a.getDecompositionOfVectorsByLinearIndependent());


        //assertEquals(expected, actual);
    }


    @Test
    public void toIMatrix1(){

        Matrix actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).toIMatrix();
        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));

        assertEquals(expected, actual);
    }

    @Test
    public void toIMatrix2(){

        Matrix actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).toIMatrix();
        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));

        assertEquals(expected, actual);
    }


    @Test
    public void toIMatrix3(){

        Matrix actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).toIMatrix();
        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));

        assertEquals(expected, actual);
    }


    @Test
    public void toIMatrix4(){

        Matrix actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).toIMatrix();
        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));

        assertEquals(expected, actual);
    }


    @Test
    public void toIMatrix5(){

        Matrix actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).toIMatrix();
        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));

        assertEquals(expected, actual);
    }


    @Test
    public void getRank1(){

        int actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getRank().getNumerator();
        int expected = 2;

        assertEquals(expected, actual);
    }


    @Test
    public void getRank2(){

        int actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getRank().getNumerator();
        int expected = 4;

        assertEquals(expected, actual);
    }

    @Test
    public void getRank3(){

        int actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getRank().getNumerator();
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    public void getRank4(){

        int actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getRank().getNumerator();
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    public void getRank5(){

        int actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getRank().getNumerator();
        int expected = 3;

        assertEquals(expected, actual);
    }


    @Test
    public void getRank6(){

        int actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getRank().getNumerator();
        int expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    public void getRank7(){

        int actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getRank().getNumerator();
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    public void getDeterminantByTriangleMatrix1(){

        Rational actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getDeterminantByTriangleMatrix();
        Rational expected = new Rational(0);
        assertEquals(expected, actual);
    }

    @Test
    public void getDeterminantByTriangleMatrix2(){

        Rational actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getDeterminantByTriangleMatrix();
        Rational expected = new Rational(-1034);
        assertEquals(expected, actual);
    }

    @Test
    public void getDeterminantByTriangleMatrix3(){

        Rational actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getDeterminantByTriangleMatrix();
        Rational expected = new Rational(-42);
        assertEquals(expected, actual);
    }

    @Test
    public void getDeterminantByTriangleMatrix4(){

        Rational actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getDeterminantByTriangleMatrix();
        Rational expected = new Rational(24);
        assertEquals(expected, actual);
    }


    @Test
    public void getDeterminantByTriangleMatrix5(){
        Matrix matrix = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName()));
        assertThrows(IllegalArgumentException.class, ()-> matrix.getDeterminantByTriangleMatrix());
    }

    @Test
    public void getDeterminantByTriangleMatrix6(){
        Rational actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getDeterminantByTriangleMatrix();
        Rational expected = new Rational(0);
        assertEquals(expected, actual);
    }

    @Test
    public void getSolutionOfLES1(){

        String actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getSolutionOfLES().toString();
        String expected = "Independent variables:\n" +
                "X1 = (-3/2)\n" +
                "X2 = (1/1)\n" +
                "X3 = (1/2)\n" +
                "\n" +
                "Dependent variables:\n";

        assertEquals(expected, actual);
    }

    @Test
    public void getSolutionOfLES2(){

        String actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName()))
                                        .getSolutionOfLES()
                                        .toString();
        String exprected = "Independent variables:\n" +
                "X1 = (9/4) + (-2/1)*X2 + (-5/4)*X5\n" +
                "X3 = (3/4) + (-3/4)*X5\n" +
                "X4 = (-1/2) + (-1/2)*X5\n" +
                "\n" +
                "Dependent variables:\n" +
                "X2 = a1\n" +
                "X5 = a2\n";
        assertEquals(exprected, actual);

    }



    @Test
    public void getTransposeMatrix1(){
        Matrix actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getTransposeMatrix();
        Matrix expected = GsonMatrixParser.getMatrix(getJsonStringOut(getMethodName()));
        assertEquals(expected, actual);
    }

    @Test
    public void getDecompositionOfVectorsByLinearIndependent1(){
        String actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getDecompositionOfVectorsByLinearIndependent();
        String expected = "Basis:\n" +
                "vector2\n" +
                "vector4\n" +
                "\n" +
                "Decomposition by basis:\n" +
                "vector1 = (0/1)*vector2 + (0/1)*vector4\n" +
                "vector2 = (1/1)*vector2 + (0/1)*vector4\n" +
                "vector3 = (-1/1)*vector2 + (0/1)*vector4\n" +
                "vector4 = (0/1)*vector2 + (1/1)*vector4\n" +
                "vector5 = (0/1)*vector2 + (2/1)*vector4\n";
        assertEquals(expected, actual);
    }

    @Test
    public void getDecompositionOfVectorsByLinearIndependent2(){
        String actual = GsonMatrixParser.getMatrix(getJsonStringIn(getMethodName())).getDecompositionOfVectorsByLinearIndependent();
        String expected = "Basis:\n" +
                "vector1\n" +
                "vector2\n" +
                "vector4\n" +
                "\n" +
                "Decomposition by basis:\n" +
                "vector1 = (1/1)*vector1 + (0/1)*vector2 + (0/1)*vector4\n" +
                "vector2 = (0/1)*vector1 + (1/1)*vector2 + (0/1)*vector4\n" +
                "vector3 = (0/1)*vector1 + (5645465/1)*vector2 + (0/1)*vector4\n" +
                "vector4 = (0/1)*vector1 + (0/1)*vector2 + (1/1)*vector4\n" +
                "vector5 = (-10/1)*vector1 + (7/1)*vector2 + (6/1)*vector4\n";
        assertEquals(expected, actual);
    }


}