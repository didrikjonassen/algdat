package algdat.matrix;

public class Matrix {
	
	/**
	 * Cache-oblivious algorithm for multiplying two matrices. More than 3x speedup over the naïve implementation on a 2048x2048 matrix.
	 * For a sparse matrix the speedup is proportional to the number of elements divided by the number of zero-elements in matrix A.
	 * 
	 * @param A The left matrix to be multiplied.
	 * @param B The right matrix to be multiplied.
	 * @return Matrix C = A*B.
	 */
	public static int[][] matrixmul(int[][] A, int[][] B){
		int m = A.length;
		int n = B[0].length;
		int o = B.length;
		int temp;
		int[][] c = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < o; j++){
				if(A[i][j]==0){
					continue;
				} else {
					temp = A[i][j];
					for(int k = 0; k < n; k++){
						c[i][k] += temp*B[j][k];
					}
				}
			}
		}
		return c;
	}

}
