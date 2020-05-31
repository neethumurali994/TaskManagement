package com.task.TaskManagement.Services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.task.TaskManagement.Entity.Doc;
import com.task.TaskManagement.Repository.DocRepository;

@Service
public class DocServices {
    @Autowired
	DocRepository docrepo;
    
	public void saveFile(MultipartFile file)
	{
		String docname = file.getOriginalFilename();
		try {
			Doc document = new Doc(docname, file.getContentType(), file.getBytes());
			docrepo.save(document);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public Optional<Doc> getfile(long id)
	{
		return docrepo.findById(id);
	}
	
	public List<Doc> getallFiles()
	{
		return docrepo.findAll();
	}
	

}
