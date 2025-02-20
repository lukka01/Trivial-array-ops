public class Main {
    public static void main(String[] args) {
//        int[] arr = new int[] {1,2,3,4,5,6};
//        print(arr);
//        minUndMax(new int[] {1, 10, 25, -13, 1000});
//        invert(new int[] {0, 1, 2, 3});
//        cut(new int[] {1, 2, 3}, 5);
        linearize(new int[][] {{1, 3}, {25}, {7, 4, 6, 9}});


    }

    public static void print (int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length-1]);
        System.out.print("}");
    }

    public static void minUndMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        System.out.println("Minimum = " + min);
        System.out.println("Maximum = " + max);
    }

    public static void invert(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len/2; i++) {
            int temp = arr[i];
            arr[i] = arr[len -1-i];
            arr[len-1-i] = temp;
        }
        print(arr);
    }


    public static int[] cut(int[] arr, int len) {
        int[] cutArray = new int[len];
        for (int i = 0; i < arr.length; i++) {
            cutArray[i] = arr[i];
        }
        print(cutArray);
        return cutArray;
    }

    public static int[] linearize(int[][] arr) {
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            len += arr[i].length;
        }
        int[] res = new int[len];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                res[index++] = arr[i][j];
            }
        }
        print(res);
        return res;
    }

    public static int[] otherSort(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        boolean[] visited = new boolean[arr1.length];
        int count = 0;

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i] && !visited[j]) {
                    res[count++] = arr1[j];
                    visited[j] = true;
                }
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!visited[i]) {
                res[count++] = arr1[i];
            }
        }
        return res;
    }








}
