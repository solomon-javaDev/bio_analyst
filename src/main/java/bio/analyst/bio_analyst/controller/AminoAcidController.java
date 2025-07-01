package bio.analyst.bio_analyst.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bio.analyst.bio_analyst.model.AminoAcid;
import bio.analyst.bio_analyst.repo.AminoAcidRepository;
import bio.analyst.bio_analyst.service.AminoAcidService;

@RestController
@RequestMapping("/aminoacids")
public class AminoAcidController {
    
    @Autowired
    AminoAcidRepository aminoAcidRepository;
    @Autowired
    AminoAcidService aminoAcidService;

    @GetMapping("/all")
    public ResponseEntity<List<AminoAcid>> getAllAminoAcids(@RequestParam(name = "filter", required = false, defaultValue = "null")String type) {
        List<AminoAcid> aminoAcids = aminoAcidRepository.findAll().stream()
            .filter(aminoAcid -> {
                if (type == null || type.equals("null")) {
                    return true; // No filter applied, return all amino acids
                }
                try {
                    return aminoAcid.getType().name().equalsIgnoreCase(type);
                } catch (IllegalArgumentException e) {
                    return false; // Invalid type, exclude this amino acid
                }
            })
            .toList();
        return ResponseEntity.ok(aminoAcids);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<AminoAcid> getAminoAcidById(@PathVariable Long id) {
        return aminoAcidRepository.findById(id)
            .map(aminoAcid -> ResponseEntity.ok(aminoAcid))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<AminoAcid> getAminoAcidByName(@PathVariable String name) {
        return aminoAcidRepository.findByName(name)
            .map(aminoAcid -> ResponseEntity.ok(aminoAcid))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchAminoAcid(
            @RequestParam(required = false) String onelettercode,
            @RequestParam(required = false) String threelettercode) {
        if (onelettercode != null) {
            Optional<AminoAcid> results = aminoAcidRepository.findByOneLetterCode(onelettercode.toUpperCase());
            if (results.isEmpty()) {
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(results.get());
            }
        } else if (threelettercode != null) {
            List<AminoAcid> results = aminoAcidRepository.findAllByThreeLetterCode(threelettercode);
            if (results.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else if (results.size() == 1) {
                return ResponseEntity.ok(results.get(0));
            } else {
                return ResponseEntity.ok(results);
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}

