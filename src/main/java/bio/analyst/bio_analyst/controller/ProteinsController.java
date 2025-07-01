package bio.analyst.bio_analyst.controller;

import org.springframework.web.bind.annotation.RestController;

import bio.analyst.bio_analyst.model.Peptide;
import bio.analyst.bio_analyst.repo.PeptideRepository;
import bio.analyst.bio_analyst.service.ProteinsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/proteins")
public class ProteinsController {

    @Autowired
    ProteinsService proteinsService;
    @Autowired
    PeptideRepository peptideRepository;

    /*
     * Methods involving basic CRUD operations for proteins
     * and peptides will be implemented here.
     */
    @GetMapping
    public ResponseEntity<?> getProteins() {
        // This method will return a list of proteins
        return ResponseEntity.ok(peptideRepository.findAll());
    } 

    //Get a protein by name
    @GetMapping("/{name}")
    public ResponseEntity<String> getProteinByName(@RequestParam String name) {
        // This method will return a protein by its ID
      
        return ResponseEntity.ok("Protein by ID");
    }

    // Add a new protein
    @PostMapping
    public ResponseEntity<String> addProtein(@RequestParam Peptide peptide) {
        // This method will add a new protein
        proteinsService.savePeptide(peptide);
        return ResponseEntity.ok(peptideRepository.findByName(peptide.getName()).get().toString());
    }

    // Update an existing protein
    @PostMapping("/{id}")
    public ResponseEntity<String> updateProtein(@RequestParam Peptide peptide) {
        // This method will update an existing protein
        return ResponseEntity.ok("Protein updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProtein(@RequestParam long id) {
        // This method will delete a protein by its ID
        return ResponseEntity.ok("Protein deleted");
    }


    @GetMapping("/calc_mw")
    public ResponseEntity<Integer> calculateMoleculatWeight(){
        
        return ResponseEntity.ok(0);
    }
}
