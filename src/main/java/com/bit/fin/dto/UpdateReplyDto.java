package com.bit.fin.dto;

public class UpdateReplyDto {
	private int class_num;
	
	private double class_rateAvg;
	
public int getclass_num() {
	return class_num;
}

public void setClass(int class_num) {
	this.class_num = class_num;
}
public double getRatingAvg() {
	return class_rateAvg;
}
public void setRatingAvg(double class_rateAvg) {
	this.class_rateAvg =class_rateAvg;
}
@Override
public String toString() {
	return "UpdateReplyDTO [class_num=" + class_num + ", ratingAvg=" + class_rateAvg + "]";
}

}
