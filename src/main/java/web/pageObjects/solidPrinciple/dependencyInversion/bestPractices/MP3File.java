package web.pageObjects.solidPrinciple.dependencyInversion.bestPractices;

public class MP3File  implements PlayerFile{

    @Override
    public void play() {
        System.out.println("Play MP3 file!");
    }
}
