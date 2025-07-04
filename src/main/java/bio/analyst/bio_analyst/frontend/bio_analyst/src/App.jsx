import AminoAcidArea from "./components/AminoAcidArea";
function App() {

  return (
    <>
      <div className="App">
     <h1>BioAnalyst</h1>
     <div>
      <ul className="nav-list">
        <li>Home</li>
        <li>AminoAcids</li>
        <li>Proteins</li>
        <li>Carbohydrates</li>
        <li>Enzymes</li>
        <li>Vitamins</li>
        <li>Nucleic acids</li>
      </ul>
     </div>
     <div className="content">
      <AminoAcidArea />
     </div>
        </div>
    </>
  )
}

export default App
