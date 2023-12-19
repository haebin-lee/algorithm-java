package algorithm.basic;

public class Bit {
    public static void main(String[] args) {
        double base = 2;
        double value = 1024;

        // Calculate the exponent
        double exponent = Math.log(value) / Math.log(base);

        System.out.println("Exponent: " + exponent);
    }
}
