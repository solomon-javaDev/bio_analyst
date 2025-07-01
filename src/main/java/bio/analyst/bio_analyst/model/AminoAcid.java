package bio.analyst.bio_analyst.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "amino_acids")
public class AminoAcid {

    @Id
    private long id;

    @Column(name = "amino_acid_name")
    private String name;

    @Column(name = "one_letter_code")
    private String oneLetterCode;

    @Column(name = "three_letter_code")
    private String threeLetterCode;

    @Column(name = "molecular_weight")
    private int molecularWeight;

    @Column(name = "amino_acid_type")
    @Enumerated(EnumType.STRING)
    private AminoAcidType type;

    // Default constructor
    public AminoAcid() {
    }

    // Constructor with parameters
    public AminoAcid(String name, String oneLetterCode, String threeLetterCode, AminoAcidType type) {
        this.name = name;
        this.oneLetterCode = oneLetterCode;
        this.threeLetterCode = threeLetterCode;
        this.type = type;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOneLetterCode() {
        return oneLetterCode;
    }

    public void setOneLetterCode(String oneLetterCode) {
        this.oneLetterCode = oneLetterCode;
    }

    public String getThreeLetterCode() {
        return threeLetterCode;
    }

    public void setThreeLetterCode(String threeLetterCode) {
        this.threeLetterCode = threeLetterCode;
    }

    public AminoAcidType getType() {
        return type;
    }

    public void setType(AminoAcidType type) {
        this.type = type;
    }


    public int getMolecularWeight() {
        return molecularWeight;
    }

    public void setMolecularWeight(int molecularWeight) {
        this.molecularWeight = molecularWeight;
    }

    public enum AminoAcidType {
    ACIDIC,
    BASIC,
    AROMATIC,
    NONPOLAR,
    POLAR_UNCHARGED
}


}
