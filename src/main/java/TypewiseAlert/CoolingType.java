package TypewiseAlert;

public enum CoolingType {
	PASSIVE_COOLING(0, 35), HI_ACTIVE_COOLING(0, 45), MED_ACTIVE_COOLING(0, 40);

	int upperLimit;
	int lowerLimit;

	CoolingType(int upperLimit, int lowerLimit) {
		// TODO Auto-generated constructor stub
		this.upperLimit = upperLimit;
		this.lowerLimit = lowerLimit;
	}

	public int getUpperLimit() {
		return upperLimit;
	}

	public int getLowerLimit() {
		return lowerLimit;
	}

};