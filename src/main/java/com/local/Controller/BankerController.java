package com.local.Controller;

import java.util.List;

import com.local.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.local.Model.Banker;
import com.local.Service.BankerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/banker")
public class BankerController {

	@Autowired
	private BankerService bankerService;
	
	@GetMapping("/allBanker")
	@ApiOperation("To get all bankers")
	public List<Banker> getallBankers() {
		return this.bankerService.getallBankers();
	}
	
	@PostMapping("/add")
	@ApiOperation("To add banker")
	public String addbanker(@RequestParam String firstname,
			@RequestParam String lastname,
			@RequestParam String email) {
		this.bankerService.addbanker(firstname, lastname, email);
		return "Banker Added Successfully";
	}

}