package com.capgemini.UserProfileAndRanking.enitities;

import java.time.LocalTime;

public enum Hour {

	H01_00, H01_30, H02_00, H02_30, H03_00, H03_30, H04_00, H04_30, H05_00, H05_30, H06_00, H06_30, H07_00, H07_30, H08_00, H08_30, H09_00, H09_30, H10_00, H10_30, H11_00, H11_30, H12_00, H12_30, H13_00, H13_30, H14_00, H14_30, H15_00, H15_30, H16_00, H16_30, H17_00, H17_30, H18_00, H18_30, H19_00, H19_30, H20_00, H20_30, H21_00, H21_30, H22_00, H22_30, H23_00, H23_30, H00_00;

	public LocalTime toLocalTime() {

		String hour = this.toString();
		String hourToParse = hour.substring(1, 3) + ":" + hour.substring(4, 6);
		return LocalTime.parse(hourToParse);

	}

}
