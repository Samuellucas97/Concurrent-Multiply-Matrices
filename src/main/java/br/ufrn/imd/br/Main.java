package br.ufrn.imd.br;

public class Main {
	public static void checkArguments(Integer dimensionMatrix, String versionAlgorithm) {
		
		if ( 	dimensionMatrix != 4 && 
				dimensionMatrix != 8 && 
				dimensionMatrix != 16 && 
				dimensionMatrix != 32 &&
				dimensionMatrix != 64 && 
				dimensionMatrix != 128 && 
				dimensionMatrix != 256 &&
				dimensionMatrix != 512 && 
				dimensionMatrix != 1024 && 
				dimensionMatrix != 2048 ) {
			throw new IllegalArgumentException("O primeiro parâmetro refere-se à dimensão das matrizes quadradras trabalhadas. "
					+ "As opcoes são 4, 8, 16, 32, 64, 128, 512, 1024 e 2048.");
		}
		
		if (	(versionAlgorithm.length() != 1) || 
				(!versionAlgorithm.equals("S") && !versionAlgorithm.equals("C")) ) {
			throw new IllegalArgumentException("O segundo parâmetro refere-se ao tipo de algoritmo escolhido. "
					+ "As opcoes são 'S' para a versão sequencial e 'C' para a versão concorrente.");
		}		
	}
	
	public static void main(String[] args) {
	
		Integer dimensionMatrix = 0;
		String versionAlgorithm = ""; 
		
		if (args.length != 2) {
			throw new IllegalArgumentException("São apenas dois parâmetros."
						+ "O primeiro parâmetro refere-se a dimensão das matrizes quadradas trabalhadas e o segundo "
						+ "parâmetro refere-se a versão do algoritmo.");	
		}
		else {
			dimensionMatrix = Integer.parseInt(args[0]);
			versionAlgorithm = args[1];
			
			checkArguments(dimensionMatrix, versionAlgorithm);
		}
		
		String nomeDoArquivoA = new String("resources/A"+dimensionMatrix+"x"+dimensionMatrix+".txt");
		String nomeDoArquivoB = new String("resources/B"+dimensionMatrix+"x"+dimensionMatrix+".txt");
	
		/// Matrizes
		Integer[][] A = FileManipulation.read(nomeDoArquivoA);
	    Integer[][] B = FileManipulation.read(nomeDoArquivoB);
	    Integer[][] C = {};
		
	    /// Variáveis usadas para cronometrar o tempo
	    long startTimeExecution = 0;
	    long endTimeExecution = 0;
	    
	    /// Versão sequencial
		if ( versionAlgorithm.equals("S") ) {
		    startTimeExecution = System.currentTimeMillis();
		    C = Sequential.matrixMultiplication(A, B, dimensionMatrix);
		    endTimeExecution = System.currentTimeMillis();
		    
		    long sequentialResultTimeExecution = endTimeExecution - startTimeExecution;
		    
		    System.out.println(dimensionMatrix+":"+"Time execution of the sequential version: " + sequentialResultTimeExecution);

		    FileManipulation.save("resources/C"+dimensionMatrix+"x"+dimensionMatrix+".txt", C, dimensionMatrix, dimensionMatrix);
		}
		/// Versão concorrente
		else {
			startTimeExecution = System.currentTimeMillis();
		    C = Concurrent.matrixMultiplication(A, B, dimensionMatrix);
		    endTimeExecution = System.currentTimeMillis();
		    
		    long concurrentResultTimeExecution = endTimeExecution - startTimeExecution;

		    System.out.println(dimensionMatrix+":"+"Time execution of the concurrent version: " + concurrentResultTimeExecution);
			
		    FileManipulation.save("resources/C"+dimensionMatrix+"x"+dimensionMatrix+".txt", C, dimensionMatrix, dimensionMatrix);
		}
	}
}