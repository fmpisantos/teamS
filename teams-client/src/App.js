import React from "react";
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";
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
import { useSelector, useDispatch } from 'react-redux';
import {
  login, 
  reset, 
  state,
  showChat,
  toggleChat
 } from '@redux/chat/chat';


const App = props =>{
  const chatState = useSelector(state);
  const dispatch = useDispatch();
  const _login = (user) => dispatch(login(user))
  const _reset = () => dispatch(reset())
  const _hasUser = () => chatState.token !== ""
  const _showChat = () => dispatch(showChat())
  const _toggleChat = () => dispatch(toggleChat())

  console.log(chatState)

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
          image: "./images/rest-api.png",
        },
        {
          name: 'Chat',
          header: "Chat",
          description: "A chat application that supports multiple users, implemented using React, Spring-boot, Spring-security & authentication, JWToken using a Postgres database.",
          path: "/projects/chat",
          image: "./images/chat.png",
          func: ()=>{ _showChat() }
        }
        ,
        {
          name: 'Snake',
          header: "Snake",
          description: "A simple snake game with HTML and JavaScript.",
          path: "/projects/snake",
          image: "./images/snake.png",
        }
      ]
    }
  ];

  return(
    <Router>
      <div className="vh-100 nonScrollable">
        <div className="row-5">
          <NavBar pages={pages}  showChat={_showChat} />
        </div>
        <div className="row-84">
        <div className="row-100 scrollable">
          <Routes>
            <Route path="/"                             element={ <About    {...props} projects={pages[1].menu}   name="About"/>   }    />
            <Route path="/about"                        element={ <About    {...props} projects={pages[1].menu}   name="About"/>   }    />
            <Route path="/projects/rest-api"            element={ <RestAPI  {...props}                            name="RestAPI"/> }    />
            <Route path="/projects/chat"                element={ <Chat     {...props} chat={chatState} login={_login} reset={_reset} hasUser={_hasUser} name="Chat"/> }       />
            <Route path="/projects/snake"               element={ <Snake    {...props} name="Snake"/> }      />
          </Routes>
        </div>
        </div>
        <div className="row-10">
          <Footer/>
        </div>
        {chatState.open ? 
          <animated.div style={animationPropsChat}>
            <Chat {...props} chat={chatState} login={_login} reset={_reset} hasUser={_hasUser} toggleChat={_toggleChat} />
          </animated.div> 
        : 
          <animated.div style={animationPropsChatButton}>
            <ChatButton {...props} chat={chatState} login={_login} reset={_reset} hasUser={_hasUser} toggleChat={()=>{console.log(chatState);_toggleChat()}} />
          </animated.div>}
      </div>
    </Router>
  )
}

export default App;
