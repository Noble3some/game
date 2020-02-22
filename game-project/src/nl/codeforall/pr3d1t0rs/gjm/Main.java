package nl.codeforall.pr3d1t0rs.gjm;

import nl.codeforall.pr3d1t0rs.gjm.ships.MusicPlayer;

public class Main {
    public static void main(String[] args) throws Exception {

        Thread thread = new Thread(){
            public void run(){
                MusicPlayer AudioPlayer = new MusicPlayer();
                try {
                    AudioPlayer.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        Game game = new Game();
        game.init();


    }
}
