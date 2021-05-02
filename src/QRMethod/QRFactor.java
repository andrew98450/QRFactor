package QRMethod;

public class QRFactor implements QRInterface {
	double[][] A;
	public QRFactor(double[][] A) 
	{
		this.A = A;
	}
	@Override
	public double[][] transpose(double[][] input) {
		
		// TODO Auto-generated method stub
		int m = input.length;
		int n = input[0].length;
		double[][] output = new double[n][m];
		for(int i = 0; i < m; i++) 
		{
			for(int j = 0; j < n; j++) 
			{
				output[j][i] = input[i][j];
			}
		}
		return output;
	}

	@Override
	public double[][] matmul(double[][] in1, double[][] in2) {
		// TODO Auto-generated method stub
		int m = in1.length;
		int n = in2[0].length;
		int p = in2.length;
		double[][] output = new double[m][n];
		for(int i = 0; i < m; i++) 
		{
			for(int j = 0; j < n; j++) 
			{
				double sum = 0;
				for(int k = 0; k < p; k++)
					sum += in1[i][k] * in2[k][j];
				output[i][j] = sum;
			}
		}
		return output;
	}

	@Override
	public double product(double[] u, double[] a) {
		// TODO Auto-generated method stub
		double sum = 0;
		for(int i = 0; i < u.length; i++) 
		{
			sum += u[i] * a[i];
		}
		return sum;
	}

	@Override
	public double norm(double[] a) {
		// TODO Auto-generated method stub
		double sum = 0;
		for(int i = 0; i < a.length; i++) 
		{
			sum += Math.pow(a[i], 2);
		}
		sum = Math.sqrt(sum);
		return sum;
	}

	@Override
	public void Factor(double[][] Q, double[][] R) {
		// TODO Auto-generated method stub
		double[][] AT = this.transpose(this.A);
		double[][] U = new double[AT.length][AT[0].length];
		for(int i = 0; i < AT.length; i++) 
		{
			for(int j = 0; j < AT[i].length; j++)
			{
				if(i == 0) 
				{
					U[i][j] = AT[i][j];
				}
				else 
				{
					double sum = 0;
					for(int k = 0; k < i; k++)
					{
						double ua_product = this.product(U[k], AT[i]);
						double uu_product = this.product(U[k], U[k]);
						sum += (ua_product / uu_product) * U[k][j];
					}
					U[i][j] = AT[i][j] - sum;
				}
			}
			for(int j = 0; j < AT[i].length; j++) 
			{
				Q[j][i] = U[i][j] / this.norm(U[i]);
			}
		}
		double[][] QT = this.transpose(Q);
		double[][] rOut = this.matmul(QT, this.A);
		for(int i = 0; i < R.length; i++)
		{
			for(int j = 0; j < R[i].length; j++) 
			{
				R[i][j] = rOut[i][j];
			}
		}
	}

	@Override
	public void printVector(double[] input) {
		// TODO Auto-generated method stub
		for(int i = 0; i < input.length; i++) 
		{
			System.out.println(input[i]);
		}
	}

	@Override
	public void printMatrix(double[][] input) {
		// TODO Auto-generated method stub
		for(int i = 0; i < input.length; i++)
		{
			for(int j = 0; j < input[i].length; j++) 
			{
				System.out.printf("%.4f ", input[i][j]);
			}
			System.out.println();
		}
	}

}
