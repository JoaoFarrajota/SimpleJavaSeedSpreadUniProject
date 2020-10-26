package pcoPrimeiraFasePackage;

/**
 * This class will create a visual representation of a certain terrain and the changes made on it depending of the wind , wind strength and obstacles.
 * @author Grupo 14 - Joao Farrajota(47141) , Pedro Luis(53469) e Claudia Palmeiro(50429)
 * @date October 2020
 */

public class MetodosEvolucao {

			
	/**
	 * This method calls the method espalhamento and vizinhosAfetados making changes to the original array
	 * @param terreno is a char 2D array 
	 * @param ventoLimites is an int array 
	 * @param ventoDir is a String
	 * @param ventoForca is an int
	 * @requires terreno != null and  ventoLimites != null and 
	 * 			 ventoDir != null and  ventoDir in {"N","S","E","O"} and 
	 * 			 ventoForca >= 0
	 */
	public static void evolucao(char[][] terreno, int[] ventoLimites, String ventoDir, int ventoForca) {

		espalhamento(terreno, vizinhosAfetados(ventoLimites, ventoForca), ventoDir);
		
	}

	
	
	/**
	 * This method calculates the amount of terrains affected depending on a certain wind strength(ventoForca) and array(ventoLimites) and returns it.
	 * @param ventoLimites is an int array
	 * @param ventoForca is an int 
	 * @requires ventoLimites != null  and  ventoForca >= 0
	 * @return an int representing the number of affected neighbors by the wind  
	 */
	public static int vizinhosAfetados(int[] ventoLimites, int ventoForca) {

	

		int vizinhos = 0;

		for (int i = 0; i < ventoLimites.length; i++)

			if (ventoForca <= ventoLimites[i]) {

				vizinhos = i;

				return vizinhos;

			}

		return vizinhos;

	}
	
	
	/**
	 * This method creates a copy of a certain terrain 
	 * @param terreno is a char 2D array  
	 * @requires terreno != null
	 * @return a char 2D array to be iterated in further methods
	 */
	public static char[][] copiaTerreno (char[][] terreno) {
	

		char[][] terrenoCopia = new char[terreno[0].length][terreno[0].length];

		for (int x = 0; x < terreno.length; x++)
			for (int y = 0; y < terreno[0].length; y++)

				terrenoCopia[x][y] = terreno[x][y];
		
		return terrenoCopia;
	}
	
	
	

	/**
	 * This method changes(replace '.' with '*') a certain terrain depending on the wind direction(only horizontally and vertically) and the amount of terrains affected(vizinhosAfetados) .
	 * When it find a wall(x) it stops affecting the terrain in that direction.
	 * @param terreno is a char 2D array
	 * @param vizinhos is an int
	 * @param ventoDir is a String
	 * @requires terreno != null  and  ventoDir != null and  ventoDir in {"N","S","E","O"} 
	 *			 and  vizinhos >= 0
	 * 			 
	 */
	public static void espalhamento(char[][] terreno, int vizinhos, String ventoDir) {

 
		char[][] terrenoCopia = copiaTerreno(terreno);
				
		for (int i = 0; i < terreno.length; i++) {
			for (int j = 0; j < terreno[i].length; j++) {

				int k = 0;
				
		
				

				while (k < vizinhos && k >= 0) {
					
					k = k + 1;
			
									
					
					switch (ventoDir) {

					case ("O"): {

						if ((j + k) < terrenoCopia.length && terrenoCopia[i][j] == '*') {

							if (terrenoCopia[i][j + k] == 'x') {

								k = -1;

							} else {

								terreno[i][j + k] = '*';

							}
						}

						break;
					}

					case ("E"): {
						
						if ((j - k) >= 0  && terrenoCopia[i][j] == '*') {

							if (terrenoCopia[i][j - k] == 'x') {

								k = -1;

							} else {

								terreno[i][j - k] = '*';

							}
						}
						
						break;
					}

					case ("N"): {
						
						if ((i + k) <  terreno.length   && terrenoCopia[i][j] == '*') {

							if (terrenoCopia[i+k][j] == 'x') {

								k = -1;

							} else {

								terreno[i+k][j] = '*';

							}
						}
						
						break;
					}

					case ("S"): {
						
						if ((i - k) >=  0   && terrenoCopia[i][j] == '*') {

							if (terrenoCopia[i-k][j] == 'x') {

								k = -1;

							} else {

								terreno[i-k][j] = '*';

							}
						}
						
						break;
						
					}

					}
				}

			}
		}
		

	}

}
