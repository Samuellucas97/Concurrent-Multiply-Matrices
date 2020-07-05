package br.ufrn.imd.br;

public class Row extends Thread{
	
	private Integer[][] a, b, c;
	private Integer startActualSectionRows, endActualSectionRows = 0, dimensionSquareMatrix;

	public Row(	Integer[][] a, 
				Integer[][] b, 
				Integer[][] c, 
				Integer startActualSectionRows, 
				Integer endActualSectionRows, 
				Integer dimensionSquareMatrix, 
				String name) {
		super(name);
		this.a = a;
		this.b = b;
		this.c = c;
		this.startActualSectionRows = startActualSectionRows;
		this.endActualSectionRows = endActualSectionRows;
		this.dimensionSquareMatrix = dimensionSquareMatrix;
	}

	@Override
	public void run() {
		
		Integer soma = 0;
		
		for (int actualSectionRows = this.startActualSectionRows; actualSectionRows < this.endActualSectionRows; ++actualSectionRows) {
			for (int actualColumnB = 0; actualColumnB < this.dimensionSquareMatrix; ++actualColumnB) {
				soma = 0;

				for (int actualColumnA_actualRowB = 0; actualColumnA_actualRowB < this.dimensionSquareMatrix; ++actualColumnA_actualRowB) {
					soma += this.a[actualSectionRows][actualColumnA_actualRowB]*this.b[actualColumnA_actualRowB][actualColumnB];				
				}

				c[actualSectionRows][actualColumnB] = soma;		
			}	
		}
	}	
}
