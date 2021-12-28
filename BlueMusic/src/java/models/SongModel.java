/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import domain.Songs;
import domain.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.IOUtils;

/**
 *
 * @author HP
 */
@ManagedBean(name="songM")
public class SongModel {
     private UploadedFile file;
      private String url = "http://192.168.43.14:8081/BlueMusic/webresources/songs/";
    private Songs song = new Songs();
    
    
     public String create(){
         try{
         String pcname = upload();
        if (pcname == null && pcname == "") {
            pcname = "";
        }
        song.setAudio(pcname);
     ClientBuilder.newClient().target(url).request().post(Entity.json(song));
     return "songList.xhtml";
         }catch(Exception ex){
           ex.printStackTrace();
           return "upload.xhtml";
         }
    }
      public List<Songs> getAll(){
        GenericType<List<Songs>> list=new GenericType<List<Songs>>(){};
     List<Songs> users = ClientBuilder.newClient().target(url).request(MediaType.APPLICATION_JSON).get(list);
      
      if(!users.isEmpty()){
          System.out.println("result");
      }
      return  users;
    }
     
     public String upload() {
        String pcname = "";
        if (file != null) {

            try {
                FacesContext context = FacesContext.getCurrentInstance();
//                ServletContext scontext = (ServletContext) context.getExternalContext().getContext();

                String rootpath = "C:\\Users\\HP\\Documents\\NetBeansProjects\\BlueMusic\\web\\songs\\";
                File saveFileHere = new File(rootpath + file.getFileName());
                InputStream inputStream = file.getInputStream();

                pcname = file.getFileName();

                SaveImage(inputStream, saveFileHere);
            } catch (IOException e) {
                  e.printStackTrace();
            }

        }
        return pcname;
    }
   public void SaveImage(InputStream inputStream, File ImageFile) throws IOException {
        OutputStream outputStream = new FileOutputStream(ImageFile);
        IOUtils.copy(inputStream, outputStream);
    }

    public Songs getSong() {
        return song;
    }

    public void setSong(Songs song) {
        this.song = song;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    
}
