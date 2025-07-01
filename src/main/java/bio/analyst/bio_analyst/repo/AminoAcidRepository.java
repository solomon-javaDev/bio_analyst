package bio.analyst.bio_analyst.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bio.analyst.bio_analyst.model.AminoAcid;

public interface AminoAcidRepository extends JpaRepository<AminoAcid, Long>{

    Optional<AminoAcid> findByName(String name);

    Optional<AminoAcid> findByOneLetterCode(String onelettercode);
    List<AminoAcid> findAllByThreeLetterCode(String threelettercode);
    List<AminoAcid> findAllByOneLetterCodeOrThreeLetterCode(String onelettercode, String threelettercode);
    List<AminoAcid> findAllByOneLetterCodeAndThreeLetterCode(String onelettercode, String threelettercode);
    List<AminoAcid> findAllByOneLetterCodeOrThreeLetterCodeOrName(String onelettercode, String threelettercode, String name);
    
}
