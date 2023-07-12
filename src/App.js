
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './Pages/Home';
import Login from './Pages/Login';
import Signup from './Pages/Signup';
import About from './Pages/About';
import Support from './Pages/Support';
import Coupon from './Pages/Coupon';
import Product from './Pages/Product';
import Cart from './Pages/Cart/Cart';
function App() {

 
  
  return (
    
  <BrowserRouter>
  <Routes>
  <Route path="/" element={<Login/>} />
  <Route path='/signup' element={<Signup/>}></Route> 
  <Route path='/about' element={<About/>}></Route> 
  <Route path='/support' element={<Support/>}></Route>   
  <Route path='/coupon' element={<Coupon/>}></Route> 
  <Route path='/product' element={<Product/>}></Route> 
  <Route path='/cart' element={<Cart/>}></Route> 
  <Route path='/home' element={<Home/>}></Route>
  </Routes>
  </BrowserRouter>
  );
}

export default App;
