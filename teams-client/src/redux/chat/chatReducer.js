const reducer = {
    reducers:
      {
        login: (state, action) => {
            console.log("login")
            return {...state, userName: action.payload.userName, token: action.payload.token};
        },
        reset: state => {
            console.log("reset")
            return {...state, userName: "", token: ""};
        },
        toggleChat: state => {
            console.log("toggle")
            return {...state, open: !state.open};
        },
        showChat: state => {
            console.log("show")
            return {...state, open: true};
        }
      }
  }
  
export default reducer;