import React, { useEffect, useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import URI from "../../../../const/FetchAPI";
import AxiosLib from "../../../../const/AxiosLib";
import LoadingBtn from "../../../layout/components/Loadbar/LoadingBtn";

export default function Form({ id }) {
  const [btnSubmit, setBtnSubmit] = useState({
    text:"Save Changes",
    disabled: false
  });
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
        setProgramStudy({ ...programStudy, data: response.data, loading: false });
      } else {
        setProgramStudy({ ...programStudy, data: response.message, loading: false });
      }
    });
  };

  
  const [students, setStudents] = useState({
    loading: false,
    message: "",
    data: [],
  });
  const detailStudent = (id) => {
    setStudents({ ...students, loading: true });
    const param = {
      type: "get",
      path: URI + "api/students/"+id,
      headers: {
        "Content-Type": "application/json",
      },
      body: {},
    };
    AxiosLib(param).then((response) => {
      if (response.result) {
        setStudents({ ...students, data: response.data[0], loading: false });
      } else {
        setStudents({ ...students, data: response.message, loading: false });
      }
    });
  };

  const [postStudent, setPostStudent] = useState({
    npm:0,
    firstname:"",
    middlename:"",
    lastname:"",
    programs:{id:0},
    programStudy:{id:0},
    email:"",
    birthdate:""
  });

  const [postSubmit, setPostSubmit] = useState({
    data:postStudent,
    message:"",
    result:""
  })
  const [birthdata,setBirthdate] = useState();
  const BirthDate = () => (
    <DatePicker
      selected={birthdata}
      onChange={(date) => {
        setPostStudent({...postStudent, birthdate:formatDate(date)});
        setBirthdate(date);
      }}
      className="form-control"
      dateFormat="yyyy-MM-dd"
      placeholderText="Birthdate"
    />
  );

  const formatDate = value => {
    var d = new Date(value),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [year, month, day].join('-');
}

  

  const SubmitPostStudent = (e) =>{
    setBtnSubmit({text:"Processing...", disabled:true });
    
    //console.log(postStudent);
      const param = {
        type: "post",
        path: URI + "api/students/",
        headers: {
          "Content-Type": "application/json",
        },
        body: postStudent,
      };
      AxiosLib(param).then((response) => {
        if(response.result){
          setPostSubmit({...postSubmit, data:response.data, result:"success", message:"Successfully saved"})
        }else{
          setPostSubmit({...postSubmit, message:response.message, result:"error"});
        }

        setBtnSubmit({text:"Save Changes", disabled:false });
    });
  }

  useEffect(()=>{
    if(id){
      detailStudent(id);
      setPostStudent({...postStudent, id:id});
    }
    fetchPrograms(); fetchProgramStudy();
  },[])


  return (
    <div className="form-create">
      {(students.loading) ? <LoadingBtn /> : ''}
      <form method="post" id="form-filter-std" autoComplete="off" className={(id) ? ((students.loading)?'d-none':'d-block') : 'd-block'} >
        <div className="mb-5">
          <label className="form-label required">NPM</label>
          {id ? (
            <input
              type="hidden"
              name="id"
              className="form-control"
              defaultValue={id}
            />
          ) : (
            ""
          )}
          <input type="text" name="npm" className="form-control"  defaultValue={students.data.npm} onChange={(e)=>setPostStudent({...postStudent, npm:e.target.value})} />
          <span className="text-danger text-message"></span>
        </div>
        <div className="row">
          <div className="col">
            <div className="mb-5">
              <label className="form-label required">First Name</label>
              <input type="text" name="firstname" className="form-control text-capitalize" defaultValue={students.data.firstname} onChange={(e)=>setPostStudent({...postStudent, firstname:e.target.value})} />
              <span className="text-danger text-message"></span>
            </div>
          </div>
          <div className="col">
            <div className="mb-5">
              <label className="form-label">Middle Name</label>
              <input type="text" name="middlename" className="form-control text-capitalize" defaultValue={students.data.middlename}  onChange={(e)=>setPostStudent({...postStudent, middlename:e.target.value})} />
            </div>
          </div>
          <div className="col">
            <div className="mb-5">
              <label className="form-label required">Last Name</label>
              <input type="text" name="lastname" className="form-control text-capitalize" defaultValue={students.data.lastname} onChange={(e)=>setPostStudent({...postStudent, lastname:e.target.value})} />
            </div>
          </div>
        </div>

        <div className="row mb-10">
          <div className="col">
            <div className="mb-5">
              <label className="form-label required">Program</label>
              <select name="program_id" className="form-select" value={(Object.values(students.data).length > 0) ? students.data.programs.id : postStudent.programs.id} onChange={(e)=>setPostStudent({...postStudent, programs:{id:e.target.value}})} >
                <option value="">Choose One</option>
                  {Object.values(programs.data).length > 0
                    ? programs.data.map((v, index) => (
                        <option value={v.id} key={index}>
                          {v.name}
                        </option>
                      ))
                    : ""}
              </select>
            </div>
            <div className="mb-5">
              <label className="form-label required">Email</label>
              <input type="email" name="email" className="form-control"  defaultValue={students.data.email} onChange={(e)=>setPostStudent({...postStudent, email:e.target.value})} />
              <span className="text-danger text-message"></span>
            </div>
          </div>
          <div className="col">
            <div className="mb-5">
              <label className="form-label required">Program Study</label>
              <select name="program_study_id" className="form-select" value={(Object.values(students.data).length > 0) ? students.data.programStudy.id : postStudent.programStudy.id} onChange={(e)=>setPostStudent({...postStudent, programStudy:{id:e.target.value}})} >
                <option value="">Choose One</option>
                  {Object.values(programStudy.data).length > 0
                    ? programStudy.data.map((v, index) => (
                        <option value={v.id} key={index}>
                          {v.name}
                        </option>
                      ))
                    : ""}
              </select>
            </div>

            <div className="mb-5">
              <label className="form-label required">Birthdate</label>
              <BirthDate />
              <span className="text-danger text-message"></span>
            </div>
          </div>
        </div>
        
        {(postSubmit.result === "error") ? (
          <div className="mb-10">
            <div className={"alert alert-"+((postSubmit.result === "error") ? 'danger':'success')}>
              <h3 className="mb-0 text-capitalize">{postSubmit.result}:</h3>
              <p className="mb-0">{postSubmit.message}</p>
            </div>
          </div>
        ) : ''}

        <div className="text-center">
          <button className="btn btn-lg btn-primary px-10" type="button" disabled={btnSubmit.disabled} onClick={(e)=>SubmitPostStudent(e)}>
            {btnSubmit.text}
          </button>
        </div>
      </form>
    </div>
  );
}
