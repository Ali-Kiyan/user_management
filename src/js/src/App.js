import "./App.css";
import User from "./components/User/User";
import Footer from "./components/Footer/Footer"

function App() {
  return (
    <div className="App">
      <h2>User Management</h2>
      <User></User>
      <Footer numberOfUsers={10}></Footer>
    </div>
  );
}

export default App;
