package services;

import java.io.IOException;

import model.User;

public interface PlanningService {

	void sendPlanning(User user) throws IOException;
	
}
