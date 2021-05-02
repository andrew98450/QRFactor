package QRMethod;

public interface QRInterface
{
	public double[][] transpose(double[][] input);
	public double[][] matmul(double[][] in1, double[][] in2);
	public double product(double[] u, double[] a);  
	public double norm(double[] a);
	public void printVector(double[] input);
	public void printMatrix(double[][] input);
	public void Factor(double[][] Q, double[][] R);
}
