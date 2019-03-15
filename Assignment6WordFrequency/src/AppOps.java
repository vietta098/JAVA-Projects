
interface AppView {
	public void run();
		
}

interface AppController{
	void appInit();
	void setView();
	void run(String viewName);
}

interface wordFrequencyApp{
	
}