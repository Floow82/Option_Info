package TD03.dequejava.monpack;

public class MaClasse {
    private String laChaine;

    public MaClasse(final String ch) {
        laChaine = ch;
    }

    public String getLaChaine(){
        return laChaine;
    }

    public void setLaChaine(final String ch) {
        laChaine = ch;
    }
    @Override
    public boolean equals(Object obj) {
        return ((MaClasse) obj).laChaine.compareTo(laChaine)==0;
    }


}
