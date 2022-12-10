import authReducer from "./AuthReducers";
import {combineReducers} from 'redux';

const AuthReducers = combineReducers({
    AuthToken : authReducer,
})

export default AuthReducers;