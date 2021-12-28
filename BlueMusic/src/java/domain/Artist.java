/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "artists")
public class Artist {
   @Id
   @GeneratedValue(strategy= GenerationType.SEQUENCE)
   private int id;
   private String artistname;
   @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(name="artist_id")
   private List<songs> songs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtistname() {
        return artistname;
    }

    public void setArtistname(String artistname) {
        this.artistname = artistname;
    }

    public List<songs> getSongs() {
        return songs;
    }

    public void setSongs(List<songs> songs) {
        this.songs = songs;
    }
   
   public boolean getEmail(){
       throw new UnsupportedOperationException("Not supported yet.");
   }

    private static class songs {

        public songs() {
        }
    }
}
