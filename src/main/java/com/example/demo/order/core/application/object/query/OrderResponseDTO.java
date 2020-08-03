package com.example.demo.order.core.application.object.query;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.example.demo.order.core.application.object.command.OrderRequestDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@NoArgsConstructor
@Getter
@Setter
public class OrderResponseDTO {
	
	String id;			//Order Id
	String ordertype; 	//1. 충전, 2. 결제
	String storename;	//주문에 연관된 가게 이름
	String teamname;	//주문에 연관된 팀 이름
	int money;
	@CreationTimestamp
	LocalDateTime orderdate;

}
