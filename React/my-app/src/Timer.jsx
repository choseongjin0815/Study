import React, { useState, useEffect } from "react";

function Timer() {
  const [seconds, setSeconds] = useState(0);

  useEffect(() => {
    const interval = setInterval(() => {
      setSeconds((prev) => prev + 1); // 매 초마다 1씩 증가
    }, 1000);

    return () => clearInterval(interval); // 컴포넌트 언마운트 시 정리
  }, []); // 의존성 배열이 비어 있으므로 처음 렌더링 시 1회만 실행

  return <p>경과 시간: {seconds}초</p>;
}

export default Timer;