import React, { createContext, useContext, useState } from "react";
import ReactDOM from "react-dom";

// 컨텍스트 생성
const ThemeContext = createContext();

function ThemedButton() {
  // 컨텍스트 값 가져오기
  const { theme, toggleTheme } = useContext(ThemeContext);

  return (
    <button
      style={{
        backgroundColor: theme === "dark" ? "#333" : "#fff",
        color: theme === "dark" ? "#fff" : "#000",
        padding: "10px 20px",
        border: "none",
        borderRadius: "5px",
        cursor: "pointer",
      }}
      onClick={toggleTheme}
    >
      {theme === "dark" ? "🌙 Dark Mode" : "☀️ Light Mode"}
    </button>
  );
}

function App() {
  const [theme, setTheme] = useState("light");

  // 테마 토글 함수
  const toggleTheme = () => {
    setTheme((prevTheme) => (prevTheme === "light" ? "dark" : "light"));
  };

  return (
    <ThemeContext.Provider value={{ theme, toggleTheme }}>
      <div
        style={{
          height: "100vh",
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          backgroundColor: theme === "dark" ? "#121212" : "#f5f5f5",
          color: theme === "dark" ? "#fff" : "#000",
        }}
      >
        <ThemedButton />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;