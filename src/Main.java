import java.util.Scanner;
import QRMethod.QRFactor;
import QRMethod.QRInterface;

public class Main {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int m = 0, n = 0;
		
		System.out.print("Input M:");
		m = input.nextInt();
		System.out.print("Input N:");
		n = input.nextInt();
		
		if (m < n)
			return;
		
		double[][] A = new double[m][n];
		double[][] Q = new double[m][n];
		double[][] R = new double[n][n];
		
		System.out.println("Input A:");
		for(int i = 0; i < A.length; i++) 
		{
			for(int j = 0; j < A[i].length; j++)
			{
				A[i][j] = input.nextDouble();
			}
		}
		
		QRInterface qrFactor = new QRFactor(A);
		qrFactor.Factor(Q, R);
		
		System.out.println("Q=");
		qrFactor.printMatrix(Q);
		System.out.println("R=");
		qrFactor.printMatrix(R);
	}
}
