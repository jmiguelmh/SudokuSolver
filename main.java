package prueba;

import java.util.Scanner;


public class programa {
	
	static boolean comprobar(int [][] matriz, int fila, int columna, int numero)
	{
		boolean resultado = true;
		
		// Comprobar horizontal
		for(int i = 0; i < 9 && resultado; i++)
		{
			if(matriz[fila][i] == numero && i != columna)
				resultado = false;
		}
		
		// Comprobar vertical
		for(int i = 0; i < 9 && resultado; i++)
		{
			if(matriz[i][columna] == numero && i != fila)
				resultado = false;
		}
		
		//Comprobar recuadro
		int recuadroHorizontal = fila / 3;
		int recuadroVertical = columna / 3;
		
		if(resultado)
		{
			if(recuadroHorizontal == 0 && recuadroVertical == 0)
			{
				for(int i = 0; i < 3; i++)
					for(int j = 0; j < 3; j++)
						if(numero == matriz[i][j] && i != fila && j != columna)
							resultado = false;
			}
			else if(recuadroHorizontal == 0 && recuadroVertical == 1)
			{
				for(int i = 0; i < 3; i++)
					for(int j = 3; j < 6; j++)
						if(numero == matriz[i][j] && i != fila && j != columna)
							resultado = false;
			}
			else if(recuadroHorizontal == 0 && recuadroVertical == 2)
			{
				for(int i = 0; i < 3; i++)
					for(int j = 6; j < 9; j++)
						if(numero == matriz[i][j] && i != fila && j != columna)
							resultado = false;
			}
			else if(recuadroHorizontal == 1 && recuadroVertical == 0)
			{
				for(int i = 3; i < 6; i++)
					for(int j = 0; j < 0; j++)
						if(numero == matriz[i][j] && i != fila && j != columna)
							resultado = false;
			}
			else if(recuadroHorizontal == 1 && recuadroVertical == 1)
			{
				for(int i = 3; i < 6; i++)
					for(int j = 3; j < 6; j++)
						if(numero == matriz[i][j] && i != fila && j != columna)
							resultado = false;
			}
			else if(recuadroHorizontal == 1 && recuadroVertical == 2)
			{
				for(int i = 3; i < 6; i++)
					for(int j = 6; j < 9; j++)
						if(numero == matriz[i][j] && i != fila && j != columna)
							resultado = false;
			}
			else if(recuadroHorizontal == 2 && recuadroVertical == 0)
			{
				for(int i = 6; i < 9; i++)
					for(int j = 0; j < 0; j++)
						if(numero == matriz[i][j] && i != fila && j != columna)
							resultado = false;
			}
			else if(recuadroHorizontal == 2 && recuadroVertical == 1)
			{
				for(int i = 6; i < 9; i++)
					for(int j = 3; j < 6; j++)
						if(numero == matriz[i][j] && i != fila && j != columna)
							resultado = false;
			}
			else if(recuadroHorizontal == 2 && recuadroVertical == 2)
			{
				for(int i = 6; i < 9; i++)
					for(int j = 6; j < 9; j++)
						if(numero == matriz[i][j] && i != fila && j != columna)
							resultado = false;
			}
		}
		
		return resultado;
	}
	
	static boolean resuelto(int[][] matriz)
	{
		boolean resultado = true;
		
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9 && resultado; j++)
				if(!comprobar(matriz, i, j, matriz[i][j]) || matriz[i][j] == 0)
					resultado = false;
		
		return resultado;
	}
	
	static void resolver(int[][] matriz, int casilla)
	{
		if(!resuelto(matriz))
		{
			int fila = casilla / 9;
			int columna = casilla % 9;
			
			while(matriz[fila][columna] != 0)
			{
				casilla++;
				fila = casilla / 9;
				columna = casilla % 9;
			}
			
			// Probar con cada número
			if(comprobar(matriz, fila, columna, 1))
			{
				matriz[fila][columna] = 1;
				resolver(matriz, casilla + 1);
				if(!resuelto(matriz))
					matriz[fila][columna] = 0;
			}
			if(comprobar(matriz, fila, columna, 2))
			{
				matriz[fila][columna] = 2;
				resolver(matriz, casilla + 1);
				if(!resuelto(matriz))
					matriz[fila][columna] = 0;
			}
			if(comprobar(matriz, fila, columna, 3))
			{
				matriz[fila][columna] = 3;
				resolver(matriz, casilla + 1);
				if(!resuelto(matriz))
					matriz[fila][columna] = 0;
			}
			if(comprobar(matriz, fila, columna, 4))
			{
				matriz[fila][columna] = 4;
				resolver(matriz, casilla + 1);
				if(!resuelto(matriz))
					matriz[fila][columna] = 0;
			}
			if(comprobar(matriz, fila, columna, 5))
			{
				matriz[fila][columna] = 5;
				resolver(matriz, casilla + 1);
				if(!resuelto(matriz))
					matriz[fila][columna] = 0;
			}
			if(comprobar(matriz, fila, columna, 6))
			{
				matriz[fila][columna] = 6;
				resolver(matriz, casilla + 1);
				if(!resuelto(matriz))
					matriz[fila][columna] = 0;
			}
			if(comprobar(matriz, fila, columna, 7))
			{
				matriz[fila][columna] = 7;
				resolver(matriz, casilla + 1);
				if(!resuelto(matriz))
					matriz[fila][columna] = 0;
			}
			if(comprobar(matriz, fila, columna, 8))
			{
				matriz[fila][columna] = 8;
				resolver(matriz, casilla + 1);
				if(!resuelto(matriz))
					matriz[fila][columna] = 0;
			}
			if(comprobar(matriz, fila, columna, 9))
			{
				matriz[fila][columna] = 9;
				resolver(matriz, casilla + 1);
				if(!resuelto(matriz))
					matriz[fila][columna] = 0;
			}
		}
	}
	
	public static void main(String args[])
	{
		int matriz[][] = new int[9][9];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce los números (0 si son en blanco): ");
		
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				int numero = sc.nextInt();
				matriz[i][j] = numero;
				
			}
		}
		
		resolver(matriz, 0);
		
		System.out.println("Resultado:");
		
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				System.out.print(matriz[i][j] + " ");
				
			}
			System.out.println();
		}
	}
}
