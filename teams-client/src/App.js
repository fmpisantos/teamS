import React from "react";
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";

import '@styles/App.css';
import '@styles/utils-min.css';
import About  from "@pages/About"
import NavBar from "@components/NavBar"
import Footer from "@components/Footer"
import RestAPI from "@components/RestAPI";
import Chat from "@components/Chat";

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
          image: "https://i.imgur.com/nMSbAgc.png",
        }
      ]
    }
  ];

  return(
    <Router>
      <div className="vh-100">
        <div className="row-5">
          <NavBar pages={pages}/>
        </div>
        <div className="row-84">
          <Routes>
            <Route path="/"                   element={ <About    {...props} projects={pages[1].menu} name="About"/>   }   />
            <Route path="/about"              element={ <About    {...props} projects={pages[1].menu} name="About"/>   }   />
            <Route path="/rest-api"           element={ <RestAPI  {...props}                          name="RestAPI"/> }   />
            <Route path="/chat"               element={ <Chat     {...props}                          name="Chat"/> }   />
          </Routes>
        </div>
        <div className="row-10">
          <Footer/>
        </div>
      </div>
    </Router>
  )
}

export default App;
