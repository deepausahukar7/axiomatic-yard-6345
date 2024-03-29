package com.cms.usecases;

import java.util.Scanner;

import com.cms.dao.AdminDao;
import com.cms.dao.AdminDaoImpl;
import com.cms.dao.FacultyDao;
import com.cms.dao.FacultyDaoImpl;
import com.cms.exception.AdminException;
import com.cms.exception.FacultyException;

public class Main {
	
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		
		
		System.out.println("Type 1 to Start: ");
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		if (n==99) {System.out.println("Thanks for using Monitor!...");
		}
		while(n!=99) {
			
		System.out.println("=============> Welcome to MONITOR <=============");
		System.out.println("Type Admin for Admin and Faculty for Faculty...");
		System.out.print("Type Here: ");
		String s = sc.next();
		if(s.equals("Admin")) {
			System.out.println("Welcome to Admin Pannel !...");
			AdminLogin admin = new AdminLogin();
			String check = admin.loginAdmin();
			System.out.println(check);
			if(check.equals("Sign in Succesfull !..")) {
				
				System.out.println("Type 99 to exit ");
				System.out.println("Type 1 for Course ");
				System.out.println("Type 2 for Batch");
				System.out.println("Type 3 for Faculty");
				System.out.println("Type 4 for Course Plan");
				System.out.println("Type 5 for Allocated Teacher");
				System.out.println("Type 6 for Generate Batch Reoprt");
				int type = sc.nextInt();
				if(type==1) {
					System.out.println("Press 99 to exit ");
					System.out.println("Press 1 for Create new Course");
					System.out.println("Press 2 for Update Course");
					System.out.println("Press 3 for View Course");
					
					
					int press = sc.nextInt();
					if(press==1) {
						CreateCourse cc = new CreateCourse();
						String courseCreated = cc.courseCreate();
						System.out.println(courseCreated);
					}else if(press == 2) {
						UpdateCourse uc = new UpdateCourse();
						String courseUpdated = uc.courseUpadate();
						System.out.println(courseUpdated);
					}else if(press == 3) {
						ViewCourse vc = new ViewCourse();
						vc.courseView();
					}else if(press == 99) {
						System.out.println("Thanks for using Monitor!...");
						n = 99;
						break;
					}else {
						System.out.println("Please enter a valid keyword...");
					}
				}else if(type == 2) {
					
					System.out.print("Press 99 to exit Press");
					System.out.println("Press 1 for Create new Batch");
					System.out.println("Press 2 for Update Batch");
					System.out.println("Press 3 for View Batch");
					
					
					int press = sc.nextInt();
					if(press==1) {
						CreateBatch cb = new CreateBatch();
						String batchCreated = cb.batchCreate();
						System.out.println(batchCreated);
					}else if(press == 2) {
						UpdateBatch ub = new UpdateBatch();
						String res = ub.batchUpdate();
						System.out.println(res);
					}else if(press == 3) {
						ViewBatch vb = new ViewBatch();
						vb.batchView();
					}else if(press == 99) {
						System.out.println("Thanks for using Monitor!...");
						n = 99;
						break;
					}else {
						System.out.println("Please enter a valid keyword...");
					}
				}else if(type == 3) {
					System.out.print("Press 99 to exit Press");
					System.out.println("Press 1 for Create new Faculty");
					System.out.println("Press 2 for Update Faculty");
					System.out.println("Press 3 for View Faculty");
					
					
					int press = sc.nextInt();
					if(press==1) {
						CreateFaculty cf = new CreateFaculty();
						String facultyCreated = cf.facultyCreate();
						System.out.println(facultyCreated);
					}else if(press == 2) {
						UpdateFaculty uf = new UpdateFaculty();
						String res = uf.facultyUpdate();
						System.out.println(res);
					}else if(press == 3) {
						ViewFaculty vf = new ViewFaculty();
						vf.facultyView();
					}else if(press == 99) {
						System.out.println("Thanks for using Monitor!...");
						n = 99;
						break;
					}else {
						System.out.println("Please enter a valid keyword...");
					}
				}else if(type == 4) {
					System.out.print("Press 99 to exit");
					System.out.println("Press 1 for Create new Course Plan");
					System.out.println("Press 2 for Update Course Plan");
					System.out.println("Press 3 for View Course Plan");
					
					
					int press = sc.nextInt();
					if(press==1) {
						CreatePlan cp = new CreatePlan();
						String planCreated = cp.planCreate();
						System.out.println(planCreated);
					}else if(press == 2) {
						UpdatePlan up = new UpdatePlan();
						String planUpdated = up.planUpdate();
						System.out.println(planUpdated);
					}else if(press == 3) {
						ViewPlan vp = new ViewPlan();
						vp.planView();
					}else if(press == 99) {
						System.out.println("Thanks for using Monitor!...");
						n = 99;
						break;
					}else {
						System.out.println("Please enter a valid keyword...");
					}
				}else if(type==5) {
					AdminDao dao = new AdminDaoImpl();
					try {
						dao.allocateFaculty();
					} catch (AdminException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}else if(type==6) {
					AdminDao dao = new AdminDaoImpl();
					try {
						dao.reportBatch();
					} catch (AdminException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}else if(type==99) {
					System.out.println("Thanks for using Monitor!...");
					n = 99;
					break;
				}else {
					System.out.println("Please enter a valid keyword...");
				}
			}
			System.out.println("Thank you for using MONITOR!..");
			}else if(s.equals("Faculty")) {
				System.out.println("Welcome to Faculty Pannel !...");
				LoginFaculty lf = new LoginFaculty();
				boolean res = lf.facultyLogin();
				if(res) {
					System.out.println("Press 99 to exit");
					
					System.out.println("Press 1 for View Course Plan");
					System.out.println("Press 2 for Update password");
					
					
					int press = sc.nextInt();
					if(press == 1) {
						ViewPlan vp = new ViewPlan();
						vp.planView();
					}else if(press == 2) {
						FacultyDao dao = new FacultyDaoImpl();
						try {
						
							
							UpdatePassword.main(null);
						
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}else if(press == 99) {
						System.out.println("Thanks for using Monitor!...");
						n = 99;
						break;
					}else {
						System.out.println("Please Enter a Valid keyword !.......");
					}
				}
			}else {
				System.out.println("Please Enter a Valid keyword !.......");
				run();
			}
		}
	}

}
