package com.problems.trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Movie {
	private final int movieId;
	private final float rating;
	private List<Movie> similarMovies; // Similarity is bi directional

	public Movie(int movieId, float rating) {
		this.movieId = movieId;
		this.rating = rating;
		similarMovies = new ArrayList<Movie>();
	}

	public int getId() {
		return movieId;
	}

	public float getRating() {
		return rating;
	}

	public void addSimilarMovie(Movie movie) {
		similarMovies.add(movie);
		movie.similarMovies.add(this);
	}

	public List<Movie> getSimilarMovies() {
		return similarMovies;
	}

	public static List<Movie> getMovieRecommendations(Movie movie,int numTopRatedSimilarMovies) {
		
		
		Set<Movie> seen = new HashSet<Movie>();
		Queue<Movie> movieQ = new LinkedList<Movie>();
		movieQ.add(movie);
		seen.add(movie);
		
		while (!movieQ.isEmpty()) {
			Movie nextMovie = movieQ.remove();
			for (Movie m : nextMovie.getSimilarMovies()) {
				if (!seen.contains(m)) {
					seen.add(m);
					movieQ.add(m);
				}
			}
		}
		
		if (seen.size() <= numTopRatedSimilarMovies) {
			return new ArrayList<Movie>(seen); // Return full list since this is
												// the max we can return
		} else {
			// Create max heap with seen movies
			PriorityQueue<Movie> heap = createMaxHeap(seen);
			List<Movie> result = new ArrayList<Movie>();
			for (int i = 0; i < numTopRatedSimilarMovies; i++) {
				result.add(heap.poll());
			}
			return result;
		}
	}

	private static PriorityQueue<Movie> createMaxHeap(Set<Movie> movies) {
		Comparator<Movie> movieComparator = new Comparator<Movie>() {
			@Override
			public int compare(Movie movie1, Movie movie2) {
				return new Float(movie2.rating).compareTo(new Float(
						movie1.rating));
			}
		};
		
		
		PriorityQueue<Movie> queue = new PriorityQueue<Movie>(movies.size(),movieComparator);
		for (Movie m : movies) {
			queue.add(m);
		}

		return queue;
	}
}