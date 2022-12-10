const authReducer = (state, action) =>{
    switch(action.type){
        case "SIGN_IN":
            return action.payload;
        
        case "SIGN_OUT":
            localStorage.removeItem("AuthToken");
            localStorage.removeItem("CurrentProfile");
            window.location = '/signin'; 
            break;
        default:
            return 0;  
    }
};

export default authReducer;