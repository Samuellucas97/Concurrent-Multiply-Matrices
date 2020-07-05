package br.ufrn.imd.br;

public class Concurrent {
	
	public static Integer[][] matrixMultiplication(Integer[][] A, Integer[][]B, Integer dimensionSquareMatrix ) {
		
		Integer[][] C = new Integer[dimensionSquareMatrix][dimensionSquareMatrix];

		int numberOfThreads = 5;//Runtime.getRuntime().availableProcessors();
		numberOfThreads = Math.min(numberOfThreads, dimensionSquareMatrix);
		
		/// Divindo a dimensão da matriz pela quantidade de threads possíveis 
		int numberElementsBySectionRows = dimensionSquareMatrix / numberOfThreads;
		
		Row[] rows = new Row[numberOfThreads];
		int startActualSectionRows = 0;
		int endActualSectionRows = 0; // Inicializando;
		
		for (int actualThread = 0; actualThread < numberOfThreads; ++actualThread) {
			endActualSectionRows = startActualSectionRows + numberElementsBySectionRows;
					
			Row row = new Row(A, B, C, startActualSectionRows, endActualSectionRows, dimensionSquareMatrix, 
					"Thread-" + Integer.toString(actualThread));
			row.start();
			rows[actualThread] = row;
			
			startActualSectionRows = endActualSectionRows;
		}
		for (Row row : rows) {
			try {
				row.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		/// Ainda falta linhas devido a divisão dimensionSquareMatrix / numberOfThreads não
		/// ser exata
		if (startActualSectionRows != (dimensionSquareMatrix)) {
			try {
				Row row = new Row(A, B, C, startActualSectionRows, (dimensionSquareMatrix), dimensionSquareMatrix, "Thread-*");
				row.start();
				row.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return C;
	}
}
