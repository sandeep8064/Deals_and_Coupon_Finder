package com.coupon.ServiceTest;

import com.coupon.exception.CouponRequestException;
import com.coupon.model.Coupon;
import com.coupon.repository.CouponRepository;
import com.coupon.service.CouponService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@SpringBootTest
public class CouponServiceTest {

	@Autowired
	private CouponService couponService;

	@MockBean
	private CouponRepository couponRepository;



	@Test
	public void findByIdTest() throws CouponRequestException {
		when (couponRepository.findById("2")).thenReturn(Optional.of(new Coupon("2","food","food","20%", "Comp", "Bakery")));
		Optional<Coupon> cou = couponService.findByCouponId("2");
		assertEquals("2", cou.get().getCouponId());
		assertEquals("food",cou.get().getCategory());
		assertEquals("food",cou.get().getCode());
		assertEquals("20%",cou.get().getOffer());
		assertEquals("Comp",cou.get().getCompanyName());
		assertEquals("Bakery",cou.get().getImageUrl());
	}

	@Test
	public void findallTest() {
		Coupon c1=new Coupon("1","user","food","20", "20%", "Bakery");
		Coupon c2=new Coupon("2","user","food","20", "20%", "Bakery");
		Coupon c3=new Coupon("3","user","food","20", "20%", "Bakery");
		Coupon c4=new Coupon("4","user","food","20", "20%", "Bakery");
		List<Coupon> cou= new ArrayList<>();
		cou.add(c1);
		cou.add(c2);
		cou.add(c3);
		cou.add(c4);

		when(couponRepository.findAll()).thenReturn(cou);
		assertEquals(couponService.findAll().size(),4);
	}

	@Test
	 public void deleteByIdTest() throws CouponRequestException {
		when (couponRepository.findById("6")).thenReturn(Optional.of(new Coupon("6","user","food","20", "20%", "Bakery")));
		doNothing().when(couponRepository).deleteById("6");
		assertEquals(couponService.deleteById("6"), "Id 6 deleted!");
	}

	

		
}
