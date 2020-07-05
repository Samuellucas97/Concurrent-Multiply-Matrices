package br.ufrn.imd.br;

/*
 * Classe respons�vel pela implementa��o da vers�o sequencial da multiplica��o
 */
public class Sequential {
	
	/*
	 * M�todo que retorna a multiplica��o das matrizes de maneira sequ�ncial. 
	 * 
	 * @return 		O resultado da multiplica��o de a por b
	 * 
	 * @author Daniel Henrique Ferreira Gomes
	 */
	public static Integer[][] matrixMultiplication(Integer[][] a, Integer[][] b, Integer size) {
		Integer[][] c = new Integer[size][size];
		for (Integer i = 0; i < size; i++) {
			for (Integer j = 0; j < size; j++) {
				Integer soma = 0;
				for (Integer k = 0; k < size; k++) {
					soma += a[i][k]*b[k][j];
				}
				c[i][j] = soma;
			}
		}
		return c;
	}
}