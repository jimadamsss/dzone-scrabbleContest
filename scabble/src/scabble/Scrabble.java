package scabble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Scrabble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			removeTiles("PQAREIOURSTHGWIOAE_");
			printRemainingTiles();
			reset();
		} 
		catch (IllegalArgumentException e)
		{
			System.out.println("Invalid input. More "+e.getMessage()+"'s have been taken from the bag than possible.");
		}
		System.out.println();
		try {
			removeTiles("LQTOONOEFFJZT");
			printRemainingTiles();
			reset();
		} 
		catch (IllegalArgumentException e)
		{
			System.out.println("Invalid input. More "+e.getMessage()+"'s have been taken from the bag than possible.");
		}
		System.out.println();
		try {
			removeTiles("AXHDRUIOR_XHJZUQEE");
			printRemainingTiles();
			reset();
		} 
		catch (IllegalArgumentException e)
		{
			System.out.println("Invalid input. More "+e.getMessage()+"'s have been taken from the bag than possible.");
		}
	}

	// tiles in alphabetical order space last. value indicates number of tiles
	public static int[] tiles = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1, 2};
	public static String letters="ABCDEFGHIJKLMNOPQRSTUVWXYZ_";
	
	public static void reset()
	{
		tiles = new int[]{9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1, 2};
	}
	public static void removeTiles(String input)
	{
		for(int i = 0; i < input.length();++i)
		{
			String letter = input.substring(i,  i+1);
			int index = input.charAt(i) - 'A';
			if (input.charAt(i) == '_')
				index = 26;
			if (tiles[index] == 0)
				throw new IllegalArgumentException(letter);
			tiles[index]--;
		}
	}
	public static void printRemainingTiles()
	{
		HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
		for(int i = 0;i < 27;++i)
		{
			Integer key = new Integer(tiles[i]);
			if (!map.containsKey(key))
			{
				map.put(key, new ArrayList<String>());
			}
			ArrayList<String> values = map.get(key);
			values.add( letters.substring(i,i+1));
		}
		Integer[] values = map.keySet().toArray(new Integer[0]);
		Arrays.sort(values);
		for (int i = values.length-1;i>=0;--i)
		{
			System.out.print(values[i]+": ");
			ArrayList<String> tilesLeft = map.get(values[i]);
			String comma = "";
			for(String tile : tilesLeft)
			{
				System.out.print(comma+" "+tile);
				comma = ",";
			}
			System.out.println();
		}
	}
}
