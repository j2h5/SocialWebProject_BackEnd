package com.bit.fin.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageDto {
	
	private String senderName;
	private String receiverName;
	private String message;
	private Timestamp date;
	private String status;
	private int class_num;
}
