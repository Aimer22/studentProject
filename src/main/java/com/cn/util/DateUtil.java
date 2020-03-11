package com.cn.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Timestamp now() {
		Date date=new Date();
		SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return Timestamp.valueOf(sdFormat.format(date));
	}
}
