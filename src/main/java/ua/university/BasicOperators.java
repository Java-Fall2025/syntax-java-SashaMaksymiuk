package ua.university;

import java.util.Arrays;

/**
 * BasicOperators class contains a set of static methods
 * for practicing Java operators, loops, arrays, and branching.
 */
public class BasicOperators {

    /**
     * Returns the sum and average of three integers.
     *
     * @param a first integer
     * @param b second integer
     * @param c third integer
     * @return double array where [0] = sum, [1] = average
     */
    public static double[] sumAndAverage(int a, int b, int c) {
        // Арифметичні оператори (+, /)
        int sum = a + b + c;
        // Важливо: ділення цілих чисел (sum / 3) дасть цілочисельний результат.
        // Для отримання точного середнього необхідно виконати ділення з плаваючою точкою.
        double average = (double) sum / 3.0;
        
        return new double[]{sum, average};
    }

    /**
     * Returns the maximum of three integers.
     */
    public static int maxOfThree(int a, int b, int c) {
        // Оператори порівняння (>) та логічні оператори (||, &&) або використання Math.max
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
        // Альтернативно: return Math.max(a, Math.max(b, c));
    }

    /**
     * Returns the corresponding grade letter for a given numeric score.
     * <p>
     * The grading scale is as follows:
     * <ul>
     * <li>90–100: 'A'</li>
     * <li>80–89:  'B'</li>
     * <li>70–79:  'C'</li>
     * <li>60–69:  'D'</li>
     * <li>50–59:  'E'</li>
     * <li>0–49:   'F'</li>
     * </ul>
     *
     * @param score the numeric score, expected to be between 0 and 100 inclusive
     * @return the grade letter corresponding to the given score
     * @throws IllegalArgumentException if {@code score} is less than 0 or greater than 100
     */
    public static char gradeFromScore(int score) {
        // Перевірка на некоректні аргументи
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100 inclusive. Received: " + score);
        }

