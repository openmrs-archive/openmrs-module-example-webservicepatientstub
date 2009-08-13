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

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.WebServiceContext;

import org.openmrs.Patient;
import org.openmrs.PatientIdentifierType;
import org.openmrs.api.APIException;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.WebServiceSupport;

/**
 * This can be accessed via /openmrs/ms/jaxws/patientservice because we mapped it to
 * /ms/jaxws/patient in the /moduleApplicationContext.xml file. <br/>
 * <br/>
 * (/ms/jaxws is mapped as the JaxWS servlet by the webservice.jaxws module. This module is set as a
 * "required module" by this module.
 */
@WebService
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public class PatientWebService {
	
	@Resource
	WebServiceContext webServiceContext;
	
	/**
	 * TODO: This might not be able to be a full Patient object but instead a PatientStub object
	 * might need to be created
	 * 
	 * @see org.openmrs.api.impl.PatientServiceImpl#getPatients(java.lang.String, java.lang.String,
	 *      java.util.List, boolean)
	 */
	public Patient[] getPatients(String name, String identifier, PatientIdentifierType[] identifierTypes,
	                             boolean matchIdentifierExactly) throws APIException {
		WebServiceSupport.authenticate(webServiceContext);
		
		// TODO change this return type to PatientStub??
		List<Patient> patientsFound = Context.getPatientService().getPatients(name, identifier,
		    Arrays.asList(identifierTypes), matchIdentifierExactly);
		return patientsFound.toArray(new Patient[] {});
	}
	
}
