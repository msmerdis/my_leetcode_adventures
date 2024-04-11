package msmerdis.leetcode;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		LocalDate date = LocalDate.now();
		String packageName = String.format("msmerdis.leetcode.y%4d.m%02d.d%02d.Solution", date.getYear(), date.getMonthValue(), date.getDayOfMonth());
		Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(packageName);
		Object object = clazz.getConstructor().newInstance();
		SolutionRunner runner = SolutionRunner.class.cast(object);

		for (SolutionTestCase tc : runner.testCases()) {
			String status;
			try {
				status = runner.invoke(tc) ? "success" : "failure";
			} catch (Exception e) {
				status = e.getClass().getSimpleName() + ": " + e.getMessage();
			}
			System.out.println(String.format("Test case %d : %s", tc.getId(), status));
		}
	}

}
