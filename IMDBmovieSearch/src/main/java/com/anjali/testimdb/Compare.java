package com.anjali.testimdb;

import java.util.List;

public class Compare {

	public static void main(String[] args) throws Exception {
		List<String> movieListExcel = MovieFromExcel.getMovieList();
		List<String> movieListImdb = MovieFromIMDB.imdbGenereList("western",
				"user_rating");
		for (String ele : movieListExcel) {
			if (movieListImdb.contains(ele)) {
				System.out.println(ele + " found");
			} else {
				System.out.println(ele + " not found");
			}
		}

		movieListImdb = MovieFromIMDB.imdb250List("Ranking");

		for (String ele : movieListExcel) {
			if (movieListImdb.contains(ele)) {
				System.out.println(ele + " found");
			} else {
				System.out.println(ele + " not found");
			}
		}
	}
}
