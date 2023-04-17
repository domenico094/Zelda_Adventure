package zelda_adventure.resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import zelda_adventure.config.Setting;

public class LoadWorld {
	public static  ArrayList<ArrayList<Integer>> temp =  new ArrayList<ArrayList<Integer>>();

	

	public static ArrayList<ArrayList<Integer>> getWorldMap() {

		try (BufferedReader br = new BufferedReader(new FileReader(Setting.R_WORLDMAP))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.isEmpty())
					continue;

				ArrayList<Integer> riga = new ArrayList<>();
				String[] val = linea.trim().split(" ");
				for (String str : val) {
					if (!str.isEmpty()) {
						int id = Integer.parseInt(str);
						riga.add(id);
					}
				}
				temp.add(riga);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

}
