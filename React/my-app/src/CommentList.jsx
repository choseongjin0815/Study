import React from "react";
import Comment from "./comment";

const comments = [
    {
        name : "이름1",
        comment : "코멘트1"
    },
    {
        name : "이름2",
        comment : "코멘트2"
    },
    {
        name : "이름3",
        comment : "코멘트3"
    }
];

function CommnetList(props) {
    return (
        <div>
            {comments.map((comment) => {
                return (
                    <Comment name={comment.name} comment={comment.comment}/>
                );
            })}
        </div>
    )
}
export default CommnetList;