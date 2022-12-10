import axios from "axios";

async function AxiosLib(param) {
  var config = {
    method: param.type,
    url: param.path,
    headers: param.headers,
    data: param.body
  };

  let response = await axios(config)
    .then(function(response) {
      var result = response.data;
      return result;
    })
    .catch(function (error) {
      error.result = false;
      return error;
    });
  return response;
}

export default AxiosLib;
