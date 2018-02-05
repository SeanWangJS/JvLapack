package com.haswalk.jvlapack;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangx on 2017/11/30.
 */
public class JvLapackTest {


    @Test
    public void testDposv(){
        double[] A = {
                3.14,  0.17, -0.90, 1.65, -0.72,
                0.00,  0.79,  0.83, -0.65,  0.28,
                0.00,  0.00,  4.53, -3.70,  1.60,
                0.00,  0.00,  0.00, 5.32, -1.37,
                0.00,  0.00,  0.00, 0.00,  1.98
        };
        double[] B = {
                -7.29,
                9.25,
                5.99,
                -1.94,
                -8.30
        };
        int n = 5;
        int LDA = 5;
        int LDB = 1;
        char uplo = 'U';
        int nrhs = 1;
        JvLapack.dposv(JvLapackLayout.ROW_MAJOR, uplo, n, nrhs, A, LDA, B, LDB);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < LDB; j++) {
                System.out.print(B[i * LDB + j] + "\t");
            }
            System.out.println();
        }
    }

    @Test
    public void testDsyev() {
        double[] A = {1.96, -6.49, -0.47, -7.20, -0.65,
                0.00,  3.80, -6.39,  1.50, -6.34,
                0.00,  0.00, 4.17, -1.51, 2.67,
                0.00,  0.00, 0.00,  5.70, 1.80,
                0.00,  0.00, 0.00,  0.00, -7.10};
        char jobz = 'V';
        char uplo = 'U';
        int N = 5;
        int LDA = 5;
        double[] w = new double[5];
        JvLapack.dsyev(JvLapackLayout.ROW_MAJOR, jobz, uplo, N, A, LDA, w);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < LDA; j++) {
                System.out.print(A[i * LDA + j] + ", ");
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(w));


    }

}
