import { useState } from 'react'
import './App.scss'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import{
Producto3,
Producto2,
Producto1,
Producto,
Store,
ChatGPT,
aboutLink,
School,
Socials,
NotFound,
  Home,
}from "./views"

function App() {

  return (
    <Routes>
<Route path="/Producto3" element={<Producto3/>}/>,
<Route path="/Producto2" element={<Producto2/>}/>,
<Route path="/Producto1" element={<Producto1/>}/>,
<Route path="/Producto" element={<Producto/>}/>,
<Route path="/Store" element={<Store/>}/>,
<Route path="/ChatGPT" element={<ChatGPT/>}/>,
<Route path="/aboutLink" element={<aboutLink/>}/>,
<Route path="/School" element={<School/>}/>,
<Route path="/Socials" element={<Socials/>}/>,
<Route path="*" element={<NotFound/>}/>,
      <Route path="/" element={<Home />} />
    </Routes>
  );
}

export default App
