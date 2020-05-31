package com.task.TaskManagement.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.task.TaskManagement.Entity.Doc;
import com.task.TaskManagement.Services.DocServices;

@Controller
public class DocController {
	
	@Autowired
	DocServices docserv;
	
	@PostMapping("/uploaddoc")
	public String addDocs(@RequestParam("files") MultipartFile[] files)
	{
		for(MultipartFile file:files)
		{
			docserv.saveFile(file);
		}
		return "redirect:/";
	}
	
	@GetMapping("/getalldoc")
	public String getAllDoc(Model model)
	{ 	 	
		List<Doc> docs = docserv.getallFiles();
		model.addAttribute("files", docs);
		return "docShow";
	}
	
	@GetMapping("/download/{id}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long id)
	{
		Doc document = docserv.getfile(id).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(document.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\""+document.getDocName()+"\"")
                .body(new ByteArrayResource(document.getData()));		
	}

}
