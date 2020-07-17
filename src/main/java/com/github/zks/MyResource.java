package com.github.zks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.poi.EncryptedDocumentException;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/")
public class MyResource {

	@SuppressWarnings("static-access")
	@Path("/hello")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() throws EncryptedDocumentException, IOException {
		//new ReadExcel().read("Sample.xlsx");
		String path = new File(".").getAbsoluteFile().getParent();
		System.out.println(path);

		return "Hello, World!!";
	}

	@POST
	@Path("checklist/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response register(@PathParam("id") String id, @QueryParam(value = "token") String token,
			List<Object> inputJsonObj) {
		System.out.println("id: " + id);
		System.out.println(inputJsonObj.size());

		System.out.println("aaa");
		return Response.status(200).entity("success").header("Access-Control-Allow-Origin", "*").build();
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/multipleFiles")
	public String upload(@FormDataParam("file") List<FormDataBodyPart> bodyParts) throws IOException {

        if(bodyParts.get(0).getFormDataContentDisposition().getFileName().equals("")){
            return "失敗";
        }else{
            for (FormDataBodyPart part : bodyParts) {
                String dataName = part.getFormDataContentDisposition().getFileName();

                File tempFile = part.getValueAs(File.class);
                
                this.fileRename(tempFile.getParent(),tempFile.getName(),dataName);
                tempFile.mkdir();
                moveTempFile(tempFile,dataName);

               
                //this.removeDirectory(tempFile);
            }
        }
		

		System.out.println("test");
		return "finish!!";
	}

	public static void read(File targetFile, StringBuilder sb) {
		try {
			FileReader filereader = new FileReader(targetFile);
			int ch;
			while ((ch = filereader.read()) != -1) {
				sb.append((char) ch);
			}
			filereader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	 public void fileRename(String parent,String oldFileName,String newFileName){
	        File fOld = new File(Paths.get(parent,oldFileName).toString());
	        File fNew = new File(Paths.get(parent,newFileName).toString());
	        this.fileRename(fOld,fNew);
	    }

	
	public void fileRename(File fOld,File fNew){
        fOld.renameTo(fNew);
    }
	
	public void moveTempFile(File tempFile,String dataName){
        File sourceDataFile = new File(tempFile.getParent() + "/" + dataName);
        File targetDataFile = new File(tempFile.getPath() + "/" + dataName);
        sourceDataFile.renameTo(targetDataFile);
    }
	
	public static void removeDirectory(File file){
        File[] fileArray = file.listFiles();
        for(int i=0; i<fileArray.length; i++){
            if(!fileArray[i].delete()){
                removeDirectory(fileArray[i]);
            }
        }
        file.delete();
    }

}

