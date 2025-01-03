import React from "react";
import ReactDOM from "react-dom/client"
function tick() {
    const element =(
        <div>
            <h1>안녕 리액트</h1>
            <h2>현재시간 : {new Date().toLocaleTimeString()}</h2>
        </div>
    );
        const root = ReactDOM.createRoot(document.getElementById('root'));
        root.render(element);
    
}

setInterval(tick,1000);

 
