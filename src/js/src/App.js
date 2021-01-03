import "./App.css";
import User from "./components/User/User";
import Footer from "./components/Footer/Footer"

function App() {
  return (
    <div className="App">
      <User></User>
      <Footer numberOfUsers={10}></Footer>
    </div>
  );
}

export default App;
