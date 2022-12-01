import React from "react";

const Home = props =>{
    return(
        <div className="app">
          <h1>{`${props.name} Page`}</h1>
          <h3>{`Counter:${props.counter.value}`}</h3>
          <button onClick={props.increment}>Increment</button>
          <button onClick={()=>props.incrementByAmount(2)}>Increment by 2</button>
        </div>
    )
  }
  
  export default Home;