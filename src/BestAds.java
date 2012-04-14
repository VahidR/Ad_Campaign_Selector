import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BestAds {

	public static void processFile(String fileName) {
		
		String  name = "";
		Integer impressions = 0;
		Integer numOfCampaigns = 0;
		Integer worth = 0;
		Integer value = 0;
		Integer Ad_inventory = 0;
		

	        try {
		         Scanner scanner = new Scanner(new File(fileName));
			 scanner.useDelimiter(System.getProperty("line.separator")); // which is '\n' in Unix like systems..
			 String first_line = scanner.next(); // skip the first line
			 Ad_inventory = Integer.parseInt(first_line);
			 System.out.println();
			 System.out.println("The Ad inventory is: " + Ad_inventory);
			 
			 HashMap<Integer, Object> hm = new HashMap<Integer , Object>();
			 Companies comp;	

			 ArrayList<Integer> worthList = new ArrayList<Integer>(); // It's all about soring the worth values
			 while (scanner.hasNext()) {

				Scanner lineScanner = new Scanner(scanner.next());
				lineScanner.useDelimiter(","); // a comma seprated file structure 

				name = lineScanner.next();
				impressions = lineScanner.nextInt();
				value = lineScanner.nextInt();
				numOfCampaigns = (Integer)(Ad_inventory/impressions); // to be sure that the outout is Integer.
				worth = numOfCampaigns * value;
				comp = new Companies(name, numOfCampaigns , worth);
				
				worthList.add(worth);
				hm.put(worth, comp);

		                System.out.println("-------\n" + name + " has " + impressions + " impressions per campaign \n The revenue per price is: " + value + "\n Its number of campaign is: "+ numOfCampaigns + "\n and it worth of: " + worth);

			 }

			 System.out.println();
			 System.out.println("------------------------------------------------------------------------ ");
			 System.out.println("The Best possible Solutions are: \n");
			 Collections.sort(worthList);
			 Collections.reverse(worthList); // since we need the most profitable companies. and Collections.sort() itself is ascending !!!
			 for (int i : worthList){
				 System.out.println(hm.get(i));
			 }
			 
			scanner.close();
		} catch (FileNotFoundException e) {
		           e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("usage: java bestAds "+ "file_name");
			System.exit(0);
		} else {
			processFile(args[0]);
		}
	}
}
