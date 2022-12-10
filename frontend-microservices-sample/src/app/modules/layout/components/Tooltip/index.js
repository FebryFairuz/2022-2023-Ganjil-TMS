import { Tooltip } from "react-bootstrap";
const renderTooltip = (props) => {
    return (
      <Tooltip id="button-tooltip" {...props}>
        {props.title}
      </Tooltip>
    );
  };

export default renderTooltip;