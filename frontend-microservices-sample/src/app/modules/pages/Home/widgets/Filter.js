import React, { useEffect, useState } from "react";
import LoadingBtn from "../../../layout/components/Loadbar/LoadingBtn";
import URI from "../../../../const/FetchAPI";
import AxiosLib from "../../../../const/AxiosLib";

export function Filter() {
  const [programs, setPrograms] = useState({
    loading: false,
    message: "",
    data: [],
  });
  const fetchPrograms = () => {
    setPrograms({ ...programs, loading: true });
    const param = {
      type: "get",
      path: URI + "api/programs",
      headers: {
        "Content-Type": "application/json",
      },
      body: {},
    };
    AxiosLib(param).then((response) => {
      if (response.result) {
        setPrograms({ ...programs, data: response.data, loading: false });
      } else {
        setPrograms({ ...programs, data: response.message, loading: false });
      }
    });
  };

  const [programStudy, setProgramStudy] = useState({
    loading: false,
    message: "",
    data: [],
  });
  const fetchProgramStudy = () => {
    setProgramStudy({ ...programStudy, loading: true });
    const param = {
      type: "get",
      path: URI + "api/program-study",
      headers: {
        "Content-Type": "application/json",
      },
      body: {},
    };
    AxiosLib(param).then((response) => {
      if (response.result) {
        setProgramStudy({
          ...programStudy,
          data: response.data,
          loading: false,
        });
      } else {
        setProgramStudy({
          ...programStudy,
          data: response.message,
          loading: false,
        });
      }
    });
  };

  const [filterStudent, setFilterStudent] = useState({
    npm: "",
    name: "",
    programs: { id: 0 },
    programStudy: { id: 0 },
  });

  const SubmitFilter = (e) => {
    console.log(filterStudent);
  };

  useEffect(() => {
    fetchPrograms();
    fetchProgramStudy();
  }, []);

  return (
    <div className="card card-xxl-stretch mb-5 mb-xl-8">
      <div className="card-header border-0 pt-5">
        <h3 className="card-title align-items-start flex-column">
          <span className="card-label fw-bolder fs-3 mb-1">Form Filter</span>
          <span className="text-muted mt-1 fw-bold fs-7">
            Find specific data
          </span>
        </h3>
      </div>

      <div className="card-body py-3">
        <form method="post" id="form-filter-std" autoComplete="off">
          <div className="mb-5">
            <label className="form-label">NPM</label>
            <input
              type="text"
              name="npm"
              className="form-control"
              defaultValue={filterStudent.npm}
              onChange={(e) =>
                setFilterStudent({ ...filterStudent, npm: e.target.value })
              }
            />
          </div>
          <div className="mb-5">
            <label className="form-label">Name</label>
            <input
              type="text"
              name="fullname"
              className="form-control"
              defaultValue={filterStudent.name}
              onChange={(e) =>
                setFilterStudent({ ...filterStudent, name: e.target.value })
              }
            />
          </div>
          <div className="row mb-10">
            {programs.message || programStudy.message ? (
              <div className="col">
                <div className="alert alert-danger">
                  {programs.message
                    ? programs.message
                    : programStudy.message
                    ? programStudy.message
                    : ""}
                </div>
              </div>
            ) : (
              ""
            )}
            <div className="col">
              <div className="mb-3">
                <label className="form-label">Program</label>
                {programs.loading ? <LoadingBtn /> : ""}
                <select
                  name="program_id"
                  className={
                    "form-select " + (programs.loading ? "d-none" : "d-block")
                  }
                  value={filterStudent.programs.id}
                  onChange={(e) =>
                    setFilterStudent({
                      ...filterStudent,
                      programs: { id: e.target.value },
                    })
                  }
                >
                  <option value="">Choose One</option>
                  {Object.values(programs.data).length > 0
                    ? programs.data.map((v, index) => (
                        <option value={parseInt(v.id)} key={index}>
                          {v.name}
                        </option>
                      ))
                    : ""}
                </select>
              </div>
            </div>
            <div className="col">
              <div className="mb-3">
                <label className="form-label">Program Study</label>
                {programStudy.loading ? <LoadingBtn /> : ""}
                <select
                  name="program_study_id"
                  className={
                    "form-select " +
                    (programStudy.loading ? "d-none" : "d-block")
                  }
                  value={filterStudent.programStudy}
                  onChange={(e)=>setFilterStudent({...filterStudent, programStudy:{id:e.target.value}})}
                >
                  <option value="">Choose One</option>
                  {Object.values(programStudy.data).length > 0
                    ? programStudy.data.map((v, index) => (
                        <option value={parseInt(v.id)} key={index}>
                          {v.name}
                        </option>
                      ))
                    : ""}
                </select>
              </div>
            </div>
          </div>

          <div className="btn-group d-flex justify-content-end text-end align-items-end">
            <button className="btn btn-lg btn-secondary" type="reset">
              Clear
            </button>
            <button className="btn btn-lg btn-primary px-10" type="button" onClick={(e)=>SubmitFilter(e)}>
              <i className="bi bi-filter text-white fs-1"></i>
              Find
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
