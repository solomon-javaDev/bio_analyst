package bio.analyst.bio_analyst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bio.analyst.bio_analyst.model.AminoAcid;
import bio.analyst.bio_analyst.model.AminoAcid.AminoAcidType;
import bio.analyst.bio_analyst.repo.AminoAcidRepository;

@Service
public class AminoAcidService {

    @Autowired
    AminoAcidRepository aminoAcidRepository;
    public List<AminoAcid> getAllAminoAcidsByType(String type){
        //check if type is valid, 
        //should be one of the enum values in AminoAcidType
        // ACIDIC, BASIC,AROMATIC, NONPOLAR,POLAR_UNCHARGED
        if(type == null){
            return null;
        }else{
            try{
                AminoAcidType aminoAcidType = AminoAcidType.valueOf(type.toUpperCase());
                List<AminoAcid> aminoacids = aminoAcidRepository.findAll().stream()
                .filter(aminoAcid -> {
                    System.out.println("Filtering amino acid: " + aminoAcid.getName() + " of type: " + aminoAcid.getType());
                    return aminoAcid.getType() == aminoAcidType;
                }).toList();
                return aminoacids;
            }catch(IllegalArgumentException e){
                //if type is not valid, return null
                return null;
            }
        }

    }
}
