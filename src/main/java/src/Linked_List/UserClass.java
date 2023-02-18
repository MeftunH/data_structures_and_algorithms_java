package src.Linked_List;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

public class UserClass {
    private String name;
    private Playlist playlist;

    public UserClass(String name) {
        this.name=name;
        this.playlist=new Playlist();
    }

    public void addSongToPlaylist(Song song) {
        playlist.addSong(song);
    }

    public void removeSongFromPlaylist(int index) {
        playlist.removeSong(index);
    }

    public int getTotalPlaylistDuration() {
        return playlist.getTotalDuration();
    }
}
