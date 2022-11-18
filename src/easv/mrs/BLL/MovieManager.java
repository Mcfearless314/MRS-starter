package easv.mrs.BLL;

import easv.mrs.BE.Movie;
import easv.mrs.BLL.util.MovieSearcher;
import easv.mrs.DAL.IMovieDataAccess;
import easv.mrs.DAL.MovieDAO;

import java.io.IOException;
import java.util.List;

public class MovieManager {

    private MovieSearcher movieSearcher = new MovieSearcher();

    private IMovieDataAccess movieDAO;

    public MovieManager() throws IOException {
        movieDAO = new MovieDAO();
    }

    public List<Movie> getAllMovies() throws Exception {
        return movieDAO.getAllMovies();
    }

    public List<Movie> searchMovies(String query) throws Exception {
        List<Movie> allMovies = getAllMovies();
        List<Movie> searchResult = movieSearcher.search(allMovies, query);
        return searchResult;
    }
    public Movie createNewMovie(int year, String title) throws Exception {
        return movieDAO.createMovie(title, year);
    }
}
