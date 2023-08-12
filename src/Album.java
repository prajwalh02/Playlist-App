import java.util.*;

public class Album {

    private String artist;

    private String name;

    private List<Song> songs;

    public Album() {
    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    //functionalities in the album

    public boolean findSong(String name) {   //parameter is name of song
        for(Song song : songs) {
            if(song.getTitle().equals(name)) {  //if i do song.getTitle() == name, then it will compare the address and always return false
                return true;
            }
        }
        return false;      //song is not found
    }

    //add song
    public String addSongToAlbum(String title, double duration) {
        if(!findSong(title)) {
            //add
            Song song = new Song(title, duration);
            this.songs.add(song);
            return "Song has been added to the Album";
        }
        return "Song already exists";
    }

    //add to playlist from album
    public String addToPlayListFromAlbum(String title, LinkedList<Song> playList) {

        for(Song song : songs) {
            if(song.getTitle().equals(title)) {
                playList.add(song);
                return "Song has been added to your playlist";
            }
        }
        return "Song does not exists";
    }

    /**
     * polymorphism:  method overloading
     * @param songNo
     * @param playList
     * @return
     */
    public String addToPlayListFromAlbum(int songNo, LinkedList<Song> playList) {
        int index = songNo - 1;
        if(index >= 0 && index < songs.size()) {
            playList.add(songs.get(index));
            return "Song has been added to your playlist";
        }
        return "Incorrect song number !!";
    }

}