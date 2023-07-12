import React, { useEffect, useState } from 'react';
import axios from 'axios';
import '../Styles/CouponList.css';
import Header from '../Component/Header';
const CouponList = () => {
  const [coupons, setCoupons] = useState([]);

  useEffect(() => {
    fetchCoupons();
  }, []);

  const fetchCoupons = async () => {
    try {
      const response = await axios.get('http://localhost:8081/coupon/findall');
      setCoupons(response.data);
    } catch (error) {
      console.error('Error fetching coupons:', error);
    }
  };

  return (
    <div className="coupon-list-container">
    <Header title="Coupons"  color="grey"/>
    <br />
    <div className="coupon-list">
      {coupons.map((coupon) => (
        <div key={coupon.couponId} className="coupon-card">
          <img src={coupon.imageUrl} alt="Coupon" className="coupon-image" />
          <div className="coupon-details">
            <p className="coupon-category">Category: {coupon.category}</p>
            <p className="coupon-count">Code: {coupon.code}</p>
            <p className="coupon-offer">Offer: {coupon.offer}</p>
            <p className="coupon-company">Company Name: {coupon.companyName}</p>
          </div>
        </div>
      ))}
    </div>
  </div>
  );
};

export default CouponList;
