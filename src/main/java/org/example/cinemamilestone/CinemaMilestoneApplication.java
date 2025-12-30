package org.example.cinemamilestone;

import org.example.cinemamilestone.DataAccessLayer.Film;
import org.example.cinemamilestone.DataAccessLayer.FilmRepository;
import org.example.cinemamilestone.DataAccessLayer.Screen;
import org.example.cinemamilestone.DataAccessLayer.ScreenRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class CinemaMilestoneApplication implements CommandLineRunner {
	private final FilmRepository filmRepository;
	private final ScreenRepository screenRepository;

	private static final Logger logger = LoggerFactory.getLogger(CinemaMilestoneApplication.class);

	public CinemaMilestoneApplication(FilmRepository filmRepository, ScreenRepository screenRepository) {
		this.filmRepository = filmRepository;
		this.screenRepository = screenRepository;
	}
	public static void main(String[] args) {

		SpringApplication.run(CinemaMilestoneApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Film film1 = new Film("Inception", "Sci-Fi", "Christopher Nolan", "English", 148, 8.8, "2010-07-16", "Mind-bending thriller. lol");
		Film film2 = new Film("SpiderMan: HomeComing", "Action", "Jon Watts", "English", 133, 7.4, "2017-07-07", "Peter Parker tries to balance high school and being Spider-man.");
		Film film3 = new Film("Spider-Man", "Action", "Sam Raimi", "English", 121, 7.3,"2002-05-03", "Peter Parker becomes spiderman and fights the green goblin. HAHAHAHAH **Evil Laughs**");
		Film film4 = new Film("The Conjuring: Haikels Java Test2", "Horror", "Haikel Hichri", "English", 112, 7.5, "2025-10-29", "Haikel sets the Java test so difficult that his students are cooked");
		Film film5 = new Film("The Final: Haikels Java Test3", "Horror", "Haikel Hichri", "English", 112, 8.2, "2025-12-2", "Haikel has yet again surpassed himself with a sequel in less than a year. (Bonus: live reaction from students as they see their grades. ");
		Film film6 = new Film("Avengers:Endgame", "Action", "Anthony & Joe Russo", "English", 181, 8.4,"2019-04-26", "The avengers assemble to undo Thanos's actions ");
		Film film7 = new Film("The Matrix", "Sci-Fi", "Lana & Lilly Wachowski", "English", 136, 8.7, "1999-03-31", "Reality-bending action.");
		Film film8 = new Film("Interstellar", "Sci-Fi", "Christopher Nolan", "English", 169, 8.6, "2014-11-07", "Epic space exploration.");
		Film film9 = new Film("Parasite", "Thriller", "Bong Joon-ho", "Korean", 132, 8.6, "2019-05-30", "Dark social satire.");
		Film film10 = new Film("The Godfather", "Crime", "Francis Ford Coppola", "English", 175, 9.2, "1972-03-24", "Classic mafia drama.");
		Film film11 = new Film("Spirited Away", "Fantasy", "Hayao Miyazaki", "Japanese", 125, 8.6, "2001-07-20", "Enchanting animated adventure.");
		Film film12 = new Film("The Dark Knight", "Action", "Christopher Nolan", "English", 152, 9.0, "2008-07-18", "Iconic superhero crime film.");
		Film film13 = new Film("Whiplash", "Drama", "Damien Chazelle", "English", 106, 8.5, "2014-10-10", "Intense music-driven drama.");
		Film film14 = new Film("Pulp Fiction", "Crime", "Quentin Tarantino", "English", 154, 8.9, "1994-10-14", "Stylized nonlinear storytelling.");
		Film film15 = new Film("Arrival", "Sci-Fi", "Denis Villeneuve", "English", 116, 7.9, "2016-11-11", "Linguistics meets alien contact.");
		Film film16 = new Film("City of God", "Crime", "Fernando Meirelles", "Portuguese", 130, 8.6, "2002-08-30", "Gritty favela chronicle.");

		this.filmRepository.saveAll(Arrays.asList(film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12, film13, film14, film15, film16));
		// Create a java.sql.Date

		LocalDate localDate1 = LocalDate.of(2025, 12, 19);//though we check if the date is not before today so if the number here doesn't match with the field date in Screen class, that might be why there is an error
		LocalDate localDate2 = LocalDate.of(2025, 12, 20);
		LocalDate localDate3 = LocalDate.of(2025, 12, 21);
		LocalDate localDate4 = LocalDate.of(2025, 12, 22);

		this.screenRepository.save(new Screen(60, "3D", 1, localDate1,"Don't forget to take the 3D glasses!", film1));
		this.screenRepository.save(new Screen(60, "3D", 1, localDate1, "N’oubliez pas d'apporter les lunettes 3D!", film1));

		this.screenRepository.save(new Screen(35, "Normal Visioning", 2, localDate1, "Popcorn served at location!", film2));
		this.screenRepository.save(new Screen(35, "Normal Visioning", 2, localDate1, "Pop-corn servi sur place !", film2));

		this.screenRepository.save(new Screen(55, "ScreenX", 3, localDate1, "Be ready for a bigger screen!", film3));
		this.screenRepository.save(new Screen(55, "ScreenX", 3, localDate1, "Préparez-vous à un écran plus grand !", film3));

		this.screenRepository.save(new Screen(10, "4DX", 4, localDate2, "Inspired by the tears of the students who took Test2", film4));
		this.screenRepository.save(new Screen(10, "4DX", 4, localDate2, "Inspiré par les larmes des étudiants qui ont passé Test2", film4));

		this.screenRepository.save(new Screen(10, "3D", 5, localDate2, "Don't forget to bring a friend!", film5));
		this.screenRepository.save(new Screen(10, "3D", 5, localDate2, "N’oubliez pas d’amener un ami !", film5));

		this.screenRepository.save(new Screen(15, "Normal Visioning", 5, localDate2, "Dive into the real world, share the experience with a friend!", film2));
		this.screenRepository.save(new Screen(9, "Normal Visioning", 5, localDate2, "Plongez dans le vrai monde, partagez l’expérience avec un ami !", film2));

		this.screenRepository.save(new Screen(2, "3D", 5, localDate2, "Prepare for liftoff, bring someone to explore the cosmos with you!", film3));
		this.screenRepository.save(new Screen(6, "3D", 5, localDate2, "Préparez le décollage, emportez quelqu’un pour explorer le cosmos avec vous !", film3));

		this.screenRepository.save(new Screen(13, "3D", 5, localDate2, "Twists await, bring a friend for the ride!", film4));
		this.screenRepository.save(new Screen(7, "3D", 5, localDate2, "Des rebondissements vous attendent, amenez un ami pour vivre ça !", film4));

		this.screenRepository.save(new Screen(6, "4DX", 5, localDate2, "Make an offer they can’t refuse—invite a friend!", film5));
		this.screenRepository.save(new Screen(18, "4DX", 5, localDate2, "Faites-leur une offre qu’ils ne pourront refuser—invitez un ami !", film5));

		this.screenRepository.save(new Screen(10, "3D", 5, localDate2, "Enter the spirit world, bring someone to share the wonder!", film6));
		this.screenRepository.save(new Screen(10, "3D", 5, localDate2, "Entrez dans le monde des esprits, amenez quelqu’un pour partager la magie !", film6));

		this.screenRepository.save(new Screen(12, "ScreenX", 5, localDate2, "Witness the legend bring a friend into the night!", film7));
		this.screenRepository.save(new Screen(23, "ScreenX", 5, localDate2, "Vivez la légende, amenez un ami dans la nuit !", film7));

		this.screenRepository.save(new Screen(16, "Normal Visioning", 5, localDate2, "Feel the intensity, bring someone to keep tempo with you!", film8));
		this.screenRepository.save(new Screen(10, "Normal Visioning", 5, localDate2, "Ressentez l’intensité, amenez quelqu’un pour garder le tempo avec vous !", film8));

		this.screenRepository.save(new Screen(5, "Normal Visioning", 5, localDate2, "Experience the chaos, bring a friend for the ride!", film9));
		this.screenRepository.save(new Screen(30, "Normal Visioning", 5, localDate2, "Vivez le chaos, amenez un ami pour le voyage !", film9));

		this.screenRepository.save(new Screen(20, "3D", 5, localDate2, "Decode the message, bring someone to discover it with you!", film10));
		this.screenRepository.save(new Screen(15, "3D", 5, localDate2, "Décodez le message, amenez quelqu’un pour le découvrir avec vous !", film10));

		this.screenRepository.save(new Screen(12, "ScreenX", 5, localDate2, "Step into their world—share the journey with a friend!", film11));
		this.screenRepository.save(new Screen(9, "ScreenX", 5, localDate2, "Entrez dans leur monde—partagez le voyage avec un ami !", film11));

		this.screenRepository.save(new Screen(25, "3D", 6, localDate3, "Epic adventure continues!", film1));
		this.screenRepository.save(new Screen(25, "3D", 6, localDate3, "L'aventure épique continue !", film1));

		this.screenRepository.save(new Screen(30, "4DX", 6, localDate3, "Feel the thrill!", film2));
		this.screenRepository.save(new Screen(30, "4DX", 6, localDate3, "Ressentez l'excitation !", film2));

		this.screenRepository.save(new Screen(20, "ScreenX", 7, localDate3, "Immersive experience awaits!", film3));
		this.screenRepository.save(new Screen(20, "ScreenX", 7, localDate3, "Une expérience immersive vous attend !", film3));

		this.screenRepository.save(new Screen(18, "Normal Visioning", 7, localDate3, "Relax and enjoy the show!", film4));
		this.screenRepository.save(new Screen(18, "Normal Visioning", 7, localDate3, "Détendez-vous et profitez du spectacle !", film4));

		this.screenRepository.save(new Screen(22, "3D", 8, localDate3, "A night of action!", film5));
		this.screenRepository.save(new Screen(22, "3D", 8, localDate3, "Une nuit d'action !", film5));

		this.screenRepository.save(new Screen(15, "4DX", 8, localDate3, "Sensory overload!", film6));
		this.screenRepository.save(new Screen(15, "4DX", 8, localDate3, "Surcharge sensorielle !", film6));

		this.screenRepository.save(new Screen(28, "ScreenX", 9, localDate3, "Step into another world!", film7));
		this.screenRepository.save(new Screen(28, "ScreenX", 9, localDate3, "Entrez dans un autre monde !", film7));

		this.screenRepository.save(new Screen(12, "Normal Visioning", 9, localDate3, "Classic storytelling!", film8));
		this.screenRepository.save(new Screen(12, "Normal Visioning", 9, localDate3, "Conte classique !", film8));

		this.screenRepository.save(new Screen(35, "3D", 10, localDate4, "Thrills and chills!", film9));
		this.screenRepository.save(new Screen(35, "3D", 10, localDate4, "Frissons garantis !", film9));

		this.screenRepository.save(new Screen(20, "ScreenX", 10, localDate4, "Experience every detail!", film10));
		this.screenRepository.save(new Screen(20, "ScreenX", 10, localDate4, "Vivez chaque détail !", film10));


		for(Screen screen : this.screenRepository.findAll()) {
			logger.info(screen.toString());
		}


	}

	public static class Config {
	}
}
