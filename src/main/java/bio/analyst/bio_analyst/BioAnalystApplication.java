package bio.analyst.bio_analyst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import bio.analyst.bio_analyst.model.Peptide;
import bio.analyst.bio_analyst.repo.PeptideRepository;


@SpringBootApplication
public class BioAnalystApplication implements CommandLineRunner{

	@Autowired
	PeptideRepository peptideRepository;
	public static void main(String[] args) {
		SpringApplication.run(BioAnalystApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Peptide peptide1 = new Peptide("Peptide1", "ACDEFGHIKLMNPQRSTVWY");
		peptideRepository.save(peptide1);

		System.out.println("Saved peptide: " + peptideRepository.findByName("Peptide1").get().getType());
	}

}
