import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import '../Styles/Product.css';
import Header from '../Component/Header';
function ProductsList({ addToCart }) {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    try {
      const response = await fetch('http://localhost:8092/products/');
      const data = await response.json();
      setProducts(data);
    } catch (error) {
      console.error('Error occurred while fetching products:', error);
    }
  };

  const handleAddToCart = async (productId) => {
    try {
      console.log('Adding product to cart:', productId);
  
      const response = await axios.get(`http://localhost:8082/cart/addtocart/${productId}`);
  
      console.log('Add to cart response:', response.data);
  
      if (response.status === 200) {
        console.log('Product added to cart successfully');
      } else {
        console.error('Error occurred while adding product to cart:', response.data);
      }
    } catch (error) {
      console.error('Error occurred while adding product to cart:', error);
    }
  };
  

  
    return (
      <div className="products-container">
       <Header title="Products"  color="grey"/>
       <br />
        <div className="cards-container">
          {products.map(product => (
            <div className="card" key={product.id}>
              <h2>{product.name}</h2>
              <p className="price">₹{product.price}</p>
              <div className="card-image">
                <img src={product.imageUrl} alt={product.name} />
              </div>
              <p className="category">Category: {product.category}</p>
              <button onClick={() => handleAddToCart(product.id)}>Add to Cart</button>
            </div>
          ))}
        </div>
        <Link to="/cart">Go to Cart</Link>
      </div>
    );
    
}

export default ProductsList;
