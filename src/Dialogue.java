

public class Dialogue {


    String dialogue;
    boolean hasOptions;


    public Dialogue(String dialogue, boolean hasOptions){
        this.dialogue = dialogue;
        this.hasOptions = hasOptions;

    }

    public String getDialogue() {
        return dialogue;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    public boolean isHasOptions() {
        return hasOptions;
    }

    public void setHasOptions(boolean hasOptions) {
        this.hasOptions = hasOptions;
    }
}


