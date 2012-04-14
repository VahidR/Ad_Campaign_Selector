
public final class Companies extends Object {
	public String m_name;
	public Integer m_numOfCampaigns;
	public Integer m_worth;
	

	public Companies(String name, Integer numOfCampaigns , Integer worth){
		this.m_name = name;
		this.m_numOfCampaigns = numOfCampaigns;
		this.m_worth = worth;
	
	}

	public String toString(){
		return ("------the company of: " + m_name + "\n" +
			"with the number Of Campaigns: " + m_numOfCampaigns + "\n" +
			"and total worth of: " + m_worth);
	}


	

}
