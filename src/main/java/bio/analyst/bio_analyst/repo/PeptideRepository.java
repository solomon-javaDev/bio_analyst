package bio.analyst.bio_analyst.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bio.analyst.bio_analyst.model.Peptide;

public interface PeptideRepository extends JpaRepository<Peptide, Long>{

   Optional<Peptide> findByName(String string);
    
}
