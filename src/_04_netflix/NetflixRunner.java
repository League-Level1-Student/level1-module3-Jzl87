package _04_netflix;

public class NetflixRunner {
	public static void main(String[] args) {
		Movie inception = new Movie("Inception", 5);
		Movie tenet = new Movie("Tenet", 4);
		Movie oppenheimer = new Movie("Oppenheimer", 3);
		Movie interstellar = new Movie ("Interstellar", 5);
		Movie darkKnight = new Movie("The dark knight", 4);
		
		inception.getTicketPrice();
		
		NetflixQueue queue = new NetflixQueue();
		
		queue.addMovie(darkKnight);
		queue.addMovie(inception);
		queue.addMovie(interstellar);
		queue.addMovie(tenet);
		queue.addMovie(oppenheimer);
		
		queue.printMovies();
		queue.sortMoviesByRating();
		System.out.println("The best Movie is " + queue.getBestMovie());
		System.out.println("The second best Movie is " + queue.getMovie(1));
	}
}
