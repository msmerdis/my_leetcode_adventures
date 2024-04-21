package msmerdis.leetcode;

import java.lang.reflect.InvocationTargetException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		LocalDate date = null;

		if (args.length > 0) {
			date = parseDate (args[0]);
		} else {
			date = LocalDate.now();
		}

		exec (date);
	}

	public static LocalDate parseDate (String date) {
		Pattern p = Pattern.compile("(\\d+)-(\\d+)-(\\d+)");
		Matcher m = p.matcher(date);
		boolean b = m.matches();

		if (b) {
			int day   = Integer.parseInt(m.group(1));
			int month = Integer.parseInt(m.group(2));
			int year  = Integer.parseInt(m.group(3));

			System.out.println("Using custom date : " + date);

			return LocalDate.of(year, month, day);
		}

		throw new DateTimeException(date);
	}

	public static SolutionRunner getRunner (LocalDate date) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String packageName = String.format("msmerdis.leetcode.y%4d.m%02d.d%02d.Solution", date.getYear(), date.getMonthValue(), date.getDayOfMonth());
		Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(packageName);
		Object object = clazz.getConstructor().newInstance();

		return SolutionRunner.class.cast(object);
	}

	public static void exec (LocalDate date) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		getRunner(date).exec();
	}

}