        // Розгалуження (if-else if-else)
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else if (score >= 50) {
            return 'E';
        } else {
            return 'F';
        }
    }

    /**
     * Returns the day of the week name for a number 1-7.
     *
     * @param day number of the day (1 for Monday, 7 for Sunday)
     * @return name of the day
     * @throws IllegalArgumentException if day is not between 1 and 7
     */
    public static String dayOfWeek(int day) {
        if (day < 1 || day > 7) {
            throw new IllegalArgumentException("Day number must be between 1 and 7. Received: " + day);
        }

        // Розгалуження (switch)
        switch (day) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                // Цей блок не повинен виконуватися через перевірку на початку,
                // але залишається для повноти switch.
                throw new IllegalStateException("Unexpected value: " + day);
        }
    }

    /**
     * Returns an array counting down from n to 1.
     *
     * @param n starting number (must be > 0)
     * @return array with elements [n, n-1, ..., 1]
     * @throws IllegalArgumentException if n is less than or equal to 0
     */
    public static int[] countdown(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0. Received: " + n);
        }

        // Робота з масивами та цикли (for loop)
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = n - i; // Використання оператора віднімання
        }
        return result;
    }

    /**
     * Returns factorial of n.
     *
     * @param n non-negative integer
     * @return factorial of n (n!)
     * @throws IllegalArgumentException if n is less than 0
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be a non-negative integer. Received: " + n);
        }
        if (n == 0) {
            return 1;
        }

        // Цикли (for loop) та оператор множення (*)
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Returns a reversed copy of the array.
     *
     * @param arr the input array
     * @return a new array with elements in reverse order
     * @throws IllegalArgumentException if arr is null
     */
    public static int[] reverseArray(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }

        // Цикл (for loop) та робота з індексами масиву
        int n = arr.length;
        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            // Елемент arr[i] переміщується на позицію reversed[n - 1 - i]
            reversed[i] = arr[n - 1 - i];
        }
        return reversed;
    }

    /**
     * Returns sum of all elements in a 2D array (matrix).
     *
     * @param matrix the 2D array
     * @return the total sum of all elements
     * @throws IllegalArgumentException if matrix is null
     */
    public static int sumMatrix(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Input matrix cannot be null.");
        }

        // Вкладені цикли (nested loops) для роботи з 2D масивами
        int sum = 0;
        for (int[] row : matrix) {
            if (row != null) {
                for (int element : row) {
                    sum += element;
                }
            }
        }
        return sum;
    }

    /**
     * Checks if a string is a palindrome.
     *
     * @param s the string to check
     * @return true if the string is a palindrome, false otherwise
     * @throws IllegalArgumentException if s is null
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input string cannot be null.");
        }

        // Перетворення, цикли, порівняння символів
        // Ігноруємо регістр та пробіли для коректної перевірки
        String cleanS = s.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = cleanS.length() - 1;

        while (left < right) {
            if (cleanS.charAt(left) != cleanS.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Returns minimum and maximum of an array.
     *
     * @param arr the input array
     * @return int array where [0] = minimum, [1] = maximum
     * @throws IllegalArgumentException if arr is null or empty
     */
    public static int[] findMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty.");
        }

        // Цикл (for loop) та оператори порівняння (>, <)
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return new int[]{min, max};
    }

    /**
     * Returns multiplication table n x n.
     *
     * @param n size of the table (must be > 0)
     * @return a 2D array representing the multiplication table
     * @throws IllegalArgumentException if n is less than or equal to 0
     */
    public static int[][] multiplicationTable(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0. Received: " + n);
        }

        // Вкладені цикли та оператор множення
        int[][] table = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Рядок (i+1) * Стовпець (j+1)
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }

    /**
     * Returns all even numbers up to n (inclusive).
     *
     * @param n the upper bound (must be non-negative)
     * @return an array containing all even numbers from 0 up to n
     * @throws IllegalArgumentException if n is less than 0
     */
    public static int[] evenNumbersUpToN(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative. Received: " + n);
        }

        // Цикл, оператор ділення по модулю (%) та динамічне визначення розміру масиву
        int count = n / 2 + 1; // Кількість парних чисел від 0 до n включно
        int[] evens = new int[count];
        int index = 0;

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                evens[index++] = i;
            }
        }
        return evens;
    }

    /**
     * Checks if a number is prime.
     *
     * @param n the number to check (must be non-negative)
     * @return true if the number is prime, false otherwise
     * @throws IllegalArgumentException if n is less than 0
     */
    public static boolean isPrime(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative. Received: " + n);
        }
        if (n <= 1) {
            return false;
        }

        // Цикл та оператор ділення по модулю (%)
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Counts vowels in a string.
     *
     * @param s the input string
     * @return the number of vowels (a, e, i, o, u, A, E, I, O, U)
     * @throws IllegalArgumentException if s is null
     */
    public static int countVowels(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input string cannot be null.");
        }

        // Цикл (for-each character) та оператор порівняння символів
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) { // Перевірка, чи символ є у рядку голосних
                count++;
            }
        }
        return count;
    }

    /**
     * Returns first n Fibonacci numbers.
     *
     * @param n number of Fibonacci numbers to return (must be >= 0)
     * @return an array containing the first n Fibonacci numbers
     * @throws IllegalArgumentException if n is less than 0
     */
    public static int[] fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative. Received: " + n);
        }

        if (n == 0) {
            return new int[0];
        }
        if (n == 1) {
            return new int[]{0};
        }

        // Цикл та оператор додавання (+)
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    /**
     * Returns the transpose of a 2D array (matrix).
     *
     * @param matrix the input matrix (must be non-null and rectangular)
     * @return the transposed matrix
     * @throws IllegalArgumentException if matrix is null or not rectangular (optional, but good practice)
     */
    public static int[][] transpose(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Input matrix cannot be null.");
        }

        // Перевірка на порожню матрицю або 0 рядків/стовпців
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }

        // Вкладені цикли: міняємо місцями кількість рядків та стовпців
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Головний оператор: поміняти індекси місцями
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    /**
     * Returns a sorted copy of the array in ascending order.
     *
     * @param arr the input array
     * @return a new array that is a sorted copy of the input array
     * @throws IllegalArgumentException if arr is null
     */
    public static int[] sortArray(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }

        // Використання допоміжного методу Arrays.sort для простоти,
        // або реалізація алгоритму сортування (наприклад, сортування бульбашкою)
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr); // Використання вбудованої функції сортування

        /*
        // Приклад реалізації сортування бульбашкою (якщо потрібно використовувати лише оператори):
        int n = sortedArr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (sortedArr[j] > sortedArr[j + 1]) { // Оператор порівняння (>)
                    // Обмін (swap)
                    int temp = sortedArr[j];
                    sortedArr[j] = sortedArr[j + 1];
                    sortedArr[j + 1] = temp;
                }
            }
        }
        */

        return sortedArr;
    }
}
