import { useState } from "react";
function AminoAcidArea() {

  const [aminoAcids, setAminoAcids] = useState([]);
  async function showAminoAcids(){
    let url = 'http://localhost:8080/aminoacids/all';
    try{
    const response = await fetch(url);
    if(response.ok){
      const data = await response.json();
      setAminoAcids(data); 
    }else{
      console.error('Failed to fetch amino acids');
    }
    }catch(error){
      console.error('Error fetching amino acids:', error);
    }


  }
 
  
  return (
    <div className="amino-acid-area">
      <h1>Amino Acid Area</h1>
      <p>This area will display information about amino acids.</p>
     <div>
        <input type="text" placeholder="Enter amino acid sequence" />
        <button onClick={showAminoAcids}>Submit</button>
      </div>
      <div className="amino-acid-info">
      <h2>Amino Acid Information</h2>
      {aminoAcids.length === 0 ? (
        <p>No amino acids data loaded yet</p>
      ) : (
        <ul>
          {aminoAcids.map((aa) => (
            <li key={aa.id}>
              {aa.name} ({aa.oneLetterCode}, {aa.threeLetterCode}) - {aa.type}, MW: {aa.molecularWeight}
            </li>
          ))}
        </ul>
      )}
        <p>Information about the entered amino acid sequence will be displayed here.</p>
     </div>
    </div>
  );
}

export default AminoAcidArea;