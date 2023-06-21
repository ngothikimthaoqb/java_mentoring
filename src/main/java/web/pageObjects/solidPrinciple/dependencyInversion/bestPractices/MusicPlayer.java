package web.pageObjects.solidPrinciple.dependencyInversion.bestPractices;

public class MusicPlayer {

    private PlayerFile file;

    // depend on interface
    public MusicPlayer(PlayerFile file)
    {
        this.file =  file;
    }

    public void play()
    {
        file.play();
    }
}
