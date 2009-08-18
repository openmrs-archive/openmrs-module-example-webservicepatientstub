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

/**
 * This represents an object smaller than the org.openmrs.Patient object so that this can be
 * transferred over webservices xml
 */
public class PatientStub {
	
	private Integer patientId;
	
	private Integer personId;
	
	private String givenName;
	
	private String middleName;
	
	private String familyName;
	
	private String identfier;
	
	private String identifierTypeId;
	
	public PatientStub() {
		
	}
	
	/**
	 * @return the patientId
	 */
	public Integer getPatientId() {
		return patientId;
	}
	
	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
	/**
	 * @return the personId
	 */
	public Integer getPersonId() {
		return personId;
	}
	
	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	
	/**
	 * @return the givenName
	 */
	public String getGivenName() {
		return givenName;
	}
	
	/**
	 * @param givenName the givenName to set
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	/**
	 * @return the familyName
	 */
	public String getFamilyName() {
		return familyName;
	}
	
	/**
	 * @param familyName the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	/**
	 * @return the identfier
	 */
	public String getIdentfier() {
		return identfier;
	}
	
	/**
	 * @param identfier the identfier to set
	 */
	public void setIdentfier(String identfier) {
		this.identfier = identfier;
	}
	
	/**
	 * @return the identifierTypeId
	 */
	public String getIdentifierTypeId() {
		return identifierTypeId;
	}
	
	/**
	 * @param identifierTypeId the identifierTypeId to set
	 */
	public void setIdentifierTypeId(String identifierTypeId) {
		this.identifierTypeId = identifierTypeId;
	}
	
}
