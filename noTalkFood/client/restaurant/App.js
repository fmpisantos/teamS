import React, { useState } from 'react';
import { StyleSheet } from 'react-native';

import Login from './src/pages/Login';

const App = () => {
  const [login, setLogin] = useState({
    email: '',
    password: '',
  });

  const handleLoginChange = (newText, type) => {
    switch(type) {
      case "email":
        login.email = newText;
        break;
      case "password":
        login.password = newText;
        break;
    }

    setLogin({ login });
  };

  return (
    <Login login={login} handleLoginChange={handleLoginChange} />
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#23363F'
  },
});

export default App;
