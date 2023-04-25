import React from 'react';
import { View, StyleSheet, TouchableWithoutFeedback, Keyboard } from 'react-native';
import Input from '../components/Input';
import Button from '../components/Button';
import { isValidEmail } from '../tools/utils';

const Login = ({ handleLoginChange, login }) => {
    const handlePress = () => {
        Keyboard.dismiss();
    };
  return (
    <TouchableWithoutFeedback onPress={handlePress}>
        <View style={styles.container}>
        <Input title="Email" onChangeText={(newText)=>{handleLoginChange(newText, "email")}} type={'email'} validate={isValidEmail} />
        <Input title="Password" onChangeText={(newText)=>{handleLoginChange(newText, "password")}} type={'password'} />
        <Button title="Login" onPress={()=>{
            console.log(login);
        }}/>
        </View>
    </TouchableWithoutFeedback>
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

export default Login;
