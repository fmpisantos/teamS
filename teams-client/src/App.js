import React from "react";
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";
import { useSelector, useDispatch } from 'react-redux'

import '@styles/App.css';
import About  from "@pages/About"
import NavBar from "@components/NavBar"
import Footer from "@components/Footer"
import RestAPI from "./components/RestAPI";

const App = props =>{
  return(
    <Router>
      <NavBar/>
      <Routes>
        <Route path="/"                   element={<About   {...props} name="About"/>}   />
        <Route path="/about"              element={<About   {...props} name="About"/>}   />
        <Route path="/projects/rest-api"  element={<RestAPI {...props} name="RestAPI"/>} />
      </Routes>
      <Footer/>
    </Router>
  )
}

export default App;
