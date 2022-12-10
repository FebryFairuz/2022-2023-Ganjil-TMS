import React from "react";
import parse from 'html-react-parser'

export default function Breadcrumb(props) {
  const title = props.title ? props.title : "-";
  const item = props.item ? props.item : null;
  const total = Object.values(item).length;
  return (
    <div className="mb-10">
      <h1>{title}</h1>
      {(total > 0) ? (
        <nav aria-label="breadcrumb">
          <ol className="breadcrumb">
            {item.map((v,index) => (
              <li className={"breadcrumb-item "+(((total-1)=== index) ? 'active':''  )} key={index}>
                <span>{parse(v.name)}</span>
              </li>
            ))}
          </ol>
        </nav>
      ) : (
        ""
      )}
    </div>
  );
}
