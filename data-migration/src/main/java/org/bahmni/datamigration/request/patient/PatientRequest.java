package org.bahmni.datamigration.request.patient;

import java.util.ArrayList;
import java.util.List;
//
//attributeType: "cd7b242c-9790-11e2-99c1-005056b562c5"
//        name: "caste"
//        value: "bar"
//        1: {attributeType:ce85ffc2-9790-11e2-99c1-005056b562c5, name:class, value:OBC}
//        attributeType: "ce85ffc2-9790-11e2-99c1-005056b562c5"
//        name: "class"
//        value: "OBC"
//        2: {attributeType:cd7be7fe-9790-11e2-99c1-005056b562c5, name:education, value:Uneducated}
//        attributeType: "cd7be7fe-9790-11e2-99c1-005056b562c5"
//        name: "education"
//        value: "Uneducated"
//        3: {attributeType:cd7c99ba-9790-11e2-99c1-005056b562c5, name:occupation, value:Student}
//        attributeType: "cd7c99ba-9790-11e2-99c1-005056b562c5"
//        name: "occupation"
//        value: "Student"
//        4: {attributeType:cd7d5878-9790-11e2-99c1-005056b562c5, name:primaryContact, value:23432}
//        attributeType: "cd7d5878-9790-11e2-99c1-005056b562c5"
//        name: "primaryContact"
//        value: "23432"
//        5: {attributeType:cd7e34e6-9790-11e2-99c1-005056b562c5, name:secondaryContact, value:34324}
//        attributeType: "cd7e34e6-9790-11e2-99c1-005056b562c5"
//        name: "secondaryContact"
//        value: "34324"
//        6: {attributeType:cd7faff6-9790-11e2-99c1-005056b562c5, name:primaryRelative, value:sfgfdg}
//        attributeType: "cd7faff6-9790-11e2-99c1-005056b562c5"
//        name: "primaryRelative"
//        value: "sfgfdg"

public class PatientRequest {
    private List<Names> names = new ArrayList<Names>();
    private Integer age;
    private String birthdate;
    private String gender;
    private String patientIdentifier;
    private String centerID;
    private List<PatientAddress> patientAddress = new ArrayList<PatientAddress>();
    private List<PatientAttribute> attributes = new ArrayList<PatientAttribute>();
}