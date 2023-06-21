package web.pageObjects.solidPrinciple.dependencyInversion.bestPractices;

public class FLACFile implements PlayerFile
{
    @Override
    public void play() {
        System.out.println("Play FLACFile file!");
    }
}
