package cleancode.studycafe.tobe.config;

import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.io.PassSelector;
import cleancode.studycafe.tobe.io.file.FileReader;
import cleancode.studycafe.tobe.model.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.StudyCafePass;

public class StudyCafeConfig {

    private final PassSelector passSelector;
    private final FileReader<StudyCafePass> passFileReader;
    private final FileReader<StudyCafeLockerPass> lockerPassFileReader;

    public StudyCafeConfig(
            PassSelector passSelector, FileReader<StudyCafePass> passFileReader,
            FileReader<StudyCafeLockerPass> lockerPassFileReader) {
        this.passSelector = passSelector;
        this.passFileReader = passFileReader;
        this.lockerPassFileReader = lockerPassFileReader;
    }

    public PassSelector getPassSelector() {
        return passSelector;
    }

    public FileReader<StudyCafePass> getPassFileReader() {
        return passFileReader;
    }

    public FileReader<StudyCafeLockerPass> getLockerPassFileReader() {
        return lockerPassFileReader;
    }

    public InputHandler getInputHandler() {
        return passSelector.getInputHandler();
    }

    public OutputHandler getOutputHandler() {
        return passSelector.getOutputHandler();
    }
}