function aminoAcidArea() {
  return (
    <div className="amino-acid-area">
      <h1>Amino Acid Area</h1>
      <p>This area will display information about amino acids.</p>
     <div>
        <input type="text" placeholder="Enter amino acid sequence" />
        <button>Submit</button>
      </div>
      <div className="amino-acid-info">
        {/* Placeholder for amino acid information */}
        <p>Information about the entered amino acid sequence will be displayed here.</p>
     </div>
    </div>
  );
}

export default aminoAcidArea;