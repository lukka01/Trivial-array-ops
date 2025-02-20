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

//    The Alps
//    We receive an array arr to check whether this array is alpine.
//    An alpine array consists a  sequence of strictly
//    increasing elements to some peak, from where its
//    elements are strictly decreasing.

    public static boolean alpine(int[] arr) {
        int max = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if ( max < arr[i] ) {
                max = arr[i];
                index++;
            }

        }
        for (int i = 0; i < index-1; i++) {
            if (arr[i] >= arr[i+1])
                return false;
        }
        for (int i = index; i < arr.length-1; i++) {
            if (arr[i] <= arr[i+1])
                return false;
        }
        return true;
    }

//    Penguin Giorgi tries to make a fortune as plancton merchant
//    at the South Pole. For that, he likes to know the optimal time points
//    when to buy and when to sell plancton. He is lucky in that he may query
//    from a penguin oracle the prizes
//    of the coming (max. 30) days. We want to help him to achieve optimal profit.

    public static int[] merchant (int[] arr ) {
        int[] res = new int[3];
        int min = arr[0];
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }

        if (minIndex == arr.length-1) {
            return new int[]{0,0,0};
        }

        int max = 0;
        int maxIndex = 0;
        for (int i = minIndex; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        res[0] = minIndex;
        res[1] = maxIndex;
        res[2] = max - min;
        return res;

    }








}
