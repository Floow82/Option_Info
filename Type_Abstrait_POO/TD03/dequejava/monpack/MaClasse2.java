package TD03.dequejava.monpack;

public class MaClasse2 {
    private Integer val;
    public MaClasse2 (final int v){
        val = v;
    }
    public MaClasse2 (){}
    public boolean equals(Object Obj){
        return ((MaClasse2)Obj).val == val;
    }
}

