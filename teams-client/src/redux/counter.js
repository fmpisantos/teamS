import { createSlice } from '@reduxjs/toolkit';
import counterReducers from './counterReducers';

export const slice = createSlice({
  name: 'counter',
  initialState: {
    value: 0,
  },
  ...counterReducers
});

export const { increment, decrement, incrementByAmount } = slice.actions;
export const state = state => state.counter

export const incrementAsync = amount => dispatch => {
  setTimeout(() => {
    dispatch(incrementByAmount(amount));
  }, 1000);
};

export default slice.reducer;
