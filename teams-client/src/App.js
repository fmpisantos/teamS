import React from "react";
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";
import { useSelector, useDispatch } from 'react-redux'

import '@styles/App.css';
import About  from "@pages/About"
import NavBar from "@components/NavBar"
import Footer from "@components/Footer"


import {
  increment,
  incrementByAmount,
  state
} from '@redux/counter';

const App = props =>{
  const counter = useSelector(state);
  const dispatch = useDispatch();
  //const _increment = () => dispatch(increment())
  //const _incrementByAmount = (amount) => {dispatch(incrementByAmount(amount))}
  return(
    <Router>
      <NavBar/>
      <Routes>
        <Route path="/" element={<About {...props} name="About"/>}/>
      </Routes>
      <Footer/>
    </Router>
  )
}

export default App;
