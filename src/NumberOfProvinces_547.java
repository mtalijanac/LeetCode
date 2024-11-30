import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberOfProvinces_547 {
    AtomicInteger provinces = new AtomicInteger();

    public int findCircleNum(int[][] isConnected) {
        for (int r = 0; r < isConnected.length; r++) {
            for (int c = 0; c <= r; c++) {
                if (isConnected[r][c] > 0) {
                    provinces.incrementAndGet();
                    deleteProvince(isConnected, r, c);
                }
            }
        }
        return provinces.get();
    }

    void deleteProvince(int[][] isConnected, final int r, final int c) {
        if (isConnected[r][c] > 0) {
            isConnected[r][c] = -1;
        }

        for (int col = 0; col <= r; col++) {
            if (isConnected[r][col] > 0) {
                deleteProvince(isConnected, r, col);
            }
        }
        for (int row = c; row < isConnected.length; row++) {
            if (isConnected[row][c] > 0) {
                deleteProvince(isConnected, row, c);
            }
        }
    }

    String toString(int[][] a) {
        StringBuilder sb = new StringBuilder();
        for (int[] arr: a) {
            sb.append(Arrays.toString(arr)).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // a -> b -> c, d
        NumberOfProvinces_547 progs = new NumberOfProvinces_547();


        testCase_60: {
            int[][] connected = {
                    {1,0,0,1},
                    {0,1,1,0},
                    {0,1,1,1},
                    {1,0,1,1}};
            int res = progs.findCircleNum(connected);
            int exp = 1;
            System.out.println(res + " == " + exp + ", " + (res == exp));

        }
    }

}
