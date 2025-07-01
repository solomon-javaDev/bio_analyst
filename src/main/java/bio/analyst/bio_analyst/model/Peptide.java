package bio.analyst.bio_analyst.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Peptide {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String sequence;
    private int length;
    @Enumerated(EnumType.STRING)
    private PeptideType type;



    public int calculateMolecularWeight(){
        int molecularWeight = 0;
        char [] aminoAcids = new char[this.sequence.length()];
        for(int i = 0; i <= sequence.length(); i++){
            aminoAcids[i] = sequence.charAt(i);
        }
        return molecularWeight-18;
    }


    // Default constructor
    protected Peptide() {
    }
    // Constructor with parameters
    public Peptide(String name, String sequence) {
        this.name = name;
        this.sequence = sequence;
        this.length = sequence.length();
        if (length == 2) {
            this.type = PeptideType.DIPEPTIDE;
        } else if (length == 3) {
            this.type = PeptideType.TRIPEPTIDE;
        } else if (length < 20) {
            this.type = PeptideType.OLIGOPEPTIDE;
        } else {
            this.type = PeptideType.POLYPEPTIDE;
        }
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSequence() {
        return sequence;
    }
    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public PeptideType getType() {
        return type;
    }
    public void setType(PeptideType type) {
        this.type = type;
    }

    public enum PeptideType {
        DIPEPTIDE, TRIPEPTIDE, OLIGOPEPTIDE, POLYPEPTIDE
    }

}
