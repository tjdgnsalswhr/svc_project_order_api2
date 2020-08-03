package com.example.demo.order.controller.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.order.core.service.TeamCustomerOrderService;

import io.swagger.annotations.ApiOperation;

@RestController
public class TeamCustomerOrderController {
	
	@Autowired
	TeamCustomerOrderService teamCustomerOrderService;
	
	@ApiOperation(value="최근 일주일 내역 조회", httpMethod = "GET", notes="최근 일주일 내역 조회 API.")
	@GetMapping(value="/order/teamcustomer/list/{teamname}")
	public ResponseEntity<Object> getRecentWeekOrderList(@PathVariable String teamname)
	{
		LocalDateTime enddate = LocalDateTime.now();
		LocalDateTime startdate = enddate.minusDays(7);
		return new ResponseEntity<>(teamCustomerOrderService.getOrderList(teamname, startdate, enddate), HttpStatus.OK);
	}
	
	@ApiOperation(value="기간 검색 내역 조회", httpMethod = "GET", notes="기간 검색 내역 조회 API.")
	@GetMapping(value="/order/teamcustomer/list/{teamname}/{startdate}/{enddate}")
	public ResponseEntity<Object> getSearchingOrderList(@PathVariable String teamname, @PathVariable LocalDateTime startdate, @PathVariable LocalDateTime enddate)
	{
		return new ResponseEntity<>(teamCustomerOrderService.getOrderList(teamname, startdate, enddate), HttpStatus.OK);
	}
	

}
