import React, { useState, useRef } from 'react';
import { TextInput, StyleSheet, Text } from 'react-native';
import { TextInputMask } from 'react-native-masked-text';

const Input = ({ title, placeholder, onChangeText, type, validate }) => {
  const [text, setText] = useState('');
  const [borderColor, setBorderColor] = useState('transparent');
  const [isFocused, setIsFocused] = useState(false);
  const inputRef = useRef(null);

  const handleTextChange = (newText) => {
    setText(newText);
    setBorderColor('transparent');
    if (onChangeText) {
      onChangeText(newText);
    }
  };

  const handleBlur = () => {
    setIsFocused(false);
    if (validate) {
      const isValid = validate(text);
      setBorderColor(isValid ? 'transparent' : 'red');
    }
  };

  const handleFocus = () => {
    setIsFocused(true);
  }

  const renderInput = () => {
    switch (type) {
      case 'email':
        return (
          <TextInput
            ref={inputRef}
            style={[styles.input, { borderColor: isFocused ? 'transparent' : borderColor }]}
            placeholder={placeholder}
            onChangeText={handleTextChange}
            value={text}
            keyboardType="email-address"
            autoCapitalize="none"
            onBlur={handleBlur}
            onFocus={handleFocus}
          />
        );
      case 'password':
        return (
          <TextInput
            ref={inputRef}
            style={[styles.input, { borderColor: isFocused ? 'transparent' : borderColor }]}
            placeholder={placeholder}
            onChangeText={handleTextChange}
            value={text}
            secureTextEntry
            onBlur={handleBlur}
            onFocus={handleFocus}
          />
        );
      case 'text':
      default:
        return (
          <TextInput
            ref={inputRef}
            style={[styles.input, { borderColor: isFocused ? 'transparent' : borderColor }]}
            placeholder={placeholder}
            onChangeText={handleTextChange}
            value={text}
            onBlur={handleBlur}
            onFocus={handleFocus}
          />
        );
    }
  };

  return (
    <>
      {title && <Text style={styles.title}>{title}</Text>}
      {type === 'phone' ? (
        <TextInputMask
          ref={inputRef}
          style={[styles.input, { borderColor: isFocused ? 'transparent' : borderColor }]}
          placeholder={placeholder}
          onChangeText={handleTextChange}
          value={text}
          type={'cel-phone'}
          options={{
            maskType: 'BRL',
            withDDD: true,
            dddMask: '(99) ',
          }}
          onBlur={handleBlur}
          onFocus={handleFocus}
        />
      ) : (
        renderInput()
      )}
    </>
  );
};

const styles = StyleSheet.create({
  input: {
    height: 40,
    borderColor: 'gray',
    borderWidth: 1,
    width: '90%',
    borderRadius: 10, 
    margin: 10,
    padding: 10,
    fontSize: 14,
    color: '#fff',
    backgroundColor: '#6D89B3',
    textAlignVertical: 'center',
    borderColor: 'transparent'
  },
  title: {
    fontSize: 12,
    paddingHorizontal: 5,
    alignSelf: 'flex-start',
    marginLeft: 25,
    marginBottom: -8,
    color: '#fff'
  },
});

export default Input;
