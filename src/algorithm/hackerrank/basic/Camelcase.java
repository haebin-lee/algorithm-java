package algorithm.hackerrank.basic;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
 * https://www.hackerrank.com/challenges/camelcase/problem
 * */
public class Camelcase {
	// Complete the camelcase function below.
    static int camelcase(String s) {
		String[] temp = s.split("[A-Z]");
    	return temp.length;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = scanner.nextLine();

        int result = camelcase("saveChangesInTheEditor");

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
