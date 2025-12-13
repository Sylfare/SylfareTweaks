package re.sylfa.sylfaretweaks.tweaks;

public interface Tweak {
    default void onLoad(){
        this.enable();
    }
    void enable();
    void disable();
}
