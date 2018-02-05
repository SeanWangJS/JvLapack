package com.haswalk.jvlapack;

/**
 * Created by wangx on 2017/11/30.
 */
public class JvLapack {

    static{
        System.load(System.getProperty("user.dir")+"\\native\\lib\\com_haswalk_jvlapack_JvLapack.dll");
    }

    /*=======================================================================*/
    /*======================Module: Symmetric Matrix=========================*/
    /*=======================================================================*/

    /*----------------------Eigenvalue---------------------------------------*/

    /**
     * Computes all eigenvalues and, optionally, eigenvectors of a
     * real symmetric matrix A.
     * @param jobz is a character to determine if or not to compute eigenvector, jobz == 'N',
     * then compute eigenvalue only, if jobz == 'V', then compute eigenvalue and eigenvector.
     * @param w eigenvalues in acsending order.
     * */
    public static native void dsyev(int layout, char jobz, char uplo, int n, double[] A, int LDA, double[] w);

    /*-----------------------------------------------------------------------*/
    /*----------------------Linear Solve-------------------------------------*/
    /*-----------------------------------------------------------------------*/

    /**
     * Computes the solution to a real system of linear equations
     * A * X = B,
     * where A is an N-by-N symmetric matrix and X and B are N-by-NRHS
     * matrices.
     * The diagonal pivoting method is used to factor A as
     * A = U * D * U**T,  if UPLO = 'U', or
     * A = L * D * L**T,  if UPLO = 'L',
     * where U (or L) is a product of permutation and unit upper (lower)
     * triangular matrices, and D is symmetric and block diagonal with
     * 1-by-1 and 2-by-2 diagonal blocks.  The factored form of A is then
     * used to solve the system of equations A * X = B.
     * */
    public static native void dsysv(int layout, char uplo, int n, int nrhs, double[] A, int LDA, int[] ipiv, double[] B, int LDB);

    /**
     * dposv computes the solution to a real system of linear equations
     * A * X = B,
     * where A is an N-by-N symmetric positive definite matrix and X and B
     * are N-by-NRHS matrices.
     * The Cholesky decomposition is used to factor A as
     * A = U**T* U,  if UPLO = 'U', or
     * A = L * L**T,  if UPLO = 'L',
     * where U is an upper triangular matrix and L is a lower triangular
     * matrix. The factored form of A is then used to solve the system of
     * equations A * X = B.
     * */
    public static native void dposv(int layout, char uplo, int n, int nrhs, double[] A, int LDA, double[] B, int LDB);

}
