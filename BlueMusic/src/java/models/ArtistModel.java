/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import domain.Artist;
import static java.util.Collections.list;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author HP
 */
@ManagedBean(name="ArtM")
public class ArtistModel {
    private String url = "http://192.168.43.14:8081/BlueMusic/webresources/artist";
    public ArtistModel() {
    }
    
    private Artist artist=new Artist();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
public List<Artist> getAll(){
    GenericType<List<Artist>> List=new GenericType<List<Artist>>(){};
    List <Artist> artists = ClientBuilder.newClient().target(url).request(MediaType.APPLICATION_JSON).get(List);
     if(!artists.isEmpty()){
          System.out.println("result");
      }
      return artists;
}
 public String create(){
     ClientBuilder.newClient().target(url).request().post(Entity.json(artist));
     return "artist.xhtml";
    }
  public String update(){
     ClientBuilder.newClient().target(url).request().put(Entity.json(artist));
     return "artist.xhtml";
    }
      public String delete(){
     ClientBuilder.newClient().target(url).request().delete(Artist.class);
     return "artist.xhtml";
    }
}