package br.ufrn.imd.br;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * Contém métodos de manipulação de arquivo personalizada para a leitura e escrita de arquivos de matrizes 
 * @author Samuel Lucas de Moura Ferino
 */
public class FileManipulation {
     
	/**
     * Lê o arquivo contendo matriz   
     * @param   fileName   Nome do arquivo a ser lido
     * @return  A matriz referente ao conteúdo do arquivo se a leitura for feita corretamente, senão uma matriz 1x1 vazia
     */
	public static Integer[][] read(String fileName){
        try{
            BufferedReader buffReader = new BufferedReader(new FileReader( fileName ));
            
            String[] dimensionsString = buffReader.readLine().split(" ");
            Integer numberOfLines = Integer.parseInt(dimensionsString[0]);
            Integer numberOfColumns = Integer.parseInt(dimensionsString[1]);

            Integer[][] matrix = new Integer[numberOfLines][numberOfColumns]; 
            String[] lineElements = new String[numberOfColumns]; 

            int actualLine = 0;    

            /// Lendo cada linha e salvando na matriz
            while( actualLine < numberOfLines ){             
                lineElements = buffReader.readLine().split(" ");

                for(int actualColumn=0; actualColumn < numberOfColumns; ++actualColumn) {
                    matrix[actualLine][actualColumn] = Integer.parseInt( lineElements[actualColumn] ); 
                }
                
                ++actualLine;
            }

            buffReader.close();
            return matrix;

        }
        catch(FileNotFoundException e){  /// Exceção de que arquivo não existe
            System.err.println( e.getMessage() );   
            return new Integer [1][1]; /// Retorno padrão 
        }  
        catch(IOException e){  /// Ocorreu outro tipo de exceção, sendo esse desconhecido
            System.err.println( e.getMessage() );
            return new Integer [1][1]; /// Retorno padrão
        }
    }
     
	/**
     * Salva o conteúdo de uma matriz em um arquivo   
     * @param   fileName   Nome do arquivo a ser escrito
     * @param   matrix   Matriz que será salva no arquivo
     * @param	numberOfLines	Quantidade de linhas da matriz
     * @param	numberOfColumns	Quantidade de colunas da matriz
     * @return  true caso a operação dê certo, caso contrário falso
     */	
	public static boolean save(String fileName, Integer[][] matrix, int numberOfLines, int numberOfColumns){
	    
	    String content =  String.valueOf(numberOfLines) + " " 
	        + String.valueOf(numberOfColumns) + "\n";
	
	    /// Leitura da matriz adicionando seus elementos a uma string 
	    for(int actualLine=0; actualLine < numberOfLines; ++actualLine) {
	        for(int actualColumn=0; actualColumn < numberOfColumns; ++actualColumn) {
	            content += String.valueOf( matrix[actualLine][actualColumn] );
	            content += " "; /// Adicionando espaço
	        }
	        content += "\n"; /// Quebrando a linha 
	    }
	
	    try{
	      FileWriter writer = new FileWriter(fileName);     
	
	      writer.write(content);
	      writer.close();  
	
	      return true;
	
	    }
	    catch(FileNotFoundException e){   ///  Exceção de que arquivo não existe
	        System.err.println( e.getMessage() );
	        return false;        
	    }
	    catch(IOException e){  /// Ocorreu outro tipo de exceção, sendo esse desconhecido
	        System.err.println( e.getMessage() );
	        return false;
	    }
	}

     
}