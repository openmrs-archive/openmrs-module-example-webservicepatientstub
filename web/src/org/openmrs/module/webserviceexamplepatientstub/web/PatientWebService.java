/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.webserviceexamplepatientstub.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.WebServiceContext;

import org.openmrs.Patient;
import org.openmrs.PatientIdentifierType;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.jaxws.JaxwsSupport;

/**
 * This can be accessed via /openmrs/ms/examplestubs/patientservice because we mapped it to
 * /ms/examplestubs/patientservice in the /moduleApplicationContext.xml file. <br/>
 * <br/>
 * (/ms/examplestubs is mapped as the JaxWS servlet by this module.
 */
@WebService
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public class PatientWebService {
	
	@Resource
	WebServiceContext webServiceContext;
	
	/**
	 * Get a list of PatientStubs that match the given name/identifier/identifiertype
	 * 
	 * @see org.openmrs.api.impl.PatientServiceImpl#getPatients(java.lang.String, java.lang.String,
	 *      java.util.List, boolean)
	 */
	public PatientStub[] getPatients(String name, String identifier, Integer[] identifierTypeIds,
	                                 boolean matchIdentifierExactly) {
		JaxwsSupport.authenticate(webServiceContext);
		
		List<PatientIdentifierType> identifierTypes = new ArrayList<PatientIdentifierType>();
		for (Integer typeId : identifierTypeIds) {
			identifierTypes.add(new PatientIdentifierType(typeId));
		}
		
		// TODO change this return type to PatientStub??
		List<Patient> patientsFound = Context.getPatientService().getPatients(name, identifier, identifierTypes,
		    matchIdentifierExactly);
		
		PatientStub[] stubsFound = new PatientStub[patientsFound.size()];
		int x = 0;
		for (Patient patient : patientsFound) {
			stubsFound[x++] = getPatientStub(patient);
		}
		return stubsFound;
	}
	
	/**
	 * Convenience method to turn a full Patient object into a PatientStub object.
	 * 
	 * @param patient the patient to convert
	 * @return the simpler PatientStub object
	 */
	private static PatientStub getPatientStub(Patient patient) {
		PatientStub stub = new PatientStub();
		stub.setPatientId(patient.getPatientId());
		stub.setPersonId(patient.getPersonId());
		stub.setGivenName(patient.getGivenName());
		stub.setMiddleName(patient.getMiddleName());
		stub.setFamilyName(patient.getFamilyName());
		stub.setIdentfier(patient.getPatientIdentifier().getIdentifier());
		stub.setIdentifierTypeId(patient.getPatientIdentifier().getIdentifierType().getPatientIdentifierTypeId().toString());
		
		return stub;
	}
	
}
