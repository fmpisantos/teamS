import { configureStore } from '@reduxjs/toolkit';
import chatReducer from './chat/chat';

export default configureStore({
  reducer: {
    chat: chatReducer,
  },
});
