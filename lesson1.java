public class lesson1 {
    public static void main(String[] args) {
//        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        System.out.println(sizeArray(arr, 15));
        int[] arr1 = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] arr2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr = arrayDifference(arr1, arr2);
        if (arr != null) {
            printArray(arr);
        }
    }

    public static int sizeArray(int[] arr, int min) {
        int a = arr.length;
        if (a < min) {
            return -1;
        }
        return a;
    }

    public static int[] arrayDifference (int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            System.out.println("Длины массивов не равны, разница не была рассчитана.");
            return null;
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] - arr2[i];
        }
        return result;
    }

    public static void printArray (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ' ');
        }
        System.out.println();
    }
}
