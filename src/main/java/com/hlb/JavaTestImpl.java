package com.hlb;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class JavaTestImpl {
    // E.g. Input: Automation, Output: noitamotuA
    // Please don't use method such as s.reverse()
    public static String reverseStringWithoutUsingStringMethod(String s) {

        char[] chr = s.toCharArray();

        for(int i=0, j=chr.length-1; i<j; i++, j--){
            char c = chr[i];
            chr[i] = chr[j];
            chr[j] = c;
        }
        return String.valueOf(chr);
    }
    
    // Sort the integer in ASC order without using the built-in method such as ArrayUtils.sort
    public static Integer[] sortIntegers(Integer[] array) {
        /**
         * I'm using quick sort with recursion instead of bubble sort,
         * Because it reduces  average TC: O(nlogn)
         */

        quickSort(array, 0, array.length-1);

        return array;
    }

    private static void quickSort(Integer[] array, int left, int right){
        if(left<right){
            int pivotIndex = partition(array, left, right);

            quickSort(array, left, pivotIndex-1);

            quickSort(array, pivotIndex+1, right);
        }


    }

    private static int partition(Integer[] array, int left, int right){
        int pivot = array[right];

        int i = left - 1;

        for( int k= left; k<right; k++){
            /**
             * Following logic is to put smaller before pivot
             */

            if(array[k]<=pivot){
                i++;

                int t = array[i];
                array[i] = array[k];
                array[k] = t;

            }
        }

        int t = array[i+1];
        array[i+1] = array[right];
        array[right] = t;

        /**
         * Return pivot index
         */
        return i + 1;
    }
    
    // Check if the given date is within the date range
    public static boolean isInDateRange(Date givenDate, Date startDate, Date endDate) {
        return !givenDate.before(startDate) && !givenDate.after(endDate);
    }
    
    // sort the given String in ASC order without using method like Arrays.sort
    public static char[] sortStringInAscOrder(String input) {
        /**
         * using previous quick sort functions
         */

        /**
         * Convert to Integer array
         */
        Integer[] array = new Integer[input.length()] ;

        int i=0;
        for(int val : input.toCharArray()){
            array[i++] = val;
        }

        quickSort(array, 0, array.length-1);

        char[] chr = new char[input.length()];

        i = 0;

        /**
         * Convert to Char array
         */

        for(int val : array){
            chr[i++] = (char) val;
        }


        return chr;
    }
    
    // Given a Alphanumeric, please return a character with the lowest occurrence
    // E.g. AbcdAbc123123, the answer is d as it only occurs once
    // If there is more than 1 char with the same lowest occurrence, return the first char in ASC order
    public static char lowestOccurrence(String input) {
        Map<Character, Integer> occurrences = new HashMap<>();
        input.chars().forEach(c->occurrences.put((char)c, occurrences.getOrDefault(c, 0)+1));

        char minChar = input.charAt(0);
        int frequency = occurrences.get(minChar);

        for(Map.Entry<Character, Integer> entry : occurrences.entrySet()){
            if(entry.getValue()<frequency){
                minChar = entry.getKey();
                frequency = entry.getValue();
            } else if (entry.getValue()==frequency) {
                if(entry.getKey()<minChar){
                    minChar = entry.getKey();
                }
            }
        }


        return minChar;
    }
    
    // Emulate a calculator to resolve the given expression
    // Abide by the mathematics rules such as (), *, / have higher precedence than +, -
    // Please don't use any utility such as script engine, you need to implement the calculator logics
    // E.g.: expression: 2.3 * (3 + 4) + 5 / -0.3
    //       calculated: -0.56666666666667
    public static double solveEquations(String expression) {

        /**
         * If expression is wrong, then my solution gives error
         */
        StringBuilder sb = new StringBuilder();

        for(char c: expression.toCharArray()){
            if(c==' ' || c=='\t' || c=='\n'){
                continue;
            }
            sb.append(c);
        }



        CopyOnWriteArrayList<String> tokens = new CopyOnWriteArrayList<>();

        int pos = 0;

        while(pos<sb.length()){
            if(getOperators().contains(sb.charAt(pos)) ){
                tokens.add(sb.charAt(pos)+"");
            } else {
                int tpos  = nextOperatorPos(sb.toString(), pos);

                if(tpos==-1){

                    tokens.add(sb.substring(pos));

                    break;
                } else{
                    tokens.add(sb.substring(pos, tpos));

                    tokens.add(sb.charAt(tpos)+"");

                    pos = tpos;
                }
            }



            pos++;
        }




        Stack<Double> values = new Stack<>();
        Stack<String> operations = new Stack<>();

        //System.out.println(tokens);
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);

            if (!getOperators().contains(token.charAt(0))) {  // number
                //System.out.println(token);
                values.push(Double.parseDouble(token));
            } else if (token.equals("(")) {
                operations.push(token);
            } else if (token.equals(")")) {
                while (!operations.isEmpty() && !operations.peek().equals("(")) {
                    doOperation(values, operations.pop());
                }
                if (!operations.isEmpty()) operations.pop(); // remove '('
            } else {
                // Handle unary minus
                if (token.equals("-") && (i == 0 || tokens.get(i - 1).equals("(") || getOperators().contains(tokens.get(i - 1).charAt(0)))) {
                    values.push(-Double.parseDouble(tokens.get(i + 1)));
                    i++; // skip the next number
                    continue;
                }
                while (!operations.isEmpty() && precedence(operations.peek()) >= precedence(token)) {
                    doOperation(values, operations.pop());
                }
                operations.push(token);
            }
        }


        while (!operations.isEmpty()) {
            doOperation(values, operations.pop());
        }

        return values.pop();
    }

    private static void doOperation(Stack<Double> values, String op) {
        double b = values.pop();
        double a = values.isEmpty() ? 0 : values.pop();
        switch (op) {
            case "+": values.push(a + b); break;
            case "-": values.push(a - b); break;
            case "*": values.push(a * b); break;
            case "/": values.push(a / b); break;
        }
    }

    private static int precedence(String op) {
        switch (op) {
            case "+": case "-": return 1;
            case "*": case "/": return 2;
            default: return 0;
        }
    }

    private static Set<Character> getOperators(){
        Set<Character> operators = new HashSet<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');
        operators.add('(');
        operators.add(')');
        return operators;
    }

    private static int nextOperatorPos(String s, int currentPos){


        for (int i=currentPos; i<s.length(); i++){
            if(getOperators().contains(s.charAt(i))){
                return i;
            }
        }

        return -1;
    }



        
    public static void main(String[] args) {
        System.out.println("Test 1: " + reverseStringWithoutUsingStringMethod("Automation"));
        Integer[] intArray =sortIntegers( new Integer[] { 10, 12, 54, 1, 2, -9, 8 });

        System.out.print("Test 2: ");
        for (Integer i : intArray) {
            System.out.print(i + ", ");
        }
        
        System.out.println();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            Date startDate = sdf.parse("2024-12-01 13:09:22");
            Date endDate = sdf.parse("2025-01-09 20:10:12");
            Date givenDate = sdf.parse("2025-02-02 00:11:22");
            System.out.println("Test 3: " + isInDateRange(givenDate, startDate, endDate));
        } catch (Exception e) {
            System.out.println(e);
        }
        
        char[] sorted = sortStringInAscOrder("testingNG311");
        System.out.print("Test 4 :");
        for (char c: sorted) {
            System.out.print(c + ", ");
        }
        System.out.println();
        System.out.println("Test 5: " + lowestOccurrence("Abc1dd23affbc1ee23u3278"));
        System.out.print("Test 6: ");
        double calculated = solveEquations("3.4 * (-5.5 + 2.45) / 0.23 - 8.82 + 78.888");
        System.out.print("calculated = " + calculated);
    }
}
