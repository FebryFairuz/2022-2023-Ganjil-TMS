import sign from 'jwt-encode';
import packageJson from "../../../../../package.json";

const AuthStoreData = value =>{
    if(value){
        var d = new Date();
        var tstamp = d.getTime() + (1*60*60*1000); // 1jam
        value.expired = tstamp;

        const roleID = rolename =>{
            if(rolename === "Student"){
                return 1;
            }else if(rolename === "Lecturer"){
                return 2;
            }else if(rolename === "Staff"){
                return 3;
            }else if(rolename === "Parent"){
                return 4;
            }else{
                return 0;
            }
        }
        
        value.currentData = {
            entityid:value.identity.entityid, 
            given_name:value.identity.given_name, 
            family_name: value.identity.family_name, 
            empid: value.identity.empid,
            role:value.identity.role,
            roleid:roleID(value.identity.role),
        };
        //console.log(value);

        const token = sign(value, packageJson.system_param.PublicKey);
        localStorage.setItem("AuthToken",token);
    }
}

export default AuthStoreData;