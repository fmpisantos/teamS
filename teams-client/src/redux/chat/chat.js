import { createSlice } from '@reduxjs/toolkit';
import chatReducer from './chatReducer';

export const slice = createSlice({
  name: 'chat',
  initialState: {
    userName: "",
    token: "",
    open:false,
    notifications: 0
  },
  ...chatReducer
});

export const { login, reset, showChat, toggleChat } = slice.actions;
export const state = state => state.chat

export default slice.reducer;
