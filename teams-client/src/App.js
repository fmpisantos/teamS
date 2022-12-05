import React from "react";
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";
import { useSelector, useDispatch } from 'react-redux'

import '@styles/App.css';
import About  from "@pages/About"
import NavBar from "@components/NavBar"
import Footer from "@components/Footer"
import RestAPI from "./components/RestAPI";

const App = props =>{
  const pages = [
    {
    name: 'About',
    path: '/about',
    menu: []
    },
    {
      name: 'Our Projects',
      path: '/about#our-projects',
      menu: [
        {
          name: 'REST API',
          header: "REST API",
          description: "A REST API that supports our chat functionality, implemented using Spring-boot, Spring-security & authentication, JWToken using a Postgres database.",
          path: "/rest-api",
          image: "https://source.unsplash.com/random",
        }
      ]
    }
  ];
  return(
    <Router>
      <NavBar pages={pages}/>
      <Routes>
        <Route path="/"                   element={ <About   {...props} projects={pages[1].menu} name="About"/>   }   />
        <Route path="/about"              element={ <About   {...props} projects={pages[1].menu} name="About"/>   }   />
        <Route path="/rest-api"           element={ <RestAPI {...props}                          name="RestAPI"/> }   />
      </Routes>
      <Footer/>
    </Router>
  )
}

export default App;
