import React, { useState } from "react";
import AxiosLib from "./AxiosLib";

const URI = "http://localhost:8080/";

function FetchPrograms() {
  const param = {
    type: "get",
    path: URI + "api/programs",
    headers: {
      "Content-Type": "application/json",
    },
    body: {},
  };
  AxiosLib(param).then((response) => {
    return response;
  });
}

export default URI;
export { FetchPrograms };
