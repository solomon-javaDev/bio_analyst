package bio.analyst.bio_analyst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bio.analyst.bio_analyst.model.Peptide;
import bio.analyst.bio_analyst.repo.PeptideRepository;

@Service
public class ProteinsService {

    @Autowired
    private PeptideRepository peptideRepository;
    public ProteinsService(PeptideRepository peptideRepository) {
        this.peptideRepository = peptideRepository;
    }

    public List<Peptide> getAllPeptides() {
        return peptideRepository.findAll();
    }

    public void savePeptide(Peptide peptide) {
       peptideRepository.save(peptide);
    }
}
