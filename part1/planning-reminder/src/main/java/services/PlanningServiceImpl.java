package services;

import java.io.IOException;
import java.util.ArrayList;

import model.Planning;
import model.User;
import services.email.EmailDTO;
import services.email.EmailService;
import services.email.EmailServiceImpl;

public class PlanningServiceImpl implements PlanningService {

	public void sendPlanning(User user) throws IOException {
		EmailDTO emailDTO = new EmailDTO();
		emailDTO.setFromAddress("planning-reminder@planning.com");
		emailDTO.setFromName(user.getFullName());
		emailDTO.setToAddress(user.getEmail());
		emailDTO.setSubject("Planning Reminder");
		emailDTO.setMessage(getMessage(user));

		EmailService emailService = new EmailServiceImpl();
		emailService.send(emailDTO);
	}

	private String getMessage(User user) throws IOException {
		String message = "<html>"; 
		
		message += "<head>";
		message += "<style>p {font-size: 13px;	font-family:\"Helvetica\",\"sans-serif\";	color:#606060}table.blueTable {border: 1px solid #1C6EA4;background-color: #EEEEEE;width: 60%;text-align: left;border-collapse: collapse;}table.blueTable td,table.blueTable th {border: 1px solid #AAAAAA;padding: 3px 2px;}table.blueTable tbody td {font-size: 13px;padding:6.75pt 13.5pt 6.75pt 13.5pt;line-height:150%;font-family:\"Helvetica\",\"sans-serif\";color:#606060}table.blueTable tr:nth-child(even) {background: #D0E4F5;}table.blueTable thead {background: #1C6EA4;background: -moz-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);background: -webkit-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);background: linear-gradient(to bottom, #5592bb 0%, #327cad 66%, #1C6EA4 100%);border-bottom: 2px solid #444444;}table.blueTable thead th {font-size: 15px;padding:6.75pt 13.5pt 6.75pt 13.5pt;font-weight: bold;color: #FFFFFF;border-left: 2px solid #D0E4F5;}table.blueTable thead th:first-child {border-left: none;}table.blueTable tfoot {font-size: 14px;font-weight: bold;color: #FFFFFF;background: #D0E4F5;background: -moz-linear-gradient(top, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);background: -webkit-linear-gradient(top, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);background: linear-gradient(to bottom, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);border-top: 2px solid #444444;}table.blueTable tfoot td {font-size: 14px;}table.blueTable tfoot .links {text-align: right;}table.blueTable tfoot .links a {display: inline-block;background: #1C6EA4;color: #FFFFFF;padding: 2px 8px;border-radius: 5px;}</style>";
		message += "</head>";
		
		message += "<body>";
		message += "<h1 style=\"color: #5e9ca0;\">Planning Reminder</h1>";
		message += "<p>Hello " + user.getFullName() + ",</p>";
		message += "<p>Below you will find your training program for the next few days.</p>";
	  
		message += "<table class=\"blueTable\" >";
		message += "<thead>";
		message += "<tr>";
		message += "<th style=\"width: 208.85px;\">Course</th>";
		message += "<th style=\"width: 75px;\">Date start</th>";
		message += "<th style=\"width: 75px;\">Date end</th>";
		message += "</tr>";
		message += "</thead>";
		
		message += "<tbody>";
		for (Planning planning : user.getPlannings()) {
			message += "<tr>";
			message += "<td>" + planning.getCourse() + "</td>";
			message += "<td>" + planning.getDateStart() + "</td>";
			message += "<td>" + planning.getDateEnd() + "</td>";
			message += "</tr>";
		}
		message += "</tbody>";
		message += "</table>";
		
		message += "</body>";
		
		message += "</html>";
				
		return message;
	}

	public static void main(String[] args) throws IOException {
		User user = new User();
		{
			user.setEmail("patsy.lee@gmail.com");
			user.setName("Patsy");
			user.setSurname("Lee");
			user.setGender("Female");

			user.setPlannings(new ArrayList<Planning>());
			// Freemarker planning
			{
				Planning planning = new Planning();
				planning.setCourse("Freemarker");
				planning.setDateStart("2021-01-10");
				planning.setDateEnd("2021-01-15");

				user.getPlannings().add(planning);
			}
			// JavaEE planning
			{
				Planning planning = new Planning();
				planning.setCourse("JavaEE");
				planning.setDateStart("2021-01-12");
				planning.setDateEnd("2021-01-18");

				user.getPlannings().add(planning);
			}
			// Angular planning
			{
				Planning planning = new Planning();
				planning.setCourse("Angular");
				planning.setDateStart("2021-01-20");
				planning.setDateEnd("2021-02-25");

				user.getPlannings().add(planning);
			}
		}

		PlanningServiceImpl planningServiceImpl = new PlanningServiceImpl();
		planningServiceImpl.sendPlanning(user);
	}
}
