package com.problems.trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CrateDistance {
	
	public static List<List<Integer>> solution(int totalCrates, List<List<Integer>> allLocations ,int truckCapacity){
		
		if(totalCrates<truckCapacity){
				return new ArrayList<List<Integer>>();
		}
		
		//System.out.println(allLocations);
		TreeMap<Double, List<Integer>> sortedCrateDistances = new TreeMap<Double, List<Integer>>();
		
		
		
		for(int i = 0; i < allLocations.size(); i++){
			
			List<Integer> cachedCordinates = new ArrayList<>();
			
			cachedCordinates.add(allLocations.get(i).get(0));
			cachedCordinates.add(allLocations.get(i).get(1));
			
			Double distance= getDistance(allLocations.get(i).get(0) ,  allLocations.get(i).get(1));
			
			sortedCrateDistances.put(distance , cachedCordinates );
		}
		
		List<List<Integer>> outputDistances = new ArrayList<>();
		int count =0 ;
		for(Map.Entry<Double, List<Integer>> entry :  sortedCrateDistances.entrySet()){
				if(count<truckCapacity){

					
					outputDistances.add(entry.getValue());
					count++;
				}
		}
		
		return outputDistances;
		
	}
	
	static double getDistance(int x, int y){
		
		double distance =  Math.sqrt( (x*x) + (y*y) );
		return distance;
	}
	
//	static PriorityQueue<ArrayList<Integer>> createMinHeap(ArrayList<Integer> crateDistances, int truckCapacity){
//
//		
//		
//		Comparator<ArrayList<Integer>> movieComparator = new Comparator<ArrayList<Integer>>() {
//            @Override
//            public int compare(ArrayList<Integer> crateDistance1, ArrayList<Integer> crateDistance2) {
//                if(crateDistance1.get(2) - crateDistance2.get(2) < 0)
//                	return -1;
//                else if(crateDistance1.get(2) - crateDistance2.get(2) > 0)
//                	return 1;
//                else
//                	return 0;
//                
//            }
//        };
// 
//		
//		
//		return new PriorityQueue();
//	}
	
	
	public static void main(String[] args) {

		
		List<List<Integer>> locations = new ArrayList<>();
		
		ArrayList<Integer> oneLocation =  new ArrayList<>();
		oneLocation.add(5);
		oneLocation.add(10);
		locations.add(oneLocation);
		ArrayList<Integer> oneLocation1 =  new ArrayList<>();
		oneLocation1.add(0);
		oneLocation1.add(3);
		locations.add(oneLocation1);
		ArrayList<Integer> oneLocation2 =  new ArrayList<>();
		oneLocation2.add(2);
		oneLocation2.add(0);
		locations.add(oneLocation2);
		ArrayList<Integer> oneLocation3 =  new ArrayList<>();
		oneLocation3.add(5);
		oneLocation3.add(3);
		locations.add(oneLocation3);
		
		System.out.println(CrateDistance.solution(0, locations, 0));
		
		
	}

}
	