package com.cms.usecases;

import java.util.List;

import com.cms.been.Batch;
import com.cms.dao.AdminDao;
import com.cms.dao.AdminDaoImpl;
import com.cms.exception.AdminException;

public class ViewBatch {
	
	public void batchView() {
		
		System.out.println();
		AdminDao dao = new AdminDaoImpl();
		try {
			List<Batch> batch = dao.viewBatch();
			batch.forEach(b -> System.out.println(b));
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		
	}

}