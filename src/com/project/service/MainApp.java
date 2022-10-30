package com.project.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.project.dao.ClassesDao;
import com.project.dao.StudentsDao;
import com.project.dao.SubjectsDao;
import com.project.dao.TeachersDao;
import com.project.login.loginValidation;

public class MainApp {
	public static void main(String[] args) throws InputMismatchException {

		StudentsDao stud_dao = new StudentsDao();
		TeachersDao teach_dao = new TeachersDao();
		ClassesDao class_dao = new ClassesDao();
		SubjectsDao sub_dao = new SubjectsDao();
		Scanner sc = new Scanner(System.in);

		Boolean status = false;

		System.out.println("Welcome to Learner's Academy");
		System.out.println("----------------------------");
		if (loginValidation.login()) {
			System.out.println("Welcome Admin");
			System.out.println("---------------");
			status = true;
		}

		if (status) {

			boolean flag = true;
			while (flag == true) {
				System.out.println("1. View Students");
				System.out.println("2. View Teachers");
				System.out.println("3. View Subjects");
				System.out.println("4. View Classes");
				System.out.println("5. View class wise report");// PENDING
				System.out.println("6. exit");
				System.out.println();

				System.out.println("Enter your option below: ");
				String option = sc.next();

				switch (option) {
				case "1":

					boolean flag1 = false;
					while (flag1 == false) {
						System.out.println("A.List of student details");
						System.out.println("B.Add students");
						System.out.println("C.Navigate to main menu");

						System.out.println("Enter your option: ");
						option = sc.next();
						switch (option) {
						case "A":
							System.out.println("below is the list of student details");
							stud_dao.displayStudents();

							break;
						case "B":

							System.out.println("Enter Student id: ");
							String id = sc.next();

							System.out.println("Enter first name: ");
							String fname = sc.next();
							System.out.println("Enter last name: ");
							String lname = sc.next();
							System.out.println("Enter student class number: ");
							String class_num = sc.next();
							if (stud_dao.studentIdValidation(id)) {
								System.out.println(id + " student id already exists! Please enter new id");
							} else if (class_dao.classValidation(class_num) != true) {
								System.out.println("Entered class number not found!");

							} else {
								stud_dao.insertStudents(id, fname, lname, class_num);

							}
							System.out.println();

							break;

						case "C":
							flag1 = true;
							break;
						}
					}
					break;

				case "2":
					boolean flag2 = false;
					while (flag2 == false) {
						System.out.println("A.List of Teacher details");
						System.out.println("B.Add Teacher");
						System.out.println("C.Navigate to main menu");

						System.out.println("Enter your option: ");
						option = sc.next();
						switch (option) {
						case "A":
							System.out.println("below is the list of teacher details");
							System.out.println();
							teach_dao.displayTeachers();

							break;
						case "B":

							System.out.println("Enter Teacher id: ");
							String id = sc.next();

							System.out.println("Enter first name: ");
							String fname = sc.next();
							System.out.println("Enter last name: ");
							String lname = sc.next();

							if (teach_dao.teacherIdValidation(id)) {
								System.out.println(id + " teeacher id already exists! Please enter new id");
							} else {
								teach_dao.insertTeachers(id, fname, lname);

							}
							System.out.println();

							break;

						case "C":
							flag2 = true;
							break;
						}
					}

					break;
				case "3":
					boolean flag4 = false;
					while (flag4 == false) {
						System.out.println("A. List of subject details");
						System.out.println("B. Add subjects");
						System.out.println("C. Asssign Class to subject");
						System.out.println("D. Asssign teacher to a class for a subject");
						System.out.println("E.Navigate to main menu");

						System.out.println("Enter your option: ");
						option = sc.next();
						switch (option) {
						case "A":
							System.out.println("below is the list of subject details");
							sub_dao.displaySubjects();

							break;
						case "B":

							System.out.println("Enter Subject id: ");
							String id = sc.next();

							System.out.println("Enter subject name: ");
							String name = sc.next();

							if (sub_dao.subjIdIdValidation(id)) {
								System.out.println(id + " subject already exists! Please enter new subject");
							} else {
								sub_dao.insertSubject(id, name);

							}
							System.out.println();

							break;

						case "C":
							System.out.println("Enter Subject id: ");
							String sub_id = sc.next();

							System.out.println("Enter class number: ");
							String class_number = sc.next();

							if (sub_dao.subjIdIdValidation(sub_id) && class_dao.classValidation(class_number)) {
								sub_dao.AssignClassToSubject(class_number, sub_id);
							} else {
								System.out.println("Enter valid subject id and class number");

							}
							System.out.println();
							break;

						case "D":
							System.out.println("Enter Subject id: ");
							String subj_id = sc.next();

							System.out.println("Enter teacher id: ");
							String teach_id = sc.next();

							if (sub_dao.subjIdIdValidation(subj_id) && teach_dao.teacherIdValidation(teach_id)) {
								sub_dao.AssignTeacherToSubject(teach_id, subj_id);
							} else {
								System.out.println("Enter valid subject id and class number");

							}
							System.out.println();
							break;

						case "E":
							flag4 = true;
							break;
						}
					}
					break;
				case "4":
					boolean flag3 = false;
					while (flag3 == false) {
						System.out.println("A.List of Classes");
						System.out.println("B.Add Class");
						System.out.println("C.Navigate to main menu");

						System.out.println("Enter your option: ");
						option = sc.next();
						switch (option) {
						case "A":
							System.out.println("below is the list of classes");
							System.out.println();
							class_dao.displayClasses();

							break;
						case "B":

							System.out.println("Enter class number: ");
							String num = sc.next();

							if (class_dao.classValidation(num)) {
								System.out.println(num + " class number already present!");
							} else {
								class_dao.insertClasses(num);

							}
							System.out.println();

							break;

						case "C":
							flag3 = true;
							break;
						}
					}

					break;
				case "5":boolean flag5 = false;
				while (flag5 == false) {
					System.out.println("A. List of Students");
					System.out.println("B. List of Subjects with Teachers");
					System.out.println("C. Navigate to main menu");
				

					System.out.println("Enter your option: ");
					option = sc.next();
					switch (option) {
					case "A":System.out.println("Enter the class number");
					String class_number=sc.next();
					if(class_dao.classValidation(class_number))
					{
						System.out.println("below is the list of students in the class "+class_number);
						stud_dao.displayStudentsByClassNum(class_number);
						System.out.println();
					}
					else
						System.out.println("Class not present!");
						break;
					case "B":

						System.out.println("Enter the class number");
						String class_number1=sc.next();
						if(class_dao.classValidation(class_number1))
						{
							System.out.println("below is the list of subjects in the class "+class_number1 +" with the assigned teachers ");
							sub_dao.displaySubjectsByClassNum(class_number1);
							System.out.println();
						}
						else
							System.out.println("Class not present!");
							
						break;

					case "C":
						flag5 = true;
						break;
					}
				}
					break;
				case "6":
					flag = false;
					System.out.println("Thank you!..logged off");
					break;
				default:
					System.out.println("Enter valid input");
				}

			}

		}
		sc.close();
	}

}
