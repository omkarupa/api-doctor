package com.po_solution.apipatient.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.po_solution.apipatient.entity.BasicMedicalQuestion;
import com.po_solution.apipatient.entity.Patient;
import com.po_solution.apipatient.pojo.MedicalQuestionPojo;
import com.po_solution.apipatient.repository.BasicMedicalQuestionRepository;

@Service
public class MedicalQuestionServiceImpl implements MedicalQuestionService {
	
	@Autowired
	BasicMedicalQuestionRepository medicalQuestionRepository;
	
	@Autowired
	PatientService patientService;
	
	

	@Override
	public MedicalQuestionPojo getQuestionList(String patientIdStr) {
		
		Long patientId;
		
		boolean isValidPatient = false;
		
		if(patientIdStr != null)
		{
			try {
				patientId	= Long.parseLong(patientIdStr);
				
				Patient patient = patientService.getPatientById(patientId);
				
				if(patient != null)
				{
					isValidPatient = true;
				}
				
				} catch (Exception e) {
					patientId = 0L;
				}
			
			if(patientId !=  0L && isValidPatient)
			{
				List<BasicMedicalQuestion> medicalQuestions =  medicalQuestionRepository.findByPatientId(patientId);
				
				MedicalQuestionPojo medicalQuestionPojo = new MedicalQuestionPojo();
				
				medicalQuestionPojo.setPatientId(patientId);
				if(medicalQuestions != null && medicalQuestions.size() > 0)
				{
					medicalQuestionPojo.setBasicMedicalQuestions(medicalQuestions);
				}
				
				return medicalQuestionPojo;
			}
		}
		
		return null;
	}

	@Override
	public MedicalQuestionPojo getQuestionListUI(String patientIdStr, Map<String, Object> requestMap) {
		
		Long patientId;
		
		boolean isValidPatient = false;
		
		if(patientIdStr != null)
		{
			try {
				patientId	= Long.parseLong(patientIdStr);
			
				Patient patient = patientService.getPatientById(patientId);
			
				if(patient != null)
				{
					isValidPatient = true;
				}
			
			} catch (Exception e) {
				patientId = 0L;
			}
			
			if(patientId !=  0L && isValidPatient)
			{
				if(requestMap.containsKey("basicMedicalQuestions"))
				{
					
					
					if(requestMap.get("basicMedicalQuestions") != null)
					{
						List<Map<String,String>> medicalQuestionsFromUI = (List<Map<String,String>>) requestMap.get("basicMedicalQuestions");
						List<BasicMedicalQuestion> medicalQuestions = convertBasicMedicalQuestion(medicalQuestionsFromUI,patientId);
						
						if(medicalQuestions != null && medicalQuestions.size() > 0)
						{
							MedicalQuestionPojo medicalQuestionPojo = new MedicalQuestionPojo();
							
							medicalQuestionPojo.setPatientId(patientId);
							medicalQuestionPojo.setBasicMedicalQuestions(medicalQuestions);;
							
							return medicalQuestionPojo;
						}
					}
				}
				
			}
		}
		
		return null;
	}

	private List<BasicMedicalQuestion> convertBasicMedicalQuestion(List<Map<String, String>> medicalQuestionsFromUI,Long patientId) {
		
		List<BasicMedicalQuestion> medicalQuestions = new ArrayList<>();
		
		if(medicalQuestionsFromUI != null && medicalQuestionsFromUI.size() > 0)
		{
			for(Map<String, String> questions : medicalQuestionsFromUI )
			{
				if(questions.containsKey("question") && questions.containsKey("questionSetCd") && questions.containsKey("responseValue") && questions.containsKey("detailDescription"))
				{
					if(questions.get("question") != null && questions.get("questionSetCd") != null  && questions.get("detailDescription") != null )
					{
						BasicMedicalQuestion question =  convertBasicMedicalQuestionFromMap(questions);
						
						question.setPatientId(patientId);
						
						question = medicalQuestionRepository.save(question);
						
						if(question != null)
						{
							medicalQuestions.add(question);
						}
					}
						
				}
			}
		}
		
		return medicalQuestions;
		
	}

	private BasicMedicalQuestion convertBasicMedicalQuestionFromMap(Map<String, String> questions) {
		
		BasicMedicalQuestion question = new BasicMedicalQuestion();
		question.setQuestion(questions.get("question"));
		question.setQuestionSetCd(questions.get("questionSetCd"));
		question.setResponseValue(questions.get("responseValue") != null ? questions.get("responseValue") : null );
		question.setDetailDescription(questions.get("detailDescription"));
		
		return question;
		
		
	}

	
}
