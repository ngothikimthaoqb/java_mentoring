package web.pageObjects.solidPrinciple.dependencyInversion.badPractices;

import web.pageObjects.solidPrinciple.dependencyInversion.bestPractices.MP3File;
import web.pageObjects.solidPrinciple.dependencyInversion.bestPractices.PlayerFile;

public class MusicPlayer {
    private PlayerFile file;

    // depend on interface
    public MusicPlayer()
    {
        this.file =  new MP3File();
    }

    public void play()
    {
        file.play();
    }
}
