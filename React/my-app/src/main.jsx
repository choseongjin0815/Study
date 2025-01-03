import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import '/src/Tick.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
    <Blocks />
  </StrictMode>,
)
