package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder value = new StringBuilder(reader.readLine());

        reader.close();

        PrintWriter writer = new PrintWriter(System.out);

        writer.println(reverseString(value));
        writer.flush();
        writer.close();
    }

    private static String reverseString(StringBuilder value) {
        StringBuilder result = new StringBuilder();

        for (int i = value.length() - 1; i >= 0; i--) {
            result.append(value.charAt(i));
        }

        return result.toString().trim();
    }
}