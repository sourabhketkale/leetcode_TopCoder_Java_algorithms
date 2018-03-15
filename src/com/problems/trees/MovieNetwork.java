package com.problems.trees;

import java.util.*;
import com.problems.trees.Movie;

public class MovieNetwork {
	
	public static void main(String[] args) {
		Movie A = new Movie(0, 1.2f);
		Movie B = new Movie(1, 2.4f);
		Movie C = new Movie(2, 3.6f);
		Movie D = new Movie(3, 4.8f);

		B.addSimilarMovie(D);
		C.addSimilarMovie(D);
		
		A.addSimilarMovie(B);
		A.addSimilarMovie(C);

	List<Movie> movies = Movie.getMovieRecommendations(A, 2);
	System.out.println(movies.size());
	for (Movie m: movies) {
		System.out.print(m.getId() + " ");
		System.out.println(m.getRating());
		}
	}
	
}

