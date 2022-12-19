/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.models;

import dev.kit2512.oop_sms.config.AppConstants;
import dev.kit2512.oop_sms.domain.entities.MajorEntity;
import dev.kit2512.oop_sms.domain.entities.StudentEntity;
import dev.kit2512.oop_sms.domain.entities.UserEntity;
import dev.kit2512.oop_sms.domain.repositories.MajorRepository.MajorException;
import dev.kit2512.oop_sms.domain.repositories.StudentRespository.StudentException;
import dev.kit2512.oop_sms.domain.usecases.AddStudentUseCase;
import dev.kit2512.oop_sms.domain.usecases.GetMajorListUseCase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author macpro13
 */
@Singleton
public class AddStudentModel extends AbstractModel {

    public static final String YEAR_OF_ADMISSION = "YearOfAdmission";

    public static final String AVAILABLE_YEARS_OF_ADMISSION = "AvailableYearsOfAdmission";

    private final AddStudentUseCase addStudentUseCase;

    private final GetMajorListUseCase getMajorListUseCase;

    public static final String GETTING_MAJORS_PROPERTY = "GettingMajors";
    
    public static final String ADDING_NEW_STUDENT = "AddingNewStudent";

    public static final String AUTO_GENERATE_ID_PASSWORD_PROPERTY = "AutoCreateIDAndPassword";

    public static final String AVAILABLE_MAJORS_PROPERTY = "AvailableMajors";

    public static final String SELECTED_MAJOR_PROPERTY = "SelectedMajor";

    public static final String SELECTED_YEAR_PROPERTY = "SelectedYear";

    public static final String FIRST_NAME_PROPERTY = "FirstName";

    public static final String LAST_NAME_PROPERTY = "LastName";

    public static final String MIDDLE_NAME_PROPERTY = "MiddleName";

    public static final String DATE_OF_BIRTH_PROPERTY = "DateOfBirth";

    public static final String ADDRESS_PROPERTY = "Address";

    public static final String CLASS_LETTER_PROPERTY = "ClassLetter";

    public static final String ERROR_MESSAGE_PROPERTY = "ErrorMessage";
    
    public static final String EMAIL_PROPERTY = "Email";
    
    public static final String PHONE_PROPERTY = "Phone";
    
    public static final String GENDER_PROPERTY = "Gender";
    
    public static final String USERNAME_PROPERTY = "Username";
    
    public static final String PASSWORD_PROPERTY = "Password";

    public static final String SHOULD_RESET = "ShouldReset";
    
    public static final String SHOULD_CLOSE_PROPERTY = "ShouldClose";

    private Integer availableYearsOfAdmission;
    
    private Boolean shouldClose = false;

    private Boolean shouldReset = false;
   
    private String email = null;
    
    private String phone = null;
    
    private Boolean gender = false;

    private Boolean gettingMajors = false;
    
    private Boolean addingNewStudent = false;
    
    private Boolean autoCreateIDAndPassword = false;

    private List<MajorEntity> availableMajors;

    private MajorEntity selectedMajor = null;

    private Integer yearOfAdmission;

    private String firstName;

    private String lastName;

    private String middleName;

    private Date dateOfBirth;

    private String address;

    private String classLetter;

    private String errorMessage = null;
    

    private String username;
    
    private String password;


    @Inject
    public AddStudentModel(AddStudentUseCase getStudentUseCase, GetMajorListUseCase getMajorListUseCase) {
        this.addStudentUseCase = getStudentUseCase;
        this.getMajorListUseCase = getMajorListUseCase;
    }

    public Boolean getAutoCreateIDAndPassword() {
        return autoCreateIDAndPassword;
    }

    public void setAutoCreateIDAndPassword(Boolean autoCreateIDAndPassword) {
        final var oldValue = this.autoCreateIDAndPassword;
        this.autoCreateIDAndPassword = autoCreateIDAndPassword;
        super.firePropertyChange(AUTO_GENERATE_ID_PASSWORD_PROPERTY, oldValue, autoCreateIDAndPassword);
    }

    public List<MajorEntity> getAvailableMajors() throws MajorException {
        return this.availableMajors;
    }

    public void setAvailableMajors(List<MajorEntity> availableMajors) {
        final var oldVaule = this.availableMajors;
        this.availableMajors = availableMajors;
        super.firePropertyChange(AVAILABLE_MAJORS_PROPERTY, oldVaule, availableMajors);
    }

    public MajorEntity getSelectedMajor() {
        return selectedMajor;
    }

    public void setSelectedMajor(MajorEntity selectedMajor) {
        final var oldValue = this.selectedMajor;
        this.selectedMajor = selectedMajor;
        super.firePropertyChange(SELECTED_MAJOR_PROPERTY, oldValue, selectedMajor);
        this.setAvailableYearsOfAdmission(this.selectedMajor.getYearOfEstablishment());
    }

