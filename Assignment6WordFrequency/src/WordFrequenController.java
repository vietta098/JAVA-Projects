
public class WordFrequenController implements AppController {
	
	AppView view;
	WordHandler word;
	DataHandler data;
	String viewName, input;
	int count;
	
	WordFrequenController(){

	}
	

	@Override
	public void setView() {
		
	}
	
	@Override
	public void appInit() {;
		
	}

	@Override
	public void run(String viewName) {
		this.viewName = viewName;
		
		if(viewName.equalsIgnoreCase("gui")) {
			view = new GUIAppView();
			view.run();
		}
		else {
			view = new COAppView();
			view.run();
		}
	}

}


