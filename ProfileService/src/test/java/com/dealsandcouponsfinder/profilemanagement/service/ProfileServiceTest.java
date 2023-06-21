package com.dealsandcouponsfinder.profilemanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dealsandcouponsfinder.profilemanagement.exception.ProfileRequestException;
import com.dealsandcouponsfinder.profilemanagement.model.Profile;
import com.dealsandcouponsfinder.profilemanagement.repository.ProfileRepository;

@SpringBootTest
public class ProfileServiceTest {

	@Autowired
	ProfileService profileService;

	@MockBean
	private ProfileRepository profileRepository;


	@Test
	void saveTest() {
		Profile pro = new Profile("user2@gmail.com", "paru", "9876543210", "Pass");
		when(profileRepository.save(pro)).thenReturn(pro);
		assertEquals(pro, profileService.save(pro));
	}

	@Test
	 public void deleteByIdTest() throws ProfileRequestException {
		when (profileRepository.findById("user2@gmail.com")).thenReturn(Optional.of(new Profile("user2@gmail.com", "paru", "9876543210", "Pass")));
		doNothing().when(profileRepository).deleteById("user21@gmail.com");
		assertEquals(profileService.deleteById("user21@gmail.com"), "Id user1@gmail.com deleted!");
	}

	@Test
	public void findByIdTest() throws ProfileRequestException {
		when (profileRepository.findById("user2@gmail.com")).thenReturn(Optional.of(new Profile("user2@gmail.com", "paru", "9876543210", "Pass")));
		Optional<Profile> profile = profileService.findById("user2@gmail.com");
		assertEquals("user2@gmail.com",profile.get().getEmailId());
		assertEquals("paru",profile.get().getFullName());
		assertEquals("9876543210",profile.get().getMobileNo());


	}


}
