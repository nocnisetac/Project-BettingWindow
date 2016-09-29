package project.betting.model.extra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StrToDate {
	public static Date stringToDate(String strDate) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = dateFormat.parse(strDate);
		return date;
	}
}
