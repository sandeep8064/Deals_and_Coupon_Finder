import React, { useEffect, useState } from 'react';
import './Cart.css';
import { loadScript } from '../../Component/utils';
import Header from '../../Component/Header';
const CartList = () => {
  const [carts, setCarts] = useState([]);
  const [couponCode, setCouponCode] = useState('');
  const [totalPrice, setTotalPrice] = useState(0);
  const [discountedPrice, setDiscountedPrice] = useState(0);


  const createOrder = async () => {
    return await fetch('http://localhost:8082/payment/'+discountedPrice*100, {
    mode: 'no-cors',
    method: 'GET',
});
}




  useEffect(() => {
    fetchCartList();
  }, []);

  const fetchCartList = async () => {
    try {
      const response = await fetch('http://localhost:8082/cart//findall');
      const data = await response.json();
      setCarts(data);
    } catch (error) {
      console.error('Error occurred while fetching cart list:', error);
    }
  };

  const applyCoupon = async () => {
    try {
      const response = await fetch(`http://localhost:8082/cart/discount/${couponCode}`);
      const data = await response.json();
      if (response.ok) {
        if (typeof data === 'number' && data !== 404) {
          setDiscountedPrice(data);
        } else {
          throw new Error('Invalid coupon');
        }
      } else {
        throw new Error(data.message || 'Error occurred while applying coupon');
      }
    } catch (error) {
      console.error('Error occurred while applying coupon:', error);
      // Show alert message for invalid coupon
      if (error.message === 'Invalid coupon') {
        alert('Invalid coupon');
      }
    }
  };
  


  const handleRemoveItem = async (cartId) => {
    try {
      // Make an API call to remove the cart item
      await fetch(`http://localhost:8082/cart/deleteCart/${cartId}`, { method: 'DELETE' });

      // Update the cart list by fetching the updated data
      fetchCartList();
    } catch (error) {
      console.error('Error occurred while removing cart item:', error);
    }
  };

  const handleCouponCodeChange = (event) => {
    setCouponCode(event.target.value);
  };


  useEffect(() => {
    const fetchTotalPrice = async () => {
      try {
        const response = await fetch('http://localhost:8082/cart/totalPrice');
        const totalPrice = await response.json();
        setTotalPrice(totalPrice);
      } catch (error) {
        console.error('Error occurred while calculating total price:', error);
      }
    };

    fetchTotalPrice();
  }, [discountedPrice]);

 
  const handlePayment = async (amount) => {
    // Load Razorpay script dynamically
    await loadScript('https://checkout.razorpay.com/v1/checkout.js');

    const options = {
      key: 'rzp_test_oOq8flTwzIFsSY', // Replace with your actual Razorpay key
      amount: discountedPrice * 100, // Amount in paise or smallest currency unit
      currency: 'INR',
      name: 'Your Store',
      description: 'Purchase Description',
      handler: (response) => {
        // Handle the payment success response
        console.log(response);
      },
      prefill: {
        email: 'customer@example.com',
        contact: '9123119649',
      },
      notes: {
        address: 'Customer Address',
      },
      theme: {
        color: '#F37254',
      },
    };

    const razorpayInstance = new window.Razorpay(options);
    razorpayInstance.open();
  };
   
  
  return (
    <div className="cart-container">
    <div className="cart-list">
    <Header title="Cart"  color="grey"/>
    <br />
      {carts.map((cart) => (
        <div key={cart.cartId} className="cart-card">
          {cart.products && (
            <div className="product-details">
              <p>Name: {cart.products.name}</p>
              <p>Price: ₹ {cart.products.price}</p>
              <img src= {cart.products.imageUrl}/>
            </div>
          )}
          <button
            className="remove-button"
            onClick={() => handleRemoveItem(cart.cartId)}
          >
            Remove
          </button>
        </div>
      ))}
    </div>
      <div className="cart-side-card">
        <h2 className="payment-details-heading">Payment</h2>
         <br />
         <br />
        <div className="coupon-code">
          <label htmlFor="coupon-input">Coupon Code:</label>
          <input
            type="text"
            id="coupon-input"
            value={couponCode}
            onChange={handleCouponCodeChange}
          />
         <br />
         <button className="pay-button" onClick={applyCoupon}>
          Apply
        </button>
          
        </div>
        <br />
        
        <br />
        <br />
        <div className="total-price">
          <p>Total Price: {totalPrice}</p>
        </div>
        <div className="discounted-price">
        {discountedPrice !== 0 && (
       <div className="discounted-price">
       <p>Discounted Price: {discountedPrice}</p> 
       </div>
        )}
        </div>
        <button className="pay-button" onClick={handlePayment}>
         pay
        </button>
      </div>
  </div>
);
};

export default CartList;
