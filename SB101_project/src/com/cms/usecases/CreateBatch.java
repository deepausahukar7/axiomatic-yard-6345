package com.cms.usecases;

import java.sql.Date;
import java.util.Scanner;

import com.cms.been.Batch;
import com.cms.dao.AdminDao;
import com.cms.dao.AdminDaoImpl;
import com.cms.exception.AdminException;

public class CreateBatch {
	
	public String batchCreate() {
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Course Id: ");
			int cid = sc.nextInt();
			System.out.println("Enter Batch Id: ");
			int bid = sc.nextInt();
			System.out.println("Enter Faculty Id: ");
			int fid = sc.nextInt();
			System.out.println("Enter No. of Students: ");
			int nos = sc.nextInt();
			System.out.println("Enter Course Start Date: ");
			Date date = Date.valueOf(sc.next());
			System.out.println("Enter Batch Duration: ");
			int duration = sc.nextInt();
			
			AdminDao dao = new AdminDaoImpl();
			Batch b = new Batch(bid, cid, fid, nos, date, duration);
			String res = null;
			try {
				res = dao.createBatch(b);
				System.out.println(res);
			} catch (AdminException e) {
				System.out.println(e.getMessage());
			}
			return res;
		
	}

}