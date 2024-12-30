import React from "react";



function Comment(props) {
    return (
        <div>
            <div>{props.name}</div>
            <div>{props.comment}</div>
        </div>
    );
    
}

export default Comment;