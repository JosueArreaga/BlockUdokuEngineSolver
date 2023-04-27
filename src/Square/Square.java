package Square;

public class Square implements Cloneable{
    boolean isOccupied;
    public Square(){isOccupied = false;}
    public void Occupy(){ isOccupied = true;}
    public void Empty() { isOccupied = false;}
    public boolean isEmpty(){return  isOccupied;}

    public Square clone(){
        try {
            return (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported: ", e);
        }
    }

    @Override
    public String toString() {
        if(isOccupied)
            return "\uD83D\uDFE6";
        return  "⬜";
    }
}
