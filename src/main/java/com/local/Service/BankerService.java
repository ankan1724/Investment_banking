package com.local.Service;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.Model.Banker;
import com.local.Repository.BankerRepo;

@Service
public class BankerService {

	@Autowired
	private BankerRepo bankerRepo;
	
	
	public List<Banker> getallBankers() {
		return this.bankerRepo.findAll();
	}
	
	
	public void addbanker(String firstname,String lastname,
			String email) {
		Banker banker=new Banker();
		banker.setFirstname(firstname.toUpperCase(Locale.ROOT));
		banker.setLastname(lastname.toUpperCase(Locale.ROOT));
		banker.setEmail(email);
		banker.setId((long)(Math.random()*1000));
		long account_number = (long) (Math.random() * 100000000000000L);
        long number = 5200000000000000L + account_number;
        banker.setAccnumber(number);
        banker.setClientid(firstname.concat(banker.getAccnumber().toString().substring(13, 16)));
        banker.setClientsecret(UUID.randomUUID().toString().substring(10));
        this.bankerRepo.save(banker);
		}
}