    public Integer getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(Integer seletedYear) {
        final var oldValue = this.yearOfAdmission;
        this.yearOfAdmission = seletedYear;
        super.firePropertyChange(SELECTED_YEAR_PROPERTY, oldValue, seletedYear);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        final var oldValue = this.firstName;
        this.firstName = firstName;
        super.firePropertyChange(FIRST_NAME_PROPERTY, oldValue, firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        final var oldValue = this.firstName;
        this.lastName = lastName;
        super.firePropertyChange(LAST_NAME_PROPERTY, oldValue, lastName);
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        final var oldValue = this.middleName;
        this.middleName = middleName;
        super.firePropertyChange(MIDDLE_NAME_PROPERTY, oldValue, middleName);
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        final var oldValue = this.dateOfBirth;
        this.dateOfBirth = dateOfBirth;
        super.firePropertyChange(DATE_OF_BIRTH_PROPERTY, oldValue, dateOfBirth);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        final var oldValue = this.address;
        this.address = address;
        super.firePropertyChange(DATE_OF_BIRTH_PROPERTY, oldValue, address);
    }

    public String getClassLetter() {
        return classLetter;
    }

    public void setClassLetter(String classLetter) {
        final var oldValue = this.classLetter;
        this.classLetter = classLetter;
        super.firePropertyChange(ADDRESS_PROPERTY, oldValue, classLetter);
    }

    public void setErrorMessage(String errorMessage) {
        final var oldValue = this.errorMessage;
        this.errorMessage = errorMessage;
        super.firePropertyChange(ERROR_MESSAGE_PROPERTY, oldValue, errorMessage);
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        final var oldValue = this.email;
        this.email = email;
        super.firePropertyChange(EMAIL_PROPERTY, oldValue, email);
    }
    

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        final var oldValue = this.phone;
        this.phone = phone;
        super.firePropertyChange(PHONE_PROPERTY, oldValue, phone);
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        final var oldValue = this.gender;
        this.gender = gender;
        super.firePropertyChange(GENDER_PROPERTY, oldValue, gender);
    }
    
    public Boolean getAddingNewStudent() {
        return addingNewStudent;
    }

    public void setAddingNewStudent(Boolean addingNewStudent) {
        final var oldValue = this.addingNewStudent;
        this.addingNewStudent = addingNewStudent;
        super.firePropertyChange(ADDING_NEW_STUDENT, oldValue, addingNewStudent);
        if (addingNewStudent) {
            final String error = this.validateInformation();
            if (error != null) {
                this.setErrorMessage(error);
                return;
            }
            try {
                final StudentEntity newStudent = new StudentEntity();
                newStudent.setUserFirstName(firstName);
                newStudent.setUserLastName(lastName);
                newStudent.setUserMiddleName(middleName);
                newStudent.setUserDateOfBirth(dateOfBirth);
                newStudent.setUserDateCreated(new Date());
                newStudent.setUserDateUpdated(new Date());
                newStudent.setUserAddress(address);
                newStudent.setUserGender(gender);
                newStudent.setUserPhone(phone);
                newStudent.setUserRole(UserEntity.UserRole.STUDENT);
                newStudent.setResults(new ArrayList<>());
                newStudent.setUserEmail(email);
                newStudent.setYearOfAdmission(yearOfAdmission);
                newStudent.setClassLetter(classLetter);
                newStudent.setMajor(selectedMajor);
                final StudentEntity createdStudent = addStudentUseCase.execute(newStudent);

                this.addingNewStudent = !this.addingNewStudent;
                super.firePropertyChange(ADDING_NEW_STUDENT, !this.addingNewStudent, this.addingNewStudent);
                super.firePropertyChange(SHOULD_RESET, false, true);
                System.out.println("Success!!");
            } catch (StudentException ex) {
                setErrorMessage(ex.getLocalizedMessage());
            }
        }
    }

    public Boolean getGettingMajors() {
        return gettingMajors;
    }

    public void setGettingMajors(Boolean gettingMajors) {
        this.gettingMajors = gettingMajors;
        super.firePropertyChange(GETTING_MAJORS_PROPERTY, false, true);
        try {
            this.setAvailableMajors(getMajorListUseCase.execute());
        } catch (MajorException ex) {
            this.setErrorMessage(ex.getLocalizedMessage());
        }
        super.firePropertyChange(GETTING_MAJORS_PROPERTY, true, false);
    }
    
    public void setUsername(String newValue) {
        final var oldValue = this.username;
        this.username = newValue;
        super.firePropertyChange(USERNAME_PROPERTY, oldValue, newValue);
    }
    
    public void setPassword(String newValue) {
        final var oldValue = this.password;
        this.password = newValue;
        super.firePropertyChange(PASSWORD_PROPERTY , oldValue, newValue);
    }
    
    private String validateInformation() {
        if (autoCreateIDAndPassword) {
            if (!username.matches(AppConstants.StringPattern.usernamePattern)) {
                return "Invalid username";
            }
            
            if (password == null || password.length() <= 8) {
                return "Passowrd must be at least 8 characters";
            }
        }
        
        if (this.dateOfBirth == null || this.dateOfBirth.after(new Date())) {
            return "Invalid date of birth";
        }
        
//        if (!this.firstName.matches("[a-zA-Z]{3,30}") || !this.middleName.matches("[a-zA-Z]{3,30}") || !this.lastName.matches("[a-zA-Z]{3,30}")) {
//            return "First name, last name or middle name is invalid";
//        }
        
        if (this.selectedMajor == null) {
            return "Missing major";
        }
        
        if (this.yearOfAdmission == null) {
            return "Missing year of admission";
        }
        
        if (this.address == null || this.address.isEmpty()) {
            return "Address must be provided";
        }
        
        if (this.phone == null || this.phone.isBlank()) {
            return "Phone must be provided";
        }
        
//        if (!this.phone.matches(AppConstants.StringPattern.phoneNumberPattern)) {
//            return "Invalid phone number";
//        }
//
        
        if (this.email == null || this.email.isBlank()) {
            return "Email must be provided";
        }
        
//        if (!this.email.matches(AppConstants.StringPattern.emailPattern)) {
//            return "Invalid Email";
//        }
        return null;
    }

    public void setAvailableYearsOfAdmission(Integer newValue) {
        final var oldValue = this.availableYearsOfAdmission;
        this.availableYearsOfAdmission = newValue;
        super.firePropertyChange(AVAILABLE_YEARS_OF_ADMISSION, oldValue, newValue);
    }
}
