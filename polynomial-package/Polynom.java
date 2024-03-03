import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Polynom {

    private ArrayList<Double> polynom;  // even index -> coefficient, odd index -> its degree

    public Polynom(double[] coefficientArray, int[] degreeArray) {

        if (coefficientArray.length != degreeArray.length) {
            throw new IllegalArgumentException("Coefficients and degrees arrays must have the same length");
        }

        this.polynom = new ArrayList<>();

        HashMap<Integer, Double> hashMap = new HashMap<>();

        for (int i = 0; i < degreeArray.length; i++) {
            hashMap.put(degreeArray[i], coefficientArray[i]);
        }

        Arrays.sort(degreeArray);
        degreeArray = reverseArray(degreeArray);

        for (int degree : degreeArray) {
            this.polynom.add(hashMap.get(degree));
            this.polynom.add((double) degree);
        }
    }

    public Polynom(ArrayList<Double> polynom) {
        this.polynom = polynom;
    }

    public ArrayList<Double> getPolynom() {
        return this.polynom;
    }

    public void setPolynom(ArrayList<Double> polynom) {
        this.polynom = polynom;
    }

    public ArrayList<Double> plus(ArrayList<Double> newPolynom) {
        ArrayList<Double> res = new ArrayList<>();
        int i = 0, j = 0;
    
        while (i < polynom.size() && j < newPolynom.size()) {
            double coeff1 = polynom.get(i);
            double exp1 = polynom.get(i + 1);
            double coeff2 = newPolynom.get(j);
            double exp2 = newPolynom.get(j + 1);
    
            if (exp1 == exp2) {
                res.add(coeff1 + coeff2);
                res.add(exp1);
                i += 2;
                j += 2;
            } else if (exp1 > exp2) {
                res.add(coeff1);
                res.add(exp1);
                i += 2;
            } else {
                res.add(coeff2);
                res.add(exp2);
                j += 2;
            }
        }
    
        // Add any remaining terms from polynom
        while (i < polynom.size()) {
            res.add(polynom.get(i));
            res.add(polynom.get(i + 1));
            i += 2;
        }
    
        // Add any remaining terms from newPolynom
        while (j < newPolynom.size()) {
            res.add(newPolynom.get(j));
            res.add(newPolynom.get(j + 1));
            j += 2;
        }
    
        return res;
    }
    
    public ArrayList<Double> minus(ArrayList<Double> newPolynom) {
        ArrayList<Double> res = new ArrayList<>();
        int i = 0, j = 0;
    
        while (i < polynom.size() && j < newPolynom.size()) {
            double coeff1 = polynom.get(i);
            double exp1 = polynom.get(i + 1);
            double coeff2 = newPolynom.get(j);
            double exp2 = newPolynom.get(j + 1);
    
            if (exp1 == exp2) {
                double difference = coeff1 - coeff2;
                if (difference != 0) {
                    res.add(difference);
                    res.add(exp1);
                }
                i += 2;
                j += 2;
            } else if (exp1 > exp2) {
                res.add(coeff1);
                res.add(exp1);
                i += 2;
            } else {
                res.add(-coeff2);  // Add the negation of the coefficient for subtraction
                res.add(exp2);
                j += 2;
            }
        }
    
        // Add any remaining terms from polynom
        while (i < polynom.size()) {
            res.add(polynom.get(i));
            res.add(polynom.get(i + 1));
            i += 2;
        }
    
        // Add any remaining terms from newPolynom
        while (j < newPolynom.size()) {
            res.add(-newPolynom.get(j));  // Add the negation of the coefficient for subtraction
            res.add(newPolynom.get(j + 1));
            j += 2;
        }
    
        return res;
    }
    
    public ArrayList<Double> derivative() {
        ArrayList<Double> res = new ArrayList<>();
        int i = 0;
        
        while (i < this.polynom.size()) {
            double coeff = this.polynom.get(i);
            double exp = this.polynom.get(i + 1);
            
            if (exp != 0) {
                double newCoeff = coeff * exp;
                res.add(newCoeff);
                res.add(exp - 1);
            }
            
            i += 2;
        }
        
        return res;
    }
    
    public String toString() {
        if (this.polynom.size() < 1) return "0";
        StringBuilder res = new StringBuilder();
        int i = 1;
        while (i < this.polynom.size()) {
            Double degree = this.polynom.get(i);
            Double coefficient = this.polynom.get(i - 1);

            res.append(coefficient);
            res.append("x^");
            res.append((int) Math.round(degree));
            res.append(" + ");
            i += 2;
        }
        // Check if there are terms to remove the trailing " + "
        if (res.length() >= 3) {
        res.delete(res.length() - 3, res.length());
        }       
        return res.toString();
    }
    
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Polynom polynom = (Polynom) obj;

        if (this.polynom.size() != polynom.polynom.size()) return false;

        for (int i = 0; i < polynom.polynom.size(); i++) {
            if (!Objects.equals(this.polynom.get(i), polynom.polynom.get(i))) return false;
        } 
        return true;
    }

    private int[] reverseArray(int[] degreeArray) {
        int[] temp = Arrays.copyOf(degreeArray, degreeArray.length);

        for (int i = 0; i < degreeArray.length; i++) {
            degreeArray[i] = temp[temp.length - i - 1];
        }
        return degreeArray;
    }
}
