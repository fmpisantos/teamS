import React from "react";
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";
import { CSSTransition } from "react-transition-group";
import '@styles/App.css';
import '@styles/utils-min.css';
import About  from "@pages/About"
import NavBar from "@components/NavBar"
import Footer from "@components/Footer"
import RestAPI from "@components/RestAPI";
import Chat from "@components/Chat/Chat";
import ChatButton from "@components/Chat/ChatButton";
import { useSpring, animated } from 'react-spring';
import Snake from "@components/Snake";

const App = props =>{
  const [chatState, setChatState] = React.useState({open:false, notifications: 0});

  const toggleChat = () => {
    setChatState({...chatState, open: !chatState.open});
  }

  const showChat = () => {
    setChatState({...chatState, open: true});
  }

  const animationPropsChat = useSpring({
    opacity: chatState.open ? 1 : 0,
    config: { mass: 1, tension: 100, friction: 25 }
  });

  const animationPropsChatButton = useSpring({
    opacity: !chatState.open ? 1 : 0,
    config: { mass: 1, tension: 100, friction: 25 }
  });

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
          path: "/projects/rest-api",
          image: "https://i.imgur.com/nMSbAgc.png",
        },
        {
          name: 'Chat',
          header: "Chat",
          description: "A chat application that supports multiple users, implemented using React, Spring-boot, Spring-security & authentication, JWToken using a Postgres database.",
          path: "/projects/chat",
          image: "https://imgur.com/3hqaM0d.png",
          func: ()=>{ showChat() }
        }
        ,
        {
          name: 'Snake',
          header: "Snake",
          description: "A simple snake game with HTML and JavaScript.",
          path: "/projects/snake",
          image: "./assets/images/snake.png",
        }
      ]
    }
  ];

  return(
    <Router>
      <div className="vh-100">
        <div className="row-5">
          <NavBar pages={pages}  showChat={showChat} />
        </div>
        <div className="row-84">
          <Routes>
            <Route path="/"                   element={ <About      {...props} projects={pages[1].menu}  showChat={showChat}  name="About"/>   }   />
            <Route path="/about"              element={ <About      {...props} projects={pages[1].menu}  showChat={showChat}  name="About"/>  }   />
            <Route path="/projects/rest-api"  element={ <RestAPI    {...props}                          name="RestAPI"/> }   />
            <Route path="/projects/chat"               element={ <Chat     {...props}                          name="Chat"/> }       />
            <Route path="/projects/snake"              element={ <Snake     {...props}                         name="Snake"/> }      />
          </Routes>
        </div>
        <div className="row-10">
          <Footer/>
        </div>
        {chatState.open ? 
          <animated.div style={animationPropsChat}>
            <Chat {...props} toggleChat={toggleChat} />
          </animated.div> 
        : 
          <animated.div style={animationPropsChatButton}>
            <ChatButton {...props} toggleChat={toggleChat} />
          </animated.div>}
      </div>
    </Router>
  )
}

export default App;
