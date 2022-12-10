import React,{useState, useEffect} from "react";
import { openModal } from "../../../layout/components/Modals/ModalPopUp";
import Form from "./Form";
import AxiosLib from "../../../../const/AxiosLib";
import LoadingBtn from "../../../layout/components/Loadbar/LoadingBtn";
import URI from "../../../../const/FetchAPI";

export function Students() {
  const openForm = (e,id) => {
    openModal({
      open: false,
      message: <Form id={id} />,
      header: "Form Add New Student",
      size: "lg",
    });
  };

  const [students, setStudents] = useState({
    loading: false,
    message: "",
    data: [],
  });
  const fetchStudents = () => {
    setStudents({ ...students, loading: true });
    const param = {
      type: "get",
      path: URI + "api/students",
      headers: {
        "Content-Type": "application/json",
      },
      body: {},
    };
    AxiosLib(param).then((response) => {
      if (response.result) {
        setStudents({ ...students, data: response.data, loading: false });
      } else {
        setStudents({ ...students, data: response.message, loading: false });
      }
    });
  };

  useEffect(() => {
    fetchStudents();
  }, []);

  return (
    <div className="card card-xxl-stretch mb-5 mb-xl-8">
      <div className="card-header border-0 pt-5">
        <h3 className="card-title align-items-start flex-column">
          <span className="card-label fw-bolder fs-3 mb-1">Students List</span>
          <span className="text-muted mt-1 fw-bold fs-7">Total 0 student</span>
        </h3>
        <div className="card-toolbar">
          <button
            className="btn btn-sm btn-light btn-active-primary"
            type="button"
            onClick={(e) => openForm(e)}
          >
            <span className="svg-icon svg-icon-3">
              <svg width="24" height="24" viewBox="0 0 24 24" fill="none">
                <rect
                  opacity="0.5"
                  x="11.364"
                  y="20.364"
                  width="16"
                  height="2"
                  rx="1"
                  transform="rotate(-90 11.364 20.364)"
                  fill="currentColor"
                ></rect>
                <rect
                  x="4.36396"
                  y="11.364"
                  width="16"
                  height="2"
                  rx="1"
                  fill="currentColor"
                ></rect>
              </svg>
            </span>
            Add New Student
          </button>
        </div>
      </div>

      <div className="card-body py-3">
        <div className="table-responsive">
          <table className="table table-row-dashed table-row-gray-300 align-middle gs-0 gy-4">
            <thead>
              <tr className="fw-bolder text-muted">
                <th>No</th>
                <th>Student ID</th>
                <th>Fullname</th>
                <th>Program</th>
                <th>Program Study</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {students.loading ? (
                <tr>
                  <td colSpan={6}>
                    <LoadingBtn />
                  </td>
                </tr>
              ) : ( '' )}
              {(Object.values(students.data).length > 0) ? (
                students.data.map((v,index)=>(
                    <tr key={index}>
                        <td>{index+1}</td>
                        <td>{v.npm}</td>
                        <td>{v.firstname +" "+ v.middlename+" "+v.lastname}</td>
                        <td>{v.programs.name}</td>
                        <td>{v.programStudy.name}</td>
                        <td>
                            <div className="btn-group">
                                <button className="btn btn-sm btn-icon btn-light" type="button" onClick={(e)=>openForm(e,v.id)}>
                                    <i className="bi bi-pencil-square"></i>
                                </button>
                                <button className="btn btn-sm btn-icon btn-danger" type="button">
                                    <i className="bi bi-trash"></i>
                                </button>
                            </div>
                        </td>
                    </tr>
                ))
              ) : (
                <tr>
                    <td colSpan={6}>No record found</td>
                </tr>
              )}
              
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}
