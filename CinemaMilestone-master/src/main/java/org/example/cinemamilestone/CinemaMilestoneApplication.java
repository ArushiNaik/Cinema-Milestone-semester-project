package org.example.cinemamilestone;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.example.cinemamilestone.BusinessLayer.FilmService;
import org.example.cinemamilestone.BusinessLayer.ScreenService;
import org.example.cinemamilestone.DataAccessLayer.Film;
import org.example.cinemamilestone.DataAccessLayer.FilmRepository;
import org.example.cinemamilestone.DataAccessLayer.Screen;
import org.example.cinemamilestone.DataAccessLayer.ScreenRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

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
		Film film4 = new Film("The Conjuring: Haikels Java Test2 29 October", "Horror", "Haikel Hichri", "English", 112, 7.5, "2025-10-29", "Haikel Sets the Java test so difficult that their students are cooked");
		Film film5 = new Film("Avengers:Endgame", "Action", "Anthony & Joe Russo", "English", 181, 8.4,"2019-04-26", "The avengers assemble to undo Thanos's actions ");
		this.filmRepository.saveAll(Arrays.asList(film1, film2, film3, film4, film5));
		// Create a java.sql.Date

		LocalDate localDate1 = LocalDate.of(2025, 10, 30);
		LocalDate localDate2 = LocalDate.of(2025, 11, 1);
		this.screenRepository.save(new Screen(60, "3D", 1, localDate1,"Don't forget to bring the 3D glasses!", film1));
		this.screenRepository.save(new Screen(35, "Normal Visioning", 2, localDate1, "Popcorn served at location!", film2));
		this.screenRepository.save(new Screen(55, "ScreenX", 3, localDate1, "Be ready for a bigger screen!", film3));
		this.screenRepository.save(new Screen(10, "4DX", 4, localDate2, "Inspired by the tears of the students who took Test2", film4));
		this.screenRepository.save(new Screen(10, "3D", 5, localDate2, "Don't forget to bring a friend!", film5));
		// Fetch all screen and log to console
		for(Screen screen : this.screenRepository.findAll()) {
			logger.info(screen.toString());
		}



	}

}
