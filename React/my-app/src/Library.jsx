import React from "react";
import Book from "./Book";

function Library(props) {
    return (
        <div>
            <Book name="처음 만난 파이썬" numberOfPage={300}/>
            <Book name="처음 만난 AWS" numberOfPage={400}/>
            <Book name="처음 만난 리액트" numberOfPage={500}/>
        </div>
    );
}